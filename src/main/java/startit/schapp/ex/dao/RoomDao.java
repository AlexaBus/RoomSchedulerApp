package startit.schapp.ex.dao;

import startit.schapp.ex.model.Room;

import java.util.List;

//interface holding methods to be implemented
public interface RoomDao {

    Room getRoom(Integer id) throws Exception;
    List<Room> listAllRooms() throws Exception;

}
