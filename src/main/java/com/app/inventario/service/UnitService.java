package com.app.inventario.service;

import com.app.inventario.model.Unit;

import java.util.List;

public interface UnitService {
    List<Unit> getAll();
    Unit getUnitById(Long unitId);
}
