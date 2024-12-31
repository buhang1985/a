package iih.pis.ivx.pay.i;

import java.util.Map;

import iih.en.pv.enfee.d.EnAccountDO;
import iih.pi.acc.account.d.PiPatAccDO;
import iih.pis.ivx.pay.d.WsResultOpGetPay;
import xap.mw.core.data.BizException;

public interface IPayRService {
	
	/**
	 * 根据患者编码查询患者ID
	 * @param patcode
	 * @return
	 * @throws BizException
	 */
	public String getIdPatByPatcode(String patcode) throws BizException;
	
	/**
	 * 当前就诊人的住院押金记录查询
	 * @param id_pisivxmember
	 * @param id_pisivxent
	 * @return
	 * @throws BizException
	 */
	public Map<String, Object> getRecord(String id_pisivxmember,String id_pisivxent) throws BizException;
	
	/**
	 * 患者账户查询(从账户信息中可得到门诊预交金余额)
	 * @param patcode
	 * @return
	 * @throws BizException
	 */
	public PiPatAccDO getPatAcc(String patcode) throws BizException;
	
	/**
	 * 患者就诊账户查询(从账户信息中可得到住院押金余额)
	 * @param id_pisivxent
	 * @return
	 * @throws BizException
	 */
	public EnAccountDO getEnAccount(String id_pisivxent) throws BizException;
	
	/**
	 * 门诊待缴费查询
	 * @param patCode
	 * @param cardCode
	 * @return
	 * @throws BizException
	 */
	public WsResultOpGetPay getNoPay(String patCode,String cardCode) throws BizException;

}
