import java.util.*;

public class UserAndHotel {

    //Я короче понял, что такое рекорд.
    //Капец эта штука уменьшает объем кода и упрощает мне жизнь
    //Это я создал пользователя и отель, но в идеале нужно ->
    //Грамотно создать под каждую цель свой класс. Тут я пытался это сделать)))

    public record User (UUID id, String name, String email){}
    public record Hotel (UUID id, String name, String email){}



}