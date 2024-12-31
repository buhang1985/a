package iih.bd.pp.baseprisrv.s.bp;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.bd.pp.baseprisrv.d.SrvPriDO;
import iih.bd.pp.baseprisrv.s.bp.qry.FindBaseSrvPriQry;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 查询基础价表服务价格列表
 * 
 * @author hao_wu 2019-8-20
 *
 */
public class FindBaseSrvPriBp {

	@SuppressWarnings("unchecked")
	public SrvPriDO[] exec(String whereStr, String orderStr) throws BizException {
		if (StringUtils.isBlank(orderStr)) {
			orderStr = "dt_e desc";
		}

		FindBaseSrvPriQry qry = new FindBaseSrvPriQry(whereStr, orderStr);
		DAFacade daFacade = new DAFacade();
		List<SrvPriDO> baseSrvprilist = (List<SrvPriDO>) daFacade.execQuery(qry.getQrySQLStr(),
				qry.getQryParameter(null), new BeanListHandler(SrvPriDO.class));
		return baseSrvprilist.toArray(new SrvPriDO[0]);
	}

}
