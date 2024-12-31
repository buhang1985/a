package iih.bl.st.s.bp;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 医保退费时医保结算对应的医疗类别
 * 
 * @author liwq
 * @since 2017-8-1 16:04:09
 */
public class GetHpRefundMedCatBP {

	@SuppressWarnings("unchecked")
	public String exec(String id_ent,String tradeNo) throws BizException {
		StringBuilder sqlb = new StringBuilder();
		sqlb.append(" select code_medkind from hp_transact_neusoft_ah where id_ent = ? and code_his = ? ");
		SqlParam sqlp = new SqlParam();
		sqlp.addParam(id_ent);
		sqlp.addParam(tradeNo);
		List<String> list = (List<String>) new DAFacade().execQuery(sqlb.toString(),  sqlp, new ColumnListHandler());
		if(ListUtil.isEmpty(list)) {
			throw new BizException("未查询到该次医保结算对应的医疗类别！");
		}
		return list.get(0);
	}
}
