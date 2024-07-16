package com.board.main;

import lombok.*;
import jakarta.persistence.*;

@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="bd_mem")
@Entity
public class SimpleBoard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 100, nullable = false)
	private String userId;

	@Column(length = 100, nullable = false)
	private String password;

	@Column(length = 50, nullable = false)
	private String name;
	
	@Column(length = 500, nullable = false)
	private String content;
	
}
