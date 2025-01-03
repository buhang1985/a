package iih.bl.cg.s.task;

import iih.bd.base.utils.AppUtils;
import iih.bd.base.utils.DateTimeUtils;
import iih.bd.utils.ContextUtils;
import iih.bl.cg.s.bp.ip.backcg.EtBackChargeBP;
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
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;

/**
 * 急诊后台记账任务
 * @author ly 2019/04/24
 *
 */
public class EtBackCgNewTask implements IBackgroundWorkPlugin {

	@Override
	public PreAlertObject executeTask(BgWorkingContext context)
			throws BizException {
		// 默认返回结果
		PreAlertObject obj = new PreAlertObject();

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
			throw new BizException("急诊后台记账任务：入参组织或人员为空,无法记账");
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
		
		String entId = null;
		if(!StringUtil.isEmpty(patId)){
			
			String sql = "select id_ent from en_ent where fg_ip = 'Y' and code_entp = '0103' and id_pat = '"
					+ patId + "' ";
			DAFacade daf = new DAFacade();
			entId = (String)daf.execQuery(sql, new ColumnHandler());
			
			if(StringUtil.isEmpty(entId))
				return obj;
		}
		
		//记账截止时间,取当日0点，记账上一天的费用，任务通常部署到凌晨1点钟
		FDateTime cgEndTime = DateTimeUtils.getDayBeginTime(chargeDate);
		EtBackChargeBP chargeBP = new EtBackChargeBP();
		BLTaskLogger.info("急诊后台记账任务开始:");
		chargeBP.exec(entId, cgEndTime, false);
		BLTaskLogger.info("急诊后台记账任务结束！");

		return obj;
	}
}
