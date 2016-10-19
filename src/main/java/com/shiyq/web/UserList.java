package com.shiyq.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shiyq.mybatis.dao.UserDao;
import com.shiyq.mybatis.domain.User;

@Controller
public class UserList {

	@Autowired
	UserDao userDao;

	@RequestMapping("/user/list")
	public String userList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter pt = response.getWriter();
		
		User user1 = new User();
		String user_name = "shiyq"+String.valueOf(Math.random()*100000).substring(0,3);
		user1.setUser_name(user_name);
		user1.setPassword("密码");
		user1.setComment("注释，"+user_name);
		userDao.insert(user1);
		List<User> users = userDao.selectAll();
		int i = 0;
		pt.println("<pre>");
		int count = this.userDao.countAll();

		pt.println(count);
		for (User user : users) {
			System.out.println("用户名:" + user.getUser_name() + ", 密码：" + user.getPassword());
			pt.print(++i+", ");
			pt.println("用户名:" + user.getUser_name() + ", 密码：" + user.getPassword()+", 注释："+user.getComment());
		}
		pt.println("</pre>");
		return null;

	}
}
