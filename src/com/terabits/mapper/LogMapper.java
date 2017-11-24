package com.terabits.mapper;

import org.apache.ibatis.annotations.Param;

public interface LogMapper {
	/**
	 * 添加日志
	 * @param name
	 * @param type
	 * @return
	 */
	public int insertLog(@Param("name") String name, @Param("type") int type);
	
	/**
	 * @param adminname
	 * @param type
	 * @param comments
	 * @return
	 */
	public int insertLogOfRecharge(@Param("adminname") String adminname, @Param("type") int type, @Param("comments") String comments);
}
