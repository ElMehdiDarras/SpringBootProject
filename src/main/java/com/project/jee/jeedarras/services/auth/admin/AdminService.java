package com.project.jee.jeedarras.services.auth.admin;

import com.project.jee.jeedarras.dto.BookACarDto;
import com.project.jee.jeedarras.dto.CarDto;
import com.project.jee.jeedarras.dto.CarDtoListDto;
import com.project.jee.jeedarras.dto.SearchCarDto;

import java.io.IOException;
import java.util.List;

public interface AdminService {

    boolean postCar(CarDto carDto) throws IOException;
    List<CarDto> getAllCars();

    void deleteCar(Long id);

    CarDto getCarById(Long id);

    boolean updateCar(Long carId, CarDto carDto) throws IOException;

    List<BookACarDto> getBookings();

    boolean changeBookingStatus(Long bookingId, String status);

    CarDtoListDto searchCar(SearchCarDto searchCarDto);


}
