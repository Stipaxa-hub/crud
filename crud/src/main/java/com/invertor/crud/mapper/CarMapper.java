package com.invertor.crud.mapper;

import com.invertor.crud.dto.CarDTO;
import com.invertor.crud.entity.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface CarMapper {
    @Mapping(target = "year", source = "yearOfManufacture")
    @Mapping(target = "brand", source = "brand.name")
    CarDTO toCarDto(Car car);
    @Mapping(target = "yearOfManufacture", source = "year")
    @Mapping(target = "brand", ignore = true)
    Car toCar(CarDTO carDTO);
}
