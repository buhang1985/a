package iih.ci.mrfp.cimrfpdto.i;

import iih.ci.mrfp.cimrfpdto.d.CiMrFpSugDTO;
import xap.mw.core.data.BizException;

public interface MrFpGetInfoMaintainService {
	
	/**
	 * 获取手术信息
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public abstract CiMrFpSugDTO[] getFpSugByRefresh(String id_ent) throws BizException;
	
	/**
	 * 获取手术信息
	 * @param id_mr
	 * @return
	 * @throws BizException
	 */
	public abstract CiMrFpSugDTO[] getFpSugByMrId(String id_mr) throws BizException;
	
	
}

