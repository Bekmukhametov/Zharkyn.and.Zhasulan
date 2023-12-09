package kz.iitu.lab2.controller;

import kz.iitu.lab2.entity.DriverLicense;
import kz.iitu.lab2.entity.TrafficViolation;
import kz.iitu.lab2.service.DataManagementService;
import kz.iitu.lab2.service.DriverLicenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/licenses")
@RequiredArgsConstructor
public class DriverLicenseController {
    private final DriverLicenseService driverLicenseService;
    private final DataManagementService dataManagementService;

    @GetMapping("/{licenseId}")
    public ResponseEntity<DriverLicense> getDriverLicenseById(@PathVariable Long licenseId) {
        DriverLicense license = driverLicenseService.findById(licenseId);
        return license != null ? ResponseEntity.ok(license) : ResponseEntity.notFound().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<DriverLicense>> getAllViolations() {
        List<DriverLicense> driverLicenses = driverLicenseService.findAll();
        return ResponseEntity.ok(driverLicenses);
    }

    @PostMapping("/{accountId}")
    public ResponseEntity<String> addDriverLicense(@RequestBody DriverLicense license, @PathVariable Long accountId) {
        dataManagementService.addDriverLicense(license, accountId);
        return ResponseEntity.ok("Driver license added successfully");
    }

    @GetMapping("/account/{accountId}")
    public ResponseEntity<DriverLicense> getDriverLicenseByAccountId(@PathVariable Long accountId) {
        try {
            DriverLicense license = driverLicenseService.findByAccountId(accountId);
            return ResponseEntity.ok(license);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{licenseId}")
    public ResponseEntity<String> deleteDriverLicense(@PathVariable Long licenseId) {
        driverLicenseService.deleteById(licenseId);
        return ResponseEntity.ok("Driver license deleted successfully");
    }
}

