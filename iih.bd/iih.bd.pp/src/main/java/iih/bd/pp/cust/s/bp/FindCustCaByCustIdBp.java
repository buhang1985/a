package iih.bd.pp.cust.s.bp;

import java.util.Collection;

import iih.bd.pp.cust.d.CustCaDO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据客户id获取客户分类业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FindCustCaByCustIdBp {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CustCaDO exec(String id_cust) throws BizException {

		String wherePart = "Id_custca in (select Id_custca from bd_cust where id_cust = ?)";
		SqlParam param = new SqlParam();
		param.addParam(id_cust);
		DAFacade daFacade = new DAFacade();
		Collection collection = daFacade.findByCond(CustCaDO.class, wherePart, param);
		if (collection == null || collection.size() <= 0) {
			return null;
		}
		return ((CustCaDO) collection.toArray(new CustCaDO[0])[0]);
	}

}
