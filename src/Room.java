import java.math.BigDecimal;
import java.util.Objects;

public class Room implements Comparable<Room> {
    private final Integer id;
    private final Integer hotelId;
    private final int roomNumber;
    private final BigDecimal pricePerNight;

    public Room(Integer id, Integer hotelId, int roomNumber, BigDecimal pricePerNight) {
        this.id = id;
        this.hotelId = hotelId;
        this.roomNumber = roomNumber;
        this.pricePerNight = pricePerNight;
    }


    public Integer getId(){return id; };
    public Integer getHotelId(){return hotelId; };
    public int getRoomNumber(){return roomNumber; };
    public BigDecimal getPricePerNight(){return pricePerNight; };

// Короче, я как понял - это я запилил сортировку номеров
    @Override
    public int compareTo(Room other) {
        return this.pricePerNight.compareTo(other.pricePerNight);
    }

//С этим я ебался долго
//Написал конечно не без помощи джемени, но все же.
//Это я сделал проверку не один и тот же ли я номер выбрал.
//Чтоб при сортировке и прочих моментах не путалось ничего
//Пришлось еще читать за equals, чтоб понять этот пиздец
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(id, room.id);
    }

//Короче, объясняю, какую соль уловил с этого говна я
//HashSet и Hashmap будто создали, чтоб быстро искать нужные объекты.
//Быстрый поиск просиходит за счет того, что у них есть свои "Коробки" ->
//В которых хранятся объекты.
//И вот то, что я написал int hashCode это я указал на номер корзины ->
//Куда я закинул все свои данные

//Теперь про Object.hash:
//Это херня, которая как раз таки и дает этот легкий поиск.
//Типо вместо меня там свои вычисления делает ->
//И сам подбирает к этому номер


    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

