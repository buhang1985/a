package iih.sc.att.i;

import iih.sc.att.dto.d.AttExecDTO;
import iih.sc.att.sctaskexec.d.SctaskexecDO;
import iih.sc.att.sctaskexecemp.d.ScTaskExecEmpDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.sys.orgfw.dept.d.DeptDO;

/**
 * 考勤查询服务
 * 
 * @author yank
 * @author ccj
 *
 */
public interface IScAttQryService {
	/**
	 * 获取存在考勤计划的部门
	 * 
	 * @return 部门arrays
	 * @throws BizException
	 */
	public DeptDO[] getHavePlanDept() throws BizException;

	/**
	 * 获取考勤执行
	 * 
	 * @param attPlanId 考勤计划ID
	 * @param date 考勤日期
	 * @return
	 * @throws BizException
	 */
	AttExecDTO getAttExec(String attPlanId, FDate date) throws BizException;
	
	/**
	 * 获取考勤科室记录树
	 * @return
	 * @throws BizException
	 */
	DeptDO[] getExecDept() throws BizException;
	
	/**
	 * 获取考勤计划
	 * @param dt_b
	 * @param dt_e
	 * @param taskplId
	 * @return
	 * @throws BizException
	 */
	SctaskexecDO getScTaskPl(String dt_b,String dt_e,String taskplId)throws BizException;
	
	/**
	 * 获取考勤计划明细
	 * @param dt_b
	 * @param dt_e
	 * @param taskexecCode
	 * @param taskplId
	 * @return
	 * @throws BizException
	 */
	ScTaskExecEmpDO[] getScTaskDetail(String dt_b,String dt_e,String taskexecCode,String taskplId) throws BizException;
	
	/**
	 * 判定该计划是否有周计划和人员
	 * @param taskplId
	 * @return
	 */
	FBoolean isHasEmpAndPlweek(String taskplId) throws BizException;
}
