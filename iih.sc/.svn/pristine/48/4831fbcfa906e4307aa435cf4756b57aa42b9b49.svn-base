package iih.sc.apt.s.bp;

import iih.bd.bc.udi.pub.IBdResDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.apt.scapt.d.ScaptAggDO;
import iih.sc.apt.scapt.d.desc.ScAptDODesc;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScContextUtils;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.scticks.d.ScSchTicksDO;
import iih.sc.sch.scticks.i.IScticksRService;
import iih.sc.scp.scplan.d.ScPlanDO;
import org.apache.commons.lang.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.custcfg.billcode.i.IBillcodeManage;

/**
 * 获取预约aggDo
 * 
 * @author ccj
 *
 */
public class GetAptAggBp {

	/**
	 * 获取预约aggDo
	 * 
	 * @param schDO 排班do
	 * @param schTickDO 号位do
	 * @param id_pat 患者id
	 * @param id_ticks 号段id
	 * @param id_scchl 预约渠道id
	 * @return ScaptAggDO 预约aggDo
	 */
	public ScaptAggDO exec(ScPlanDO planDO, ScSchDO schDO, ScSchTickDO schTickDO, String id_pat, String id_scchl,FBoolean fg_mtapp_apt)
			throws BizException {
		if (planDO == null || schDO == null || schTickDO == null || StringUtils.isEmpty(id_pat)
				|| StringUtils.isEmpty(id_scchl))
			return null;
		ScAptDO aptDO = new ScAptDO();
		aptDO.setDt_appt(ScAppUtils.getServerDateTime()); // 预约操作日期时间
		aptDO.setId_dateslot(schDO.getId_dayslot()); // 日期分组
		aptDO.setId_dep_appt(ScContextUtils.getDeptId()); // 预约操作部门
		aptDO.setId_emp_appt(ScContextUtils.getPsnId()); // 预约操作人员
		aptDO.setId_org_appt(ScContextUtils.getOrgId()); // 预约操作机构
		aptDO.setId_grp(ScContextUtils.getGrpId()); // 预约集团
		aptDO.setId_org(ScContextUtils.getOrgId()); // 预约机构
		aptDO.setId_sch(schDO.getId_sch()); // 计划排班_排班id
		aptDO.setId_pat(id_pat); // 患者id
		aptDO.setId_scca(schDO.getId_scca()); // 排班分类
		aptDO.setId_scres(planDO.getId_scres()); // 排班资源
		aptDO.setId_scsrv(planDO.getId_scsrv()); // 计划服务
		aptDO.setId_sctp(schDO.getId_sctp()); // 排班类型_自定义档案
		aptDO.setId_scchl(id_scchl); // 排班渠道
		aptDO.setQueno(schTickDO.getQueno()); // 票号
		// 获取当前午别
//		IScDaysLotService daysLotService = ServiceFinder.find(IScDaysLotService.class);
//		DaysLotDO nowDaysLot = daysLotService.getNowDaysLot(IScDictCodeConst.SD_SCTP_OP, FBoolean.FALSE);
		// 针对排班为跨天午别晚班
//		FDate nowDate = ScAppUtils.getServerDate();
//		FDate aptDate = schDO.getD_sch();
//		if(aptDate.before(nowDate)){
//			if(IBdResDictCodeConst.ID_DAYSLOT_NIGHTSHIFT.equals(nowDaysLot.getId_dayslottp())){
//				aptDate = aptDate.getDateAfter(1);
//			}
//		}
		// 判断是否为号段预约号段预约要保存号段的id
		if (StringUtils.isNotEmpty(schTickDO.getId_ticks())) {
			aptDO.setId_ticks(schTickDO.getId_ticks());
			IScticksRService iScticksRService = ServiceFinder.find(IScticksRService.class);
			ScSchTicksDO schTicksDO = iScticksRService.findById(schTickDO.getId_ticks());
			aptDO.setDt_b(new FDateTime(schDO.getD_sch().toString() + " " + schTicksDO.getT_b())); // 预计开始日期时间
			aptDO.setDt_e(new FDateTime(schDO.getD_sch().toString() + " " + schTicksDO.getT_e())); // 预计结束日期时间
		} else {
			aptDO.setDt_b(new FDateTime(schDO.getD_sch().toString() + " " + schTickDO.getT_b())); // 预计开始日期时间
			aptDO.setDt_e(new FDateTime(schDO.getD_sch().toString() + " " + schTickDO.getT_e())); // 预计结束日期时间
		}
		aptDO.setFg_payment(FBoolean.FALSE); // 预约已支付标志
		aptDO.setFg_notice(FBoolean.FALSE); // 预约已通知标志
		aptDO.setFg_canc(FBoolean.FALSE); // 取消预约标志
		aptDO.setFg_canc_notice(FBoolean.FALSE); // 取消预约已通知标志
		aptDO.setFg_bill(FBoolean.FALSE); // 已记费标志
		aptDO.setId_tick(schTickDO.getId_tick()); // 号位id
		aptDO.setSd_sctp(schDO.getSd_sctp()); // 排班类型编码
		aptDO.setId_status(IScDictCodeConst.ID_APTSTATUS_ORDER);
		if(fg_mtapp_apt != null && fg_mtapp_apt.booleanValue())
		{
			aptDO.setSd_status(IScDictCodeConst.SD_APTSTATUS_FINISH); //分诊时预约, 预约状态为 完成
		}
		else
		{
			aptDO.setSd_status(IScDictCodeConst.SD_APTSTATUS_ORDER); // 预约状态为预约
		}
		aptDO.setStatus(DOStatus.NEW);

		// 生成编码
		aptDO.setCode(this.createCode(ScAptDODesc.CLASS_FULLNAME));

		ScaptAggDO aggDO = new ScaptAggDO();
		aggDO.setParentDO(aptDO);
		return aggDO;
	}

	/**
	 * 生成编码
	 * 
	 * @param doDescFullName 实体元数据类全名
	 * @return
	 * @throws BizException
	 */
	private String createCode(String doDescFullName) throws BizException {
		IBillcodeManage codeManage = ServiceFinder.find(IBillcodeManage.class);
		String code = codeManage.getPreBillCode_RequiresNew(doDescFullName);
		return code;
	}

}
