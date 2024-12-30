package iih.sc.sch.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScContextUtils;
import iih.sc.comm.ScSqlUtils;
import iih.sc.scbd.s.ep.SccaEP;
import iih.sc.scbd.scheduleca.d.ScheduleCADO;
import iih.sc.sch.dto.d.SchOralInfoDTO;
import iih.sc.sch.s.bp.oral.ValidateNewSchBP;
import iih.sc.sch.s.ep.OralSchEP;
import iih.sc.sch.scsch.d.ScSchChlDO;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.d.SchOcpResDO;
import iih.sc.sch.scsch.d.ScschAggDO;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.scp.scplan.d.ScPlanDO;
import iih.sc.scp.scplan.i.IScplanRService;
import iih.sc.scp.scplweek.d.EuWeekTp;
import iih.sc.scp.scplweek.d.ScPlanWeekDO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;

/**
 * 新增口腔科排班BP
 * 
 * @author zhengcm
 * @date 2016-09-14 10:14:49
 *
 */
public class InsertOralSchBP {

	/**
	 * 新增口腔科排班
	 *
	 * @param schDTOList 口腔科排班DTO列表
	 * @throws BizException
	 * @author zhengcm
	 */
	public void exec(List<SchOralInfoDTO> schDTOList) throws BizException {
		if (ListUtil.isEmpty(schDTOList)) {
			return;
		}
		// 验证新增排班
		ValidateNewSchBP newValidator = new ValidateNewSchBP();
		newValidator.exec(schDTOList);

		// 排班计划Map
		Map<String, ScPlanDO> planMap = new HashMap<String, ScPlanDO>();
		// 排班周计划Map
		Map<String, ScPlanWeekDO> planWeekMap = new HashMap<String, ScPlanWeekDO>();
		// 排班号位Map
		List<ScSchTickDO> schTickDOList = new ArrayList<ScSchTickDO>();
		// 排班聚合DO列表
		List<ScschAggDO> schAggDOList = new ArrayList<ScschAggDO>();

		List<SchOralInfoDTO> schList = new ArrayList<SchOralInfoDTO>();

		// 帅选出占用排班数据
		List<SchOralInfoDTO> ocpSchList = this.splitOcpSch(schDTOList, schList);

		// 1、获取排班计划
		planMap = this.getPlanDO(schList);

		// 2、获取排班周计划
		planWeekMap = this.getPlanWeek(schList);

		// 3、获取排班分类
		ScheduleCADO scdo = this.GetScCa();

		// 4、组装排班AggDO
		this.processSchAggDO(schList, planMap, planWeekMap, schAggDOList, schTickDOList, scdo);

		// 5、数据检查
		this.checkOralSchDatas(schAggDOList);

		// 6、保存排班和排班渠道
		ScschAggDO[] aggDOs = this.saveOralSchAggDO(schAggDOList);

		// 7、保存排班号位
		this.saveOralSchTick(schTickDOList);

		// 8、保存排班的占用排班
		this.saveSchOcp(ocpSchList, aggDOs);
	}

	/**
	 * 组装排班AggDO
	 *
	 * @param schDTOList 口腔科排班信息DTO列表
	 * @param planMap 排班计划Map
	 * @param planWeekMap 排班周计划Map
	 * @param schAggDOList 排班聚合DO列表
	 * @param schTickDOList 排班号位DO列表
	 * @throws BizException
	 * @author zhengcm
	 */
	private void processSchAggDO(List<SchOralInfoDTO> schDTOList, Map<String, ScPlanDO> planMap,
			Map<String, ScPlanWeekDO> planWeekMap, List<ScschAggDO> schAggDOList, List<ScSchTickDO> schTickDOList,
			ScheduleCADO cado) throws BizException {
		for (SchOralInfoDTO oralSchDTO : schDTOList) {
			String key = oralSchDTO.getId_scpl();
			ScPlanDO planDO = null;
			if (null != planMap && planMap.containsKey(key)) {
				planDO = planMap.get(key);
			}
			ScPlanWeekDO planWeekDO = null;
			key = oralSchDTO.getId_scpl() + oralSchDTO.getId_dayslot();
			if (null != planWeekMap && planWeekMap.containsKey(key)) {
				planWeekDO = planWeekMap.get(key);
			}
			ScschAggDO schAggDO = this.createNewSch(oralSchDTO, planDO, planWeekDO, schTickDOList, cado);
			schAggDOList.add(schAggDO);
		}
	}

