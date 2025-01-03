package iih.hp.cp.i.external.privode;

import xap.mw.core.data.BizException;

/**
 * 就诊获取临床路径接口
 * @author HUMS
 *
 */
public interface IHpCpEnRService {
	
	/**
	 * 根据就诊id判断患者能否出院
	 * 
	 * @param entId 就诊id
	 * @return true：能出院；false：不能出院
	 * @throws BizException 
	 */
	public boolean canLeaveHospital(String entId) throws BizException;
	/**
	 * 根据就诊id判断患者能否转科
	 * 
	 * @param entId 就诊id
	 * @return true：能转科；false：不能转科
	 * @throws BizException 
	 */
	public boolean canConversionDepartment(String entId) throws BizException;
}
