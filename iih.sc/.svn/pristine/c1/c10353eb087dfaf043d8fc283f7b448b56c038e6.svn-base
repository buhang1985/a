package iih.sc.sch.s.task.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScParamUtils;
import iih.sc.comm.ScSqlUtils;
import iih.sc.scbd.schedulechl.d.EuEndtimeUnit;
import iih.sc.scbd.schedulechl.d.ScChlPeriodDO;
import iih.sc.scbd.schedulechl.i.IScChlPeriodDORService;
import iih.sc.sch.s.ep.OralSchEP;
import iih.sc.sch.s.ep.SchChlEP;
import iih.sc.sch.s.ep.SchEP;
import iih.sc.sch.s.ep.TickEP;
import iih.sc.sch.s.ep.TicksEP;
import iih.sc.sch.scsch.d.ScSchChlDO;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.sctick.d.EuUseScope;
import iih.sc.sch.sctick.d.EuUseState;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.scticks.d.ScSchTicksDO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnListHandler;

/**
 * 回收号源（新）
 * 
 * @author zhengcm
 * @date 2017-08-31 09:25:10
 *
 */
public class RecycleTickBP {

	private static final int PageSize = 99999;
	/**
	 * 任务执行
	 * 
	 * @author zhengcm
	 * @throws BizException
	 */
	public void exec(Map<String, Object> map) throws BizException {

		// 设置上下文组织
		Context.get().setOrgId((String) map.get("id_org"));

		// 排班和主号源关联Map
		Map<String, Integer> schMajMap = new HashMap<String, Integer>();
		// 排班主键列表
		List<String> schIdsList = new ArrayList<String>();
		// 排班和号位关系
		Map<String, List<ScSchTickDO>> schTickMap = new HashMap<String, List<ScSchTickDO>>();
		// 记录关闭到期的排班渠道
		List<ScSchChlDO> closeChlDOList = new ArrayList<ScSchChlDO>();

		// 1、获取回收天数参数
		int recycleDays = ScParamUtils.getOpTickRecycleDays();

		// 2、查询排版和主号源池数据
		FArrayList schList = this.querySch(recycleDays);
		if (null == schList || schList.isEmpty()) {
			return;
		}

		// 3、处理排班数据
		this.processSchDatas(schList, schMajMap, schIdsList);

		// 4、排班号位
		schTickMap = this.getSchTickMap(schIdsList);

		// 5、获取排班
		ScSchDO[] schDOs = this.getSch(schIdsList);

		// 6、更新排班：返回数据记录自动释放号源的排班
		List<String> autoReleaseSchIdList = this.updateSch(schDOs, schMajMap, schTickMap, closeChlDOList);

		// 7、保存关闭的排班渠道
		if (!ListUtil.isEmpty(closeChlDOList)) {
			new SchChlEP().save(closeChlDOList.toArray(new ScSchChlDO[0]));
		}

		// 8、更新号位:把保留的号源设置为开放
		this.updateSchTick(autoReleaseSchIdList);

		// 9、更新号段
		this.updateSchTicks(autoReleaseSchIdList);

	}

	/**
	 * 查询排班和主号源池
	 *
	 * @author zhengcm
	 * 
	 * @param recycleDays 号源回收天数
	 * @return 排班与主号源池数据
	 * @throws BizException
	 */
	private FArrayList querySch(int recycleDays) throws BizException {
		// 开始日期
		String dt_begin = ScAppUtils.getServerDate().toString();
		// 结束日期
		String dt_end = ScAppUtils.getDateAfter(dt_begin, recycleDays);
		// 查询SQL
		StringBuilder sb = new StringBuilder();
		sb.append("select distinct ");
		sb.append("sch.id_sch, ");
		sb.append("param.polno_maj ");
		sb.append("from ");
		sb.append("sc_sch sch ");
		sb.append("inner join sc_pl pl on sch.id_scpl = pl.id_scpl and pl.sd_sctp = '" + IScDictCodeConst.SD_SCTP_OP
				+ "' ");
		sb.append("inner join sc_dep_param param on pl.id_dep = param.id_dep ");
		sb.append("where ");
		sb.append("sch.d_sch >= '" + dt_begin + "' ");
		sb.append("and sch.d_sch < '" + dt_end + "' ");
		// 查询
		FArrayList list = AppFwUtil.getMapListWithDao(sb.toString());
		return list;
	}

