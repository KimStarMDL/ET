package com.myet.basic.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myet.basic.dto.UserDTO;
import com.myet.basic.user.UserService;
import com.mysql.cj.Session;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/login")
	public String userLogin() {

		return "login";
	}

	@PostMapping("/login")
	public String loginForm(UserDTO dto, HttpServletRequest request, RedirectAttributes rttr, Model model) {
		HttpSession session = request.getSession();
		UserDTO user = userService.login(dto);
		System.out.print(user);

		if (user == null) { // 로그인 실패
			session.setAttribute("user", null);
			model.addAttribute("msg", "입력하신 정보가 일치하지 않습니다."); // 로그인 실패시 보내는 메세지
			System.out.print("로그인 실패");
			return "login";
		} else {
			session.setAttribute("user", user); // 로그인 성공
		}

		return "redirect:/main";
	}

	@GetMapping("/logout")
	public String userLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/main";
	}

	@GetMapping("/signUp")
	public String userInsert() {

		return "signUp";
	}

	@PostMapping("/signUpForm")
	public String signUpForm(@Valid UserDTO dto, Errors errors, Model model, String u_id, String u_nick) {

		if (errors.hasErrors()) {
			List<FieldError> list = errors.getFieldErrors();
			for (FieldError err : list) {
				System.out.print(err.getField());

				if (err.isBindingFailure()) {

					model.addAttribute("valid_" + err.getField());
					System.out.print("적용안댐");
				} else {
					model.addAttribute("valid" + err.getField(), err.getDefaultMessage());
					System.out.print("적용안댐2");
				}
			}

			// 다시 회원가입 화면으로
			model.addAttribute("u_dto", dto);
			return "signUp";
		}

//		int idResult = userService.idCheck(u_id);
//		int nickResult = userService.nickCheck(u_nick);
//		
//		if(idResult == 1 || nickResult == 1) {
//			return "signUp";
//		}

		boolean b = userService.userInsert(dto);
		return "redirect:main";
	}

//	@PostMapping("/idCheck")
//	@ResponseBody
//	public int idCheck(String u_id) {
//		int result = userService.idCheck(u_id);
//		return result;
//	}

	@PostMapping("/idCheck")
	@ResponseBody
	public int idCheck(@RequestBody HashMap<String, String> map) {

		return userService.idCheck(map.get("u_id"));
	}

	@PostMapping("/nickCheck")
	@ResponseBody
	public int nickCheck(@RequestBody HashMap<String, String> map) {

		return userService.nickCheck(map.get("u_nick"));
	}

	@PostMapping("/emailCheck")
	@ResponseBody
	public int emailCheck(@RequestBody HashMap<String, String> map) {

		return userService.emailCheck(map.get("u_email"));
	}

	@GetMapping("/mypage")
	public String userMypage() {

		
		/*
		 * String my_id = (String)session.getAttribute("u_id");
		 * 
		 * UserDTO mydto = userService.userRead(my_id);
		 * 
		 * model.addAttribute("mydto", mydto);
		 */

		return "mypage";
	}

	@PostMapping("/mypage")
	public String mypageForm(Model model, @RequestParam("u_id") String u_id) {

		model.addAttribute("userDTO", userService.userRead(u_id));
		
		return "redirect:mypage";
	}

	@GetMapping("/userInfo")
	public String userInfo() {

		return "";
	}

	@PostMapping("/userUpdate")
	public String userUpdate() {

		return "";
	}

	@PostMapping("/userDelete")
	public String userDelete() {

		return "";
	}

}
