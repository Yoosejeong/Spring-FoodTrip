package org.tukorea.foodtrip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.tukorea.foodtrip.domain.UserVO;
import org.tukorea.foodtrip.persistence.UserDAO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	public void joinUser(UserVO userVO) throws Exception {
	    userDAO.join(userVO);
	}

	public UserVO readUser(String userId) throws Exception {
		return userDAO.read(userId);
	}
	
	@Transactional(propagation = Propagation.REQUIRED,  rollbackFor = Exception.class)
	public void deleteUser(String userId) throws Exception {
		userDAO.deleteUserBoards(userId);
		userDAO.delete(userId);
	}

	public void updateUser(UserVO userVO) throws Exception {
		userDAO.update(userVO);
	}

	public int loginUser(UserVO userVO) throws Exception {

		return userDAO.login(userVO);

	}
	
	public boolean isUserIdExists(String userId) throws Exception {
		return userDAO.checkUserIdExists(userId) > 0;
	}

	public boolean isNicknameExists(String nickname) throws Exception {
		return userDAO.checkNicknameExists(nickname) > 0;
	}
}