	/**
	 * 处理排班数据
	 *
	 * @param schList 排班主号源池数据列表
	 * @param schMajMap 排班与主号源池的对应Map
	 * @param schIdsList 排班主键列表
	 * @throws BizException
	 * @author zhengcm
	 */
	@SuppressWarnings("unchecked")
	private void processSchDatas(FArrayList schList, Map<String, Integer> schMajMap, List<String> schIdsList)
			throws BizException {
		for (int i = 0; i < schList.size(); i++) {
			Map<String, Object> map = (Map<String, Object>) schList.get(i);
			String schId = map.get("id_sch").toString();
			Integer polnoMaj = 0;
			if (null != map.get("polno_maj")) {
				polnoMaj = Integer.parseInt(map.get("polno_maj").toString());
			}
			schMajMap.put(schId, polnoMaj);
			schIdsList.add(schId);
		}
	}

	/**
	 * 根据主键列表获取排班
	 *
	 * @param schIdsList 排班主键列表
	 * @return 排班DO数组
	 * @throws BizException
	 * @author zhengcm
	 */
	private ScSchDO[] getSch(List<String> schIdsList) throws BizException {
		String cond = ScSqlUtils.getInSqlByIds("id_sch", schIdsList);
		ScSchDO[] schDOs = new SchEP().getSchByCond(cond, null);
		return schDOs;
	}

