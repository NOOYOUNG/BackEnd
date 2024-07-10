package com.example.demo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface MemoRepository extends JpaRepository<Memo, Long> {
	Long countByUserIdAndPassword(String userId, String pwd);

	Memo findByUserId(String userId);

	@Transactional // 연속해서 삭제되지 않도록 트랜잭셔널
	void deleteByUserId(String userId); // 삭제시 반환할 값 없기 때문에 void	
	
}
