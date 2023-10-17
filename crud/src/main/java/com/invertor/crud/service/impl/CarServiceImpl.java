package com.invertor.crud.service.impl;

import com.invertor.crud.dto.CarDTO;
import com.invertor.crud.entity.Brand;
import com.invertor.crud.entity.Car;
import com.invertor.crud.exception.NotFoundException;
import com.invertor.crud.mapper.CarMapper;
import com.invertor.crud.repository.BrandRepository;
import com.invertor.crud.repository.CarRepository;
import com.invertor.crud.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final BrandRepository brandRepository;
    private final CarMapper carMapper;

    @Override
    public void save(CarDTO carDTO) {
        Car car = carMapper.toCar(carDTO);
        Brand brand = brandRepository.findByName(carDTO.brand()).orElse(new Brand(carDTO.brand()));
        car.setBrand(brand);
        carRepository.save(car);
    }

    @Override
    public List<CarDTO> findAll() {
        return carRepository.findAll().stream()
                .map(carMapper::toCarDto)
                .collect(Collectors.toList());
    }

    @Override
    public CarDTO findByID(Long id) {
        return carMapper.toCarDto(carRepository.findById(id).orElseThrow(() -> new NotFoundException("Car not found by id: " + id)));
    }

    @Override
    public void delete(Long id) {
        carRepository.deleteById(id);
    }
}
