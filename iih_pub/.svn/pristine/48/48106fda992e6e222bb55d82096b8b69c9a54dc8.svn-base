package iih.mp.dg.alert.i;

import xap.mw.core.data.BizException;

public interface IMpdgMsgAlertService {
	
	/**
	*  药房缺药消息提醒
	*/
	public abstract void sendDrugLackMsg(String[] id_dgipaps) throws BizException;
	
	/**
	 *  药单发送完成后发送消息提醒给对应药房的用户
	 */
	public abstract void sendAplistToPharmacyMsg(String[] id_dgipaps) throws BizException;
}
