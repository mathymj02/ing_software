package cl.veranum.hotel_veranum.controller;



import cl.veranum.hotel_veranum.model.Habitacion;
import cl.veranum.hotel_veranum.service.HabitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/habitaciones")
public class HabitacionController {
    @Autowired
    private HabitacionService habitacionService;

    @GetMapping
    public List<Habitacion> listar() {
        return habitacionService.listarHabitaciones();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Habitacion> obtenerPorId(@PathVariable Long id) {
        Habitacion habitacion = habitacionService.obtenerPorId(id);
        if (habitacion == null) {
            return ResponseEntity.notFound().build();  // Devuelve 404 si no existe
        }
        return ResponseEntity.ok(habitacion);  // Devuelve 200 y el objeto si existe
    }
    @GetMapping("/disponibles")
    public List<Habitacion> buscarDisponibles(
            @RequestParam String tipo,
            @RequestParam LocalDate fechaInicio,
            @RequestParam LocalDate fechaFin) {
        return habitacionService.buscarDisponibles(tipo, fechaInicio, fechaFin);
    }
    @PostMapping
    public ResponseEntity<Habitacion> crearHabitacion(@RequestBody Habitacion habitacion) {
        Habitacion nuevaHabitacion = habitacionService.crearHabitacion(habitacion);
        return ResponseEntity.ok(nuevaHabitacion);
    }
}

