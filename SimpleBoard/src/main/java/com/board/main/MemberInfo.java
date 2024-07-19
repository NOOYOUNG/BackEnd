package com.board.main;

import lombok.*;
import jakarta.persistence.*;

@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="api_mem")
@Entity

public class MemberInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 100, nullable = false)
	private String password;
	
	@Column(length = 100, nullable = false)
	private String name;

	
}
