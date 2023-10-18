package com.app.inventario.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "categorias")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long categoryId;
    private String description;
    private Boolean state;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Product> products;
}
