package com.workintech.ecommerce.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "store" , schema = "ecommerce")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Long id ;

    @Column(name = "name")
    private String  name;

    @Column(name = "phone")
    private Long phone;

    @Column(name = "tax_no")
    private Long tax_no;

    @Column(name = "bank_account")
    private Long bank_account;

    @OneToMany(mappedBy = "store" , cascade = CascadeType.ALL)
    private List<Product> products;


    public void addProduct(Product product){
        if (product == null){
            products = new ArrayList<>();
        }
        products.add(product);
    }


}
