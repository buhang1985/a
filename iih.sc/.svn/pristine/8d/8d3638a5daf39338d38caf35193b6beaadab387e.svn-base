package iih.sc.apt.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.apt.scapt.d.ScAptOpDO;
import iih.sc.apt.scapt.d.ScaptAggDO;
import iih.sc.apt.scapt.i.IScaptCudService;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScContextUtils;
import iih.sc.scbd.scheduleres.d.ScheduleResDO;
import iih.sc.scbd.scheduleres.i.IScheduleresRService;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvDO;
import iih.sc.scbd.schedulesrv.i.ISchedulesrvMDORService;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.i.IScschMDORService;
import iih.sc.scp.scplan.d.ScPlanDO;
import iih.sc.scp.scplan.i.IScplanRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 门诊预约保存
 * 
 * @author ccj
 *
 */
public class SaveAptOpBP {

	/**
	 * 门诊预约保存
	 * 
	 * @param aggDO 预约aggDo
	 * @param id_scsrv 服务id
	 * @throws BizException
	 */
	public void exec(ScaptAggDO aggDO, String id_scsrv) throws BizException {
		if (aggDO == null || aggDO.getParentDO() == null)
			return;
		IScheduleresRService rService = ServiceFinder.find(IScheduleresRService.class);
		IScplanRService iScplanRService = ServiceFinder.find(IScplanRService.class);
		IScschMDORService mdorService = ServiceFinder.find(IScschMDORService.class);
		ScAptOpDO aptopDO = new ScAptOpDO();
		ScAptDO aptDO = aggDO.getParentDO();
		ScSchDO schDO = mdorService.findById(aptDO.getId_sch());
		ScPlanDO planDO = iScplanRService.findById(schDO.getId_scpl());
		aptopDO.setId_dep(planDO.getId_dep()); // 计划科室
		String id_res = aptDO.getId_scres(); // 资源id
		ScheduleResDO resDO = rService.findById(id_res);
		aptopDO.setId_dep_belong(resDO.getId_dep()); // 资源归属部门
		if (!StringUtil.isEmpty(resDO.getId_emp())) {
			// 如果资源为专家号时 插入医生
			aptopDO.setId_emp(resDO.getId_emp());
		}
		aptopDO.setId_grp(ScContextUtils.getGrpId()); // 预约集团
		aptopDO.setId_org(ScContextUtils.getOrgId()); // 预约机构
		aptopDO.setId_apptmd_op(IScDictCodeConst.ID_APPTMD_OP_NORMAL);
		aptopDO.setSd_apptmd_op(IScDictCodeConst.SD_APPTMD_OP_NORMAL); // 门诊预约方式编码
		ISchedulesrvMDORService schedulesrvMDORService = ServiceFinder.find(ISchedulesrvMDORService.class);
		ScheduleSrvDO scheduleSrvDO = schedulesrvMDORService.findById(id_scsrv);
		if (scheduleSrvDO == null)
			throw new BizException(IScMsgConst.SC_APT_PLAN_SCSRV_EXISTS);
		aptopDO.setId_srvtp(scheduleSrvDO.getId_srvtp());
		aptopDO.setSd_srvtp(scheduleSrvDO.getSd_srvtp()); // 医疗服务类型编码
		aptopDO.setStatus(DOStatus.NEW);
		aggDO.setScAptOpDO(new ScAptOpDO[] { aptopDO });
		IScaptCudService cudSrv = ServiceFinder.find(IScaptCudService.class);
		cudSrv.save(new ScaptAggDO[] { aggDO });
	}
}
