package com.terabits.dao;

public interface LogDAO {
	/**
	 * 添加日志
	 * @param name
	 * @param type
	 * @return
	 */
	public int insertLog(String name, int type);
	
	/**
	 * @param adminname
	 * @param type
	 * @param comments
	 * @return
	 * @throws Exception
	 */
	public int insertLogOfRecharge(String adminname, int type, String comments) throws Exception;
}
