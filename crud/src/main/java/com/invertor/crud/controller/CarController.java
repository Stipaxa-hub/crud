package com.invertor.crud.controller;

import com.invertor.crud.dto.CarDTO;
import com.invertor.crud.service.CarService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/car")
public class CarController {

    private final CarService carService;

    @GetMapping("/{id}")
    public CarDTO findById(@PathVariable Long id) {
        return carService.findByID(id);
    }

    @GetMapping
    public List<CarDTO> findAll() {
        return carService.findAll();
    }

    @PostMapping
    public ResponseEntity<Void> save(@Validated @RequestBody CarDTO carDTO) {
        carService.save(carDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        carService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
