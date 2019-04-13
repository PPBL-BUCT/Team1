package demo.springboot.service;

import java.util.List;

import demo.springboot.domain.Account;
import demo.springboot.domain.Transform;

public interface AccountService {
	int deleteByPrimaryKey(Integer account);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer account);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);

	List<Account> getAll(String user_id);

	boolean checkSHA(String parameter, Transform transform);
}
