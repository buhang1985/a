package iih.pe.listener.bp;

import iih.en.pv.inpatient.d.InpatientDO;
import iih.pe.listener.qry.GetInpatientDOSql;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

public class GetInpatientDOBp {
	
	public InpatientDO[] exec(String medicalno, int visittimes) throws BizException{
		return getInpatientDOByIdent(medicalno,visittimes);
	}
	
	private InpatientDO[] getInpatientDOByIdent(String medicalno, int visittimes) throws BizException{
		GetInpatientDOSql sql = new GetInpatientDOSql(medicalno,visittimes);
		InpatientDO[] inpatientDOs = (InpatientDO[]) AppFwUtil.getDORstWithDao(sql, InpatientDO.class);
		return inpatientDOs;
	}

}
