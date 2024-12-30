package iih.sc.apt.s.bp.oral;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.dto.d.AptOralDTO;
import iih.sc.apt.s.ep.OralAptEP;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScSqlUtils;
import iih.sc.comm.ScValidator;
import iih.sc.pub.ScGroupControlUtils;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDO;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDsDO;
import iih.sc.scbd.scdeptparam.d.ScdeptparamAggDO;
import iih.sc.scbd.schedulechl.d.ScChlPeriodDO;
import iih.sc.scbd.schedulechl.d.SchedulechlAggDO;
import iih.sc.scbd.schedulechl.i.ISchedulechlRService;
import iih.sc.sch.i.IScSchOutQryService;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.sctick.d.ScSchTickDO;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取口腔科预约BP
 * 
 * @author zhengcm
 * @modofier zhengcm 增加集团管控
 * @date 2016-09-21 16:20:33
 *
 */
public class GetOralAptBP {

	/**
	 * 获取口腔科预约数据
	 *
	 * @param deptId 排班科室
	 * @param docIds 医生
	 * @param roomName 诊间名称
	 * @param beginDate 开始日期
	 * @param endDate 结束日期
	 * @param codeChl 渠道编码
	 * @param isShowAddTick 是否显示加号
	 * @return 口腔科预约DTO日期分组后的Map
	 * @throws BizException
	 * @author zhengcm
	 */
	public FMap exec(String deptId, String[] docIds, String roomName, FDate beginDate, FDate endDate, String codeChl,
			FBoolean isShowAddTick) throws BizException {
		// 1、参数校验
		ScValidator.validateParam("deptId", deptId);
		ScValidator.validateParam("beginDate", beginDate);
		ScValidator.validateParam("endDate", endDate);
		ScValidator.validateParam("codeChl", codeChl);

		int aptType = 0;// 查询类型：单日预约（默认）
		if (beginDate.compareTo(endDate) != 0) {// 全周预约
			ScValidator.validateParam("docIds", docIds);
			aptType = 1;
		}

		// 2、查询数据
		List<AptOralDTO> oralAptDTOList = this.queryDatas(aptType, deptId, docIds, roomName, isShowAddTick, beginDate,
				endDate, codeChl);
		if (ListUtil.isEmpty(oralAptDTOList)) {
			return null;
		}

		// 所有号位ID
		List<String> tickIdList = new ArrayList<String>();
		// 号位占用数据Map
		Map<String, ScSchTickDO[]> tickOccupiedMap = new LinkedHashMap<String, ScSchTickDO[]>();

		// 3、设置排班版本
		new SetOralAptSchVersionBP().exec(oralAptDTOList);

		// 4、处理患者的不良行为信息
		new OralAptPatBbrProccessBP().exec(oralAptDTOList);

		// 5、取出排班号位主键和记录预约数据
		this.processAptDTO(oralAptDTOList, tickIdList);

		// 6、获取所有号位的占用情况
		this.getBatchTickOccupied(tickIdList, tickOccupiedMap);

		// 7、设置号位的占用情况
		this.setTickOccupiedData(oralAptDTOList, tickOccupiedMap);

		// 8、数据按计划分组
		Map<String, List<AptOralDTO>> planGroupMap = this.groupByPlan(oralAptDTOList);

		// 9、补全计划中缺少的午别数据
		Map<String, List<AptOralDTO>> fillDatasMap = this.fillEmptyDatas(deptId, planGroupMap);

		// 10、数据按照日期分组编码分组
		Map<String, List<AptOralDTO>> datasMap = this.getGroupDatas(fillDatasMap);

		// 11、设置渠道
		this.setDTOChl(oralAptDTOList, codeChl);

		// 12、设置号源剩余数量
		new SetOralAptQuanCanUseBP().exec(oralAptDTOList);

		// 13、返回值处理
		FMap fmap = this.convertReturnDatas(datasMap);

		return fmap;

	}

