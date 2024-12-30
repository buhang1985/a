package iih.sc.apt.s.task.bp;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.res.dayslot.d.DaysLotDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.pi.reg.patbbr.d.PiPatBbrDO;
import iih.pi.reg.patbbr.i.IPatbbrCudService;
import iih.pi.reg.patbbr.i.IPatbbrRService;
import iih.sc.apt.s.bp.GetPatBbrInvalidDateBP;
import iih.sc.apt.s.ep.AptEP;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScParamUtils;
import iih.sc.scbd.i.IScDaysLotService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.org.d.OrgDO;
import xap.sys.orgfw.org.i.IOrgRService;

/**
 * 自动爽约
 * 
 * @author zhengcm
 * @date 2017-03-17 11:34:41
 *
 */
public class AutoBreakAptBP {
	/**
	 * 执行
	 * 
	 * @throws BizException
	 */
	public void exec(Map<String, Object> map) throws BizException {

		if (null == map.get("id_org")) {
			throw new BizException("参数id_org为空，请检查！");
		}
		int invalidDays = -1;
		// 无失效日期记录的失效天数
		if(map.get("invalid_days") != null){
			String invalid_days = (String) map.get("invalid_days");
			if(isInt(invalid_days)){
				invalidDays = Integer.valueOf(invalid_days); 
			}
		}
		String id_org = (String) map.get("id_org");
		if(StringUtil.isEmpty(id_org)) throw new BizException("id_org不能为空！");
		// 设置上下文组织
		Context.get().setOrgId(id_org);
		IOrgRService iorgrservice = ServiceFinder.find(IOrgRService.class);
		OrgDO org = iorgrservice.findById(id_org);
		Context.get().setGroupId(org.getId_grp());

		// 获取服务器当前日期
		FDate today = ScAppUtils.getServerDate();

		// 系统对应的员工ID
		String id_emp_sys = ScParamUtils.getSysEmpId();

		// 预约挂号爽约控制方式参数:
		// 0-不爽约
		// 1-预约不缴费为爽约
		// 2-预约不缴费或预约不取号即爽约
		// 3-预约不缴费或预约不取号或预约取号不就诊或挂号不就诊即爽约
		int brokentp = ScParamUtils.getScBrokenTp(id_org);

		// 不良行为列表
		List<PiPatBbrDO> bbrDOList = new ArrayList<PiPatBbrDO>();
		if(invalidDays != -1){
			// 处理过期的不良记录--处理xx天以上并且没有设置失效日期的不良记录
			this.processOverdueApt(today,invalidDays);
		}
		// 处理当前时间失效的不良记录
		this.processInvalidApt(today);

		// 处理昨天未取号的预约
		this.processYesterdayNoFetchApt(brokentp, today, id_emp_sys, bbrDOList);

		// 处理昨天挂号未就诊或取号未就诊
		this.processYestodayRegNoVisit(brokentp, today, id_emp_sys, bbrDOList);

		// 保存不良行为
		this.savePatBbr(bbrDOList);
	}

	/**
	 * 处理过期的不良记录:三个月之前
	 *
	 * @param today
	 * @throws BizException
	 * @author zhengcm
	 */
	public void processOverdueApt(FDate today,int invalidDays) throws BizException {
		IPatbbrRService bbrQryService = ServiceFinder.find(IPatbbrRService.class);
		IPatbbrCudService bbrCmdService = ServiceFinder.find(IPatbbrCudService.class);
		String cond = String.format("dt_disable is null and dt_act < '%s' and fg_active = 'Y' and sd_bbrtp in ('%s','%s')",
				today.getDateBefore(invalidDays) + " 00:00:00", IScDictCodeConst.SD_APT_SCORAL_BREAK_BBRTP,
				IScDictCodeConst.SD_REG_NOTICKET_BREAK_BBRTP);
		PiPatBbrDO[] bbrDOs = bbrQryService.find(cond, null, FBoolean.FALSE);
		if (ArrayUtil.isEmpty(bbrDOs)) {
			return;
		}
		for (PiPatBbrDO bbrDO : bbrDOs) {
			bbrDO.setStatus(DOStatus.UPDATED);
			bbrDO.setFg_active(FBoolean.FALSE);
		}
		bbrCmdService.update(bbrDOs);
	}
	/**
	 * 处理当前时间过期的不良记录
	 * @throws BizException
	 */
	private void processInvalidApt(FDate today) throws BizException{
		IPatbbrRService bbrQryService = ServiceFinder.find(IPatbbrRService.class);
		IPatbbrCudService bbrCmdService = ServiceFinder.find(IPatbbrCudService.class);
		String cond = String.format("dt_disable is not null and dt_disable <= '%s' and fg_active = 'Y' and sd_bbrtp in ('%s','%s')",
				today + " 00:00:00", IScDictCodeConst.SD_APT_SCORAL_BREAK_BBRTP,
				IScDictCodeConst.SD_REG_NOTICKET_BREAK_BBRTP);
		PiPatBbrDO[] bbrDOs = bbrQryService.find(cond, null, FBoolean.FALSE);
		if (ArrayUtil.isEmpty(bbrDOs)) {
			return;
		}
		for (PiPatBbrDO bbrDO : bbrDOs) {
			bbrDO.setStatus(DOStatus.UPDATED);
			bbrDO.setFg_active(FBoolean.FALSE);
		}
		bbrCmdService.update(bbrDOs);
		
	}

