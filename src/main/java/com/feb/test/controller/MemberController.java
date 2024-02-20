package com.feb.test.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.feb.test.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	// 회원가입 페이지 : /loginPage.do
	@GetMapping("/loginPage.do")
	public ModelAndView loginForm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	
	/* 
	  	회원가입 : /join.do
	    params.get("memberId") : 회원 ID
	 	params.get("passwd") : 회원 비밀번호
	 	params.get("email") : 회원 이메일
	 */
	 
	@PostMapping("/join.do")
	public ModelAndView join(@RequestParam HashMap<String, String> params) { // @RequestParam 붙여야한다
		
		ModelAndView mv = new ModelAndView();
		
		System.out.println("params : " + params.get("memberId"));
		System.out.println("passwd : " + params.get("passwd"));
		System.out.println("email : " + params.get("email"));

		
		// 회원 테이블에 정보 입력하기 
		// inset이기 때문에 반환 타입은 int (1 성공, 0실패)
		int result = memberService.join(params);
		
		
		System.out.println("result333333333333333333 : " + result);
		mv.setViewName("login");
		return mv;
	}
}


