package iih.bl.cg.s.task;

import iih.bd.base.utils.AppUtils;
import iih.bd.base.utils.DateTimeUtils;
import iih.bd.utils.ContextUtils;
import iih.bl.cg.s.bp.ip.backcg.IpBackChargeBP;
import iih.bl.comm.IBlConst;
import iih.bl.comm.log.BLTaskLogger;
import iih.bl.comm.util.BlValidateUtil;

import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;
import xap.sys.jdbc.lock.PKLock;

/**
 * 住院后台记账--新任务
 * 
 * @author yankan
 * @since 2017-09-20
 *
 */
public class IpBackCgNewTask implements IBackgroundWorkPlugin {
	/**
	 * 执行任务
	 * 
	 * @param context 上下文
	 */
	@Override
	public PreAlertObject executeTask(BgWorkingContext context) throws BizException {
		// 默认返回结果
		PreAlertObject obj = new PreAlertObject();
		//加锁
		boolean lock=PKLock.getInstance().addDynamicLock("iih.bl.cg.s.task.IpBackCgNewTask",0);
		if(!lock){
			throw new BizException("住院自动划价加锁失败！");
		}
		// 获取参数
		Map<String, Object> map = context.getKeyMap();
		String patId = (String) map.get("id_pat");
		String orgId = (String) map.get("id_org");
		String chargeDateStr = (String) map.get("charge_date");
		String cgEmpId = (String)map.get("id_emp_cg");//记账人员ID
		if (IBlConst.ALL_PATTERN.equals(patId)) {
			patId = null;// *代表全部
		}
		if (StringUtil.isEmpty(orgId) || StringUtil.isEmpty(cgEmpId)) {
			throw new BizException("住院后台记账任务：入参组织或人员为空,无法记账");
		}
		
		Context.get().setOrgId(orgId);// 设置组织ID
		if(!StringUtil.isEmpty(cgEmpId)){
			Context.get().setStuffId(cgEmpId);//人员ID
			PsnDocDO psn = ContextUtils.getPsnDoc();
			if(psn!=null){
				Context.get().setDeptId(psn.getId_dep());
				Context.get().setGroupId(psn.getId_group());
			}else{
				return obj;
			}
		}		
		
		// 记账日期
		FDate chargeDate = null;
		if (!StringUtil.isEmpty(chargeDateStr)) {
			chargeDate = new FDate(chargeDateStr);
		} else {
			chargeDate = AppUtils.getServerDate();
		}
		
		BlValidateUtil.validateContextForTask(Context.get());
		
		//记账截止时间,取当日0点，记账上一天的费用，任务通常部署到凌晨1点钟
		FDateTime cgEndTime = DateTimeUtils.getDayBeginTime(chargeDate);			
		IpBackChargeBP chargeBP = new IpBackChargeBP();// IBlConst.ALL_PATTERN
		BLTaskLogger.info("住院后台记账任务开始:");
		chargeBP.exec(patId, cgEndTime, false);
		BLTaskLogger.info("住院后台记账任务结束！");

		return obj;
	}
}
