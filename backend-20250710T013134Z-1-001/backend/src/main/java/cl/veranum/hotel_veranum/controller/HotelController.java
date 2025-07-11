package cl.veranum.hotel_veranum.controller;


import cl.veranum.hotel_veranum.model.Hotel;
import cl.veranum.hotel_veranum.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/hoteles")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @GetMapping
    public List<Hotel> listar() {
        return hotelService.listarHoteles();
    }

    @GetMapping("/{id}")
    public Hotel obtenerPorId(@PathVariable Long id) {
        return hotelService.obtenerPorId(id);
    }

    @PostMapping
    public ResponseEntity<Hotel> crearHotel(@RequestBody Hotel hotel) {
        Hotel nuevoHotel = hotelService.crearHotel(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoHotel);
    }
}
