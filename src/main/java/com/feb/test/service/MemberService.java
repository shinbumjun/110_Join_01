package com.feb.test.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feb.test.dao.MemberDao;

@Service
public class MemberService {

	@Autowired
	MemberDao memberDao;
	
	// 회원가입
	public int join(HashMap<String, String> params) {
		System.out.println("params222222222222222222 : " + params);
		return memberDao.join(params);
	}

}
