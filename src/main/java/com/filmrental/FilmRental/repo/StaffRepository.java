package com.filmrental.FilmRental.repo;

import com.filmrental.FilmRental.dto.StaffStoreDTO;
import com.filmrental.FilmRental.model.Staff;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Byte> {

    @Query("""
        SELECT new com.filmrental.FilmRental.dto.StaffStoreDTO(
            s.staffId,
            s.firstName,
            s.lastName,
            st.storeId,
            a.addressId
        )
        FROM Staff s
        JOIN s.store st
        JOIN s.address a
    """)
    List<StaffStoreDTO> getStaffWithStoreDetails();

    Optional<Staff> findByUsername(String username);
}