package model;

import java.math.BigDecimal;
import java.util.UUID;

public record Room(
        UUID id,
        UUID hotelId,
        int roomNumber,
        BigDecimal pricePerNight
) implements Comparable<Room>{
    @Override
    public int compareTo(Room other){
        return this.pricePerNight.compareTo(other.pricePerNight);
    }
}
//Если бы я сразу допер, что могу через рекорд заебашить
//Я бы был суперменом