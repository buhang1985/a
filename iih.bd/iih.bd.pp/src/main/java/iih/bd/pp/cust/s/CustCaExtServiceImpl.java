package iih.bd.pp.cust.s;

import iih.bd.pp.cust.d.CustCaDO;
import iih.bd.pp.cust.i.ICustCaExtService;
import iih.bd.pp.cust.s.bp.FindCustCaByCustIdBp;
import xap.mw.core.data.BizException;

/***
 * 付款客户分类扩展服务
 * 
 * @author hao_wu
 *
 */
public class CustCaExtServiceImpl implements ICustCaExtService {

	@Override
	public CustCaDO FindCustCaByCustId(String id_cust) throws BizException {
		FindCustCaByCustIdBp bp = new FindCustCaByCustIdBp();
		CustCaDO result = bp.exec(id_cust);
		return result;
	}

}
