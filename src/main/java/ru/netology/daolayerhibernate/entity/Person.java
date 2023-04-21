package ru.netology.daolayerhibernate.entity;


import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name = "customers")
public class Person {

    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "name")),
            @AttributeOverride(name = "surname", column = @Column(name = "surname")),
            @AttributeOverride(name = "age", column = @Column(name = "age"))
    })
    private PersonId personId;
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    @JoinColumn(name = "city_of_living", nullable = false)
    @ManyToOne(optional = false)
    private City city;

}
