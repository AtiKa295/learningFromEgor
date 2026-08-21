package service;

import exception.BookingConflictException;
import exception.EntityNotFoundException;
import model.Booking;
import model.BookingStatus;
import model.Hotel;
import model.Room;
import repository.CrudRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public class BookingService {

    private final CrudRepository<Hotel, UUID> hotelRepository;
    private final CrudRepository<Room, UUID> roomRepository;
    private final CrudRepository<Booking, UUID> bookingRepository;

    public BookingService(CrudRepository<Hotel, UUID> hotelRepository,
                          CrudRepository<Room, UUID> roomRepository,
                          CrudRepository<Booking, UUID> bookingRepository){
        this.hotelRepository = hotelRepository;
        this.roomRepository = roomRepository;
        this.bookingRepository = bookingRepository;
    }

    public List<Hotel> findHotelsByCity(String city){
        return hotelRepository.findAll().stream()
                .filter(hotel -> hotel.city().equalsIgnoreCase(city.trim()))
                .toList();
    }

    public List<Room> getAvailableRooms (UUID hotelId, BigDecimal maxPrice){
        return roomRepository.findAll().stream()
                .filter(room -> room.hotelId().equals(hotelId))
                .filter(room -> maxPrice == null || room.pricePerNight().compareTo(maxPrice) <= 0)
                .sorted(Comparator.comparing(Room::pricePerNight))
                .toList();
    }

    public Booking bookRoom(UUID userId, UUID roomId, LocalDate checkIn, LocalDate checkOut){
        if (checkIn.isAfter(checkOut) || checkIn.isEqual(checkOut)){
            throw new BookingConflictException("Дата выезда должна быть строго позже даты заезда");
        }
    }
//Ой в пизду биля
    //Кутак пас биля
    //Заебал биля
    //Фляга свистит
    //Буду завтра дописывать и комменты к коду выше допишу, я уже часов 6-7 это ковыряю
}
