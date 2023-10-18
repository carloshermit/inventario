package com.app.inventario.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "productos")
public class Product {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long productId;
    private String description;
    private Float price;
    private Float quantity;
    private Boolean state;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Unit unit;

}