	/**
	 * 查询数据
	 *
	 * @param aptType
	 * @param deptId
	 * @param docIds
	 * @param roomName
	 * @param isShowAddTick
	 * @param beginDate
	 * @param endDate
	 * @param chlCode
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	@SuppressWarnings("unchecked")
	private List<AptOralDTO> queryDatas(int aptType, String deptId, String[] docIds, String roomName,
			FBoolean isShowAddTick, FDate beginDate, FDate endDate, String chlCode) throws BizException {
		// 组装查询SQL
		StringBuilder sb = this.getSql(aptType, deptId, docIds, roomName, isShowAddTick);
		// SQL参数
		SqlParam params = this.getSqlParam(aptType, deptId, roomName, beginDate, endDate, chlCode);
		// 查询数据
		List<AptOralDTO> oralAptDTOList = (List<AptOralDTO>) new DAFacade().execQuery(sb.toString(), params,
				new BeanListHandler(AptOralDTO.class));
		return oralAptDTOList;
	}

	/**
	 * 组装查询SQL
	 *
	 * @param aptType 预约类型
	 * @param docIds 排班计划Id数组
	 * @param roomName 诊间名称
	 * @param isShowAddTick 是否显示加号
	 * @return sql
	 * @throws BizException
	 * @author zhengcm
	 */
	private StringBuilder getSql(int aptType, String deptId, String[] docIds, String roomName, FBoolean isShowAddTick)
			throws BizException {
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		sb.append("sch.id_sch,");
		sb.append("sch.fg_active as fg_active_sch,");
		sb.append("tick.id_tick,");
		sb.append("tick.eu_used as eu_used_tick,");
		sb.append("tick.queno,");
		sb.append("tick.t_b as t_b_tick,");
		sb.append("tick.fg_add as fg_add_tick,");
		sb.append("tick.sd_reserve_rsn,");
		sb.append("tick.note_reserve,");
		sb.append("tick.fg_active as fg_active_tick,");
		sb.append("tick.id_tick_occupier,");
		sb.append("sch.d_sch,");
		sb.append("sch.id_dayslot,");
		sb.append("site.id_quesite,");
		sb.append("site.name as name_quesite,");
		sb.append("site.room,");
		sb.append("pl.name as name_scpl,");
		sb.append("pl.id_scpl,");
		sb.append("pl.id_scsrv as id_scsrv_main,");
		sb.append("srv_pl.name as name_scsrv_main,");
		sb.append("apt.id_scsrv,");
		sb.append("srv.name as name_scsrv,");
		sb.append("apt.id_apt,");
		sb.append("apt.id_pat,");
		sb.append("apt.sd_status,");
		sb.append("apt.id_scchl,");
		sb.append("chl.code as code_scchl,");
		sb.append("oral.posi_teeth,");
		sb.append("oral.id_proc_oral,");
		sb.append("oral.sd_proc_oral,");
		sb.append("case when (oral.id_proc_oral is null or oral.id_proc_oral = '~') then oral.name_proc_oral else doc.name end as name_proc_oral,");
		sb.append("oral.d_next_appt,");
		sb.append("oral.note_next,");
		sb.append("oral.note,");
		sb.append("oral.svrslot,");
		sb.append("oral.id_statustag,");
		sb.append("oral.sd_statustag,");
		sb.append("oral.dt_lastmdf,");
		sb.append("oral.id_emp_lastmdf,");
		sb.append("psn.name as name_emp_lastmdf,");
		sb.append("sta.name as name_statustag,");
		sb.append("pat.name as name_pat,");
		sb.append("pat.mob as tel_pat,");
		sb.append("pat.fg_realname,");
		sb.append("lot.code as code_dayslot ");
		sb.append("from ");
		sb.append("sc_sch sch ");
		sb.append("inner join sc_tick tick on tick.id_sch = sch.id_sch ");
		if (!isShowAddTick.booleanValue()) {
			sb.append("and tick.fg_add = 'N' ");
		}
		sb.append("inner join bd_dayslot lot on lot.id_dayslot = sch.id_dayslot ");
		sb.append("inner join sc_pl pl on pl.id_scpl = sch.id_scpl and pl.id_dep = ? ");
		sb.append("inner join bd_que_site site on site.id_quesite = sch.id_quesite ");
		if (aptType == 0 && !StringUtil.isEmptyWithTrim(roomName)) {
			sb.append("and room = ? ");
		}
		sb.append("left join sc_apt apt on apt.id_tick = tick.id_tick and (apt.fg_canc is null or apt.fg_canc = 'N') ");
		sb.append("left join sc_apt_op_oral oral on oral.id_apt = apt.id_apt ");
		sb.append("left join sc_chl chl on chl.id_scchl = apt.id_scchl ");
		sb.append("left join pi_pat pat on pat.id_pat = apt.id_pat ");
		sb.append("left join bd_udidoc doc on doc.id_udidoc = oral.id_proc_oral ");
		sb.append("left join sc_srv srv on srv.id_scsrv = apt.id_scsrv ");
		sb.append("left join sc_srv srv_pl on srv_pl.id_scsrv = pl.id_scsrv ");
		sb.append("left join bd_udidoc sta on sta.id_udidoc = oral.id_statustag ");
		sb.append("left join bd_psndoc psn on psn.id_psndoc = oral.id_emp_lastmdf ");

		sb.append("where ");

		String order = null;// 排序

		if (aptType == 0) {
			sb.append("sch.d_sch = ? ");
			order = "order by tick.t_b,pl.name,site.room,site.name";
		} else {
			sb.append("sch.d_sch >= ? ");
			sb.append("and sch.d_sch <= ? ");
			order = "order by tick.t_b,sch.d_sch";
		}
		if (!ArrayUtil.isEmpty(docIds)) {
			// 转换排班计划id
			List<String> scplIdList = this.array2List(docIds);
			sb.append("and " + ScSqlUtils.getInSqlByIds("sch.id_scpl", scplIdList));
		}
		sb.append("and pl.sd_sctp = ? ");
		// 集团管控
		sb.append(" and " + ScGroupControlUtils.getGroupControlFitler(new ScSchDO(), "sch"));
		sb.append(order);
		return sb;
	}

