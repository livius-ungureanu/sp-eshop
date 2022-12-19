package com.lun.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lun.dto.LocationRequest;
import com.lun.model.Location;
import com.lun.repository.LocationRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepo locationRepository;

    public void createLocation(LocationRequest locationRequest) {
        locationRepository
            .save(Location.builder()
                    .name(locationRequest.getName())
                    .address(locationRequest.getAddress())
                    .zipCode(locationRequest.getZipCode())
                    .build());
    }

    public List<Location> getLocations() {
        return locationRepository.findAll();
    }
}
