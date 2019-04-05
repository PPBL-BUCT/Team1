package demo.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.springboot.dao.AccountDao;
import demo.springboot.domain.Account;
import demo.springboot.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountDao accountDao;
	
	@Override
	public int deleteByPrimaryKey(Integer account) {
		return accountDao.deleteByPrimaryKey(account);
		// TODO Auto-generated method stub
		//
	}

	@Override
	public int insert(Account record) {
		// TODO Auto-generated method stub
		return accountDao.insert(record);
		//先和核心业务服务器验证密码,验证成功调用Dao层将Status位置1
	}

	@Override
	public int insertSelective(Account record) {
		// TODO Auto-generated method stub
		return accountDao.insertSelective(record);
	}

	@Override
	public Account selectByPrimaryKey(Integer account) {
		// TODO Auto-generated method stub
		return accountDao.selectByPrimaryKey(account);
	};

	@Override
	public int updateByPrimaryKeySelective(Account record) {
		// TODO Auto-generated method stub
		return accountDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Account record) {
		// TODO Auto-generated method stub
		return accountDao.updateByPrimaryKey(record);
	}

	@Override
	public List<Account> getAll(String user_id) {
		// TODO Auto-generated method stub
		return accountDao.getAll(user_id);
	}
	
}