	/**
	 * 处理昨天未取号的预约
	 * 
	 * @author zhengcm
	 *
	 * @param brokentp
	 * @param today
	 * @param id_emp_sys
	 * @param bbrDOList
	 * @throws BizException
	 */
	public void processYesterdayNoFetchApt(int brokentp, FDate today, String id_emp_sys, List<PiPatBbrDO> bbrDOList)
			throws BizException {
		if (brokentp == 0) {
			return;
		}
		String fmt = "fg_canc = 'N' and sd_sctp = '%s' and dt_b >= '%s' and dt_b < '%s' ";
		IScDaysLotService iscdayslotservice = ServiceFinder.find(IScDaysLotService.class);
		DaysLotDO dayslot = iscdayslotservice.getNowDaysLotCross(IScDictCodeConst.SD_SCTP_OP, FBoolean.FALSE);
		String dt_b = "";
		String dt_e = "";
		if(dayslot != null){
			dt_b = (new FDate(dayslot.getDef1()).getDateBefore(1))+ " 00:00:00";
			dt_e = dayslot.getDef1()+ " 00:00:00";
		}else{
			dt_b = today.getDateBefore(1) + " 00:00:00";
			dt_e = today + " 00:00:00";
		}
		String cond = null;
		if (brokentp == 1) {
			cond = String.format(fmt + " and sd_status = '%s'", IScDictCodeConst.SD_SCTP_OP, dt_b, dt_e,
					IScDictCodeConst.SD_APTSTATUS_ORDER);
		} else {
			cond = String.format(fmt + "and sd_status in ('%s','%s')", IScDictCodeConst.SD_SCTP_OP, dt_b, dt_e,
					IScDictCodeConst.SD_APTSTATUS_ORDER, IScDictCodeConst.SD_APTSTATUS_PAY);
		}
		AptEP aptEP = new AptEP();
		ScAptDO[] aptDOs = aptEP.getByWhere(cond);
		if (ArrayUtil.isEmpty(aptDOs)) {
			return;
		}
		// 不良记录失效日期
		FDateTime dt_disable = new GetPatBbrInvalidDateBP().exec(ScAppUtils.getServerDateTime(), IScDictCodeConst.ID_APT_SCORAL_BREAK_BBRTP);
		for (ScAptDO aptDO : aptDOs) {
			PiPatBbrDO patBbrDO = new PiPatBbrDO();
			patBbrDO.setStatus(DOStatus.NEW);
			patBbrDO.setId_grp(aptDO.getId_grp());
			patBbrDO.setId_org(aptDO.getId_org());
			patBbrDO.setId_pat(aptDO.getId_pat());
			patBbrDO.setId_key(aptDO.getId_apt());
			patBbrDO.setId_bbrtp(IScDictCodeConst.ID_APT_SCORAL_BREAK_BBRTP);
			patBbrDO.setSd_bbrtp(IScDictCodeConst.SD_APT_SCORAL_BREAK_BBRTP);
			if(dt_disable != null){
				patBbrDO.setDt_disable(dt_disable);
			}
			patBbrDO.setDes_reason(IScMsgConst.SC_APT_SCORAL_BREAK_NOTE);
			// 记录预约日期 changed by zhengcm 2018-03-01
			patBbrDO.setDt_act(aptDO.getDt_b());
			patBbrDO.setId_emp(id_emp_sys);
			patBbrDO.setFg_active(FBoolean.TRUE);
			bbrDOList.add(patBbrDO);

			// 当前预约爽约
			// aptDO.setStatus(DOStatus.UPDATED);
			// aptDO.setSd_status(IScDictCodeConst.SD_APTSTATUS_CANCEL);//
			// 预约状态：取消
			// aptDO.setId_status(IScDictCodeConst.ID_APTSTATUS_CANCEL);
			// aptDO.setFg_canc(FBoolean.TRUE);
			// aptDO.setDt_canc(ScAppUtils.getServerDateTime());
			// aptDO.setId_emp_canc(id_emp_sys);
			// aptDO.setNote_canc(IScMsgConst.SC_APT_SCORAL_BREAK_NOTE);
		}
		// 保存预约数据
		// aptEP.save(aptDOs);
	}

