package org.tukorea.foodtrip.persistence;

import java.util.List;

import org.tukorea.foodtrip.domain.UserVO;

public interface UserDAO {
	public void join(UserVO userVO) throws Exception;

	public UserVO read(String userId) throws Exception;

	public void delete(String userId) throws Exception;

	public void update(UserVO userVO) throws Exception;

	public int login(UserVO userVO) throws Exception;

	public List<UserVO> readList() throws Exception;

	public void deleteUserBoards(String userId)throws Exception;
	
	public int checkUserIdExists(String userId)throws Exception;

	public int checkNicknameExists(String nickname) throws Exception;

}
