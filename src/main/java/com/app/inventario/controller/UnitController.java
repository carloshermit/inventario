package com.app.inventario.controller;

import com.app.inventario.model.Unit;
import com.app.inventario.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/unidades")
public class UnitController {
    @Autowired
    UnitService unitService;
    @GetMapping("/read")
    public ResponseEntity<List<Unit>> getAllUnit(){
        List<Unit> units=unitService.getAll();
        if(units.isEmpty())
            return  ResponseEntity.noContent().build();
        return ResponseEntity.ok(units);
    }
}