	/**
	 * 更新排班
	 *
	 * @author zhengcm
	 * 
	 * @param schDOs 排班DO数组
	 * @param schMajMap 排班与主号源池对应Map
	 * @param schOpenPlocnMap 排班与开放渠道的号源池关系Map
	 * @param schTickMap 排班与号位的关系Map
	 * @param closeChlDOList 到期关闭的渠道
	 * @return autoReleaseSchIdList 自动释放号源的排班ID列表
	 * @throws BizException
	 */
	private List<String> updateSch(ScSchDO[] schDOs, Map<String, Integer> schMajMap,
			Map<String, List<ScSchTickDO>> schTickMap, List<ScSchChlDO> closeChlDOList) throws BizException {
		if (ArrayUtil.isEmpty(schDOs)) {
			return null;
		}
		// 自动释放号源的排班ID列表
		List<String> autoReleaseSchIdList = new ArrayList<String>();
		// 记录关闭渠道的号位（需要清空号位的渠道和号源池）
		List<ScSchTickDO> closeTickList = new ArrayList<ScSchTickDO>();
		int polno_maj = 0;// 主号源池
		for (ScSchDO schDO : schDOs) {
			// 判断排班是否自动释放号源
			if (schDO.getFg_auto_release() != null && schDO.getFg_auto_release().equals(FBoolean.TRUE)) {
				schDO.setStatus(DOStatus.UPDATED);
				polno_maj = 0;
				if (null != schMajMap && !schMajMap.isEmpty() && schMajMap.containsKey(schDO.getId_sch())) {
					polno_maj = schMajMap.get(schDO.getId_sch());
				}
				String majApptName = "Quan" + polno_maj + "_appt";// 号源池polno_maj_可预约
				int majAppt = schDO.getAttrVal(majApptName) == null ? 0 : (Integer) schDO.getAttrVal(majApptName);// 数量_号源池polno_maj_可预约
				int totalAppt = schDO.getQuan_total_appt() == null ? 0 : schDO.getQuan_total_appt();// 数量_总数_可预约
				int total = schDO.getQuan_total() == null ? 0 : schDO.getQuan_total();
				int totalChkin = total - totalAppt;// 数量_总数_可挂号
				majAppt = majAppt + totalChkin;// 将TotalChkin释放到主号源的可预约数量中
				schDO.setQuan_total_appt(totalAppt + totalChkin);// 数量_总数_可预约

				// 号源池对应的渠道
				Map<Integer, List<String>> polnoChlMap = new HashMap<Integer, List<String>>();
				// 排班渠道关闭情况
				Map<Integer, Boolean> polnoMap = this.closeSchChl(schDO, polnoChlMap, closeChlDOList);
				// 修改其他号源(未开放)数据(0号源和主号源除外)
				for (int i = 1; i <= 9; i++) {
					// 释放非主号源池
					if (i != polno_maj) {
						// 排班当前号源池是否全部渠道关闭
						if (null == polnoMap || !polnoMap.containsKey(i) || !polnoMap.get(i)) {
							continue;
						}
						String apptName = "Quan" + i + "_appt";// 号源池i_可预约
						String usedName = "Quan" + i + "_used";// 号源池i_已用
						int appt = schDO.getAttrVal(apptName) == null ? 0 : (Integer) schDO.getAttrVal(apptName);// 数量_号源池i_可预约
						int used = schDO.getAttrVal(usedName) == null ? 0 : (Integer) schDO.getAttrVal(usedName);// 数量_号源池i_已用
						majAppt = majAppt + appt - used;// 释放号源到主号源池
						schDO.setAttrVal(apptName, used);
					}
				}
				schDO.setAttrVal(majApptName, majAppt);// 主号源池可预约数量
				autoReleaseSchIdList.add(schDO.getId_sch());// 记录自动释放号源的排班，便于批量更新号位和号段

				// 关闭无开放渠道的非0非主号源池
				for (int j = 1; j <= 9; j++) {
					// 非主号源池且无开放渠道的号源池
					if (j == polno_maj || !(null != polnoMap && polnoMap.containsKey(j) && polnoMap.get(j))) {
						continue;
					}
					// 当前排班对应的所有号位
					List<ScSchTickDO> tickList = null;
					if (schTickMap != null && schTickMap.containsKey(schDO.getId_sch())) {
						tickList = schTickMap.get(schDO.getId_sch());
					}
					if (ListUtil.isEmpty(tickList)) {
						continue;
					}
					for (ScSchTickDO tickDO : tickList) {
						// 非未用状态的号位不做处理
						if (null != tickDO.getEu_used() && tickDO.getEu_used() != EuUseState.WY) {
							continue;
						}
						// 号位对应的号源池不为空且为关闭渠道的号源池(号位指定的渠道全部关闭时清空)
						if (tickDO.getPolno() != null && tickDO.getPolno() == j) {
							// 当前号位指定的渠道
							String tickChl = tickDO.getIds_scchl();
							if (!StringUtil.isEmptyWithTrim(tickChl)) {
								// 当前号源池的渠道
								List<String> polnoChlList = polnoChlMap.get(j);
								String[] tickChls = tickChl.split(",");
								boolean isclear = true;
								for (String chl : tickChls) {
									if (!polnoChlList.contains(chl)) {
										isclear = false;
										break;
									}
								}
								if (isclear) {
									tickDO.setStatus(DOStatus.UPDATED);
									tickDO.setIds_scchl(null);
									tickDO.setPolno(null);
									closeTickList.add(tickDO);
								}
							}
						}
					}
				}
			}

		}
		// 更新排班
		new SchEP().save(schDOs);
		// 关闭号位号源池
		if (!ListUtil.isEmpty(closeTickList)) {
			new TickEP().save(closeTickList.toArray(new ScSchTickDO[0]));
		}
		// 返回自动释放号源的排班列表
		return autoReleaseSchIdList;
	}

	/**
	 * 获取排班号位Map
	 *
	 * @author zhengcm
	 * 
	 * @param schIdsList 排班主键列表
	 * @return 排班与号位关系Map
	 * @throws BizException
	 */
	private Map<String, List<ScSchTickDO>> getSchTickMap(List<String> schIdsList) throws BizException {
		// 查询所有号位
		String cond = ScSqlUtils.getInSqlByIds("id_sch", schIdsList);
		ScSchTickDO[] tickDOs = this.getAllTickByCond(cond);
		if (ArrayUtil.isEmpty(tickDOs)) {
			return null;
		}
		
		Map<String, List<ScSchTickDO>> tickMap = new HashMap<String, List<ScSchTickDO>>();
		for (ScSchTickDO tickDO : tickDOs) {
			String key = tickDO.getId_sch();
			if (tickMap.containsKey(key)) {
				tickMap.get(key).add(tickDO);
			} else {
				List<ScSchTickDO> list = new ArrayList<ScSchTickDO>();
				list.add(tickDO);
				tickMap.put(key, list);
			}
		}
		return tickMap;
	}