	/**
	 * Sql参数
	 *
	 * @param aptType 预约类型
	 * @param deptId 科室id
	 * @param roomName 诊间名称
	 * @param beginDate 开始日期
	 * @param endDate 结束日期
	 * @return sql参数
	 * @throws BizException
	 * @author zhengcm
	 */
	private SqlParam getSqlParam(int aptType, String deptId, String roomName, FDate beginDate, FDate endDate,
			String chlCode) throws BizException {
		SqlParam params = new SqlParam();
		params.addParam(deptId);
		if (aptType == 0) {// 单日预约
			if (!StringUtil.isEmptyWithTrim(roomName)) {
				params.addParam(roomName);
			}
			params.addParam(beginDate);
		} else {// 全周预约
			FDate newEndDate = this.getEndDateByScChl(endDate, chlCode);
			params.addParam(beginDate);
			params.addParam(newEndDate);
		}
		params.addParam(IScDictCodeConst.SD_SCTP_OP);
		return params;
	}

	/**
	 * Array转换成List
	 *
	 * @param strArr 字符串数组
	 * @return 字符串List
	 * @throws BizException
	 * @author zhengcm
	 */
	private List<String> array2List(String[] strArr) throws BizException {
		if (ArrayUtil.isEmpty(strArr)) {
			return null;
		}
		List<String> arrList = new ArrayList<String>();
		for (String str : strArr) {
			if (!arrList.contains(str)) {
				arrList.add(str);
			}
		}
		return arrList;
	}

	/**
	 * 处理查询到的号位数据：获取号位ID
	 *
	 * @param oralAptDTOList
	 * @param tickIdList
	 * @throws BizException
	 * @author zhengcm
	 */
	private void processAptDTO(List<AptOralDTO> oralAptDTOList, List<String> tickIdList) throws BizException {
		if (ListUtil.isEmpty(oralAptDTOList)) {
			return;
		}
		for (AptOralDTO aptOralDTO : oralAptDTOList) {
			tickIdList.add(aptOralDTO.getId_tick());
		}
	}