	/**
	 * 创建排班聚合DO
	 *
	 * @param oralSchDTO 口腔科排班信息DTO
	 * @param planDO 排班计划DO
	 * @param planWeekDO 排班周计划DO
	 * @return 排班聚合DO
	 * @throws BizException
	 * @author zhengcm
	 */
	@SuppressWarnings("unchecked")
	private ScschAggDO createNewSch(SchOralInfoDTO oralSchDTO, ScPlanDO planDO, ScPlanWeekDO planWeekDO,
			List<ScSchTickDO> schTickList, ScheduleCADO cado) throws BizException {
		DBUtil util = new DBUtil();
		// 排班聚合DO
		ScschAggDO schAggDO = new ScschAggDO();
		// 排班
		ScSchDO schDO = new ScSchDO();
		schDO.setStatus(DOStatus.NEW);
		schDO.setId_sch(util.getOIDs(1)[0]);// 主键
		schDO.setId_grp(ScContextUtils.getGrpId());
		schDO.setId_org(ScContextUtils.getOrgId());
		schDO.setId_quesite(oralSchDTO.getId_quesite());
		schDO.setId_emp_nurse(oralSchDTO.getId_emp_nurse());// 排班护士
		schDO.setId_scpl(planDO.getId_scpl());
		schDO.setSd_sctp(IScDictCodeConst.SD_SCTP_OP);// 排班类型：门诊
		schDO.setId_sctp(IScDictCodeConst.ID_SCTP_OP);
		schDO.setId_scca(planDO.getId_scca());
		schDO.setId_depparam(oralSchDTO.getId_depparam());
		schDO.setD_sch(oralSchDTO.getD_sch());
		schDO.setId_dayslot(oralSchDTO.getId_dayslot());
		schDO.setScpolcn(oralSchDTO.getScpolcn());
		schDO.setId_tickmd(planDO.getId_tickmd());
		schDO.setSd_tickmd(planDO.getSd_tickmd());// 票号模式
		schDO.setId_apptru(planDO.getId_apptru());
		schDO.setQuan_total_appt(planWeekDO.getQuan_total_appt() == null ? 0 : planWeekDO.getQuan_total_appt());
		schDO.setQuan_total(planWeekDO.getQuan_total() == null ? 0 : planWeekDO.getQuan_total());
		schDO.setAddquecn(0);
		schDO.setT_b_acpt(planWeekDO.getT_b_acpt());
		schDO.setT_e_acpt(planWeekDO.getT_e_acpt());
		schDO.setFg_std_acpt(planWeekDO.getFg_std_acpt());
		schDO.setSrvslot(planWeekDO.getSrvslot());
		schDO.setSugest_exmint(planWeekDO.getSugest_exmint());
		schDO.setSugest_num_mint(planWeekDO.getSugest_num_mint());
		schDO.setSugest_num_tick(planWeekDO.getSugest_num_tick());
		schDO.setT_e_reg(planWeekDO.getT_e_reg());
		// changed by zhengcm 2018-04-11 处理新增并停诊的场景
		if (null != oralSchDTO.getFg_active() && !oralSchDTO.getFg_active().booleanValue()) {
			schDO.setFg_active(FBoolean.FALSE);// 不启用
		} else {
			schDO.setFg_active(FBoolean.TRUE);// 启用
		}
		schDO.setQuan_total(oralSchDTO.getQuan_total() == null ? 0 : oralSchDTO.getQuan_total());
		schDO.setQuan_total_appt(schDO.getQuan_total());
		schDO.setQuan_total_used(0);
		schDO.setQuan0_appt(oralSchDTO.getQuan0_appt() == null ? 0 : oralSchDTO.getQuan0_appt());
		schDO.setQuan0_used(0);
		schDO.setQuan1_appt(oralSchDTO.getQuan1_appt() == null ? 0 : oralSchDTO.getQuan1_appt());
		schDO.setQuan1_used(0);
		schDO.setQuan2_appt(oralSchDTO.getQuan2_appt() == null ? 0 : oralSchDTO.getQuan2_appt());
		schDO.setQuan2_used(0);
		schDO.setQuan3_appt(oralSchDTO.getQuan3_appt() == null ? 0 : oralSchDTO.getQuan3_appt());
		schDO.setQuan3_used(0);
		schDO.setQuan4_appt(oralSchDTO.getQuan4_appt() == null ? 0 : oralSchDTO.getQuan4_appt());
		schDO.setQuan4_used(0);
		schDO.setQuan5_appt(oralSchDTO.getQuan5_appt() == null ? 0 : oralSchDTO.getQuan5_appt());
		schDO.setQuan5_used(0);
		schDO.setQuan6_appt(oralSchDTO.getQuan6_appt() == null ? 0 : oralSchDTO.getQuan6_appt());
		schDO.setQuan6_used(0);
		schDO.setQuan7_appt(oralSchDTO.getQuan7_appt() == null ? 0 : oralSchDTO.getQuan7_appt());
		schDO.setQuan7_used(0);
		schDO.setQuan8_appt(oralSchDTO.getQuan8_appt() == null ? 0 : oralSchDTO.getQuan8_appt());
		schDO.setQuan8_used(0);
		schDO.setQuan9_appt(oralSchDTO.getQuan9_appt() == null ? 0 : oralSchDTO.getQuan9_appt());
		schDO.setQuan9_used(0);
		schDO.setId_scca(cado.getId_scca());
		schDO.setMax_num_add(oralSchDTO.getMax_num_add() == null ? 0 : oralSchDTO.getMax_num_add());
		schAggDO.setParentDO(schDO);

		// 排班渠道
		ScSchChlDO[] schChlDOs = null;
		if (null != oralSchDTO.getSch_chl_list() && oralSchDTO.getSch_chl_list().size() > 0) {
			FArrayList flist = oralSchDTO.getSch_chl_list();
			schChlDOs = (ScSchChlDO[]) flist.toArray(new ScSchChlDO[] {});
			if (!ArrayUtil.isEmpty(schChlDOs)) {
				for (ScSchChlDO chlDO : schChlDOs) {
					chlDO.setStatus(DOStatus.NEW);
					chlDO.setId_schchl(null);
				}
			}
		}
		schAggDO.setChildren(ScSchChlDO.class, schChlDOs);

		// 当前排班的号位
		ScSchTickDO[] schTickDOs = null;
		if (null != oralSchDTO.getSch_tick_list() && oralSchDTO.getSch_tick_list().size() > 0) {
			FArrayList flist = oralSchDTO.getSch_tick_list();
			schTickDOs = (ScSchTickDO[]) flist.toArray(new ScSchTickDO[] {});
		}
		if (!ArrayUtil.isEmpty(schTickDOs)) {
			for (ScSchTickDO tickDO : schTickDOs) {
				tickDO.setStatus(DOStatus.NEW);
				tickDO.setId_tick(null);
				tickDO.setId_sch(schDO.getId_sch());
				schTickList.add(tickDO);
			}
		}

		return schAggDO;
	}

