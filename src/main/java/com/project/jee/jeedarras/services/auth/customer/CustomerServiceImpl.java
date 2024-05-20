package com.project.jee.jeedarras.services.auth.customer;

import com.project.jee.jeedarras.dto.BookACarDto;
import com.project.jee.jeedarras.dto.CarDto;
import com.project.jee.jeedarras.dto.CarDtoListDto;
import com.project.jee.jeedarras.dto.SearchCarDto;
import com.project.jee.jeedarras.enums.BookCarStatus;
import com.project.jee.jeedarras.repository.BookACarRepository;
import com.project.jee.jeedarras.repository.CarRepository;
import com.project.jee.jeedarras.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.project.jee.jeedarras.entity.BookACar;
import com.project.jee.jeedarras.entity.Car;
import com.project.jee.jeedarras.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class CustomerServiceImpl implements CustomerService{

    private final CarRepository carRepository;

    private final UserRepository userRepository;

    private final BookACarRepository bookACarRepository;

    @Override
    public List<CarDto> getAllCars() {

        return carRepository.findAll().stream().map(Car::getCarDto).collect(Collectors.toList());
    }

    @Override
    public boolean bookACar(BookACarDto bookACarDto) {
        Optional<Car> optionalCar = carRepository.findById(bookACarDto.getCarId());
        Optional<User> optionalUser = userRepository.findById(bookACarDto.getUserId());
        if (optionalCar.isPresent() && optionalUser.isPresent()){
            Car existingCar = optionalCar.get();
            BookACar bookACar = new BookACar();
            bookACar.setUser(optionalUser.get());
            bookACar.setCar(existingCar);
            bookACar.setBookCarStatus(BookCarStatus.PENDING);
            long diffInMilliSeconds = bookACarDto.getToDate().getTime() - bookACarDto.getFromDate().getTime();
            long days = TimeUnit.MILLISECONDS.toDays(diffInMilliSeconds); // Use MILLISECONDS instead of MICROSECONDS
            bookACar.setDays(days);
            bookACar.setFromDate(bookACarDto.getFromDate()); // Set fromDate from bookACarDto
            bookACar.setToDate(bookACarDto.getToDate());     // Set toDate from bookACarDto
            bookACar.setPrice(existingCar.getPrice() * days);
            bookACarRepository.save(bookACar);
            return true;
        }

        return false;
    }


    @Override
    public CarDto getCarById(Long carId) {
        Optional<Car> optionalCar =carRepository.findById(carId);
        return optionalCar.map(Car::getCarDto).orElse(null);
    }


    @Override
    public List<BookACarDto> getBookingsByUserId(Long userId) {
        return bookACarRepository.findAllByUserId(userId).stream().map(BookACar::getBookACarDto).collect(Collectors.toList());
    }

    @Override
    public CarDtoListDto searchCar(SearchCarDto searchCarDto) {
        Car car = new Car();
        car.setBrand(searchCarDto.getBrand());
        car.setType(searchCarDto.getType());
        car.setTransmission(searchCarDto.getTransmission());
        car.setColor(searchCarDto.getColor());
        ExampleMatcher exampleMatcher =
                ExampleMatcher.matchingAll()
                        .withMatcher("brand", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                        .withMatcher("type", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                        .withMatcher("transmission", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                        .withMatcher("color", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());
        Example<Car> carExample = Example.of(car, exampleMatcher);
        List<Car> carList = carRepository.findAll(carExample);
        CarDtoListDto carDtoListDto = new CarDtoListDto();
        carDtoListDto.setCarDtoList(carList.stream().map(Car::getCarDto).collect(Collectors.toList()));
        return carDtoListDto;
    }
}

