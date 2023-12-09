package kz.iitu.lab2.service;

import kz.iitu.lab2.entity.User;
import kz.iitu.lab2.entity.Vehicle;
import kz.iitu.lab2.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleService {
    private final VehicleRepository vehicleRepository;
    private final UserService userService;

    public Vehicle findById(Long id) {
        return vehicleRepository.findById(id).orElse(null);
    }

    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    public Vehicle save(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public void deleteById(Long id) {
        vehicleRepository.deleteById(id);
    }

    public Vehicle addVehicle(Vehicle vehicle, Long accountId) {
        User user = userService.findById(accountId);
        if (user == null) {
            throw new IllegalArgumentException("Account not found");
        }
        vehicle.setUser(user);
        return save(vehicle);
    }

    public void deleteVehicle(Long vehicleId) {
        deleteById(vehicleId);
    }

    public Vehicle updateVehicle(Vehicle vehicle) {
        return save(vehicle);
    }
}