	/**
	 * 保存排班
	 *
	 * @param schAggDOList 排班聚合DO列表
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private ScschAggDO[] saveOralSchAggDO(List<ScschAggDO> schAggDOList) throws BizException {
		if (ListUtil.isEmpty(schAggDOList)) {
			return null;
		}
		return new OralSchEP().insertSch(schAggDOList.toArray(new ScschAggDO[0]));
	}

	/**
	 * 保存排班号位
	 *
	 * @param schTickDOList 排班号位DO列表
	 * @throws BizException
	 * @author zhengcm
	 */
	private void saveOralSchTick(List<ScSchTickDO> schTickDOList) throws BizException {
		if (ListUtil.isEmpty(schTickDOList)) {
			return;
		}
		new OralSchEP().insertSchTick(schTickDOList.toArray(new ScSchTickDO[] {}));
	}

	/**
	 * 获取排班周计划
	 *
	 * @param schDTOList 口腔科排班信息DTO列表
	 * @return 排班周计划Map
	 * @throws BizException
	 * @author zhengcm
	 */
	private Map<String, ScPlanWeekDO> getPlanWeek(List<SchOralInfoDTO> schDTOList) throws BizException {
		List<String> plIds = new ArrayList<String>();
		List<String> lotIds = new ArrayList<String>();
		for (SchOralInfoDTO oralSchDTO : schDTOList) {
			plIds.add(oralSchDTO.getId_scpl());
			lotIds.add(oralSchDTO.getId_dayslot());
		}
		String where = ScSqlUtils.getInSqlByIds("id_scpl", plIds) + " and eu_weektp = " + EuWeekTp.DAY + " and "
				+ ScSqlUtils.getInSqlByIds("id_dayslot", lotIds);
		ScPlanWeekDO[] weekDOs = new OralSchEP().getPlanWeekByCond(where, null);
		if (ArrayUtil.isEmpty(weekDOs)) {
			return null;
		}
		Map<String, ScPlanWeekDO> planWeekMap = new HashMap<String, ScPlanWeekDO>();
		for (ScPlanWeekDO planWeekDO : weekDOs) {
			planWeekMap.put(planWeekDO.getId_scpl() + planWeekDO.getId_dayslot(), planWeekDO);
		}
		return planWeekMap;
	}

