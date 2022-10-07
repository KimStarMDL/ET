package com.myet.basic.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class LifetipDTO {
	
	private int lt_num;
	private String u_id;
	@NotBlank(message = "입력해주세요.")
	private String lt_title;
	private String lt_content;
	private LocalDateTime lt_date;
	private int lt_view;
	

}
