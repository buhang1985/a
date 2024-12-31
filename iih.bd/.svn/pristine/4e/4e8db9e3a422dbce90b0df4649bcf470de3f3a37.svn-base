package iih.bd.srv.s.bp;

import iih.bd.srv.s.bp.qry.GetDeptsrvlimitDeptTreeSql;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.orgfw.dept.d.DeptDO;

public class DeptsrvlimitDeptTreeBP {

	public DeptDO[] getDeptsrvlimitDeptTree() throws BizException {
		ITransQry sql = new GetDeptsrvlimitDeptTreeSql();
		return (DeptDO[]) AppFwUtil.getDORstWithDao(sql, DeptDO.class);
	}

}
