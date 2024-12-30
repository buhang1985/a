package iih.sc.att.s.bp;

import iih.bd.res.dayslot.d.DaysLotDO;
import iih.sc.att.s.bp.qry.GetAttExecEmpCountQry;
import iih.sc.att.s.bp.qry.GetDaysLotDOListQry;
import iih.sc.att.s.bp.qry.GetScTaskPlWeekDOListQry;
import iih.sc.att.sctaskexec.d.SctaskexecDO;
import iih.sc.att.sctaskexecemp.d.ScTaskExecEmpDO;
import iih.sc.att.sctaskexecemp.i.ISctaskexecempCudService;
import iih.sc.att.sctaskplweek.d.ScTaskPlWeekDO;
import iih.sc.att.sctaskplweek.d.desc.ScTaskPlWeekDODesc;
import iih.sc.att.sctaskplweek.i.ISctaskplweekRService;
import iih.sc.comm.ScAppUtils;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 新增个人排班
 * 
 * @author ccj
 * 
 */
public class AddExecByEmpBp {
	/**
	 * 新增个人排班
	 * 
	 * @param id_pl
	 *            计划di
	 * @param id_emp
	 *            人员id
	 * @param id_peri
	 *            区间id
	 * @param id_taskexec
	 *            执行id
	 * @param beginDate
	 *            考试时间
	 * @param endDate
	 *            结束时间
	 */
	public void exec(String id_pl, String id_emp, String id_peri, String id_taskexec, FDate beginDate, FDate endDate) throws BizException {

		// 1.验证当前数据明细是否冲突
		if (AppFwUtil.getDORstWithDao(new GetAttExecEmpCountQry(id_emp, id_taskexec), ScTaskExecEmpDO.class).length == 1) {
			throw new BizException("该人员已经在考勤中，请重选择其他人员！");
		}

		// 2.获取考勤周计划信息
		ISctaskplweekRService sctaskplweekRService = ServiceFinder.find(ISctaskplweekRService.class);
		ISctaskexecempCudService cudService = ServiceFinder.find(ISctaskexecempCudService.class);

		SctaskexecDO execDo = new SctaskexecDO();
		execDo.setId_taskpl(id_pl);
		// 考勤执行do
		// 3.新增人员排班时在原来排班的基础上再次新增
		ScTaskPlWeekDO[] plWeekDOs = (ScTaskPlWeekDO[]) AppFwUtil.getDORstWithDao(new GetScTaskPlWeekDOListQry(new SctaskexecDO[] { execDo }), ScTaskPlWeekDO.class);
		// 4.判断周计划是否为空(避免脏数据)
		if (ArrayUtil.isEmpty(plWeekDOs))
			throw new BizException("该考勤计划无周计划，请先维护考勤计划的周计划后在进行本次操作！");
		String[] xdaysStrs = ScAppUtils.allDateBetween(beginDate, endDate);
		GetScTaskExecEmpListBP empListBP = new GetScTaskExecEmpListBP();
		List<ScTaskExecEmpDO> execEmpDOList = empListBP.exec(plWeekDOs, xdaysStrs, id_emp, null, id_taskexec);
		cudService.save(execEmpDOList.toArray(new ScTaskExecEmpDO[execEmpDOList.size()]));
	}
}
