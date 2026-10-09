package com.Fawadkhan.hms.Service;

import com.Fawadkhan.hms.Entity.Room;
import com.Fawadkhan.hms.Repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository){
        this.roomRepository = roomRepository;

    }
    // CREATE
    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    // GET ALL
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    // GET BY ID
    public Optional<Room> getRoomById(Long id) {
        return roomRepository.findById(id);
    }

    // UPDATE
    public Room updateRoom(Long id, Room room) {

        Room existingRoom = roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found"));

        existingRoom.setRoomNumber(room.getRoomNumber());
        existingRoom.setRoomType(room.getRoomType());
        existingRoom.setCapacity(room.getCapacity());
        existingRoom.setOccupiedBeds(room.getOccupiedBeds());
        existingRoom.setStatus(room.getStatus());
        existingRoom.setHostel(room.getHostel());

        return roomRepository.save(existingRoom);
    }

    // DELETE
    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }
}

