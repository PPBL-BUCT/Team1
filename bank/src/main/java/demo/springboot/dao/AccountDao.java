package demo.springboot.dao;

import org.apache.ibatis.annotations.Mapper;

import demo.springboot.domain.Account;

@Mapper
public interface AccountDao {
    int deleteByPrimaryKey(Integer account);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer account);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
}