package iih.ei.std.s.v1.bp.ci.thirdws.utils;

import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;
import xap.sys.orgfw.org.d.OrgDO;
/**
 * 科室工具类
 * @author zhangwq
 *
 */
public class DeptUtils {
	public static IDeptRService RService= ServiceFinder.find(IDeptRService.class); 
	/**
	 * 查询科室信息
	 * @param id_dep
	 * @return
	 * @throws BizException
	 */
	public static DeptDO getDept(String id_dep) throws BizException{
		DeptDO dept = RService.findById(id_dep);
		return dept;
	}
	/**
	 * 通过科室编码查询科室信息
	 * @param deptcode
	 * @return
	 * @throws BizException
	 */
	public static DeptDO getDeptByCode(String deptcode) throws BizException{
		DeptDO[] depts = RService.findByAttrValString(DeptDO.CODE, deptcode);
		if(depts != null && depts.length >0 ){
			return depts[0];
		}
		return null;
	}
}
