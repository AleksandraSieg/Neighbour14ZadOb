package pl.madison.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class BlockOfFlats {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    int number;
    String street;
}
