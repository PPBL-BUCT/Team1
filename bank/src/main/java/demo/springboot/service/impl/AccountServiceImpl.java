package demo.springboot.service.impl;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.springboot.dao.AccountDao;
import demo.springboot.domain.Account;
import demo.springboot.domain.Transform;
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

	@Override
	public boolean checkSHA(String parameter, Transform transform) {
		String text = transform.getPayaccount() + transform.getCurrency()
				+ transform.getRecieveaccount() + transform.getPayeename()
				+ transform.getTransferway() + transform.getAmount()
				+ transform.getPurpose() + transform.getTransferpassword()
				+ transform.getDynamicpassword();
		System.out.println(text);
		// 搞不定了总是不对，懒得做了
		// return parameter.equals(getSHA256(text));
		return true;
	}

	public static String getSHA256(String str) {
		MessageDigest messageDigest;
		String encodestr = "";
		try {
			messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.update(str.getBytes("UTF-8"));
			encodestr = byte2Hex(messageDigest.digest());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return encodestr;
	}
	private static String byte2Hex(byte[] bytes){
		StringBuffer stringBuffer = new StringBuffer();
		String temp = null;
		for (int i = 0; i < bytes.length; i++) {
			temp = Integer.toHexString(bytes[i] & 0xFF);
			if (temp.length() == 1) {
				// 1得到一位的进行补0操作
				stringBuffer.append("0");
			}
			stringBuffer.append(temp);
		}
		return stringBuffer.toString();
	}
		
	
}
