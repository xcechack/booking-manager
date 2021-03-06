package cz.muni.fi.pa165.dto;

import javax.validation.constraints.NotNull;

/**
 *  Data transfer object for creating a Room item.
 * 
 * @author Jana Cechackova
 */
public class CreateRoomDto {
    @NotNull
    private int number;
    
    @NotNull
    private Long hotelId;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateRoomDto)) return false;

        final CreateRoomDto room = (CreateRoomDto) o;

        return room.getNumber()==(getNumber());
    }

    @Override
    public int hashCode() {
        return this.getNumber()+hotelId.hashCode();
    }
}
