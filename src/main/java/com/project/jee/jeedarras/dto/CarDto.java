package com.project.jee.darrasjee.dto;

import com.project.jee.darrasjee.domain.CarParameters;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CarDto {

        private String registrationNr;
        private String brand;
        private String model;
        private Boolean isAvailable;

}
