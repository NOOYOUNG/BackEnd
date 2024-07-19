package com.board.main;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberInfoRepository extends JpaRepository<MemberInfo, Long> {

	Long countByNameAndPassword(String name, String password);

	MemberInfo findByName(String name);

	MemberInfo findById(String userId);

}
