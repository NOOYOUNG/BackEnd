package com.board.main;

import org.springframework.stereotype.Repository;

import com.board.main.SimpleBoard.SimpleBoardBuilder;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SimpleBoardRepository extends JpaRepository<SimpleBoard, Long> {

	Long countByIdAndPassword(Long contentsId, String password);


	
}
