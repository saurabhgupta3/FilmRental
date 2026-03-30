package com.filmrental.FilmRental.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filmrental.FilmRental.dto.StaffStoreDTO;
import com.filmrental.FilmRental.service.StaffService;

@RestController
@RequestMapping("/api/staff")
public class StaffController {

    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping("/store")
    public List<StaffStoreDTO> getStaffDetails() {
        return staffService.getStaffDetails();
    }
}