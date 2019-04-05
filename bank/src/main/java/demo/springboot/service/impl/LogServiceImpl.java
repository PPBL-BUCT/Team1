package demo.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.springboot.dao.LogDao;
import demo.springboot.domain.Log;
import demo.springboot.service.LogService;

@Service
public class LogServiceImpl implements LogService{
	@Autowired
	private LogDao logDao;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return logDao.deleteByPrimaryKey(id);
	}
    //删除账号生成日志
	@Override
	public int insert(Log record) {
		// TODO Auto-generated method stub
		return logDao.insert(record);
	}
   //加挂账号生成日志
	@Override
	public int insertSelective(Log record) {
		// TODO Auto-generated method stub
		return logDao.insertSelective(record);
	}

	@Override
	public Log selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return logDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Log record) {
		// TODO Auto-generated method stub
		return logDao.updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKey(Log record) {
		// TODO Auto-generated method stub
		return logDao.updateByPrimaryKeySelective(record);
	}
	@Override
	public List<Log> selectList(Log log) {
		// TODO Auto-generated method stub
		return logDao.selectList(log);
	}


}
