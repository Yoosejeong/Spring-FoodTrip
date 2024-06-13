package org.tukorea.foodtrip.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserVO {
	private String userId;
	private String passwd;
	private String email;
	private String phone;
	private String nickname;

}
