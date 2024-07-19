package com.board.main;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.board.main.SimpleBoard.SimpleBoardBuilder;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SimpleBoardRepository extends JpaRepository<SimpleBoard, Long> {

	Long countByIdAndPassword(Long contentsId, String password);

	Long countByNameAndPassword(String userName, String userPassword);

	@Transactional
	void deleteByName(String userName);

	Long countByIdAndPassword(String userId, String userPassword);

	Long countById(Long contentsId);


	
}