	/**
	 * 号位数据按照午别分组
	 *
	 * @param oralAptDTOList
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private Map<String, List<AptOralDTO>> groupOralAptDTOByDayslot(List<AptOralDTO> oralAptDTOList) throws BizException {
		Map<String, List<AptOralDTO>> tickGroupMap = new LinkedHashMap<String, List<AptOralDTO>>();
		if (ListUtil.isEmpty(oralAptDTOList)) {
			return tickGroupMap;
		}
		for (AptOralDTO aptDTO : oralAptDTOList) {
			String key = aptDTO.getCode_dayslot();
			if (tickGroupMap.containsKey(key)) {
				tickGroupMap.get(key).add(aptDTO);
			} else {
				List<AptOralDTO> temp = new ArrayList<AptOralDTO>();
				temp.add(aptDTO);
				tickGroupMap.put(key, temp);
			}
		}
		return tickGroupMap;
	}

	/**
	 * 按照午别编码将数据分组
	 *
	 * @param allPlanMap
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private Map<String, List<AptOralDTO>> getGroupDatas(Map<String, List<AptOralDTO>> allPlanMap) throws BizException {
		if (null == allPlanMap || allPlanMap.isEmpty()) {
			return null;
		}
		Map<String, List<AptOralDTO>> datasMap = new LinkedHashMap<String, List<AptOralDTO>>();
		for (Map.Entry<String, List<AptOralDTO>> entry : allPlanMap.entrySet()) {
			List<AptOralDTO> list = entry.getValue();
			for (AptOralDTO dto : list) {
				String key = dto.getCode_dayslot();
				if (datasMap.containsKey(key)) {
					datasMap.get(key).add(dto);
				} else {
					List<AptOralDTO> temp = new ArrayList<AptOralDTO>();
					temp.add(dto);
					datasMap.put(key, temp);
				}
			}
		}
		return datasMap;
	}

	/**
	 * 填充午别空值数据
	 *
	 * @param deptId
	 * @param planGroupMap
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private Map<String, List<AptOralDTO>> fillEmptyDatas(String deptId, Map<String, List<AptOralDTO>> planGroupMap)
			throws BizException {
		if (StringUtil.isEmptyWithTrim(deptId) || null == planGroupMap || planGroupMap.isEmpty()) {
			return null;
		}
		Map<String, List<ScSchTickDO>> deptDayslotMap = this.calDeptDayslotTick(deptId);
		if (null == deptDayslotMap || deptDayslotMap.isEmpty()) {
			return null;
		}
		Map<String, List<AptOralDTO>> datasMap = new LinkedHashMap<String, List<AptOralDTO>>();
		for (Map.Entry<String, List<AptOralDTO>> entry : planGroupMap.entrySet()) {
			List<AptOralDTO> allList = new ArrayList<AptOralDTO>();
			String planKey = entry.getKey();
			List<AptOralDTO> list = entry.getValue();
			Map<String, List<AptOralDTO>> daysMap = this.groupOralAptDTOByDayslot(list);
			for (Map.Entry<String, List<ScSchTickDO>> daysEntry : deptDayslotMap.entrySet()) {
				String key = daysEntry.getKey();
				List<ScSchTickDO> tickDOs = daysEntry.getValue();
				if (daysMap.containsKey(key)) {
					allList.addAll(list);
				} else {
					for (ScSchTickDO tickDO : tickDOs) {
						AptOralDTO dto = new AptOralDTO();
						dto.setId_sch(list.get(0).getId_sch());
						dto.setId_scpl(list.get(0).getId_scpl());
						dto.setName_scpl(list.get(0).getName_scpl());
						dto.setRoom(list.get(0).getRoom());
						dto.setName_quesite(list.get(0).getName_quesite());
						dto.setD_sch(list.get(0).getD_sch());
						dto.setT_b_tick(tickDO.getT_b());
						dto.setFg_active_tick(tickDO.getFg_active());
						dto.setFg_add_tick(tickDO.getFg_add());
						dto.setCode_dayslot(key);
						allList.add(dto);
					}
				}
			}
			datasMap.put(planKey, allList);
		}
		return datasMap;
	}

	/**
	 * 按照计划将数据分组
	 *
	 * @param oralAptDTOList
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private Map<String, List<AptOralDTO>> groupByPlan(List<AptOralDTO> oralAptDTOList) throws BizException {
		if (ListUtil.isEmpty(oralAptDTOList)) {
			return null;
		}
		Map<String, List<AptOralDTO>> planGroupMap = new LinkedHashMap<String, List<AptOralDTO>>();
		for (AptOralDTO aptDTO : oralAptDTOList) {
			String key = aptDTO.getId_scpl();
			if (planGroupMap.containsKey(key)) {
				planGroupMap.get(key).add(aptDTO);
			} else {
				List<AptOralDTO> list = new ArrayList<AptOralDTO>();
				list.add(aptDTO);
				planGroupMap.put(key, list);
			}
		}
		return planGroupMap;
	}

	/**
	 * 按照科室计算午别号位
	 *
	 * @param deptId
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private Map<String, List<ScSchTickDO>> calDeptDayslotTick(String deptId) throws BizException {
		if (StringUtil.isEmptyWithTrim(deptId)) {
			return null;
		}
		ScdeptparamAggDO aggDO = new OralAptEP().getDeptParamAggByDeptId(deptId, IScDictCodeConst.SD_SCTP_OP);
		if (null == aggDO) {
			return null;
		}
		ScDeptParamDO hdo = aggDO.getParentDO();
		ScDeptParamDsDO[] dsDOs = (ScDeptParamDsDO[]) aggDO.getChildren(ScDeptParamDsDO.class);
		if (ArrayUtil.isEmpty(dsDOs)) {
			return null;
		}
		Map<String, List<ScSchTickDO>> map = new LinkedHashMap<String, List<ScSchTickDO>>();
		for (ScDeptParamDsDO dsDO : dsDOs) {
			String key = dsDO.getCode_dayslot();
			int num = dsDO.getQuan_total();
			int limit = dsDO.getQuan_addlimit();
			FTime dt_b = dsDO.getT_begin();
			List<ScSchTickDO> list = new ArrayList<ScSchTickDO>();
			// 正常号
			for (int i = 0; i < num; i++) {
				ScSchTickDO tickDO = new ScSchTickDO();
				tickDO.setFg_add(FBoolean.FALSE);
				tickDO.setT_b(dt_b);
				FTime dt_e = ScAppUtils.addMinutesByFTime(dt_b, hdo.getSec_period());
				dt_b = dt_e;
				tickDO.setT_e(dt_e);
				tickDO.setFg_active(FBoolean.FALSE);
				list.add(tickDO);
			}
			// 处理加号
			for (int i = 0; i < limit; i++) {
				ScSchTickDO tickDO = new ScSchTickDO();
				tickDO.setFg_add(FBoolean.TRUE);
				tickDO.setT_b(ScAppUtils.addMinutesByFTime(dt_b, 1));
				dt_b = ScAppUtils.addMinutesByFTime(dt_b, hdo.getSec_period());
				tickDO.setT_e(dt_b);
				tickDO.setFg_active(FBoolean.FALSE);
				list.add(tickDO);
			}
			map.put(key, list);
		}
		return map;
	}

	/**
	 * 批量获取号位占用情况
	 *
	 * @param tickIdList
	 * @param tickOccupiedMap
	 * @throws BizException
	 * @author zhengcm
	 */
	private void getBatchTickOccupied(List<String> tickIdList, Map<String, ScSchTickDO[]> tickOccupiedMap)
			throws BizException {
		if (ListUtil.isEmpty(tickIdList)) {
			return;
		}
		// 排班对外查询服务
		IScSchOutQryService qryService = ServiceFinder.find(IScSchOutQryService.class);
		tickOccupiedMap = qryService.batchGetOccupiedTickList(tickIdList.toArray(new String[0]));
	}

