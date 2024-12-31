package iih.bl.itf.std;

import xap.mw.core.data.BizException;

/**
 * 费用标准对外服务--门诊自助发票查询
 * @author shaokx 2019/2/25
 *
 */
public interface IBlOpIncRService {
	
	/**
	 * 门诊自助发票查询（查询一个患者的发票信息）
	 * @param param
	 * @return
	 * @throws BizException
	 * @author shaokx 2019/2/25
	 */
	public abstract String getPatIncInfo(String param) throws BizException;
	
	/**
	 * 门诊自助发票明细查询（根据一个结算id查询发票明细信息）
	 * @param param
	 * @return
	 * @throws BizException
	 * @author shaokx 2019/2/25
	 */
	public abstract String getIncItmInfo(String param) throws BizException;
	
}
