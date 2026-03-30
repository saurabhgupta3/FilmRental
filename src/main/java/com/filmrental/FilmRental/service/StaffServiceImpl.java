package com.filmrental.FilmRental.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.filmrental.FilmRental.dto.StaffStoreDTO;
import com.filmrental.FilmRental.repo.StaffRepository;

@Service
public class StaffServiceImpl implements StaffService {

    private final StaffRepository staffRepository;

    public StaffServiceImpl(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public List<StaffStoreDTO> getStaffDetails() {
        return staffRepository.getStaffWithStoreDetails();
    }
}