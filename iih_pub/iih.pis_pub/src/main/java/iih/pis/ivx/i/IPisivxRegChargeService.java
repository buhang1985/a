package iih.pis.ivx.i;

import xap.mw.core.data.BizException;

/**
 * 微信服务号webservice接口总服务：患者注册与费用
 *
 */
public interface IPisivxRegChargeService {

	/**
	 * 患者注册发卡
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract String patRegAndDistrCard(String param) throws BizException;

	/**
	 * 患者校验
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract String patValidate(String param) throws BizException;
	
	/**
	 * 门诊预交金充值
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract String opRecharge(String param) throws BizException;
	
	/**
	 * 门诊账户查询
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract String getOpAccountInfo(String param) throws BizException;
	
	/**
	 * 门诊预交金充值查询
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract String getOpRechargeRecord(String param) throws BizException;
	
	/**
	 * 门诊费用清单查询
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract String getOpCostBill(String param) throws BizException;
	
	/**
	 * 住院预交金充值
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract String ipRecharge(String param) throws BizException;
	
	/**
	 * 住院账户查询
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract String getIpAccountInfo(String param) throws BizException;
	
	/**
	 * 住院充值记录查询
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract String getIpRechargeRecord(String param) throws BizException;
	
	/**
	 * 住院费用清单查询
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract String getIpCostBill(String param) throws BizException;
	
	/**
	 * 预交金充值对对账
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract String getTradeInfo(String param) throws BizException;
	/**
	 * 病案复印支付
	 * @param param
	 * @return
	 * @throws BizException
	 */
	//public abstract String payMedicalRecordCopy(String param) throws BizException;
	
	/**
	 * 病案复印退费
	 * @param param
	 * @return
	 * @throws BizException
	 */
	//public abstract String rtnMedicalRecordCopy(String param) throws BizException;
}
