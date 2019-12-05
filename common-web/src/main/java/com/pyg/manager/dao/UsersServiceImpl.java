package com.pyg.manager.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pyg.manager.dao.mapper.AuthoritiesMapper;
import com.pyg.manager.dao.mapper.UsersMapper;
import com.pyg.manager.dao.pojo.Authorities;
import com.pyg.manager.dao.pojo.AuthoritiesExample;
import com.pyg.manager.dao.pojo.Users;
import com.pyg.manager.dao.pojo.UsersExample;
import com.pyg.manager.dao.pojo.UsersExample.Criteria;

import entity.PageResult;

/**
 * 服务实现层
 * 
 * @author Administrator
 *
 */

@Service("usersService")
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersMapper usersMapper;

	@Autowired
	private AuthoritiesMapper authoritiesMapper;

	/**
	 * 查询全部
	 */
	@Override
	public List<Users> findAll() {
		return usersMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Page<Users> page = (Page<Users>) usersMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(Users users) {
		usersMapper.insert(users);
		Authorities authorities = new Authorities();
		authorities.setUsername(users.getUsername());
		authorities.setAuthority("ROLE_ADMIN");
		authoritiesMapper.insert(authorities);
	}

	/**
	 * 修改
	 */
	@Override
	public void update(Users users) {
		usersMapper.updateByPrimaryKey(users);
	}

	@Override
	public PageResult findPage(Users users, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);

		UsersExample example = new UsersExample();
		Criteria criteria = example.createCriteria();

		if (users != null) {
			if (users.getUsername() != null
					&& users.getUsername().length() > 0) {
				criteria.andUsernameLike("%" + users.getUsername() + "%");
			}
			if (users.getPassword() != null
					&& users.getPassword().length() > 0) {
				criteria.andPasswordLike("%" + users.getPassword() + "%");
			}
			if (users.getUsernamealias() != null
					&& users.getUsernamealias().length() > 0) {
				criteria.andUsernamealiasLike(
						"%" + users.getUsernamealias() + "%");
			}
			if (users.getInfo1() != null && users.getInfo1().length() > 0) {
				criteria.andInfo1Like("%" + users.getInfo1() + "%");
			}
			if (users.getInfo2() != null && users.getInfo2().length() > 0) {
				criteria.andInfo2Like("%" + users.getInfo2() + "%");
			}
		}
		Page<Users> page = (Page<Users>) usersMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}

	@Override
	public Users findOne(String userName) {
		return usersMapper.selectByPrimaryKey(userName);
	}

	@Override
	public void delete(String[] userNames) {
		for (String userName : userNames) {

			AuthoritiesExample authoritiesExample = new AuthoritiesExample();
			AuthoritiesExample.Criteria criteria = authoritiesExample
					.createCriteria();
			criteria.andUsernameEqualTo(userName);
			authoritiesMapper.deleteByExample(authoritiesExample);
			usersMapper.deleteByPrimaryKey(userName);

		}
	}

}
