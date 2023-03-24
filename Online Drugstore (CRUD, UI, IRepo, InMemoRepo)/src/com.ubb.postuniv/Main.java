package com.ubb.postuniv;

import com.ubb.postuniv.domain.Drug;
import com.ubb.postuniv.domain.Transaction;
import com.ubb.postuniv.domain.CardClient;
import com.ubb.postuniv.repository.IRepository;
import com.ubb.postuniv.repository.InMemoryRepository;
import com.ubb.postuniv.service.DrugstoreService;
import com.ubb.postuniv.userInterface.DrugstoreUI;

public class Main {

    public static void main(String[] args) throws Exception {
        IRepository<Drug> drugRepository = new InMemoryRepository<>();
        IRepository<Transaction> transactionRepository = new InMemoryRepository<>();
        IRepository<CardClient> cardClientRepository = new InMemoryRepository<>();

        drugRepository.add(new Drug(1, "Drug 1", "Ingred", 150, true));
        drugRepository.add(new Drug(2, "Drug 2", "Ingred", 120, true));
        drugRepository.add(new Drug(3, "Drug 3", "Ingred", 150, false));
        drugRepository.add(new Drug(4, "Drug 4", "Ingred", 540, true));
        drugRepository.add(new Drug(5, "Drug 5", "Ingred", 330, true));
        drugRepository.add(new Drug(6, "Drug 6", "Ingred", 330, false));
        drugRepository.add(new Drug(7, "Drug 7", "Ingred", 430, true));

        DrugstoreService drugstoreService = new DrugstoreService(drugRepository,cardClientRepository,transactionRepository);
        DrugstoreUI drugstoreUI = new DrugstoreUI(drugstoreService);
        drugstoreUI.start();
    }
}
