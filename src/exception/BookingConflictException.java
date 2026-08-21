package exception;
//Короче, фляга уже свистит, я уже путаюсь в языках между английским и русским
//До этого весь текст комментов я нахуячил на английском
//Это просто кастомные ошибки
//Видите ли джемини развыебывалась на меня, обосрала мой изначальный код в BookingService
//И сказала мол вот, читай вникай и изучай
//Я там ссылочку прикреплю в CommentsForEgor это мое состояние сейчас
public class BookingConflictException extends RuntimeException{
    public BookingConflictException(String message){
        super(message);
    }
}
