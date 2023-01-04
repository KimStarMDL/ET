package com.myet.basic.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
	
//	@NotBlank(message = "아이디는 필수 입력사항 입니다.")
//	@Pattern(message = "5자 이상 입력", regexp = "[a-zA-Z0-9]{5,}")
	private String u_id;  //회원 아이디
//	@Pattern(message = "2자 이상 입력", regexp = "[a-zA-Z0-9가-힣]{2,}")
	private String u_nick;  //회원 닉네임
//	@Pattern(message = "영문 또는 한글, 숫자 포함하여 8자 이상으로 입력", regexp = "[a-zA-Z0-9]{8,}")
	private String u_pw;  //회원 비밀번호
//	@Pattern(message = "이메일 형식에 맞게 입력", regexp = "[a-zA-Z0-9]{5,}@[a-z]{3,}.[a-z]{3,}")
	private String u_email;  //회원 이메일

}
