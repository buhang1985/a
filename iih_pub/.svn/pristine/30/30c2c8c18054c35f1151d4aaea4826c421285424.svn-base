package iih.bl.itf.std;

import xap.mw.core.data.BizException;

/**
 * 费用标准对外服务--门诊预交金查询服务
 * @author ly 2018/7/16
 *
 */
public interface IBlOpPrepayRService {

	/**
	 * 门诊账户查询
	 * @param param
	 * @return
	 * @throws BizException
	 * @author ly 2018/7/16
	 */
	public abstract String getAccountInfo(String param) throws BizException;
	
	/**
	 * 门诊充值记录查询(含余额)
	 * @param param
	 * @return
	 * @throws BizException
	 * @author ly 2018/7/16
	 */
	public abstract String getRechargeRecord(String param) throws BizException;
	
	/**
	 * 充值记录查询新(门诊+住院)
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract String getRechargeInfo(String param) throws BizException;
}
