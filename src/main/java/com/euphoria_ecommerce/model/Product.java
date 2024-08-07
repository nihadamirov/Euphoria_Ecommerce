package com.euphoria_ecommerce.model;

import com.euphoria_ecommerce.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String productName;

    private String size;
    private String color;


    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @JsonIgnore
    @JsonManagedReference
    @ManyToOne
    private Category category;

//    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL)
    private List<Price> price;

    @Lob
    @Column(name = "picture", columnDefinition = "text")
    private String picture;


}
