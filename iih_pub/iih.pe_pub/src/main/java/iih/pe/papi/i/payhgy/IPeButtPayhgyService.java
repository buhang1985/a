package iih.pe.papi.i.payhgy;

import xap.mw.core.data.BizException;

public interface IPeButtPayhgyService {

	/*
	 * 获取病理结果
	 * 
	 */
	public abstract Boolean pePatientConnectPayhgy (String id_pepsnappt) throws BizException;

}
