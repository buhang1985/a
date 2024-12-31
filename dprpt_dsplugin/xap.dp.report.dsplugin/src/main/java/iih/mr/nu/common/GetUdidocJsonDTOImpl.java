package iih.mr.nu.common;

import iih.mr.nu.common.bp.GetUdiJsonBp;
import iih.mr.nu.common.javabean.UdidocJsonDTO;

public class GetUdidocJsonDTOImpl {

	/**
	 * 获取Json格式的自定义档案数据（带□的自定义档案）
	 * @param fullclassname
	 * @return
	 * @throws Exception
	 */
	public UdidocJsonDTO[] exec(String fullclassname) throws Exception {
		
		GetUdiJsonBp bp = new GetUdiJsonBp();
		
		return bp.exec(fullclassname);
	}
}
