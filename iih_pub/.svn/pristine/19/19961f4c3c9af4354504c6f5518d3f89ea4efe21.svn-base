package iih.bl.itf.std;

import xap.mw.core.data.BizException;

/**
 * 费用标准对外服务--门诊收费服务
 * @author ly 2018/7/16
 *
 */
public interface IBlOpChargeService {

	/**
	 * 门诊自助收付款
	 * @param param
	 * @return
	 * @throws BizException
	 * @author shaokx 2019/1/9
	 */
	public abstract String pay(String param) throws BizException;
	
	/**
	 * 门诊自助划价（带事务）
	 * @param param
	 * @return
	 * @throws BizException
	 * @author shaokx 2019/1/17
	 */
	public abstract String pricing(String param) throws BizException;
	
	/**
	 * 门诊自助划价（不带事务）
	 * @param param
	 * @return
	 * @throws BizException
	 * @author shaokx 2019/1/17
	 */
	public abstract String pricingNoTrans(String param) throws BizException;
	
	/**
	 * 门诊补退费
	 * @param param
	 * @return
	 * @throws BizException
	 * @author zhangxin
	 */
	public abstract String setOpCostBill(String param) throws BizException;
	
	/**
	 * 门诊补退费新(可循环记账)
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract String setOpCostBillNew(String param) throws BizException;
	
}
