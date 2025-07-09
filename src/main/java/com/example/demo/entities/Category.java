package com.example.demo.entities;


import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Category extends BaseEntity {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long Id;

    @Column(nullable = false,unique = true)
    private String name;


    //,fetch = FetchType.LAZY,cascade = CascadeType.ALL
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