	/**
	 * 关闭到期渠道
	 * 
	 * @author zhengcm
	 *
	 * @param schDO
	 * @param closeChlDOList
	 * @return
	 * @throws BizException
	 */
	private Map<Integer, Boolean> closeSchChl(ScSchDO schDO, Map<Integer, List<String>> polnoChlMap,
			List<ScSchChlDO> closeChlDOList) throws BizException {
		if (null == schDO) {
			return null;
		}
		OralSchEP schEP = new OralSchEP();
		String cond = String.format("id_sch = '%s'", schDO.getId_sch());
		// 查询排班对应的排班渠道数据
		ScSchChlDO[] chlDOs = schEP.getSchChlByCond(cond, null);
		if (ArrayUtil.isEmpty(chlDOs)) {
			return null;
		}
		// 排班中包含的渠道:List<id_scchl>
		List<String> chlIds = new ArrayList<String>();

		for (ScSchChlDO chlDO : chlDOs) {
			String key = chlDO.getId_scchl();
			if (!chlIds.contains(key)) {
				chlIds.add(key);
			}
			if (polnoChlMap.containsKey(chlDO.getScpolcn())) {
				polnoChlMap.get(chlDO.getScpolcn()).add(chlDO.getId_scchl());
			} else {
				List<String> chlList = new ArrayList<String>();
				chlList.add(chlDO.getId_scchl());
				polnoChlMap.put(chlDO.getScpolcn(), chlList);
			}
		}
		// 查询渠道对应的渠道期间
		IScChlPeriodDORService pqryService = ServiceFinder.find(IScChlPeriodDORService.class);
		cond = ScSqlUtils.getInSqlByIds("id_scchl", chlIds) + " and sd_sctp = '" + IScDictCodeConst.SD_SCTP_OP + "'";
		ScChlPeriodDO[] periodDOs = pqryService.find(cond, null, FBoolean.FALSE);
		if (ArrayUtil.isEmpty(periodDOs)) {
			return null;
		}
		// 当前服务器日期时间
		FDateTime nowDateTime = ScAppUtils.getServerDateTime();
		// 需要关闭的排班渠道：val = id_sch + "_" + id_scchl
		List<String> closeIds = new ArrayList<String>();
		for (ScChlPeriodDO periodDO : periodDOs) {
			if (periodDO.getEnd_time_val() == null || periodDO.getEu_end_time_unit() == null) {
				continue;
			}
			if (periodDO.getEnd_time_val() == 0 && periodDO.getEu_end_time_unit() == EuEndtimeUnit.DAY) {
				continue;
			}
			FDateTime closeDateTime = this.getCloseDateTime(nowDateTime, periodDO.getEnd_time_val(),
					periodDO.getEu_end_time_unit());
			FDateTime schDateTime = new FDateTime(schDO.getD_sch() + " " + schDO.getT_b_acpt());
			if (closeDateTime.toString().compareTo(schDateTime.toString()) > 0) {
				String val = periodDO.getId_scchl();
				if (!closeIds.contains(val)) {
					closeIds.add(val);// 记录关闭的排班渠道
				}
			}
		}
		if (ListUtil.isEmpty(closeIds)) {
			return null;
		}
		for (ScSchChlDO chlDO : chlDOs) {
			if (!closeIds.contains(chlDO.getId_scchl())) {
				continue;
			}
			if (chlDO.getFg_active() == null || chlDO.getFg_active().booleanValue()) {
				chlDO.setStatus(DOStatus.UPDATED);
				chlDO.setFg_active(FBoolean.FALSE);
				closeChlDOList.add(chlDO);
			}
		}
		// 号源池渠道关闭情况
		Map<Integer, Boolean> polnoMap = new HashMap<Integer, Boolean>();
		// 记录各号源池是否回收号源：全部渠道关闭时需要回收
		for (Map.Entry<Integer, List<String>> entry : polnoChlMap.entrySet()) {
			List<String> chlList = entry.getValue();
			if (ListUtil.isEmpty(chlList)) {
				continue;
			}
			boolean isrecycle = true;
			for (String id_scchl : chlList) {
				if (!closeIds.contains(id_scchl)) {
					isrecycle = false;
					break;
				}
			}
			polnoMap.put(entry.getKey(), isrecycle);
		}
		return polnoMap;
	}

