package iih.sc.apt.s.bp;

import iih.sc.apt.dto.d.AptDto;
import iih.sc.apt.dto.d.MtApt4EsDTO;
import iih.sc.apt.s.event.MakeMtAptEvent;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.apt.scapt.d.ScAptMtDO;
import iih.sc.apt.scapt.d.ScaptAggDO;
import iih.sc.apt.scapt.i.IScaptCudService;
import iih.sc.comm.ScContextUtils;
import iih.sc.scbd.scheduleres.d.ScheduleResDO;
import iih.sc.scbd.scheduleres.i.IScheduleresRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 医技预约保存
 * 
 * @author ccj
 * @modifier zhengcm 医技预约表字段删除
 */
public class SaveAptMtBP {

	/**
	 * 保存预约主表和医技预约子表
	 * 
	 * @param aggDO 预约aggDo
	 * @param id_entp 就诊类型
	 * @param id_en 就诊id
	 * @param id_or 医嘱id
	 * @param content_or 医嘱内容
	 * @param id_dep_sign 申请科室id
	 * @param fBoolean 加急标识
	 */
	public void exec(ScaptAggDO aggDO, AptDto aptDto) throws BizException {
		if (aggDO == null || aptDto == null)
			return;
		ScAptMtDO aptMtDO = new ScAptMtDO();
		ScAptDO aptDO = aggDO.getParentDO();
		aptMtDO.setFg_arrive(FBoolean.FALSE); // 医技辅签到标志
		aptMtDO.setId_dep_mp(aptDto.getId_dep()); // 执行部门
		// aptMtDO.setId_entp(aptDto.getId_entp()); // 就诊类型
		// aptMtDO.setId_ent(aptDto.getId_ent()); // 就诊id
		String id_mt = getIdMtByScAptDo(aptDO); // 资源医技辅id
		if (StringUtil.isEmpty(id_mt))
			return;
		aptMtDO.setId_mt(id_mt); // 资源医技辅id
		// aptMtDO.setId_or(aptDto.getId_or()); // 医技辅医嘱id
		// aptMtDO.setContent_or(aptDto.getContent_or()); // 医嘱内容
		// aptMtDO.setId_dep_apply(aptDto.getId_dep_sign()); // 申请科室
		// aptMtDO.setFg_urgent(aptDto.getFg_urgent()); // 加载标识
		aptMtDO.setId_grp(ScContextUtils.getGrpId()); // 预约集团
		aptMtDO.setId_org(ScContextUtils.getOrgId()); // 预约机构
		// aptMtDO.setSd_apptmd_mt(IScDictCodeConst.SD_APPTMD_OP_NORMAL); //
		// 医技辅预约方式编码
		aptMtDO.setStatus(DOStatus.NEW);
		aggDO.setScAptMtDO(new ScAptMtDO[] { aptMtDO });
		IScaptCudService cudSrv = ServiceFinder.find(IScaptCudService.class);
		cudSrv.save(new ScaptAggDO[] { aggDO });

		// 触发检查预约信息事件
		MtApt4EsDTO apt4EsDTO = new MtApt4EsDTO();
		apt4EsDTO.setId_apt(aggDO.getParentDO().getId_apt());
		new MakeMtAptEvent().invoke(apt4EsDTO);
	}

	/**
	 * 返回医技辅id根据预约主表do
	 * 
	 * @param aptDO 预约do
	 * @return 资源对应的医技辅id
	 */
	private String getIdMtByScAptDo(ScAptDO aptDO) throws BizException {
		if (aptDO == null || StringUtil.isEmpty(aptDO.getId_scres()))
			return null;
		String id_scres = aptDO.getId_scres(); // 资源id
		IScheduleresRService rService = ServiceFinder.find(IScheduleresRService.class);
		ScheduleResDO resDO = rService.findById(id_scres);
		return resDO.getId_mt();
	}
}
