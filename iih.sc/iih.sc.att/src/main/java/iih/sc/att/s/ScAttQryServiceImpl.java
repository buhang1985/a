package iih.sc.att.s;

import iih.sc.att.dto.d.AttExecDTO;
import iih.sc.att.i.IScAttQryService;
import iih.sc.att.s.bp.GetAttExecByPlBP;
import iih.sc.att.s.bp.GetHavePlanDeptBp;
import iih.sc.att.s.bp.qry.GetExecDeptBP;
import iih.sc.att.s.bp.qry.GetScTaskPlBP;
import iih.sc.att.s.bp.qry.IsHasEmpAndPlweekBP;
import iih.sc.att.sctaskexec.d.SctaskexecDO;
import iih.sc.att.sctaskexecemp.d.ScTaskExecEmpDO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.sys.orgfw.dept.d.DeptDO;

/**
 * 考勤查询服务
 * 
 * @author 
 *
 */
@Service(serviceInterfaces = { IScAttQryService.class }, binding = Binding.JSONRPC)
public class ScAttQryServiceImpl implements IScAttQryService {

	/**
	 * 获取存在考勤计划的部门
	 * 
	 * @return 部门arrays
	 * @throws BizException
	 */
	@Override
	public DeptDO[] getHavePlanDept() throws BizException {
		GetHavePlanDeptBp deptBp = new GetHavePlanDeptBp();
		return deptBp.exec();
	}	
	/**
	 * 获取考勤执行
	 * @param attPlanId 考勤计划ID
	 * @param date 考勤日期
	 * @return
	 * @throws BizException
	 */
	@Override
	public AttExecDTO getAttExec(String attPlanId,FDate date) throws BizException{
		GetAttExecByPlBP getExecBP = new GetAttExecByPlBP();
		return getExecBP.exec(attPlanId, date);
	}
	
	
	/**
	 * 获取考勤科室记录树
	 * @return
	 * @throws BizException
	 */
	@Override
	public DeptDO[] getExecDept() throws BizException {
		GetExecDeptBP getExecDeptBP = new GetExecDeptBP();
		return getExecDeptBP.exec();
	}
	
	/**
	 * 获取考勤计划
	 * @param dt_b
	 * @param dt_e
	 * @param taskexecId
	 * @return
	 * @throws BizException
	 */
	@Override
	public SctaskexecDO getScTaskPl(String dt_b, String dt_e, String taskplId)throws BizException {
		GetScTaskPlBP getScTaskBP = new GetScTaskPlBP();
		return getScTaskBP.exec(dt_b, dt_e, taskplId);
	}
	
	/**
	 * 获取考勤计划明细
	 * @param dt_b
	 * @param dt_e
	 * @param taskexecCode
	 * @param taskplId
	 * @return
	 * @throws BizException
	 */
	@Override
	public ScTaskExecEmpDO[] getScTaskDetail(String dt_b, String dt_e,String taskexecCode, String taskplId) throws BizException {
		GetScTaskDetailBP getScTaskDetailBP = new GetScTaskDetailBP();
		return getScTaskDetailBP.exec(dt_b, dt_e, taskexecCode, taskplId);
	}
	
	/**
	 * 判定该计划是否有周计划和人员
	 * @param taskplId
	 * @return
	 */
	@Override
	public FBoolean isHasEmpAndPlweek(String taskplId) throws BizException {
		IsHasEmpAndPlweekBP isHasEmpAndPlweekBP = new IsHasEmpAndPlweekBP();
		return isHasEmpAndPlweekBP.exec(taskplId);		 
	}
	
	
}
