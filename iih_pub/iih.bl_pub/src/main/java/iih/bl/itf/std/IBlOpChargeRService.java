package iih.bl.itf.std;

import xap.mw.core.data.BizException;

/**
 * 费用标准对外服务--门诊收费查询服务
 * @author ly 2018/7/16
 *
 */
public interface IBlOpChargeRService {
	
	/**
	 * 门诊费用清单查询
	 * @param param
	 * @return
	 * @throws BizException
	 * @author ly 2018/7/16
	 */
	public abstract String getCostBill(String param) throws BizException;
	
	/**
	 * 门诊自助支付待缴查询
	 * @param param
	 * @return
	 * @throws BizException
	 * @author shaokx 2019/1/9
	 */
	public abstract String getNoPay(String param) throws BizException;
	
	/**
	 * 门诊自助支付待缴查询新(跟旧的相比换了预划价接口)
	 * @param param
	 * @return
	 * @throws BizException
	 * @author shaokx 2019/1/9
	 */
	public abstract String getNoPayNew(String param) throws BizException;
	
	/**
	 * 门诊自助支付已缴费查询（废弃）
	 * @param param
	 * @return
	 * @throws BizException
	 * @author shaokx 2019/1/9
	 */
	public abstract String getAlreadyPay(String param) throws BizException;
	
	
}
