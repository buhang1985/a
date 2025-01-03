package iih.pe.comm.i;

import xap.mw.core.data.BizException;

public interface IPeEventService {
	
	/**
	 * 发送体检挂号信息
	 * @param id_pepsnappt
	 */
	public void sendPeBs001(String id_pepsnappt) throws BizException;
	
	/**
	 * 发送体检检查申请单
	 * @param id_pepsnappt
	 */
	public void sendPeBs002(String id_pepsnappt) throws BizException;
	/**
	 * 发送体检检验申请单
	 * @param id_pepsnappt
	 */
	public void sendPeBs006(String id_pepsnappt) throws BizException;

}