	/**
	 * 更新排班号位:把保留的号源设置为开放
	 *
	 * @param schIdsList 排班主键列表
	 * @throws BizException
	 * @author zhengcm
	 */
	private void updateSchTick(List<String> schIdsList) throws BizException {
		if (ListUtil.isEmpty(schIdsList)) {
			return;
		}
		TickEP tickEP = new TickEP();
		// 查询所有号位
		String cond = ScSqlUtils.getInSqlByIds("id_sch", schIdsList) + " and fg_active = 'Y' and eu_usescope = "
				+ EuUseScope.REG;
		ScSchTickDO[] tickDOs = tickEP.getTickByCond(cond, null);
		if (ArrayUtil.isEmpty(tickDOs)) {
			return;
		}
		for (ScSchTickDO tickDO : tickDOs) {
			tickDO.setStatus(DOStatus.UPDATED);
			tickDO.setEu_usescope(EuUseScope.APT);
		}
		// 更新号位
		tickEP.save(tickDOs);
	}

	/**
	 * 更新排班号段
	 *
	 * @param schIdsList 排班主键列表
	 * @throws BizException
	 * @author zhengcm
	 */
	private void updateSchTicks(List<String> schIdsList) throws BizException {
		if (ListUtil.isEmpty(schIdsList)) {
			return;
		}
		TicksEP ticksEP = new TicksEP();
		// 查询所有号位
		String cond = ScSqlUtils.getInSqlByIds("id_sch", schIdsList);
		ScSchTicksDO[] ticksDOs = ticksEP.getTicksByCond(cond, null);
		if (ArrayUtil.isEmpty(ticksDOs)) {
			return;
		}
		for (ScSchTicksDO ticksDO : ticksDOs) {
			ticksDO.setStatus(DOStatus.UPDATED);
			ticksDO.setQuecn_appt(ticksDO.getQuecn());
		}
		// 更新号段
		ticksEP.save(ticksDOs);
	}

	/**
	 * 根据提前关闭时间计算渠道关闭时间（当前时间相加）
	 *
	 * @author zhengcm
	 * 
	 * @param nowDateTime 当前时间
	 * @param closeVal 提前关闭时间
	 * @param closeUnit 提前关闭时间单位
	 * @return 与当前时间相加的差值日期
	 * @throws BizException
	 */
	private FDateTime getCloseDateTime(FDateTime nowDateTime, int closeVal, int closeUnit) throws BizException {
		FDateTime newDateTime = new FDateTime();
		if (closeUnit == EuEndtimeUnit.HOUR) {
			newDateTime = nowDateTime.addSeconds(3600 * closeVal);
		} else if (closeUnit == EuEndtimeUnit.DAY) {
			if (closeVal > 0) {
				newDateTime = nowDateTime.getDateTimeAfter(closeVal);
			} else if (closeVal < 0) {
				newDateTime = nowDateTime.getDateTimeBefore(closeVal);
			}
		}
		return newDateTime;
	}
	
	/**
	 * 查询排班下号位sql
	 * @param cond
	 * @return
	 */
	private String getQrySql(String cond){
		StringBuilder qry = new StringBuilder();
		qry.append(" select id_tick,id_grp,id_org,id_sch,code,name,queno,eu_usescope,fg_active,ds,sv,id_ticks,")
		.append("eu_used,eu_add,polno_used,prjfld1,prjfld2,prjfld3,prjfld4,prjfld5,prjfld6,id_scsrv,id_tick_occupier,fg_add,")
		.append("id_reserve_rsn,sd_reserve_rsn,note_reserve,t_b,t_e,ids_scchl,polno,createdby,createdtime,modifiedby,modifiedtime,ids_kinditm")
		.append(" from sc_tick ")
		.append(" where 1=2");
		if (!StringUtil.isEmpty(cond)) {
			qry.append(" or ").append(cond);
		}
		return qry.toString();
	}
	
