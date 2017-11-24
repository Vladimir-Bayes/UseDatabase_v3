package com.terabits.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.terabits.dao.LogDAO;
import com.terabits.mapper.LogMapper;
import com.terabits.utils.DBTools;

@Repository("logDAO")
public class LogDAOImpl implements LogDAO {

	public int insertLog(String name, int type) {
		SqlSession session = DBTools.getSession();
        LogMapper mapper = session.getMapper(LogMapper.class);
        try {
        	mapper.insertLog(name, type);
        	session.commit();
        	return 200;
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
            return 400;
        } finally {
        	session.close();
        }
	}
	
	public int insertLogOfRecharge(String adminname, int type, String comments) throws Exception {
		SqlSession session = DBTools.getSession();
		LogMapper mapper = session.getMapper(LogMapper.class);
		try {
			mapper.insertLogOfRecharge(adminname, type, comments);
			session.commit();
			return 200;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.rollback();
			return 400;
		} finally {
			session.close();
		}
	}
	

}
