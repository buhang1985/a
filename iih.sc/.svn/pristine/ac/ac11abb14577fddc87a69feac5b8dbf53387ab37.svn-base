package iih.sc.sch.s.bp;

import iih.sc.comm.ScContextUtils;
import iih.sc.comm.ScSqlUtils;
import iih.sc.comm.ScValidator;
import iih.sc.sch.dto.d.SchOralInfoDTO;
import iih.sc.sch.s.ep.OralSchEP;
import iih.sc.sch.scsch.d.ScSchChlDO;
import iih.sc.sch.sctick.d.EuAddTickMod;
import iih.sc.sch.sctick.d.EuUseState;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.scp.scplan.d.ScPlanDO;
import iih.sc.scp.scplan.i.IScplanRService;
import iih.sc.scp.scpltick.d.ScPlanWeekTickDO;
import iih.sc.scp.scplweek.d.EuWeekTp;
import iih.sc.scp.scplweek.d.ScPlanWeekChlDO;
import iih.sc.scp.scplweek.d.ScPlanWeekDO;
import iih.sc.scp.scplweek.d.ScplweekAggDO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 根据排班计划获取口腔科周计划的号位和渠道数据BP
 * 
 * @author zhengcm
 * @date 2016-09-19 15:52:37
 *
 */
public class GetOralSelectedSchPlanBP {

	public FMap exec(String id_scpl) throws BizException {
		// 1、检查参数
		ScValidator.validateParam("id_scpl", id_scpl);

		// 2、根据排班计划获取排班周计划模板
		ScplweekAggDO[] weekAggDOs = this.getPlanWeekDOByPlan(id_scpl);
		ScPlanDO planDO = null;
		planDO = ServiceFinder.find(IScplanRService.class).findById(id_scpl);
		if (ArrayUtil.isEmpty(weekAggDOs)) {			
			throw new BizException(planDO.getName() + "的周计划没设置模板, 请先对应设置!");
		}

		// 3、排班周计划id
		List<String> ids = new ArrayList<String>();
		for (ScplweekAggDO weekAggDO : weekAggDOs) {
			ids.add(weekAggDO.getParentDO().getId_scplweek());
		}

		// 4、排班周计划号位Map
		Map<String, List<ScPlanWeekTickDO>> planWeekTickMap = this.getPlanWeekTickByPlanWeek(ids);

		// 5、设置排班和排班渠道和排班号位数据
		List<SchOralInfoDTO> oralSchDTOList = new ArrayList<SchOralInfoDTO>();
		this.setSchChlAndTickData(weekAggDOs, oralSchDTOList, planWeekTickMap, planDO);

		// 6、根据日期分组id进行分组
		Map<String, SchOralInfoDTO> oralSchMap = this.groupByDatasByDayslot(oralSchDTOList);

		// 返回类型转换
		FMap fmap = new FMap();
		if (oralSchMap != null && !oralSchMap.isEmpty()) {
			for (Map.Entry<String, SchOralInfoDTO> entry : oralSchMap.entrySet()) {
				fmap.put(entry.getKey(), entry.getValue());
			}
		}
		return fmap;
	}

