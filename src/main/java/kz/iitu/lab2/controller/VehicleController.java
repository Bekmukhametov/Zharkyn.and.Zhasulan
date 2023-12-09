package kz.iitu.lab2.controller;

import kz.iitu.lab2.entity.Vehicle;
import kz.iitu.lab2.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/all")
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        List<Vehicle> vehicles = vehicleService.findAll();
        return ResponseEntity.ok(vehicles);
    }

    @GetMapping("/{vehicleId}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long vehicleId) {
        Vehicle vehicle = vehicleService.findById(vehicleId);
        return vehicle != null ? ResponseEntity.ok(vehicle) : ResponseEntity.notFound().build();
    }

    @PostMapping("/{accountId}")
    public ResponseEntity<String> addVehicle(@RequestBody Vehicle vehicle, @PathVariable Long accountId) {
        vehicleService.addVehicle(vehicle, accountId);
        return ResponseEntity.ok("Vehicle added successfully");
    }

    @DeleteMapping("/{vehicleId}")
    public ResponseEntity<String> deleteVehicle(@PathVariable Long vehicleId) {
        vehicleService.deleteById(vehicleId);
        return ResponseEntity.ok("Vehicle deleted successfully");
    }
}
