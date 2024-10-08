package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
public interface BookDao extends JpaRepository<BookInfo, Long>{
	@Transactional
	void deleteById(Long id);

	List<BookInfo> findByBookNameContains(String searchText);

	Optional<BookInfo> findById(Long id);
}
