package com.app.inventario.service;

import com.app.inventario.model.Unit;
import com.app.inventario.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitServiceImpl implements UnitService {
    @Autowired
    UnitRepository unitRepository;
    @Override
    public List<Unit> getAll() {
        return unitRepository.findAll();
    }
    @Override
    public Unit getUnitById(Long unitId) {
        return unitRepository.findById(unitId).orElse(null);
    }
}
