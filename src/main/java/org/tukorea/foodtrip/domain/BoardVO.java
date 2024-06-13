package org.tukorea.foodtrip.domain;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardVO {
	private Long boardId;
	private String title;
	private String content;
	private String userId;
	private String createdAt;
	private String updatedAt;
	private String category;
	private float rating;
	private int views;
	private String nickname;
	
	



}
