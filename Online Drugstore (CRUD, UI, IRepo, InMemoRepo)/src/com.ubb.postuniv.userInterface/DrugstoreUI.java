package com.ubb.postuniv.userInterface;

import com.ubb.postuniv.domain.CardClient;
import com.ubb.postuniv.domain.Drug;
import com.ubb.postuniv.domain.Transaction;
import com.ubb.postuniv.service.DrugstoreService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DrugstoreUI{
    private DrugstoreService drugstoreService;
    private Scanner scanner;

    public DrugstoreUI (DrugstoreService drugstoreService){
        this.drugstoreService = drugstoreService;
        this.scanner = new Scanner(System.in);
    }

    public void start(){
        while(true){
            showMainMenu();
            int option = scanner.nextInt();
            scanner.nextLine();
            switch(option){
                case 1:
                    drugsMenu();
                    break;
                case 2:
                    cardClientMenu();
                    break;
                case 3:
                    transactionMenu();
                    break;
                case 0:
                    System.out.println("Bye bye! umu");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void showMainMenu(){
        System.out.println("Catena - Drugstore of the heart - Main Menu");
        System.out.println("1. Drugs CRUD");
        System.out.println("2. Card Client CRUD");
        System.out.println("3. Transaction CRUD");
        System.out.println("0. Exit");
        System.out.println("Enter your choice:");
    }

    private void drugsMenu(){
        while(true){
            showDrugMenu();
            int option = scanner.nextInt();
            scanner.nextLine();
            switch(option){
                case 1:
                    addDrug();
                    break;
                case 2:
                    updateDrug();
                    break;
                case 3:
                    deleteDrug();
                    break;
                case 4:
                    listDrugs();
                    break;
                case 5:
                    searchDrugs();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Please try again!");
            }
        }
    }

    private void showDrugMenu(){
        System.out.println("Catena - Drugstore of the heart - Drugs CRUD Submenu");
        System.out.println("1. Add drugs");
        System.out.println("2. Update drugs");
        System.out.println("3. Delete drugs");
        System.out.println("4. List of drugs");
        System.out.println("5. Search drugs");
        System.out.println("0. Main Menu");
        System.out.println("Enter your choice:");
    }

    private void addDrug(){
        System.out.println("Enter Drug ID:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter drug name:");
        String name = scanner.nextLine();
        System.out.println("Enter producer name:");
        String producer = scanner.nextLine();
        System.out.println("Enter drug price:");
        double price = scanner.nextDouble();
        System.out.println("Is a prescription needed? (yes/no):");
        scanner.nextLine();
        boolean prescriptionNeeded = scanner.nextLine().equalsIgnoreCase("yes");
        Drug drug = new Drug(id,name,producer,price,prescriptionNeeded);
        drugstoreService.addDrug(drug);
        System.out.println("Task failed successfully!");
    }

    private void updateDrug(){
        System.out.println("Enter ID of the drug to update:");
        int id = scanner.nextInt();
        scanner.nextLine();
        Drug drug = drugstoreService.findDrugById(id);
        if(drug != null){
            System.out.println("Enter the new drug name (leave blank to keep current one):");
            String name = scanner.nextLine();
            if(!name.isEmpty()){
                drug.setName(name);
            }
            System.out.println("Enter the new producer name (leave blank to keep the current one):");
            String producer = scanner.nextLine();
            if(!producer.isEmpty()){
                drug.setProducer(producer);
            }
            System.out.println("Enter the new price (0 to keep the old one):");
            Double price = scanner.nextDouble();
            if(price != 0){
                drug.setPrice(price);
            }
            System.out.println("Enter the new information regarding the prescription (yes/no, leave blank if there is no update):");
            boolean prescriptionNeeded = scanner.nextLine().equalsIgnoreCase("yes");
            drug.setPrescriptionNeed(prescriptionNeeded);
        }
    }

    public void deleteDrug(){
        System.out.println("Enter ID of the drug to delete:");
        int id = scanner.nextInt();
        scanner.nextLine();
        Drug drug = drugstoreService.findDrugById(id);
        if(drug != null){
            drugstoreService.deleteDrug(id);
            System.out.println("Drug deleted!");
        } else {
            System.out.println("Drug not found!");
        }
    }

    private void listDrugs (){
        System.out.println("Drug list:");
        drugstoreService.getAllDrugs().forEach(System.out::println);
    }

    private void searchDrugs(){
        System.out.println("Enter search term:");
        String searchTerm = scanner.nextLine();
        System.out.println("Search results:");
        drugstoreService.searchDrug(searchTerm).forEach(System.out::println);
    }

    private void cardClientMenu(){
        while (true){
            showCardClientMenu();
            int option = scanner.nextInt();
            scanner.nextLine();
            switch(option){
                case 1:
                    addCardClient();
                    break;
                case 2:
                    updateCardClient();
                    break;
                case 3:
                    deleteCardClient();
                    break;
                case 4:
                    listCardClient();
                    break;
                case 5:
                    searchCardClient();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Please try again!");
            }
        }
    }

    private void showCardClientMenu(){
        System.out.println("Catena - drugstore of the heart - Card Client CRUD submenu");
        System.out.println("1. Add card client");
        System.out.println("2. Update card client");
        System.out.println("3. Delete Card Client");
        System.out.println("4. List all client cards");
        System.out.println("5. Search for a specific card client");
        System.out.println("0. Main menu");
        System.out.println("Enter your choice:");
    }

    private void addCardClient(){
        System.out.println("Card client ID:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Client first name:");
        String surname = scanner.nextLine();
        System.out.println("Client last name:");
        String name = scanner.nextLine();
        System.out.println("CNP:");
        String CNP = scanner.nextLine();
        System.out.println("Birthdate:");
        String birthDate = scanner.nextLine();
        System.out.println("Registration date:");
        String registrationDate = scanner.nextLine();
        CardClient cardClient = new CardClient(id,name,surname,CNP,birthDate,registrationDate);
    }

    private void updateCardClient(){
        System.out.println("Enter ID of the card to update:");
        int id = scanner.nextInt();
        scanner.nextLine();
        CardClient cardClient = drugstoreService.findCardClientById(id);
        if(cardClient != null){
            System.out.println("Enter the new client name (leave blank to keep current one):");
            String name = scanner.nextLine();
            if(!name.isEmpty()){
                cardClient.setName(name);
            }
            System.out.println("Enter the new surname name (leave blank to keep the current one):");
            String surname = scanner.nextLine();
            if(!surname.isEmpty()){
                cardClient.setSurname(surname);
            }
            System.out.println("Enter the new CNP (leave blank to keep the current one):");
            String CNP = scanner.nextLine();
            if(!CNP.isEmpty()){
                cardClient.setCNP(CNP);
            }
            System.out.println("Enter the new birthDate (leave blank to keep the current one):");
            String birthDate = scanner.nextLine();
            if(!birthDate.isEmpty()){
                cardClient.setBirthDate(birthDate);
            }
            System.out.println("Enter the new registrationDate (leave blank to keep the current one):");
            String registrationDate = scanner.nextLine();
            if(!registrationDate.isEmpty()){
                cardClient.setRegistrationDate(registrationDate);
            }
        }
    }

    private void deleteCardClient(){
        System.out.println("Enter the ID of the card to delete:");
        int id = scanner.nextInt();
        scanner.nextLine();
        CardClient cardClient = drugstoreService.findCardClientById(id);
        if(cardClient != null){
            drugstoreService.deleteCardClient(id);
            System.out.println("Card deleted successfully!");
        } else {
            System.out.println("Card client not found!");
        }
    }

    private void listCardClient(){
        System.out.println("Card clients list:");
        drugstoreService.getAllCardClient().forEach(System.out::println);
    }
    private void searchCardClient(){
        System.out.println("Enter search term:");
        String searchTerm = scanner.nextLine();
        System.out.println("Search results:");
        drugstoreService.searchCardClient(searchTerm).forEach(System.out::println);
    }

    private void transactionMenu(){
        while(true){
            showTransactionMenu();
            int option = scanner.nextInt();
            scanner.nextLine();
            switch(option){
                case 1:
                    addTransaction();
                    break;
                case 2:
                    updateTransaction();
                    break;
                case 3:
                    deleteTransaction();
                    break;
                case 4:
                    listTransactions();
                    break;
                case 5:
                    searchTransactions();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Please try again!");
            }
        }
    }

    private void showTransactionMenu(){
        System.out.println("Catena - drugstore of the heart - Transaction CRUD submenu");
        System.out.println("1. Add transaction");
        System.out.println("2. Update transaction");
        System.out.println("3. Delete transaction");
        System.out.println("4. List transactions");
        System.out.println("5. Search transactions");
        System.out.println("0. Main menu");
        System.out.println("Enter your choice:");
    }

    private void addTransaction(){
        System.out.println("Transaction ID:");
        int id = scanner.nextInt();
        System.out.println("Card client ID:");
        Integer idCardClient = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Client Drug ID:");
        Integer idDrug = scanner.nextInt();
        System.out.println("Transaction date and time (dd.MM.yyyy HH:mm):");
        String dateTime = scanner.nextLine();
        System.out.println("Count:");
        int count = scanner.nextInt();

        Transaction transaction = new Transaction(id,idDrug,idCardClient,dateTime,count);
    }

    private void updateTransaction(){
        System.out.println("Enter ID of the transaction to update:");
        int id = scanner.nextInt();
        scanner.nextLine();
        Transaction transaction = drugstoreService.findTransactionById(id);
        if(transaction != null) {
            System.out.println("Enter the new transaction id ( 0 to keep the current one):");
            id = scanner.nextInt();
            if (id != 0) {
                transaction.setId(id);
            }
            System.out.println("Enter the new drug ID (0 to keep the current one):");
            Integer idDrug = scanner.nextInt();
            if (idDrug != 0) {
                transaction.setIdDrug(idDrug);
            }
            System.out.println("Enter the new card id (0 to keep the current one):");
            Integer IdCardClient = scanner.nextInt();
            if (IdCardClient != 0) {
                transaction.setIdCardClient(IdCardClient);
            }
            System.out.println("Enter the new dateTime (leave blank to keep the current one):");
            String dateTime = scanner.nextLine();
            if (!dateTime.isEmpty()) {
                transaction.setDateTime(dateTime);
            }
            System.out.println("Enter the new count (0 to keep the current one):");
            int count = scanner.nextInt();
            if (count != 0) {
                transaction.setCount(count);
            }
        }
    }

    private void deleteTransaction(){
        System.out.println("Enter the id of the transaction to delete:");
        int id = scanner.nextInt();
        scanner.nextLine();
        Transaction transaction = drugstoreService.findTransactionById(id);
        if(transaction != null){
            drugstoreService.deleteTransaction(id);
            System.out.println("Transaction deleted successfully!");
        } else {
            System.out.println("Transaction not found!");
        }
    }

    private void listTransactions(){
        System.out.println("Transaction list:");
        drugstoreService.getAllTransactions().forEach(System.out::println);
    }

    private void searchTransactions(){
        System.out.println("Enter search term:");
        String searchTerm = scanner.nextLine();
        System.out.println("Search results:");
        drugstoreService.searchTransactions(searchTerm).forEach(System.out::println);
    }
}
