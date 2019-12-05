package com.pyg.manager.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pyg.manager.dao.UsersService;
import com.pyg.manager.dao.pojo.Users;

import entity.PageResult;
import entity.Result;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private UsersService usersService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<Users> findAll(){			
		return usersService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return usersService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param users
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody Users users){
		try {
			users.setEnabled(true);
			usersService.add(users);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param users
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody Users users){
		try {
			users.setEnabled(true);
			usersService.update(users);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
	}	
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public Users findOne(String id){
		return usersService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(String [] ids){
		try {
			usersService.delete(ids);
			return new Result(true, "删除成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
		/**
	 * 查询+分页
	 * @param brand
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody Users users, int page, int rows  ){
		return usersService.findPage(users, page, rows);		
	}
	
}