	/**
	 * 设置号位占用情况数据
	 *
	 * @param oralAptDTOList
	 * @param tickOccupiedMap
	 * @throws BizException
	 * @author zhengcm
	 */
	@SuppressWarnings("unchecked")
	private void setTickOccupiedData(List<AptOralDTO> oralAptDTOList, Map<String, ScSchTickDO[]> tickOccupiedMap)
			throws BizException {
		if (ListUtil.isEmpty(oralAptDTOList) || null == tickOccupiedMap || tickOccupiedMap.isEmpty()) {
			return;
		}
		for (AptOralDTO aptDTO : oralAptDTOList) {
			String key = aptDTO.getId_tick();
			if (!tickOccupiedMap.containsKey(key)) {
				continue;
			}
			ScSchTickDO[] tickDOs = tickOccupiedMap.get(key);
			if (ArrayUtil.isEmpty(tickDOs)) {
				continue;
			}
			for (ScSchTickDO tickDO : tickDOs) {
				aptDTO.getTickarray().add(tickDO.getId_tick());
			}
		}
	}

	/**
	 * 根据渠道的可预约天数和开始日期计算结束日期
	 *
	 * @param endDate
	 * @param codeChl
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private FDate getEndDateByScChl(FDate endDate, String codeChl) throws BizException {
		ScChlPeriodDO perDO = this.getChlPeriodByChlCode(codeChl);
		if (null == perDO) {
			return null;
		}
		int days = perDO.getDays();
		String newEndDate = ScAppUtils.getDateAfter(ScAppUtils.getServerDateTime().getBeginDate().toString(), days);
		if (StringUtil.isEmptyWithTrim(newEndDate)) {
			return endDate;
		}
		// 比较大小
		if (endDate.after(new FDate(newEndDate))) {
			return new FDate(newEndDate);
		}
		return endDate;
	}

	/**
	 * 查询对应渠道充的门诊排班类型的渠道期间
	 *
	 * @param codeChl
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private ScChlPeriodDO getChlPeriodByChlCode(String codeChl) throws BizException {
		ISchedulechlRService qryService = ServiceFinder.find(ISchedulechlRService.class);
		String where = String.format("code = '%s'", codeChl);
		SchedulechlAggDO[] aggDOs = qryService.find(where, null, FBoolean.FALSE);
		if (ArrayUtil.isEmpty(aggDOs)) {
			return null;
		}
		ScChlPeriodDO[] chlPerDOs = (ScChlPeriodDO[]) aggDOs[0].getChildren(ScChlPeriodDO.class);
		if (ArrayUtil.isEmpty(chlPerDOs)) {
			return null;
		}
		// 去排班类型为“门诊”的期间
		for (ScChlPeriodDO perDO : chlPerDOs) {
			if (perDO.getSd_sctp().equals(IScDictCodeConst.SD_SCTP_OP)) {
				return perDO;
			}
		}
		return null;
	}

	/**
	 * 设置渠道
	 *
	 * @param oralAptDTOList
	 * @param code_schchl
	 * @throws BizException
	 * @author zhengcm
	 */
	private void setDTOChl(List<AptOralDTO> oralAptDTOList, String code_schchl) throws BizException {
		if (ListUtil.isEmpty(oralAptDTOList) || StringUtil.isEmptyWithTrim(code_schchl)) {
			return;
		}
		ScChlPeriodDO chlPeriodDO = this.getChlPeriodByChlCode(code_schchl);
		if (null == chlPeriodDO) {
			return;
		}
		for (AptOralDTO dto : oralAptDTOList) {
			dto.setId_scchl(chlPeriodDO.getId_scchl());
		}
	}

	/**
	 * 处理返回值：FMap格式返回
	 *
	 * @param datasMap
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	@SuppressWarnings("unchecked")
	private FMap convertReturnDatas(Map<String, List<AptOralDTO>> datasMap) throws BizException {
		FMap fmap = new FMap();
		if (datasMap != null && !datasMap.isEmpty()) {
			for (Map.Entry<String, List<AptOralDTO>> entry : datasMap.entrySet()) {
				FArrayList flist = new FArrayList();
				List<AptOralDTO> list = entry.getValue();
				flist.addAll(list);
				fmap.put(entry.getKey(), flist);
			}
		}
		return fmap;
	}
}