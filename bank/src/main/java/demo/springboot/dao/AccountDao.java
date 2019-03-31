package demo.springboot.dao;

import demo.springboot.domain.Account;

public interface AccountDao {
    int deleteByPrimaryKey(Integer account);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer account);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
}