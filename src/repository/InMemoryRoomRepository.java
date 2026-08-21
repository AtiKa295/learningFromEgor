package repository;

import model.Hotel;
import model.Room;

import java.util.*;


public class InMemoryRoomRepository implements CrudRepository<Room, UUID>{



    private final Map<UUID, Room> storage = new HashMap<>();

    @Override
    public Room save (Room room){
        storage.put(room.id(), room);
        return room;
    }

    @Override
    public Optional<Room> findById(UUID id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Room> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void deletedById(UUID id) {
        storage.remove(id);
    }
}
