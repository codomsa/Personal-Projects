package com.ubb.postuniv.service;

import com.ubb.postuniv.domain.CardClient;
import com.ubb.postuniv.domain.Drug;
import com.ubb.postuniv.domain.Transaction;
import com.ubb.postuniv.repository.IRepository;

import java.util.HashMap;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class DrugstoreService{
    private IRepository<Drug> drugRepository;
    private IRepository<CardClient> cardClientRepository;
    private IRepository<Transaction> transactionRepository;

    public DrugstoreService(IRepository<Drug> drugRepository,
                            IRepository<CardClient> cardClientRepository,
                            IRepository<Transaction> transactionRepository){
        this.drugRepository=drugRepository;
        this.cardClientRepository=cardClientRepository;
        this.transactionRepository=transactionRepository;
    }

    // Drug CRUD methods

    public void addDrug(Drug drug){
        drugRepository.add(drug);
    }

    public void updateDrug (Drug drug){
        drugRepository.update(drug);
    }

    public void deleteDrug (int id){
        drugRepository.delete(id);
    }

    public Drug findDrugById(int id){
        return drugRepository.findById(id);
    }

    public List<Drug> findAllDrugs(){
        return drugRepository.findAll();
    }

    // CardClient CRUD methods

    public void addCardClient(CardClient cardClient){
        cardClientRepository.add(cardClient);
    }

    public void updateCardClient(CardClient cardClient){
        cardClientRepository.update(cardClient);
    }

    public void deleteCardClient (int id){
        cardClientRepository.delete(id);
    }

    public CardClient findCardClientById(int id){
        return cardClientRepository.findById(id);
    }

    public List<CardClient> findAllCardClient(){
        return cardClientRepository.findAll();
    }

    // Transaction CRUD methods

    public void addTransaction(Transaction transaction){
        transactionRepository.add(transaction);
    }
    public void updateTransaction(Transaction transaction){
        transactionRepository.update(transaction);
    }
    public void deleteTransaction(int id){
        transactionRepository.delete(id);
    }

    public Transaction findTransactionById(int id){
        return transactionRepository.findById(id);
    }

    public List<Transaction> findAllTransaction(){
        return transactionRepository.findAll();
    }

    public List<Drug> searchDrug(String searchTerm){
        return drugRepository.findAll().stream()
                .filter(drug -> drug.getName().toLowerCase().contains(searchTerm.toLowerCase()) ||
                        drug.getProducer().toLowerCase().contains(searchTerm.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<CardClient> searchCardClient (String searchTerm){
        return cardClientRepository.findAll().stream()
                .filter(cardClient -> cardClient.getName().toLowerCase().contains(searchTerm.toLowerCase()) ||
                        cardClient.getSurname().toLowerCase().contains(searchTerm.toLowerCase()) ||
                        cardClient.getCNP().contains(searchTerm))
                .collect(Collectors.toList());
    }

    public List<Transaction> searchTransactionsInInterval (LocalDate startDate, LocalDate endDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        return transactionRepository.findAll().stream()
                .filter(transaction -> {
                    LocalDateTime transactionDateTime = LocalDateTime.parse(transaction.getDateTime(), formatter);
                    LocalDate transactionDate = transactionDateTime.toLocalDate();
                    return transactionDate.isAfter(startDate.minusDays(1)) && transactionDate.isBefore(endDate.plusDays(1));
                })
                .collect(Collectors.toList());
    }

    public List<Drug> getDrugsBySales(){
        Map<Integer, Long> drugSales = transactionRepository.findAll().stream()
                .collect(Collectors.groupingBy(Transaction::getIdDrug, Collectors.counting()));

        return drugRepository.findAll().stream()
                .sorted(Comparator.<Drug, Long>comparing(drug -> drugSales.getOrDefault(drug.getId(),0L)).reversed())
                .collect(Collectors.toList());
    }

    public void increaseDrugPrice (double percentage, double maxPrice){
        List<Drug> drugs = drugRepository.findAll().stream()
                .filter(drug -> drug.getPrice() < maxPrice)
                .collect(Collectors.toList());
        drugs.forEach(drug -> {
            double newPrice = drug.getPrice() * (1 + (percentage / 100));
            drug.setPrice(newPrice);
            drugRepository.update(drug);
        });
    }

    public List<CardClient> getCardClientsByDiscountValue(){
        Map<Integer, Double> cardClientDiscounts = new HashMap<>();

        transactionRepository.findAll().forEach(transaction -> {
            if (transaction.getIdCardClient() != null){
                Drug drug = drugRepository.findById(transaction.getIdDrug());
                double discount = drug.getPrescriptionNeed() ? 0.15 : 0.10;
                double discountValue = transaction.getCount() * drug.getPrice() * discount;
                cardClientDiscounts.put(transaction.getIdCardClient(), cardClientDiscounts.getOrDefault(transaction.getIdCardClient(), 0.0) + discountValue);
            }
        });

        return cardClientRepository.findAll().stream()
                .sorted(Comparator.<CardClient, Double>comparing(client -> cardClientDiscounts.getOrDefault(client.getId(),0.0)).reversed())
                .collect(Collectors.toList());
    }

    public void deleteTransactionsInInterval (LocalDate startDate, LocalDate endDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        List<Transaction> transactionsToDelete = transactionRepository.findAll().stream()
                .filter(transaction -> {
                    LocalDateTime transactionDateTime = LocalDateTime.parse(transaction.getDateTime(),formatter);
                    LocalDate transactionDate = transactionDateTime.toLocalDate();
                    return transactionDate.isAfter(startDate.minusDays(1)) && transactionDate.isBefore(endDate.minusDays(1));
                })
                .collect(Collectors.toList());
        transactionsToDelete.forEach(transaction -> transactionRepository.delete(transaction.getId()));
    }

    public List<Transaction> getAllTransactions(){
        return transactionRepository.findAll();
    }

    public List<Transaction> searchTransactions(String searchTerm){
        return transactionRepository.findAll().stream()
                .filter(transaction -> transaction.toString().toLowerCase().contains(searchTerm.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Drug> getAllDrugs(){
        return drugRepository.findAll();
    }

    public List<Drug> searchDrugs(String searchTerm){
        return drugRepository.findAll().stream()
                .filter(drug -> drug.toString().toLowerCase().contains(searchTerm.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<CardClient> getAllCardClient(){
        return cardClientRepository.findAll();
    }


}
