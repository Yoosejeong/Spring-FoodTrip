package org.tukorea.foodtrip.service;

import org.tukorea.foodtrip.domain.UserVO;

public interface UserService {
	public void joinUser(UserVO userVO) throws Exception;

	public UserVO readUser(String userId) throws Exception;

	public void deleteUser(String userId) throws Exception;

	public void updateUser(UserVO userVO) throws Exception;

	public int loginUser(UserVO userVO) throws Exception;

	public boolean isUserIdExists(String userId) throws Exception;

	public boolean isNicknameExists(String nickname) throws Exception;
}
