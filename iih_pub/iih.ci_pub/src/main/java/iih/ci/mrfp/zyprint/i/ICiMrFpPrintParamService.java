package iih.ci.mrfp.zyprint.i;

import xap.mw.core.data.BizException;

public interface ICiMrFpPrintParamService {

	/**
	 * 病案首页中医打印
	 * @param id_org
	 * @return
	 * @throws BizException
	 */
	public abstract Boolean GetPrintParam(String id_org) throws BizException;
}
