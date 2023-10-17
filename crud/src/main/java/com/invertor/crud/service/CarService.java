package com.invertor.crud.service;

import com.invertor.crud.dto.CarDTO;

import java.util.List;

public interface CarService {
    void save(CarDTO carDTO);
    List<CarDTO> findAll();
    CarDTO findByID(Long id);
    void delete(Long id);
}
