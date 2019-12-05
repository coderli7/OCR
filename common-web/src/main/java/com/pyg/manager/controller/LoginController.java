package com.pyg.manager.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pyg.manager.commonutils.MyCommonUtils;

@RestController
@RequestMapping("/login")
public class LoginController {

	@SuppressWarnings({"rawtypes", "unchecked"})
	@RequestMapping("/name")
	public Map name() {
		String name = MyCommonUtils.getCurUser();
		Map map = new HashMap<>();
		map.put("loginName", name);
		return map;
	}

}
