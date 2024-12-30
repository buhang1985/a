package iih.sc.scp.s.bp.mt;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.comm.DateTimeUtils;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScValidator;
import iih.sc.scp.dto.d.MtPlWkDTO;
import iih.sc.scp.s.ep.ScplEp;
import iih.sc.scp.s.ep.ScplWeekEP;
import iih.sc.scp.s.ep.ScplWeekTickEP;
import iih.sc.scp.s.ep.ScplWeekTicksEP;
import iih.sc.scp.scplan.d.ScPlanDO;
import iih.sc.scp.scpltick.d.ScPlanWeekTickDO;
import iih.sc.scp.scplticks.d.ScPlanWeekTicksDO;
import iih.sc.scp.scplweek.d.ScPlanWeekChlDO;
import iih.sc.scp.scplweek.d.ScPlanWeekDO;
import iih.sc.scp.scplweek.d.ScplweekAggDO;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FTime;

/**
 * 查找周计划的详细信息
 * 
 * @author
 *
 */
public class GetMtPlWeekBP {
	/**
	 * 查找周计划的详细信息
	 * 
	 * @param plScWeekId
	 *            周计划id
	 * @return
	 * @throws BizException
	 */
	public MtPlWkDTO exec(String plScWeekId) throws BizException {
		if (ScValidator.isEmptyIgnoreBlank(plScWeekId))
			return null;
		// 1.获取周计划(对渠道作处理)
		ScplweekAggDO agg = this.getPlWeek(plScWeekId);
		if (agg == null)
			return null;
		// 2.获取计划
		ScPlanDO pl = this.getScPlan(agg.getParentDO().getId_scpl());
		if (pl == null)
			return null;
		// 3.组装DTO
		MtPlWkDTO wkDTO = new MtPlWkDTO();
		this.wrap2MtPlWk(wkDTO, agg, pl);
		// 4.根据计划号位模式获取号段或号位
		this.wrapTickOrTicks(wkDTO, agg.getParentDO().getId_scplweek(), pl.getSd_tickmd());
		return wkDTO;
	}

	/**
	 * 获取计划
	 * 
	 * @param scplId
	 * @return
	 * @throws BizException
	 */
	private ScPlanDO getScPlan(String scplId) throws BizException {
		ScplEp ep = new ScplEp();
		return ep.getScPl(scplId);
	}

	/**
	 * 获取周计划AggDO并对渠道作处理
	 * 
	 * @param plScWeekId
	 * @return
	 * @throws BizException
	 */
	private ScplweekAggDO getPlWeek(String plScWeekId) throws BizException {
		ScplWeekEP ep = new ScplWeekEP();
		ScplweekAggDO agg = ep.getScplweekAggById(plScWeekId);
		if (agg == null)
			return null;
		this.processScplweekAggDO(agg);
		return agg;
	}

	/**
	 * 处理周计划渠道作处理
	 * 
	 * @param agg
	 */
	private void processScplweekAggDO(ScplweekAggDO agg) {
		if (ScValidator.isNullOrEmpty(agg))
			return;
		ScPlanWeekDO plWeek = agg.getParentDO();
		if (ScValidator.isNullOrEmpty(plWeek))
			return;
		ScPlanWeekChlDO[] chls = agg.getScPlanWeekChlDO();
		if (ScValidator.isNullOrEmpty(chls))
			return;
		int scpolcn = plWeek.getScpolcn();
		Map<Integer, ScPlanWeekChlDO> map = new HashMap<>();
		for (int i = 0; i < scpolcn; i++) {
			ScPlanWeekChlDO chlDo = new ScPlanWeekChlDO();
			Integer scnum = (Integer) plWeek.getAttrVal("Quan" + i + "_appt");
			chlDo.setScnum(scnum);
			chlDo.setScpolcn(i);
			map.put(i, chlDo);
		}
		for (ScPlanWeekChlDO chl : chls) {
			Integer key = chl.getScpolcn();
			if (ScValidator.isNullOrEmpty(key))
				continue;
			if (map.containsKey(key)) {
				ScPlanWeekChlDO value = map.get(key);
				value.setId_scchl(ScValidator.isEmptyIgnoreBlank(value.getId_scchl()) ? chl.getId_scchl()
						: value.getId_scchl() + "," + chl.getId_scchl());
				value.setName_scchl(ScValidator.isEmptyIgnoreBlank(value.getName_scchl()) ? chl.getName_scchl()
						: value.getName_scchl() + "," + chl.getName_scchl());
				value.setCode_scchl(ScValidator.isEmptyIgnoreBlank(value.getCode_scchl()) ? chl.getCode_scchl()
						: value.getCode_scchl() + "," + chl.getCode_scchl());
				String code_scchl = chl.getCode_scchl();// 处理授权科室 和 授权医生
				if ("02".equals(code_scchl)) {
					value.setIds_dep_spec(chl.getIds_dep_spec());// 授权科室id
					value.setNames_dep_spec(chl.getNames_dep_spec());
					value.setIds_emp_spec(chl.getIds_emp_spec());// 授权医生id
					value.setNames_emp_spec(chl.getNames_emp_spec());
				}
				// 就诊类型
				value.setId_entp(ScValidator.isEmptyIgnoreBlank(value.getId_entp()) ? chl.getId_entp() : chl.getId_entp());
				value.setCode_entp(ScValidator.isEmptyIgnoreBlank(value.getCode_entp()) ? chl.getCode_entp() : chl.getCode_entp());
				value.setName_entp(ScValidator.isEmptyIgnoreBlank(value.getName_entp()) ? chl.getName_entp() : chl.getName_entp());
			} else {
				Integer scnum = (Integer) plWeek.getAttrVal("Quan" + key + "_appt");
				chl.setScnum(scnum == null ? 0 : scnum);
				map.put(key, chl);
			}
		}
		agg.setScPlanWeekChlDO(map.values().toArray(new ScPlanWeekChlDO[0]));
	}

