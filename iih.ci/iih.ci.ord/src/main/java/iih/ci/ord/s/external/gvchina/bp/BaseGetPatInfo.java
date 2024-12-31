package iih.ci.ord.s.external.gvchina.bp;

import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;

public class BaseGetPatInfo {

	protected String getDeptIdByCode(String code_dept) throws BizException{
		DeptDO[] szDeptDO = ServiceFinder.find(IDeptRService.class).findByAttrValString(DeptDO.CODE, code_dept);
		return null == szDeptDO || szDeptDO.length == 0?null:szDeptDO[0].getId_dep();
	}
}
