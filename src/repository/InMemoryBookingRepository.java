package repository;

import model.Booking;

import java.util.*;

public class InMemoryBookingRepository implements CrudRepository<Booking, UUID> {

    private final Map<UUID, Booking> storage = new HashMap<>();

    @Override
    public Booking save(Booking booking) {
        storage.put(booking.id(), booking);
        return booking;
    }

    @Override
    public Optional<Booking> findById(UUID id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Booking> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void deletedById(UUID id) {
        storage.remove(id);
    }
}
