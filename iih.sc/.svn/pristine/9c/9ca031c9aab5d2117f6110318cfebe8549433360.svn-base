package iih.sc.att.s.bp.qry;

import iih.sc.att.sctaskplemp.d.ScTaskPlEmpDO;
import iih.sc.att.sctaskplemp.i.ISctaskplempRService;
import iih.sc.att.sctaskplweek.d.ScTaskPlWeekDO;
import iih.sc.att.sctaskplweek.i.ISctaskplweekRService;
import iih.sc.comm.ScContextUtils;
import iih.sc.pub.ScGroupControlUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.permfw.pub.EnvContextUtil;
/**
 * 判定该计划是否有周计划和人员
 * @author renying
 *
 */
public class IsHasEmpAndPlweekBP {
	/**
	 * 判定该计划是否有周计划和人员
	 * @param taskplId
	 * @return
	 * @throws BizException 
	 */
	public FBoolean exec(String taskplId) throws BizException{
		ISctaskplempRService rservice = ServiceFinder.find(ISctaskplempRService.class);
		String qryCon = String.format("  id_taskpl ='%s'",  taskplId);
		
		ScTaskPlEmpDO[] empDOs = rservice.find(qryCon, "", FBoolean.FALSE);
		if(ArrayUtil.isEmpty(empDOs))
			throw new BizException("该计划不存在考勤人员，请先维护考勤人员");
		
		ISctaskplweekRService weekService = ServiceFinder.find(ISctaskplweekRService.class);
		String condition = String.format(" Id_taskpl = '%s'",taskplId);
		ScTaskPlWeekDO[] weekDOs = weekService.find(condition, "", FBoolean.FALSE);
		if(ArrayUtil.isEmpty(weekDOs))
		{
			throw new BizException("考勤计划不存在周计划，请先维护周计划");
		}
		return FBoolean.TRUE;
	}
}