	/**
	 * 获取排班计划
	 *
	 * @param schDTOList 口腔科排班信息DTO列表
	 * @return 排班计划Map
	 * @throws BizException
	 * @author zhengcm
	 */
	private Map<String, ScPlanDO> getPlanDO(List<SchOralInfoDTO> schDTOList) throws BizException {
		Map<String, ScPlanDO> planMap = new HashMap<String, ScPlanDO>();
		List<String> plIds = new ArrayList<String>();
		for (SchOralInfoDTO oralSchDTO : schDTOList) {
			plIds.add(oralSchDTO.getId_scpl());
		}
		if (ListUtil.isEmpty(plIds)) {
			return null;
		}
		ScPlanDO[] planDOs = ServiceFinder.find(IScplanRService.class).findByBIds(plIds.toArray(new String[] {}),
				FBoolean.FALSE);
		if (!ArrayUtil.isEmpty(planDOs)) {
			for (ScPlanDO planDO : planDOs) {
				planMap.put(planDO.getId_scpl(), planDO);
			}
		}
		// 检查排班计划是否存在
		for (String id_scpl : plIds) {
			if (planMap != null && !planMap.isEmpty()) {
				if (!planMap.containsKey(id_scpl)) {
					throw new BizException("排班计划ID为" + id_scpl + "的数据不存在");
				}
			} else {
				throw new BizException("排班计划ID为" + id_scpl + "的数据不存在");
			}
		}
		return planMap;
	}

	/**
	 * 获取排班分类
	 * 
	 * @return
	 * @throws BizException
	 */
	private ScheduleCADO GetScCa() throws BizException {
		SccaEP sccaEp = new SccaEP();
		ScheduleCADO cado = sccaEp.GetScca(IScDictCodeConst.SD_SCTP_OP);
		return cado;
	}

	/**
	 * 排班数据检查
	 *
	 * @param schAggDOList 排班AggDO列表
	 * @throws BizException
	 * @author zhengcm
	 */
	public void checkOralSchDatas(List<ScschAggDO> schAggDOList) throws BizException {
		if (ListUtil.isEmpty(schAggDOList)) {
			return;
		}
		for (ScschAggDO aggDO : schAggDOList) {
			ScSchChlDO[] chlDOs = (ScSchChlDO[]) aggDO.getChildren(ScSchChlDO.class);
			if (ArrayUtil.isEmpty(chlDOs)) {
				continue;
			}
			for (ScSchChlDO chlDO : chlDOs) {
				if (null == chlDO.getScpolcn()) {
					throw new BizException(IScMsgConst.SC_SCH_CHL_EXIST_EMPTY);// 排班渠道数据存在号源池可预约数或渠道为空，请检查！
				}
			}
		}
	}

	/**
	 * 区分排班和占用
	 *
	 * @param schDTOList
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private List<SchOralInfoDTO> splitOcpSch(List<SchOralInfoDTO> schDTOList, List<SchOralInfoDTO> schList)
			throws BizException {
		if (ListUtil.isEmpty(schDTOList)) {
			return null;
		}
		List<SchOralInfoDTO> ocpList = new ArrayList<SchOralInfoDTO>();
		for (SchOralInfoDTO infoDTO : schDTOList) {
			if (infoDTO.getFg_occupy() != null && infoDTO.getFg_occupy().booleanValue()) {
				ocpList.add(infoDTO);
			} else {
				schList.add(infoDTO);
			}
		}
		schDTOList = schList;
		return ocpList;
	}

	/**
	 * 保存新增排班对应的占用排班数据
	 *
	 * @param ocpList
	 * @param schAggDOList
	 * @throws BizException
	 * @author zhengcm
	 */
	private void saveSchOcp(List<SchOralInfoDTO> ocpList, ScschAggDO[] aggDOs) throws BizException {
		if (ListUtil.isEmpty(ocpList)) {
			return;
		}
		Map<String, String> pkMap = new HashMap<String, String>();
		for (ScschAggDO aggDO : aggDOs) {
			ScSchDO schDO = aggDO.getParentDO();
			String key = schDO.getId_scpl() + schDO.getD_sch() + schDO.getId_dayslot();
			String val = schDO.getId_sch();
			pkMap.put(key, val);
		}
		List<SchOcpResDO> datas = new ArrayList<SchOcpResDO>();
		for (SchOralInfoDTO ocpDTO : ocpList) {
			String key = ocpDTO.getId_scpl() + ocpDTO.getD_sch() + ocpDTO.getId_dayslot();
			SchOcpResDO resDO = new SchOcpResDO();
			resDO.setStatus(DOStatus.NEW);
			resDO.setId_sch(pkMap.get(key));
			resDO.setId_quesite(ocpDTO.getId_quesite());
			datas.add(resDO);
		}
		new OralSchEP().saveSchOcpRes(datas.toArray(new SchOcpResDO[0]));
	}
}