	/**
	 * 设置排班和排班渠道和排班号位数据
	 *
	 * @param weekAggDOs 排班周计划DO数组
	 * @param oralSchDTOList 口腔科排班信息DTO列表
	 * @param planWeekTickMap 排班周计划号位Map
	 * @throws BizException
	 * @author zhengcm
	 */
	@SuppressWarnings("unchecked")
	private void setSchChlAndTickData(ScplweekAggDO[] weekAggDOs,
			List<SchOralInfoDTO> oralSchDTOList,
			Map<String, List<ScPlanWeekTickDO>> planWeekTickMap, ScPlanDO planDO)
			throws BizException {
		for (ScplweekAggDO weekAggDO : weekAggDOs) {
			ScPlanWeekDO planWeekDO = weekAggDO.getParentDO();
			SchOralInfoDTO oralSchDTO = new SchOralInfoDTO();
			oralSchDTO.setFg_enable(planDO.getFg_active());
			oralSchDTO.setName_scpl(planDO.getName());
			oralSchDTO.setId_scpl(planWeekDO.getId_scpl());
			oralSchDTO.setId_dayslot(planWeekDO.getId_dayslot());
			oralSchDTO.setScpolcn(planWeekDO.getScpolcn());
			oralSchDTO.setQuan_total(planWeekDO.getQuan_total());
			oralSchDTO.setQuan_total_used(0);
			oralSchDTO.setQuan0_appt(planWeekDO.getQuan0_appt());
			oralSchDTO.setQuan1_appt(planWeekDO.getQuan1_appt());
			oralSchDTO.setQuan2_appt(planWeekDO.getQuan2_appt());
			oralSchDTO.setQuan3_appt(planWeekDO.getQuan3_appt());
			oralSchDTO.setQuan4_appt(planWeekDO.getQuan4_appt());
			oralSchDTO.setQuan5_appt(planWeekDO.getQuan5_appt());
			oralSchDTO.setQuan6_appt(planWeekDO.getQuan6_appt());
			oralSchDTO.setQuan7_appt(planWeekDO.getQuan7_appt());
			oralSchDTO.setQuan8_appt(planWeekDO.getQuan8_appt());
			oralSchDTO.setQuan9_appt(planWeekDO.getQuan9_appt());
			oralSchDTO.setMax_num_add(planWeekDO.getMax_num_add());
			ScPlanWeekChlDO[] weekChlDOs = (ScPlanWeekChlDO[]) weekAggDO
					.getChildren(ScPlanWeekChlDO.class);

			// 设置排班渠道
			if (!ArrayUtil.isEmpty(weekChlDOs)) {
				List<ScSchChlDO> schChlList = new ArrayList<ScSchChlDO>();
				for (ScPlanWeekChlDO weekChlDO : weekChlDOs) {
					ScSchChlDO schChlDO = new ScSchChlDO();
					schChlDO.setId_grp(ScContextUtils.getGrpId());
					schChlDO.setId_org(ScContextUtils.getOrgId());
					schChlDO.setScpolcn(weekChlDO.getScpolcn());
					schChlDO.setId_scchl(weekChlDO.getId_scchl());
					schChlDO.setName_scchl(weekChlDO.getName_scchl());
					schChlList.add(schChlDO);
				}
				FArrayList chlFList = new FArrayList();
				chlFList.addAll(schChlList);
				oralSchDTO.setSch_chl_list(chlFList);
				oralSchDTOList.add(oralSchDTO);
			}

			// 设置排班号位
			List<ScPlanWeekTickDO> planWeekTickList = planWeekTickMap.get(planWeekDO
					.getId_scplweek());
			if (!ListUtil.isEmpty(planWeekTickList)) {
				List<ScSchTickDO> schTickList = new ArrayList<ScSchTickDO>();
				for (ScPlanWeekTickDO planWeekTickDO : planWeekTickList) {
					ScSchTickDO schTickDO = new ScSchTickDO();
					schTickDO.setId_grp(ScContextUtils.getGrpId());
					schTickDO.setId_org(ScContextUtils.getOrgId());
					schTickDO.setCode(planWeekTickDO.getCode());
					schTickDO.setName(planWeekTickDO.getName());
					schTickDO.setQueno(planWeekTickDO.getQueno());
					schTickDO.setT_b(planWeekTickDO.getT_b());
					schTickDO.setT_e(planWeekTickDO.getT_e());
					schTickDO.setFg_active(planWeekTickDO.getFg_active());
					schTickDO.setEu_used(EuUseState.WY);
					schTickDO.setEu_usescope(planWeekTickDO.getEu_usescope());
					schTickDO.setEu_add(EuAddTickMod.ZCH);
					schTickDO.setId_scsrv(planWeekTickDO.getId_scsrv());
					schTickDO.setFg_add(planWeekTickDO.getFg_add());
					schTickList.add(schTickDO);
				}
				FArrayList tickFList = new FArrayList();
				tickFList.addAll(schTickList);
				oralSchDTO.setSch_tick_list(tickFList);
			}
			oralSchDTOList.add(oralSchDTO);
		}
	}

	/**
	 * 根据排班计划查询排班周计划模板
	 *
	 * @param id_scpl 排班计划id
	 * @return 排班周计划聚合DO数组
	 * @throws BizException
	 * @author zhengcm
	 */
	private ScplweekAggDO[] getPlanWeekDOByPlan(String id_scpl) throws BizException {
		if (StringUtil.isEmptyWithTrim(id_scpl)) {
			return null;
		}
		String where = String.format("id_scpl = '%s' and eu_weektp = " + EuWeekTp.DAY, id_scpl);
		return new OralSchEP().getPlanWeekAggByCond(where, null);
	}

	/**
	 * 根据排班周计划查询排班周计划号位
	 *
	 * @param id_scplweeks 排班周计划id列表
	 * @return 排班周计划号位Map
	 * @throws BizException
	 * @author zhengcm
	 */
	private Map<String, List<ScPlanWeekTickDO>> getPlanWeekTickByPlanWeek(List<String> id_scplweeks)
			throws BizException {
		Map<String, List<ScPlanWeekTickDO>> planWeekTickMap = new HashMap<String, List<ScPlanWeekTickDO>>();
		String where = ScSqlUtils.getInSqlByIds("id_scplweek", id_scplweeks);
		ScPlanWeekTickDO[] planWeekTickDOs = new OralSchEP().getPlanWeekTickByCond(where, "queno");
		if (ArrayUtil.isEmpty(planWeekTickDOs)) {
			return planWeekTickMap;
		}
		for (ScPlanWeekTickDO planWeekTickDO : planWeekTickDOs) {
			String key = planWeekTickDO.getId_scplweek();
			if (planWeekTickMap.containsKey(key)) {
				planWeekTickMap.get(key).add(planWeekTickDO);
			} else {
				List<ScPlanWeekTickDO> temp = new ArrayList<ScPlanWeekTickDO>();
				temp.add(planWeekTickDO);
				planWeekTickMap.put(key, temp);
			}
		}
		return planWeekTickMap;
	}

	/**
	 * 根据日期分组id分组
	 *
	 * @param oralSchDTOList 口腔科排班信息DTO列表
	 * @return 根据日期分组id分组Map
	 * @throws BizException
	 * @author zhengcm
	 */
	private Map<String, SchOralInfoDTO> groupByDatasByDayslot(List<SchOralInfoDTO> oralSchDTOList)
			throws BizException {
		Map<String, SchOralInfoDTO> oralSchMap = new HashMap<String, SchOralInfoDTO>();
		if (ListUtil.isEmpty(oralSchDTOList)) {
			return oralSchMap;
		}
		for (SchOralInfoDTO oralSchDTO : oralSchDTOList) {
			oralSchMap.put(oralSchDTO.getId_dayslot(), oralSchDTO);
		}
		return oralSchMap;
	}
}
