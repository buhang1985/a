package iih.sc.sch.s.bp;

import java.util.HashSet;
import java.util.Set;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.scp.scplan.d.ScPlanDO;
import iih.sc.scp.scplan.d.desc.ScPlanDODesc;
import iih.sc.scp.scplan.i.IScplanRService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;

/**
 * 获取可预约的科室集合
 * @author liubin
 *
 */
public class GetAvlAptDepListBP {
	/**
	 * 获取可预约的科室集合
	 * 根据计划进行过滤
	 * @return
	 * @throws BizException
	 */
	public DeptDO[] exec() throws BizException{
		ScPlanDO[] scPlanDOs = getScPlanDOs();
		if(!ArrayUtil.isEmptyNoNull(scPlanDOs)){
			String[] deptIds = getDepIds(scPlanDOs);
			if(!ArrayUtil.isEmptyNoNull(deptIds)){
				return getDeptDOs(deptIds);
			}
		}
		return null;
	}
	
	/**
	 * 得到所有的门诊排班
	 * 
	 * @return
	 * @throws BizException
	 */
	private ScPlanDO[] getScPlanDOs() throws BizException{
		IScplanRService scplRService = ServiceFinder.find(IScplanRService.class);
		String whereStr = String.format("%s.%s = '%s' AND %s.%s = '%s'",ScPlanDODesc.TABLE_ALIAS_NAME, ScPlanDO.SD_SCTP, IScDictCodeConst.SD_SCTP_OP, ScPlanDODesc.TABLE_ALIAS_NAME, ScPlanDO.FG_ACTIVE, "Y");
		return scplRService.find(whereStr, null, FBoolean.TRUE);
	}
	/**
	 * 从ScPlanDO集合中得到deptId
	 * 
	 * @param scPlanDOs
	 * @return
	 */
	private String[] getDepIds(ScPlanDO[] scPlanDOs){
		if(!ArrayUtil.isEmptyNoNull(scPlanDOs)){
			Set<String> deptSet = new HashSet<>();
			for(int i=0;i<scPlanDOs.length;i++){
				deptSet.add(scPlanDOs[i].getId_dep());
			}
			return deptSet.toArray(new String[0]);
		}
		return null;
	}
	/**
	 * 根据Id_dept集合得到DeptDO集合
	 * 
	 * @param deptIds
	 * @return
	 * @throws BizException
	 */
	private DeptDO[] getDeptDOs(String[] deptIds) throws BizException{
		IDeptRService deptRService = ServiceFinder.find(IDeptRService.class);
		if(!ArrayUtil.isEmptyNoNull(deptIds)){
			return deptRService.findByIds(deptIds, FBoolean.FALSE);
		}
		return null;
	}
}
