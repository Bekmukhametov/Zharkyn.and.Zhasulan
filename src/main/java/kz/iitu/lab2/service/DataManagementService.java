package kz.iitu.lab2.service;

import kz.iitu.lab2.entity.DriverLicense;
import kz.iitu.lab2.entity.User;
import kz.iitu.lab2.entity.Vehicle;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DataManagementService {
    private final DriverLicenseService driverLicenseService;
    private final VehicleService vehicleService;
    private final UserService userService;

    public DriverLicense addDriverLicense(DriverLicense driverLicense, Long accountId) {
        User user = userService.findById(accountId);
        driverLicense.setUser(user);
        return driverLicenseService.save(driverLicense);
    }

    public void deleteDriverLicense(Long licenseId) {
        driverLicenseService.deleteById(licenseId);
    }

    public Vehicle updateVehicle(Vehicle vehicle) {
        return vehicleService.save(vehicle);
    }
}

