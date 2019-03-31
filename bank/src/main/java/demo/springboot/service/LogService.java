package demo.springboot.service;

import demo.springboot.domain.Log;

public interface LogService {
	    int deleteByPrimaryKey(Integer id);

	    int insert(Log record);

	    int insertSelective(Log record);

	    Log selectByPrimaryKey(Integer id);

	    int updateByPrimaryKeySelective(Log record);

	    int updateByPrimaryKey(Log record);
}
