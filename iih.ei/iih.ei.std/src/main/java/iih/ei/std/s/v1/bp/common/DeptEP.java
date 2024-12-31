package iih.ei.std.s.v1.bp.common;

import iih.ei.std.d.v1.utils.EiValidator;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;

public class DeptEP {
	/**
	 * 根据code获取科室
	 * 
	 * @param code
	 * @return
	 * @throws BizException
	 */
	public DeptDO getDeptByCode(String code) throws BizException{
		if(StringUtil.isEmptyWithTrim(code))
			return null;
		IDeptRService rservice = ServiceFinder.find(IDeptRService.class);
		DeptDO[] depts = rservice.findByAttrValString(DeptDO.CODE, code);
		return ArrayUtil.isEmpty(depts) ? null : depts[0];
	}
	/**
	 * 根据id获取科室 zhangpp
	 * @param depId
	 * @return
	 * @throws BizException
	 */
	public DeptDO getDeptById(String depId) throws BizException{
		if(EiValidator.isEmptyIgnoreBlank(depId)){
			return null;
		}
		IDeptRService rservice = ServiceFinder.find(IDeptRService.class);
		return rservice.findById(depId);
	}
}
