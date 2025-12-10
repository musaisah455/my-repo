package com.my_apps.mybookmongo.sequence;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document(collection = "database_sequences")
public class DatabaseSequence {

        @Id
        private String id;
        private long seq;
        // Getters, setters

}