	/**
	 * 基于分页查询号位：目前最大数据量
	 * @param cond
	 * @return
	 * @throws DAException
	 */
	private ScSchTickDO[] getAllTickByCond(String cond) throws DAException{
		DAFacade dafacade = new DAFacade();
		int sc_tickCount = getSc_tickCount(cond);
		List<ScSchTickDO> tick_list = null;
		List<ScSchTickDO> list = null;
		if(sc_tickCount < PageSize){
		String qry = this.getQrySql(cond);
			tick_list = (List<ScSchTickDO>) dafacade.execQuery(qry, new BeanListHandler(ScSchTickDO.class));
		if(ListUtil.isEmpty(tick_list)) return null;
		return (ScSchTickDO[]) tick_list.toArray(new ScSchTickDO[0]);
		} else {
			//页数
			int page = sc_tickCount/PageSize;
			//余数
			int remainderData = sc_tickCount%page;
			boolean isRemain = false;
			if(remainderData != 0){
				page++;
				isRemain = true;
			}
			int begin = 0;
			int end = 0;
			for(int i=0; i<=page; i++){
				if(i < page){
					begin = (PageSize*i)+1;                                                        
					end = PageSize*(i+1);
					String qry = this.getQrySql(cond, begin, PageSize);
					list = (List<ScSchTickDO>) dafacade.execQuery(qry, new BeanListHandler(ScSchTickDO.class));
					tick_list.addAll(list);
				} else {
					if (isRemain) {
						begin = end + 1;
						end = end + remainderData;
						String qry = this.getQrySql(cond, begin, end);
						list = (List<ScSchTickDO>) dafacade.execQuery(qry, new BeanListHandler(ScSchTickDO.class));
						tick_list.addAll(list);
	}
	}
			}
		}
		return (ScSchTickDO[]) tick_list.toArray(new ScSchTickDO[0]);
	} 
	
	/**
	 * 查询排班下号位分页sql
	 * @param cond
	 * @param beginDate
	 * @param endData
	 * @return
	 */
	private String getQrySql(String cond, int begin, int end) {
		StringBuilder qry = new StringBuilder();
		qry.append("select * from")
		.append(" (select id_tick,id_grp,id_org,id_sch,code,name,queno,eu_usescope,fg_active,ds,sv,id_ticks,")
		.append("eu_used,eu_add,polno_used,prjfld1,prjfld2,prjfld3,prjfld4,prjfld5,prjfld6,id_scsrv,id_tick_occupier,fg_add,")
		.append("id_reserve_rsn,sd_reserve_rsn,note_reserve,t_b,t_e,ids_scchl,polno,createdby,createdtime,modifiedby,modifiedtime,ids_kinditm,rownum rn")
		.append(" from sc_tick")
		.append(" where rownum <= " + end);
		if (!StringUtil.isEmpty(cond)) {
			qry.append(" or ").append(cond)
			.append(" ) sc");
		}
		qry.append(") where sc.rn >=" + begin);
		return qry.toString();
	}
	
	/**
	 * 查询票号表中数据总条数
	 * @return
	 * @throws DAException 
	 */
	private int getSc_tickCount(String cond) throws DAException{
		StringBuilder qry = new StringBuilder();
		qry.append("select count(1) from sc_tick where 1=2");
		if (!StringUtil.isEmpty(cond)) {
			qry.append(" or ").append(cond);
		}
		DAFacade dafacade = new DAFacade();
		 int sc_tickCount = 0;
		List<String> list = (List<String>) dafacade.execQuery(qry.toString(), new ColumnListHandler());
		if (list != null && list.size() > 0) {
			Object o = list.get(0);
			sc_tickCount = Integer.parseInt(o.toString());
		}
		return sc_tickCount;
	}
}
