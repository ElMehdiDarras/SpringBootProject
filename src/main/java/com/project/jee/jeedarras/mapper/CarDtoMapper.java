package com.project.jee.darrasjee.mapper;

import com.project.jee.darrasjee.domain.Car;
import com.project.jee.darrasjee.dto.CarDto;
import org.springframework.stereotype.Service;

@Service
public class CarDtoMapper {

        public static Car mapToCar(CarDto carDto) {

                return Car.builder()
                        .registrationNr(carDto.getRegistrationNr())
                        .brand(carDto.getBrand())
                        .model(carDto.getModel())
                        .isAvailable(carDto.getIsAvailable())
                        .build();

        }

}
