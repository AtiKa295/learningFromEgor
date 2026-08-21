package repository;

import model.Hotel;

import java.util.*;

public class InMemoryHotelRepository implements CrudRepository<Hotel, UUID>{

    private final Map<UUID, Hotel> storage = new HashMap<>();

    @Override
    public Hotel save (Hotel hotel){
        storage.put(hotel.id(), hotel);
        return hotel;
    }

    @Override
    public Optional<Hotel> findById(UUID id){
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Hotel> findAll(){
        return new ArrayList<>(storage.values());
    }

    @Override
    public void deletedById(UUID id){
        storage.remove(id);
    }
}
