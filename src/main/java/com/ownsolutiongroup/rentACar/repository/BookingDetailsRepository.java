package com.ownsolutiongroup.rentACar.repository;

import com.ownsolutiongroup.rentACar.entity.BookingDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingDetailsRepository extends JpaRepository<BookingDetails,Long> {
}
