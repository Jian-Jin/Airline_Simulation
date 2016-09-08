package com.demo.action;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.demo.model.User;

public class UserDAOImpl implements UserDAO {

	private SqlSessionTemplate sqlSessionTemplate;
	
    
	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	public boolean checkLogin(String userName, String passWord) {
		User user = new User();
		user.setName(userName);
		user.setPassword(passWord);
		List<User> result = new ArrayList<User>();
		result =sqlSessionTemplate.selectList("com.demo.model.User.selectUser",user);
		// TODO Auto-generated method stub
		if (result.size()==1) {
			return true;
		} else {
			return false;
		}
	}
    


}

