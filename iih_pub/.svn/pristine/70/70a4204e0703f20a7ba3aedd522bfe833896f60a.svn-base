package iih.ci.ord.external.blood.ruimei.i;

import xap.mw.core.data.BizException;

public interface IRuiMeiBloodManageService {
	
	String getUserInfo(String param) throws BizException;
	String getDeptInfo(String param) throws BizException;
	/**
	 * 获取科室所有住院信息
	 * @param xmlParam
	 * @return
	 * @throws BizException
	 */
	String getIpInfoByDep(String xmlParam) throws BizException;
	String getIpInfoByPat(String xmlParam) throws BizException;
	/**
	 * 通过住院号查询住院信息
	 * 
	 * @param param
	 * @return
	 */
	String getIpInfoByIpCode(String xmlParam) throws BizException;
	/**
	 * 回写备血医嘱信息
	 * 
	 * @param param
	 * @return
	 */
	String writebackpbt(String param) throws BizException;
	/**
	 * 回写用血医嘱信息
	 * 
	 * @param param
	 * @return
	 */
	String writebackubt(String param) throws BizException;
	/**
	 * 备用血医嘱作废
	 * 
	 * @param param
	 * @return
	 */
	String writebackcanclebubt(String param) throws BizException;
	/**
	 * 万全血库用血
	 * 回写用血医嘱并补费
	 */
	String writebackubtAddFee(String param) throws BizException;

}
