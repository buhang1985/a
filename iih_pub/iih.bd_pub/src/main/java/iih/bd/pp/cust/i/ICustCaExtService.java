package iih.bd.pp.cust.i;

import iih.bd.pp.cust.d.CustCaDO;
import xap.mw.core.data.BizException;

/**
 * 付款客户分类扩展服务接口
 * 
 * @author hao_wu
 *
 */
public interface ICustCaExtService {
	/**
	 * 根据客户id获取客户分类
	 * 
	 * @param id_cust
	 * @return
	 * @throws BizException
	 */
	public abstract CustCaDO FindCustCaByCustId(String id_cust) throws BizException;
}
