package repository;

import model.User;

import java.util.*;
//Весь этот файл и ему подобные это по сути подкапотка CrudRepository
public class InMemoryUserRepository implements CrudRepository<User, UUID> {

    private final Map<UUID, User> storage = new HashMap<>();
//Короче, поясню тут, че я вообще сделал и че за новые 4 файла.

    //Как я разобрался, данный код позволяет хранить данные в оперативке, чтоб программа
    //Не лезла в БД и не ковырялась в ненужных местах
    // Т.е по запросу она данные берет и удаляет.


    //Про мапы я уже рассказывал, поэтому дальше по факту каждого "Четверостишия"
    //Оно берет айди юзера и кладет в мапу
    //Если пользователь с таким айди уже был, то просто обновит данные о нем
    //И соответственно возвращает обновленного Юзера
    @Override
    public User save(User user){
        storage.put(user.id(), user);
        return user;
    }


    //Ищет юзера по ключу, тут все легко и понятно
    //Если найдет, то вернет юзера, не найдет вернет нул
    @Override
    public Optional<User> findById(UUID id){
        return Optional.ofNullable(storage.get(id));
    }


    //Возвращает коллекцию, которая сейчас в мапе
    @Override
    public List<User> findAll(){
        return new ArrayList<>(storage.values());
    }


    //Удаляет айди
    @Override
    public void deletedById(UUID id){
        storage.remove(id);
    }
}

//Ну это далось попроще, чем вчера, я уже начинаю осознавать, что пишу
