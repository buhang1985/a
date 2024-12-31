package iih.bd.srv.s.bp;

import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.bd.srv.s.bp.qry.GetDiDefSpecQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.orm.utils.ITransQry;

/**
 * 查询特殊诊断
 * @author YANG
 *
 */
public class GetDiDefSpecBP {

	public DiagDefDO[] exec(String id_org, String sqlWhere) throws BizException{
		ITransQry qry =new GetDiDefSpecQry(id_org, sqlWhere);
		DiagDefDO[] diagDefDOs = (DiagDefDO[]) AppFwUtil.getDORstWithDao(qry, DiagDefDO.class);
		return diagDefDOs;
	}
}
