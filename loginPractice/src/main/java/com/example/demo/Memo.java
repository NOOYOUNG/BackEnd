package com.example.demo;

import lombok.*;
import jakarta.persistence.*;

@ToString
@Getter
@Builder
//@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_memo")
@Entity
public class Memo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 100, nullable = false)
	private String userId;

	@Column(length = 100, nullable = false)
	private String password;

	@Column(length = 50, nullable = false)
	private String name;

	@Column(nullable = false)
	private int age;
	
	@Column(length = 200, nullable = false)
	private String address;
	
	@Column(length = 200, nullable = false)
	private String phone;
	
    public Memo(Long id, String userId, String password, String name, int age, String address, String phone) {
        this.id = id;
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.age = age;
        this.address = address;
        this.phone = phone;
    }

}
