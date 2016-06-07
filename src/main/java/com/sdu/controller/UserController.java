package com.sdu.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import sun.awt.ModalExclude;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sdu.po.User;
import com.sdu.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "index.do", method = RequestMethod.POST)
	public void getUserList(Model model, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		JSONObject o = new JSONObject();
		List users = userService.getUsers();
		JSONArray array = new JSONArray();
		for (Map<String, Object> map : (List<Map<String, Object>>) users) {
			JSONObject object = new JSONObject();
			object.put("map", map);
			array.add(object);
		}
		o.put("result", array);
		response.getWriter().write(o.toString());
		response.getWriter().flush();
		response.getWriter().close();
	}

	@RequestMapping(value = "edit.do", method = { RequestMethod.GET })
	public String edit(@RequestParam("id") Integer id, Model model,
			HttpServletResponse response, HttpServletRequest request)
			throws Exception {
		model.addAttribute("user", userService.getUserById(id));
		return "edit";
	}

	@RequestMapping(value = "editSubmit.do", method = { RequestMethod.POST })
	public void updateUser(@ModelAttribute("user") User user,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		userService.updatePo(user, user.getId());
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	@RequestMapping(value = "addSubmit.do", method = { RequestMethod.POST })
	public void addSubmit(@ModelAttribute("user") User user,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		userService.savePo(user);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		// return "./index";
	}

	@RequestMapping(value = "delete.do", method = { RequestMethod.GET })
	public void addSubmit(@RequestParam("id") Integer id,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		userService.daletePo(id);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}