	/**
	 * 处理昨天挂号未就诊或取号未就诊
	 * 
	 * @author zhengcm
	 *
	 * @param brokentp
	 * @param today
	 * @param id_emp_sys
	 * @param bbrDOList
	 * @throws BizException
	 */
	@SuppressWarnings({ "unchecked" })
	private void processYestodayRegNoVisit(int brokentp, FDate today, String id_emp_sys, List<PiPatBbrDO> bbrDOList)
			throws BizException {
		if (brokentp == 0 || brokentp != 3) {
			return;
		}
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		sb.append("ent.id_grp,");
		sb.append("ent.id_org,");
		sb.append("ent.id_ent,");
		sb.append("ent.dt_entry,");
		sb.append("ent.id_pat ");
		sb.append("from ");
		sb.append("en_ent ent ");
		sb.append("inner join en_ent_op op on op.id_ent = ent.id_ent ");
		sb.append("where ");
		sb.append("ent.fg_canc = 'N' ");
		sb.append("and ent.dt_entry >= ? ");
		sb.append("and ent.dt_entry < ? ");
		sb.append("and op.sd_status = ? ");
		SqlParam params = new SqlParam();
		IScDaysLotService iscdayslotservice = ServiceFinder.find(IScDaysLotService.class);
		DaysLotDO dayslot = iscdayslotservice.getNowDaysLotCross(IScDictCodeConst.SD_SCTP_OP, FBoolean.FALSE);
		if(dayslot != null){
			params.addParam(new FDate(dayslot.getDef1()).getDateBefore(1));
			params.addParam(new FDate(dayslot.getDef1()));
		}else{
			params.addParam(today.getDateBefore(1));
		params.addParam(today);
		}
		params.addParam(IEnDictCodeConst.SD_ENSTATUS_OP_REGISTER);// 挂号
		List<PatiVisitDO> datas = (List<PatiVisitDO>) new DAFacade().execQuery(sb.toString(), params,
				new BeanListHandler(PatiVisitDO.class));
		if (ListUtil.isEmpty(datas)) {
			return;
		}
		// 不良记录失效日期
		FDateTime dt_disable = new GetPatBbrInvalidDateBP().exec(ScAppUtils.getServerDateTime(), IScDictCodeConst.ID_REG_NOTICKET_BREAK_BBRTP);
		for (PatiVisitDO entDO : datas) {
			PiPatBbrDO patBbrDO = new PiPatBbrDO();
			patBbrDO.setStatus(DOStatus.NEW);
			patBbrDO.setId_grp(entDO.getId_grp());
			patBbrDO.setId_org(entDO.getId_org());
			patBbrDO.setId_pat(entDO.getId_pat());
			patBbrDO.setId_key(entDO.getId_ent());
			patBbrDO.setId_bbrtp(IScDictCodeConst.ID_REG_NOTICKET_BREAK_BBRTP);
			patBbrDO.setSd_bbrtp(IScDictCodeConst.SD_REG_NOTICKET_BREAK_BBRTP);
			if(dt_disable != null){
				patBbrDO.setDt_disable(dt_disable);
			}
			patBbrDO.setDes_reason(IScMsgConst.SC_APT_SCORAL_BREAK_NOTE);
			// 记录预约日期 changed by zhengcm 2018-03-01
			patBbrDO.setDt_act(entDO.getDt_entry());
			patBbrDO.setId_emp(id_emp_sys);
			patBbrDO.setFg_active(FBoolean.TRUE);
			bbrDOList.add(patBbrDO);
		}
	}

	/**
	 * 保存不良行为
	 * 
	 * @author zhengcm
	 *
	 * @param bbrDOList
	 * @throws BizException
	 */
	private void savePatBbr(List<PiPatBbrDO> bbrDOList) throws BizException {
		if (ListUtil.isEmpty(bbrDOList)) {
			return;
		}
		// 患者不良记录维护服务
		IPatbbrCudService cmdService = ServiceFinder.find(IPatbbrCudService.class);
		// 保存不良记录
		cmdService.save(bbrDOList.toArray(new PiPatBbrDO[0]));
	}
	
	/**
	 * 判断是否是整型
	 * @param str
	 * @return
	 */
	private static boolean isInt(String str) {
        try {
            Integer.valueOf(str);
            return true;
        } catch (Exception e) {
        return false;
        }
    }
}
