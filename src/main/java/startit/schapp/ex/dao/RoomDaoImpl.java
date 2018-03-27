package startit.schapp.ex.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import startit.schapp.ex.model.Room;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoomDaoImpl implements RoomDao {

    @Autowired
    private Room room;

    @PersistenceContext
    private EntityManager em;

    private final String selectRoomById= "from Room a where a.id=:id";
    private final String selectAllRooms = "from Room";

    @Transactional
    //impractical
    public Room getRoom(Integer id) throws Exception{
        room = em.createQuery(selectRoomById,Room.class)
                .setParameter("id",id)
                .getSingleResult();
        return room;
    }

    @Transactional
    //i'm thonking about listing on a separate page of the app all the rooms with their details and availability
    public List<Room> listAllRooms() throws Exception {
        return em.createQuery(selectAllRooms,Room.class)
                .getResultList();
    }

    //also, this class should have methods for adding new rooms, removing rooms, etc.
}
