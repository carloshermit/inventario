package com.app.inventario.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "unidades")
public class Unit {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long unitId;
    private String description;
    private Boolean state;

    @OneToMany(mappedBy ="unit")
    @JsonIgnore
    private List<Product> products;
}
