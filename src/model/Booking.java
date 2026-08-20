package model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Locale;
import java.util.UUID;

public record Booking(
        UUID id,
        UUID userId,
        UUID roomId,
        LocalDate checkIn,
        LocalDate checkOut,
        BigDecimal totalPrice,
        BookingStatus status
) {
}


//Теперь по LocalDate
//Как я понял эта залупа хранит в себе только дату (Год, Месяц, день)
//джемини посоветовала использовать его, т.к в него встроены ф-ции, которыу в будущем нам пригодятся.
//По типу пересчета ночей и различных проверок дат, чтоб не было ошибок и багов

//Ну и по поводу UUID, хоть мы и общались уже на эту тему
//Да просто жизнь упрощает тем, что меньше код будет.

//Шлифану по поводу Record
//Это чудо упрощает мне жизнь.
//Я, как понял она за меня генерит геттеры и сеттеры, конструкторы и т.п
//Только все это хранится "под капотом", а не на "Кузове"

//Ну и я еще небольшой порядок в файлах навел
