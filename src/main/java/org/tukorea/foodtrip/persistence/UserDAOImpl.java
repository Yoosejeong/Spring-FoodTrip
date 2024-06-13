package org.tukorea.foodtrip.persistence;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.tukorea.foodtrip.domain.UserVO;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SqlSession sqlSession;

	private static final String namespace = "org.tukorea.foodtrip.mapper.userMapper";

	public UserVO read(String userId) throws Exception {

		UserVO userVO = sqlSession.selectOne(namespace + ".selectByid", userId);
		return userVO;
	}

	public void join(UserVO userVO) throws Exception {
		sqlSession.insert(namespace + ".insert", userVO);
	}

	public void delete(String userId) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace + ".delete", userId);
	}

	public void update(UserVO userVO) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(namespace + ".update", userVO);
	}

	public int login(UserVO userVO) throws Exception {
		return sqlSession.selectOne(namespace + ".Login", userVO);
	}

	public List<UserVO> readList() throws Exception {
		List<UserVO> userlist = new ArrayList<UserVO>();
		userlist = sqlSession.selectList(namespace + ".selectAll");
		return userlist;
	}

	public void deleteUserBoards(String userId) throws Exception {
		sqlSession.delete(namespace + ".deleteUserBoards", userId);
	}

	public int checkUserIdExists(String userId) {
		return sqlSession.selectOne(namespace + ".checkUserIdExists", userId);
	}

	public int checkNicknameExists(String nickname) {
		return sqlSession.selectOne(namespace + ".checkNicknameExists", nickname);
	}
}
