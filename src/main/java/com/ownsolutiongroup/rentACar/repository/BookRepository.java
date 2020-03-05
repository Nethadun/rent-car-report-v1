package com.ownsolutiongroup.rentACar.repository;

import com.ownsolutiongroup.rentACar.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
