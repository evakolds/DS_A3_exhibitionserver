package services.models;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.UUID;

@EnableAutoConfiguration
@Entity
@Table(name = "exhibitions")

public class Exhibition {
    @Id
    private String exhibition_id;
    private String name;
    private int open;


    public Exhibition(String name,
                      int open) {
        if (open == 1 || open == 0)
            this.open = open;
        else
            this.open = 0;
        this.name = name;
        this.exhibition_id = UUID.randomUUID().toString();
    }

    public Exhibition() {

    }

    public String getExhibition_id() {
        return exhibition_id;
    }

    public String getName() {
        return name;
    }
    public void open() {
        if (open == 0)
            open = 1;
    }

    public void close() {
        if (open == 1)
            open = 0;
    }

}