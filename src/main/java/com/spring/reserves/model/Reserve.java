package com.spring.reserves.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// name of the collection, change "reserves" for your collection and complete your model
@Document("reserves")
public class Reserve {
    @Id
    public String id;
    public Client client;
    public String startDate;
    public String endDate;

    public static class Client {
        public String name;
        public String surname;
    }
}