	/**
	 * 组装MtPlWkDTO
	 * 
	 * @param wkDTO
	 * @param agg
	 * @param pl
	 */
	private void wrap2MtPlWk(MtPlWkDTO wkDTO, ScplweekAggDO agg, ScPlanDO pl) {
		if(IScDictCodeConst.SD_TICKMD_TIME.equals(pl.getSd_tickmd())){
			ScPlanWeekChlDO[] chls = agg.getScPlanWeekChlDO();
			for (int i = 0; i < chls.length; i++) {
				ScPlanWeekChlDO chl = chls[i];
				int mins = (int) agg.getParentDO().getAttrVal("Quan"+chl.getScpolcn() + "_appt");
				FTime time = DateTimeUtils.getFTime(mins);
				chl.setSctime(time);
			}
		}
		wkDTO.setSd_tickmd(pl.getSd_tickmd());
		ScPlanWeekDO plWeek = agg.getParentDO();
		wkDTO.setId_scplweek(plWeek.getId_scplweek());
		wkDTO.setSv(plWeek.getSv());
		wkDTO.setId_scpl(plWeek.getId_scpl());
		wkDTO.setName_scpl(pl.getName());
		wkDTO.setIdx_week(plWeek.getIdx_week());
		wkDTO.setWeekno(plWeek.getWeekno());
		wkDTO.setId_dayslot(plWeek.getId_dayslot());
		wkDTO.setCode_schrule(pl.getCode_schrule());
		wkDTO.setId_dep(pl.getId_dep());
		wkDTO.setId_scsrv(pl.getId_scsrv());
		wkDTO.setName_scsrv(pl.getName_srv());
		wkDTO.setName_dayslot(plWeek.getName_dayslot());
		wkDTO.setId_apptru(pl.getId_apptru());
		wkDTO.setWeek_list(ScAppUtils.aggDoArray2List(agg));
		wkDTO.setFg_setentp(plWeek.getFg_setentp());
		wkDTO.setId_scca(pl.getId_scca());
		wkDTO.setSd_sctp(pl.getSd_sctp());
	}

	/**
	 * 查询号位或号段 组装MtPlWkDTO
	 * 
	 * @param wkDTO
	 * @param plweekId
	 * @param tickmd
	 * @throws BizException
	 */
	private void wrapTickOrTicks(MtPlWkDTO wkDTO, String plweekId, String tickmd) throws BizException {
		if (IScDictCodeConst.SD_TICKMD_TICK.equals(tickmd)) {
			// 号位
			ScplWeekTickEP tickEP = new ScplWeekTickEP();
			ScPlanWeekTickDO[] tick = tickEP.getTickByWeekIds(new String[] { plweekId });
			wkDTO.setWeek_tick_list(ScAppUtils.doArray2List(tick));
		} else if (IScDictCodeConst.SD_TICKMD_TICKS.equals(tickmd)) {
			// 号段
			ScplWeekTicksEP ticksEP = new ScplWeekTicksEP();
			ScPlanWeekTicksDO[] ticks = ticksEP.getTicksByWeekIds(new String[] { plweekId });
			wkDTO.setWeek_ticks_list(ScAppUtils.doArray2List(ticks));
			// 号位
			ScplWeekTickEP tickEP = new ScplWeekTickEP();
			ScPlanWeekTickDO[] tick = tickEP.getTickByWeekIds(new String[] { plweekId });
			if (!ArrayUtils.isEmpty(tick)) {
				wkDTO.setWeek_tick_list(ScAppUtils.doArray2List(tick));
			}
		} else if (IScDictCodeConst.SD_TICKMD_TIME.equals(tickmd)) {
			// 时间片
			ScplWeekTickEP tickEP = new ScplWeekTickEP();
			ScPlanWeekTickDO[] tick = tickEP.getTickByWeekIds(new String[] { plweekId });
			wkDTO.setWeek_tick_list(ScAppUtils.doArray2List(tick));
		} else
			throw new BizException("计划票号模式错误!");
	}
}
