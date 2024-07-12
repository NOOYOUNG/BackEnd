package com.example.demo;

import lombok.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "book_info")
@Entity
public class BookInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 100, nullable = false)
	private String bookName;
	
	@Column(length = 100, nullable = false)
	private String isbn;
	
	@Column(length = 100, nullable = false)
	private String author;
	
	@Column(length = 100, nullable = false)
	private String publisher;
	
	@Column(length = 100, nullable = false)
	private LocalDate publishDate;
	
}
