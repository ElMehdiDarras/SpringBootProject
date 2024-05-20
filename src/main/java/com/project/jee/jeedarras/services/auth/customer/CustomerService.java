package com.project.jee.jeedarras.services.auth.customer;

import com.project.jee.jeedarras.dto.BookACarDto;
import com.project.jee.jeedarras.dto.CarDto;
import com.project.jee.jeedarras.dto.CarDtoListDto;
import com.project.jee.jeedarras.dto.SearchCarDto;

import java.util.List;

public interface CustomerService {

    List<CarDto> getAllCars();

    boolean bookACar(BookACarDto bookACarDto);

    CarDto getCarById(Long carId);

    List<BookACarDto> getBookingsByUserId(Long userId);

    CarDtoListDto searchCar(SearchCarDto searchCarDto);

}
