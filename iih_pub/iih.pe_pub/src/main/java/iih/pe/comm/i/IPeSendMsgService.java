package iih.pe.comm.i;

import xap.mw.core.data.BizException;

public interface IPeSendMsgService {
	

	/**
	 * 获取体检登录用户
	 * @param id_dep
	 */
	public String[] findUserInfo(String id_dep,String id_org) throws BizException;

}
