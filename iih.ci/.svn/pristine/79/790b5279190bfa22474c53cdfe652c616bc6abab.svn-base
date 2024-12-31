package iih.ci.diag.s.bp;

import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.bd.srv.diagdef.d.desc.DiagDefDODesc;
import iih.bd.srv.diagdef.i.IDiagdefMDORService;
import iih.ci.diag.s.CiDiUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 取得诊断信息
 * @author li_zheng
 *
 */
public class getDiagDefDOSBP {
	public String spot =".";
	public String  and = " or ";
	public DiagDefDO[] exec(String value)throws BizException{
	IDiagdefMDORService  service = CiDiUtils.getIDiagdefMDORService();
	
	String str = DiagDefDODesc.TABLE_ALIAS_NAME +spot +DiagDefDO.NAME +"  like '%"+value+"%' "+and
			+ DiagDefDODesc.TABLE_ALIAS_NAME +spot+ DiagDefDO.WBCODE+ " like '%"+value+"%' "+and
			 +DiagDefDODesc.TABLE_ALIAS_NAME +spot +DiagDefDO.PYCODE +" like '%"+value+"%'";
	return service.find(str, DiagDefDO.NAME, FBoolean.FALSE);
	}

}
