package services.models;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.UUID;

@EnableAutoConfiguration
@Entity
@Table(name = "organisers")

public class Organiser {
    @Id
    private String organiser_id;
    private String name;
    private String surname;


    public Organiser(String name,
                     String surname) {
        this.name = name;
        this.surname = surname;
        this.organiser_id = UUID.randomUUID().toString();
    }

    public Organiser() {

    }

    public String getOrganiser_id() {
        return organiser_id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}