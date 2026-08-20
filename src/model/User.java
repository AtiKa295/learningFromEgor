package model;


import java.util.UUID;

public record User(
        UUID id,
        String name,
        String email
) {
    //Перезуячил я весь код... Хотелось плакать....

}
