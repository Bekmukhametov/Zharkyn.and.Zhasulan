package kz.iitu.lab2.service;

import kz.iitu.lab2.entity.DriverLicense;
import kz.iitu.lab2.entity.User;
import kz.iitu.lab2.repository.DriverLicenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverLicenseService {

    private final DriverLicenseRepository driverLicenseRepository;

    private final UserService userService;

    public DriverLicense findById(Long id) {
        return driverLicenseRepository.findById(id).orElse(null);
    }

    public List<DriverLicense> findAll() {
        return driverLicenseRepository.findAll();
    }

    public DriverLicense save(DriverLicense driverLicense) {
        return driverLicenseRepository.save(driverLicense);
    }

    public void deleteById(Long id) {
        driverLicenseRepository.deleteById(id);
    }

    public DriverLicense findByAccountId(Long accountId) {
        User user = userService.findById(accountId);
        if (user == null) {
            throw new IllegalArgumentException("Account not found");
        }
        return driverLicenseRepository.findByUser(user);
    }

    public void addDriverLicense(DriverLicense license, Long accountId) {
    }
}