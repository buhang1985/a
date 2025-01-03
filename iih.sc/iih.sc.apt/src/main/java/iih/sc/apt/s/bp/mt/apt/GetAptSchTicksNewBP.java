package iih.sc.apt.s.bp.mt.apt;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.dto.d.MtResDTO;
import iih.sc.apt.s.ep.OralAptEP;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScParamUtils;
import iih.sc.comm.ScSqlUtils;
import iih.sc.comm.ScValidator;
import iih.sc.scbd.dto.d.ScBdSrvDTO;
import iih.sc.scbd.schedulesrv.d.ScSrvKindItm;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvRelDO;
import iih.sc.scbd.schedulesrv.i.IScSrvKindItmRService;
import iih.sc.scbd.schedulesrv.i.IScheduleSrvRelDORService;
import iih.sc.sch.i.IScSchOutQryService;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.d.ScSchOptsrvDO;
import iih.sc.sch.scsch.i.IScSchOptsrvDORService;
import iih.sc.sch.sctick.d.EuUseScope;
import iih.sc.sch.sctick.d.EuUseState;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.scticks.d.ScSchTicksDO;
import iih.sc.scp.scplan.d.ScPlanDO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.SqlParamDTO;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取选号预约号位或号段BP
 * 
 * @author zhengcm
 * @date 2017-12-18 15:18:50
 *
 */
public class GetAptSchTicksNewBP {

	/**
	 * 获取选号预约号位或号段
	 * 
	 * @author zhengcm
	 * @date 2017-12-18 16:21:28
	 *
	 * @param id_sch
	 * @param sd_tickmd
	 * @param id_scchl
	 * @param id_srv
	 * @param sd_sctp
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public FArrayList exec(String id_sch, String id_scchl, String id_srv, String id_enttp,String sd_sctp,String id_pat,String id_ent,FDate d_sch,FBoolean fg_hp) throws BizException {
		// 参数检查
		ScValidator.validateParam("id_sch", id_sch);
		ScValidator.validateParam("id_scchl", id_scchl);
		ScValidator.validateParam("sd_sctp", sd_sctp);
		ScValidator.validateParam("d_sch", d_sch);
		// 排班DO
		ScSchDO schDO = new OralAptEP().getSch(id_sch);
		if (null == schDO) {
			throw new BizException("没找到排班信息，请检查！");
		}

		// 排班计划
		ScPlanDO planDO = new OralAptEP().getScPlan(schDO.getId_scpl());

		// 当前排班渠道剩余可预约数
		List<String> schIdList = new ArrayList<String>();
		schIdList.add(schDO.getId_sch());
		Map<String,Map<Integer, Integer>> map = ServiceFinder.find(IScSchOutQryService.class).batchGetChlSchRemainFilterEntpAmount(schIdList,id_enttp,
				id_scchl);
		if (null == map || map.isEmpty() || !map.containsKey(schIdList.get(0)) || null == map.get(schIdList.get(0))) {
			throw new BizException("渠道剩余可用数量不足，请检查！");
		}
		int remain = map.get(schIdList.get(0)).get(IScDictCodeConst.SC_CHL_REMAIN);
		Map<Integer,Integer> polcnMap = map.get(schIdList.get(0));

		// 处理号位或号段
		FArrayList flist = new FArrayList();
		if (schDO.getSd_tickmd().equals(IScDictCodeConst.SD_TICKMD_TICK)) {// 号位模式
			ScSchTickDO[] tickDOs = this.getTick(id_sch);
			if (sd_sctp.equals(IScDictCodeConst.SD_SCTP_MT) || sd_sctp.equals(IScDictCodeConst.SD_SCTP_OT)) {// 医技或手术
				// 读取系统参数医技预约检查项目类型
				FBoolean isSrvCheck = ScParamUtils.getscAptCOI(planDO.getId_dep());
				// 根据服务过滤设置号位是否可用
				this.filterTickBySrv(tickDOs, id_srv, isSrvCheck, sd_sctp, planDO,id_sch);
			}
			// 根据排班项目类别细目过滤设置号位是否可用
			this.setTickActiveByScSrvKinditm(tickDOs, id_srv,schDO.getId_scca(),id_sch,id_pat,id_ent,d_sch,fg_hp);
			// 根据渠道设置号位是否可用
			this.setTickActiveByScchl(tickDOs, id_scchl, id_enttp,remain,polcnMap);
			if (!ArrayUtil.isEmpty(tickDOs)) {
				for (ScSchTickDO tickDO : tickDOs) {
					flist.add(tickDO);
				}
			}
		} else if (schDO.getSd_tickmd().equals(IScDictCodeConst.SD_TICKMD_TICKS)) {// 号段模式
			ScSchTicksDO[] ticksDOs = this.getTicks(id_sch);
			if (sd_sctp.equals(IScDictCodeConst.SD_SCTP_MT) || sd_sctp.equals(IScDictCodeConst.SD_SCTP_OT)) {// 医技
				// 读取系统参数医技预约检查项目类型
				FBoolean isSrvCheck = ScParamUtils.getscAptCOI(planDO.getId_dep());
				// 根据服务过滤设置号段是否可用
				this.filterTicksBySrv(ticksDOs, id_srv, isSrvCheck, sd_sctp, planDO,id_sch);
			}
			// 根据排班项目类别细目过滤设置号段是否可用
			this.setTicksActiveByScSrvKinditm(ticksDOs, id_srv,schDO.getId_scca(),id_sch,id_pat,id_ent,d_sch,fg_hp);
			// 根据渠道设置号段是否可用
			this.setTicksActiveByScchl(ticksDOs, id_scchl, remain,polcnMap);
			if (!ArrayUtil.isEmpty(ticksDOs)) {
				for (ScSchTicksDO ticksDO : ticksDOs) {
					flist.add(ticksDO);
				}
			}
		}else if (schDO.getSd_tickmd().equals(IScDictCodeConst.SD_TICKMD_TIME)) {// 时间片模式
			ScSchTicksDO[] ticksDOs = this.getTimeTicks(id_sch);
			if (!ArrayUtil.isEmpty(ticksDOs)) {
				for (ScSchTicksDO ticksDO : ticksDOs) {
					flist.add(ticksDO);
				}
			}
		}
		return flist;
	}

	/**
	 * 获取号位
	 *
	 * @param id_sch
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private ScSchTickDO[] getTick(String id_sch) throws BizException {
		if (StringUtil.isEmptyWithTrim(id_sch)) {
			return null;
		}
		String whereStr = "id_sch = ?";
		SqlParamDTO param = new SqlParamDTO();
		param.addParam(id_sch);
		return new OralAptEP().getSchTickByWhere(whereStr,param);
	}

	/**
	 * 获取号段
	 *
	 * @param id_sch
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private ScSchTicksDO[] getTicks(String id_sch) throws BizException {
		String cond = String.format("id_sch = '%s'", id_sch);
		return new OralAptEP().getSchTicksByWhere(cond, "t_b");
	}
	
	/**
	 * 获取时间片信息(号段)  计算字段:预约id 用于前台判断是否可移动
	 * @param id_sch
	 * @return
	 * @throws BizException
	 */
	private ScSchTicksDO[] getTimeTicks(String id_sch) throws BizException {
		StringBuilder sql = new StringBuilder();
		sql.append(" select t.id_ticks,");
		sql.append(" t.id_sch,");
		sql.append(" t.code,");
		sql.append(" t.queno_b,");
		sql.append(" t.quecn,");
		sql.append(" t.t_b,");
		sql.append(" t.t_e,");
		sql.append(" t.fg_used,");
		sql.append(" t.fg_active,");
		sql.append(" t.fg_add,");
		sql.append(" t.quecn_used,");
		sql.append(" t.quecn_appt,");
		sql.append(" apt.id_apt as id_scapt");
		sql.append(" from sc_ticks t");
		sql.append(" left join sc_apt apt on apt.id_ticks = t.id_ticks and apt.fg_canc = 'N'");
		sql.append(" where t.fg_active = 'Y'");
		sql.append(" and t.id_sch = ?");
		sql.append(" order by t.t_b asc");
		SqlParam param = new SqlParam();
		param.addParam(id_sch);
		List<ScSchTicksDO> aptList = (List<ScSchTicksDO>) new DAFacade().execQuery(sql.toString(),param, new BeanListHandler(
				ScSchTicksDO.class));
		return aptList.toArray(new ScSchTicksDO[0]);
	}
	/**
	 * 根据医疗服务id_srv->查询医疗项目排班类别->查询排班项目类别细目,号位没有排班项目类别细目的以及存在类别细目包含医疗服务
	 * 查询到的类别细目的显示可预约的号位,否则显示不可预约
	 * @param tickDOs  号位数据
	 * @param id_srv 诊疗服务
	 * @param id_scca 排班分类
	 * @param id_sch 排班id
	 * @param id_pat 患者id
	 * @param id_ent 就诊id
	 * @param d_sch 排班日期
	 * @param fg_hp 医保支付标识
	 * @throws BizException
	 * @author yzh
	 */
	@SuppressWarnings("unchecked")
	private void setTickActiveByScSrvKinditm(ScSchTickDO[] tickDOs, String id_srv, String id_scca, String id_sch,String id_pat, String id_ent, FDate d_sch,FBoolean fg_hp) throws BizException {
		MtResDTO resDTO = new MtResDTO();
		//初始化resDTO
		this.initDaysList(resDTO);
		//获取患者互斥校验数据
		this.checkSrvMutex(id_pat, id_srv, id_ent, ScAppUtils.getServerDateTime(), resDTO, d_sch,fg_hp);
		String schKindItms = "";
		Map<String, List<String>> tickReleseKind = null;
		// 排斥禁止和次数限制为空,且强制并行或提示并行不为空时释放类别明细
		if (ArrayUtil.isEmpty(resDTO.getDays_excl_must().toArray())
				&& ArrayUtil.isEmpty(resDTO.getDays_excl_times().toArray())
				&& ((!ArrayUtil.isEmpty(resDTO.getDays_together_must().toArray()))
						|| (!ArrayUtil.isEmpty(resDTO.getDays_together_hint().toArray())))) {
			schKindItms = this.getSchproptpKinditmBP(id_sch);
			if (!StringUtil.isEmpty(schKindItms)) {
				// 获取号源释放的类别
				tickReleseKind = this.getSrvKindByitms(schKindItms.split(","));
			}
		} else if (ArrayUtil.isEmpty(resDTO.getDays_excl_must().toArray())
				&& ArrayUtil.isEmpty(resDTO.getDays_excl_times().toArray())
				&& (resDTO.getFg_release() != null && resDTO.getFg_release().booleanValue())) {
			schKindItms = this.getSchproptpKinditmBP(id_sch);
			if (!StringUtil.isEmpty(schKindItms)) {
				// 获取号源释放的类别
				tickReleseKind = this.getSrvKindByitms(schKindItms.split(","));
			}
				}
		// 根据排班id和服务id查询服务的排班类别细目
		ScBdSrvDTO[] scbdsrvs = this.getScBdSrv8IdSrv(id_sch, id_srv);
		List<ScSchTickDO> canUseKinditmresult = new ArrayList<ScSchTickDO>();
		IScSrvKindItmRService iscsrvkinditmrservice = ServiceFinder.find(IScSrvKindItmRService.class);
		for (ScSchTickDO tick : tickDOs) {
			String ids_kinditm = tick.getIds_kinditm();
			if (StringUtil.isEmpty(ids_kinditm)) {
				canUseKinditmresult.add(tick);
				continue;
			}

			String cond = ScSqlUtils.getInSqlByIds(ScSrvKindItm.ID_SCSRVKINDITM, ids_kinditm.split(","));
			ScSrvKindItm[] scSrvKindItms = iscsrvkinditmrservice.find(cond, null, FBoolean.FALSE);

			// 根据服务上的类别明细查询出DO DO上的服务类别需要参与到下面的类别明细的校验
			Map<String, String> scSrvKindItmMap = ScAppUtils.extractStrMapFromObjs(ScSrvKindItm.ID_SCSRVKIND,
					"Id_scsrvkinditem", scbdsrvs, schKindItms);

			// 根据号位号段上的类别明细查询出DO DO上的服务类别需要参与到下面的类别明细的校验
			Map<String, List<String>> scTickKindItmMap = ScAppUtils.extractStrMapFromObjs(ScSrvKindItm.ID_SCSRVKIND,
					ScSrvKindItm.ID_SCSRVKINDITM, scSrvKindItms);
			boolean isCheckKinditm = true;
			if (!StringUtil.isEmpty(ids_kinditm)) {
				for (Map.Entry<String, List<String>> entry : scTickKindItmMap.entrySet()) {
					String id_scsrvkind = entry.getKey();
					// 释放类别明细校验
					if (tickReleseKind != null) {
						List<String> ids_kinditm_list_tick = scTickKindItmMap.get(id_scsrvkind);
						List<String> ids_kinditm_list_rele = tickReleseKind.get(id_scsrvkind);
						// 如果释放的类别存在排班的类别 且 服务类别中不存在
						if (scTickKindItmMap.containsKey(id_scsrvkind) && !scSrvKindItmMap.containsKey(id_scsrvkind)) {
							// 如果释放的明细全包含号位的明细,校验通过,否则失败
							if (!ListUtil.isEmpty(ids_kinditm_list_rele)
									&& ids_kinditm_list_rele.containsAll(ids_kinditm_list_tick)) {
								tick.setFg_active(FBoolean.TRUE);
								continue;
							} else {
								tick.setFg_active(FBoolean.FALSE);
								isCheckKinditm = false;
							}
						}
						// 如果释放的类别存在排班的类别 且 服务类别中存在
						else if (tickReleseKind.containsKey(id_scsrvkind)
								&& scSrvKindItmMap.containsKey(id_scsrvkind)) {
							// 在号位中添加所有释放的类别明细
							ids_kinditm_list_tick.addAll(ids_kinditm_list_rele);
									}
										}

					// 判断服务是否包含号位号段上的类别
					if (scSrvKindItmMap.containsKey(id_scsrvkind)) {
						// 取出号位号段上的类别对应的明细集合list
						List<String> id_kinditm_list = scTickKindItmMap.get(id_scsrvkind);
						// 判断号位号段上的类别对应明细是否包含服务上该类别下的明细 释放掉的类别,类别明细是空
						if (!id_kinditm_list.contains(scSrvKindItmMap.get(id_scsrvkind))
								&& !StringUtil.isEmpty(scSrvKindItmMap.get(id_scsrvkind))) {
							tick.setFg_active(FBoolean.FALSE);
							isCheckKinditm = false;
									}
					} else {
						tick.setFg_active(FBoolean.FALSE);
						isCheckKinditm = false;
								}
							}
						}
			if (isCheckKinditm) {
				tick.setFg_active(FBoolean.TRUE);
				canUseKinditmresult.add(tick);
			}
		}
	}
	
	/**
	 * 根据医疗服务id_srv->查询医疗项目排班类别->查询排班项目类别细目,号段没有排班项目类别细目的以及存在类别细目包含医疗服务
	 * 查询到的类别细目的显示可预约的号段,否则显示不可预约
	 * @param ticksDOs 号段数据
	 * @param id_srv 诊疗项目id
	 * @param id_scca 排班分类id
	 * @param id_sch 排班id
	 * @param id_pat 患者id
	 * @param id_ent 就诊id
	 * @param d_sch 排班日期
	 * @param fg_hp 医保支付标识
	 * @throws BizException
	 * @author yzh
	 */
	private void setTicksActiveByScSrvKinditm(ScSchTicksDO[] ticksDOs, String id_srv, String id_scca, String id_sch,String id_pat,String id_ent,FDate d_sch,FBoolean fg_hp) throws BizException {
		MtResDTO resDTO = new MtResDTO();
		//初始化resDTO
		this.initDaysList(resDTO);
		//获取患者互斥校验数据
		this.checkSrvMutex(id_pat, id_srv, id_ent, ScAppUtils.getServerDateTime(), resDTO, d_sch,fg_hp);
		String schKindItms = "";
		Map<String, List<String>> tickReleseKind = null;
		// 排斥禁止和次数限制为空,且强制并行或提示并行不为空时释放类别明细
		if (ArrayUtil.isEmpty(resDTO.getDays_excl_must().toArray())
				&& ArrayUtil.isEmpty(resDTO.getDays_excl_times().toArray())
				&& ((!ArrayUtil.isEmpty(resDTO.getDays_together_must().toArray()))
						|| (!ArrayUtil.isEmpty(resDTO.getDays_together_hint().toArray())))) {
			schKindItms = this.getSchproptpKinditmBP(id_sch);
			if (!StringUtil.isEmpty(schKindItms)) {
				// 获取号源释放的类别
				tickReleseKind = this.getSrvKindByitms(schKindItms.split(","));
			}
		} else if (ArrayUtil.isEmpty(resDTO.getDays_excl_must().toArray())
				&& ArrayUtil.isEmpty(resDTO.getDays_excl_times().toArray()) && (resDTO.getFg_release() != null && resDTO.getFg_release().booleanValue())) {
			schKindItms = this.getSchproptpKinditmBP(id_sch);
			if (!StringUtil.isEmpty(schKindItms)) {
				// 获取号源释放的类别
				tickReleseKind = this.getSrvKindByitms(schKindItms.split(","));
				}
			}
		ScBdSrvDTO[] scbdsrvs = this.getScBdSrv8IdSrv(id_sch, id_srv);
			IScSrvKindItmRService iscsrvkinditmrservice = ServiceFinder.find(IScSrvKindItmRService.class);
		List<String> canUseKinditmresult = new ArrayList<String>();
		for (ScSchTicksDO ticks : ticksDOs) {
			String ids_kinditm = ticks.getIds_kinditm();
			if (StringUtil.isEmpty(ids_kinditm)) {
				canUseKinditmresult.add(ticks.getId_ticks());
				continue;
							}

			String cond = ScSqlUtils.getInSqlByIds(ScSrvKindItm.ID_SCSRVKINDITM, ids_kinditm.split(","));
			ScSrvKindItm[] scSrvKindItms = iscsrvkinditmrservice.find(cond, null, FBoolean.FALSE);
			// 根据服务上的类别明细查询出DO DO上的服务类别需要参与到下面的类别明细的校验
			Map<String, String> scSrvKindItmMap = ScAppUtils.extractStrMapFromObjs(ScSrvKindItm.ID_SCSRVKIND,
					"Id_scsrvkinditem", scbdsrvs, schKindItms);
			// 根据号位号段上的类别明细查询出DO DO上的服务类别需要参与到下面的类别明细的校验
			Map<String, List<String>> scTickKindItmMap = ScAppUtils.extractStrMapFromObjs(ScSrvKindItm.ID_SCSRVKIND,
					ScSrvKindItm.ID_SCSRVKINDITM, scSrvKindItms);
			boolean isCheckKinditm = true;
			if (!StringUtil.isEmpty(ids_kinditm)) {
				for (Map.Entry<String, List<String>> entry : scTickKindItmMap.entrySet()) {
					String id_scsrvkind = entry.getKey();

					// 释放类别明细校验
 					if (tickReleseKind != null) {
						List<String> ids_kinditm_list_tick = scTickKindItmMap.get(id_scsrvkind);
						List<String> ids_kinditm_list_rele = tickReleseKind.get(id_scsrvkind);
						// 如果释放的类别存在排班的类别 且 服务类别中不存在
						if (scTickKindItmMap.containsKey(id_scsrvkind) && !scSrvKindItmMap.containsKey(id_scsrvkind)) {
							// 如果释放的明细全包含号位的明细,校验通过,否则失败
							if (!ListUtil.isEmpty(ids_kinditm_list_rele)
									&& ids_kinditm_list_rele.containsAll(ids_kinditm_list_tick)) {
								ticks.setFg_active(FBoolean.TRUE);
								continue;
							} else {
								ticks.setFg_active(FBoolean.FALSE);
								isCheckKinditm = false;
						}
									}
						// 如果释放的类别存在排班的类别 且 服务类别中存在
						else if (tickReleseKind.containsKey(id_scsrvkind)
								&& scSrvKindItmMap.containsKey(id_scsrvkind)) {
							// 在号位中添加所有释放的类别明细
							ids_kinditm_list_tick.addAll(ids_kinditm_list_rele);
										}
									}

					// 判断服务是否包含号位号段上的类别
					if (scSrvKindItmMap.containsKey(id_scsrvkind)) {
						// 取出号位号段上的类别对应的明细集合list
						List<String> id_kinditm_list = scTickKindItmMap.get(id_scsrvkind);
						// 判断号位号段上的类别对应明细是否包含服务上该类别下的明细 释放掉的类别,类别明细是空
						if (!id_kinditm_list.contains(scSrvKindItmMap.get(id_scsrvkind))
								&& !StringUtil.isEmpty(scSrvKindItmMap.get(id_scsrvkind))) {
							ticks.setFg_active(FBoolean.FALSE);
							isCheckKinditm = false;
								}
					} else {
						ticks.setFg_active(FBoolean.FALSE);
						isCheckKinditm = false;
							}
						}
				}
			if (isCheckKinditm) {
				ticks.setFg_active(FBoolean.TRUE);
			}
		}
	}
	/**
	 * 根据渠道设置号位是否可用:存在指定渠道的号位时，只显示当前渠道号位对应的号段，否则显示可预约的号位对应的号段（空渠道）
	 * 2018-04-27需求：空渠道和包含当前渠道的号位可用，其他不可用
	 * 
	 * @author zhengcm
	 * @date 2017-12-18 16:02:55
	 *
	 * @param tickDOs
	 * @param id_scchl
	 * @param remain
	 * @throws BizException
	 */
	private void setTickActiveByScchl(ScSchTickDO[] tickDOs, String id_scchl, String id_enttp,int remain,Map<Integer,Integer> polcnMap) throws BizException {
		if (ArrayUtil.isEmpty(tickDOs) || StringUtil.isEmptyWithTrim(id_scchl)) {
			return;
		}
		// 指定了当前渠道的可预约的号位数量
		int canuse = 0;
		for (ScSchTickDO tickDO : tickDOs) {
			for (Integer polcn : polcnMap.keySet()) {
			if (tickDO.getFg_active().booleanValue() && !StringUtil.isEmptyWithTrim(tickDO.getIds_scchl())
					&& tickDO.getIds_scchl().contains(id_scchl) && tickDO.getEu_usescope() == EuUseScope.APT
						&& tickDO.getEu_used() == EuUseState.WY && (tickDO.getPolno()== null || tickDO.getPolno() == polcn)) {
				canuse = canuse + 1;
					break;
				}
			}
		}
		// 如果剩余可预约数量大于指定了当前渠道可预约的号位数量时，允许预约空渠道号位，否则只能预约指定渠道号位
		if (remain > canuse) {
			for (ScSchTickDO tickDO : tickDOs) {
				boolean active = false;
				for (Integer polcn : polcnMap.keySet()) {
				if (tickDO.getFg_active().booleanValue()
						&& (StringUtil.isEmptyWithTrim(tickDO.getIds_scchl()) || tickDO.getIds_scchl().contains(
								id_scchl)) && tickDO.getEu_usescope() == EuUseScope.APT
							&& tickDO.getEu_used() == EuUseState.WY && (tickDO.getPolno()== null || tickDO.getPolno() == polcn)) {
						active = true;
						break;
					}
				}
				if(active){
					tickDO.setFg_active(FBoolean.TRUE);
				}else{
					tickDO.setFg_active(FBoolean.FALSE);
				}
			}
		} else {
			for (ScSchTickDO tickDO : tickDOs) {
				boolean active = false;
				for (Integer polcn : polcnMap.keySet()) {
				if (tickDO.getFg_active().booleanValue() && !StringUtil.isEmptyWithTrim(tickDO.getIds_scchl())
						&& tickDO.getIds_scchl().contains(id_scchl) && tickDO.getEu_usescope() == EuUseScope.APT
							&& tickDO.getEu_used() == EuUseState.WY && (tickDO.getPolno()== null || tickDO.getPolno() == polcn)) {
						active = true;
						break;
					} 
				}
				if(active){
					tickDO.setFg_active(FBoolean.TRUE);
				}else{
					tickDO.setFg_active(FBoolean.FALSE);
				}
			}
		}
	}

	/**
	 * 根据渠道设置号段是否可用：存在指定渠道的号位时，只显示当前渠道号位对应的号段，否则显示可预约的号位对应的号段（空渠道）
	 * 2018-04-27需求：空渠道和包含当前渠道的号位可用，其他不可用
	 * 
	 * @author zhengcm
	 * @date 2017-12-18 16:10:02
	 *
	 * @param ticksDOs
	 * @param id_scchl
	 * @param remain
	 * @throws BizException
	 */
	private void setTicksActiveByScchl(ScSchTicksDO[] ticksDOs, String id_scchl, int remain,Map<Integer,Integer> polcnMap) throws BizException {
		if (ArrayUtil.isEmpty(ticksDOs) || StringUtil.isEmptyWithTrim(id_scchl)) {
			return;
		}
		Map<String, FBoolean> map = new HashMap<String, FBoolean>();
		Map<String,Integer> ticksUseNum = new HashMap<String,Integer>();
		//符合就诊类型号源池号的号段已使用的符合号源池号就诊类型的号位数量
		Map<String,Integer> ticksUsedNum = new HashMap<String,Integer>();
		List<String> ids = new ArrayList<String>();
		for (ScSchTicksDO ticksDO : ticksDOs) {
			ids.add(ticksDO.getId_ticks());
			map.put(ticksDO.getId_ticks(), FBoolean.FALSE);
			ticksUseNum.put(ticksDO.getId_ticks(), 0);
			ticksUsedNum.put(ticksDO.getId_ticks(), 0);
		}
		// 校验号段中是否存在可预约的号位
		//String cond = String.format(
		//		"fg_active = 'Y' and eu_usescope = %d and eu_used = %d" + " and "
		//				+ ScSqlUtils.getInSqlByIds("id_ticks", ids), EuUseScope.APT.intValue(),
		//		EuUseState.WY.intValue());
		String cond = String.format(
				"fg_active = 'Y' and eu_usescope = %d " + " and "
						+ ScSqlUtils.getInSqlByIds("id_ticks", ids), EuUseScope.APT.intValue());
		ScSchTickDO[] tickDOs = new OralAptEP().getSchTickByWhereStr(cond);
		if (!ArrayUtil.isEmpty(tickDOs)) {
			// 指定了当前渠道的可预约的号位数量
			int canuse = 0;
			for (ScSchTickDO tickDO : tickDOs) {
				for (Integer polcn : polcnMap.keySet()) {
				if (tickDO.getFg_active().booleanValue() && !StringUtil.isEmptyWithTrim(tickDO.getIds_scchl())
						&& tickDO.getIds_scchl().contains(id_scchl) && tickDO.getEu_usescope() == EuUseScope.APT
							&& tickDO.getEu_used() == EuUseState.WY && (tickDO.getPolno()== null || tickDO.getPolno() == polcn) ) {
					canuse = canuse + 1;
						break;
					}
				}
			}
			if (remain > canuse) {
				for (ScSchTickDO tickDO : tickDOs) {
					for (Integer polcn : polcnMap.keySet()) {
						if (tickDO.getFg_active().booleanValue() && (StringUtil.isEmptyWithTrim(tickDO.getIds_scchl())
											|| tickDO.getIds_scchl().contains(id_scchl)) && tickDO.getEu_usescope() == EuUseScope.APT
									&& (tickDO.getPolno() == null || tickDO.getPolno() == polcn)) {
								if (tickDO.getEu_used() == EuUseState.WY) {
									map.remove(tickDO.getId_ticks());
									map.put(tickDO.getId_ticks(), FBoolean.TRUE);
								}else if(tickDO.getEu_used() == EuUseState.SY){
									int numUsed = ticksUsedNum.get(tickDO.getId_ticks()) == null?0:ticksUsedNum.get(tickDO.getId_ticks())+1;
									ticksUsedNum.put(tickDO.getId_ticks(), numUsed);
								}
								int num = ticksUseNum.get(tickDO.getId_ticks()) == null ? 0
										: ticksUseNum.get(tickDO.getId_ticks()) + 1;
							ticksUseNum.put(tickDO.getId_ticks(), num);
								break;
						}
					}
				}
			} else {
				for (ScSchTickDO tickDO : tickDOs) {
					for (Integer polcn : polcnMap.keySet()) {
					if (tickDO.getFg_active().booleanValue() && (StringUtil.isEmptyWithTrim(tickDO.getIds_scchl())
							|| tickDO.getIds_scchl().contains(id_scchl)) && tickDO.getEu_usescope() == EuUseScope.APT
								&& (tickDO.getPolno()== null || tickDO.getPolno() == polcn)) {
							if(tickDO.getEu_used() == EuUseState.WY){
								//map.remove(tickDO.getId_ticks());
						map.put(tickDO.getId_ticks(), FBoolean.TRUE);
								
							}else if(tickDO.getEu_used() == EuUseState.SY){
								int numUsed = ticksUsedNum.get(tickDO.getId_ticks()) == null?0:ticksUsedNum.get(tickDO.getId_ticks())+1;
								ticksUsedNum.put(tickDO.getId_ticks(), numUsed);
							}
						int num = ticksUseNum.get(tickDO.getId_ticks()) == null?0:ticksUseNum.get(tickDO.getId_ticks())+1;
						ticksUseNum.put(tickDO.getId_ticks(), num);
							break;
						}
					}
				}
			}
		}
		for (ScSchTicksDO ticksDO : ticksDOs) {
			if (ticksDO.getFg_active().booleanValue()) {
				//int quecn_used = ticksDO.getQuecn_used()==null?0:ticksDO.getQuecn_used();
				int useNum = ticksUsedNum.get(ticksDO.getId_ticks()) == null?0:ticksUsedNum.get(ticksDO.getId_ticks());
				ticksDO.setQuecn_used(useNum);
				//int useRemain = quecn_used - useNum;
				int quecn_appt = ticksUseNum.get(ticksDO.getId_ticks()) == null?0:ticksUseNum.get(ticksDO.getId_ticks());
				ticksDO.setQuecn_appt(quecn_appt);
				ticksDO.setFg_active(map.get(ticksDO.getId_ticks()));
			}
		}
	}

	/**
	 * 根据服务过滤设置号位是否可用
	 * 
	 * @author zhengcm
	 * @date 2017-12-18 16:06:46
	 *
	 * @param tickDOs
	 * @param id_srv
	 * @param isSrvCheck
	 * @param sd_sctp
	 * @param planDO
	 * @throws BizException
	 */
	private void filterTickBySrv(ScSchTickDO[] tickDOs, String id_srv, FBoolean isSrvCheck, String sd_sctp,
			ScPlanDO planDO,String id_sch) throws BizException {
		if (ArrayUtil.isEmpty(tickDOs) || StringUtil.isEmptyWithTrim(id_srv) || !isSrvCheck.booleanValue()) {
			return;
		}
		// 根据服务过滤设置号位状态
		if (isSrvCheck.booleanValue() && !StringUtil.isEmptyWithTrim(id_srv)) {
			List<String> scSrvIds = new ArrayList<String>();
			if (sd_sctp.equals(IScDictCodeConst.SD_SCTP_MT)) {
				for (ScSchTickDO tickDO : tickDOs) {
					String val = tickDO.getId_scsrv();
					if (!StringUtil.isEmptyWithTrim(val) && !scSrvIds.contains(val)) {
						scSrvIds.add(val);
					}
				}
				IScSchOptsrvDORService optsrvService = ServiceFinder.find(IScSchOptsrvDORService.class);
				ScSchOptsrvDO[] optSrvDOs = optsrvService.findByAttrValString(ScSchDO.ID_SCH, id_sch);
				if(!ArrayUtil.isEmpty(optSrvDOs)){
					for (ScSchOptsrvDO optsrvDO : optSrvDOs) {
						scSrvIds.add(optsrvDO.getId_scsrv());
					}
				}
			} else if (sd_sctp.equals(IScDictCodeConst.SD_SCTP_OT)) {// 手术取计划对应的排班服务
				scSrvIds.add(planDO.getId_scsrv());
			}
			Map<String, List<String>> map = this.getSrvMap(scSrvIds);
			for (ScSchTickDO tickDO : tickDOs) {
				String key = tickDO.getId_scsrv();
				if (sd_sctp.equals(IScDictCodeConst.SD_SCTP_OT)) {
					key = planDO.getId_scsrv();
				}
				boolean isUse = false;
				if(!MapUtils.isEmpty(map)){
					for (Map.Entry<String, List<String>> entry : map.entrySet()) {
						List<String> idSrvList = entry.getValue();
						if(!ListUtil.isEmpty(idSrvList) && idSrvList.contains(id_srv)){
							isUse = true;
							break;
						}
					}
				}
				if (StringUtil.isEmptyWithTrim(key) || null == map || !map.containsKey(key) || !isUse) {
					tickDO.setFg_active(FBoolean.FALSE);
				}
			}
			
		}
	}

	/**
	 * 根据服务过滤设置号段是否可用
	 * 
	 * @author zhengcm
	 * @date 2017-12-18 16:13:02
	 *
	 * @param ticksDOs
	 * @param id_srv
	 * @param isSrvCheck
	 * @param sd_sctp
	 * @param planDO
	 * @throws BizException
	 */
	private void filterTicksBySrv(ScSchTicksDO[] ticksDOs, String id_srv, FBoolean isSrvCheck, String sd_sctp,
			ScPlanDO planDO,String id_sch) throws BizException {
		if (ArrayUtil.isEmpty(ticksDOs)) {
			return;
		}
		// 根据服务过滤设置号段状态
		if (isSrvCheck.booleanValue() && !StringUtil.isEmptyWithTrim(id_srv)) {
			List<String> scSrvIds = new ArrayList<String>();
			if (sd_sctp.equals(IScDictCodeConst.SD_SCTP_MT)) {
				for (ScSchTicksDO ticksDO : ticksDOs) {
					String val = ticksDO.getId_scsrv();
					if (!StringUtil.isEmptyWithTrim(val) && !scSrvIds.contains(val)) {
						scSrvIds.add(val);
					}
				}
				IScSchOptsrvDORService optsrvService = ServiceFinder.find(IScSchOptsrvDORService.class);
				ScSchOptsrvDO[] optSrvDOs = optsrvService.findByAttrValString(ScSchDO.ID_SCH, id_sch);
				if(!ArrayUtil.isEmpty(optSrvDOs)){
					for (ScSchOptsrvDO optsrvDO : optSrvDOs) {
						scSrvIds.add(optsrvDO.getId_scsrv());
					}
				}				
				//根据排班id获取排班的 备用排版服务id 放入scSrvIds
			} else if (sd_sctp.equals(IScDictCodeConst.SD_SCTP_OT)) {// 手术取计划对应的排班服务
				scSrvIds.add(planDO.getId_scsrv());
			}
			Map<String, List<String>> map = this.getSrvMap(scSrvIds);
			for (ScSchTicksDO ticksDO : ticksDOs) {
				String key = ticksDO.getId_scsrv();
				if (sd_sctp.equals(IScDictCodeConst.SD_SCTP_OT)) {
					key = planDO.getId_scsrv();
				}
				boolean isUse = false;
				if(!MapUtils.isEmpty(map)){
					for (Map.Entry<String, List<String>> entry : map.entrySet()) {
						List<String> idSrvList = entry.getValue();
						if(!ListUtil.isEmpty(idSrvList) && idSrvList.contains(id_srv)){
							isUse = true;
							break;
						}
					}
				}
				if (StringUtil.isEmptyWithTrim(key) || null == map || !map.containsKey(key) || !isUse) {
					ticksDO.setFg_active(FBoolean.FALSE);
				}
			}
		}
	}

	/**
	 * 获取号位或号段的排班服务对应的医疗服务
	 *
	 * @param scSrvIds
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private Map<String, List<String>> getSrvMap(List<String> scSrvIds) throws BizException {
		if (ListUtil.isEmpty(scSrvIds)) {
			return null;
		}
		String cond = ScSqlUtils.getInSqlByIds("id_scsrv", scSrvIds);
		IScheduleSrvRelDORService relQryService = ServiceFinder.find(IScheduleSrvRelDORService.class);
		ScheduleSrvRelDO[] relDOs = relQryService.find(cond, null, FBoolean.FALSE);
		if (ArrayUtil.isEmpty(relDOs)) {
			return null;
		}
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (ScheduleSrvRelDO relDO : relDOs) {
			if (map.containsKey(relDO.getId_scsrv())) {
				map.get(relDO.getId_scsrv()).add(relDO.getId_mdsrv());
			} else {
				List<String> list = new ArrayList<String>();
				list.add(relDO.getId_mdsrv());
				map.put(relDO.getId_scsrv(), list);
			}
		}
		return map;
	}

	/**
	 * 根据排班id和服务id查询服务的排班类别细目
	 * 
	 * @author yzh
	 * @param idSch
	 * @param idSrv
	 * @return
	 * @throws DAException
	 */
	private ScBdSrvDTO[] getScBdSrv8IdSrv(String idSch, String idSrv) throws BizException {
		StringBuffer qrySql = new StringBuffer();
		qrySql.append(" select A.id_scbdsrv,A.id_srv,B.id_scsrvkinditm as id_scsrvkinditem,D.Id_Scsrvkind ").append(" from sc_bdsrv A")
				.append(" left outer join sc_bdsrv_kinditm B on A.id_scbdsrv = B.id_scbdsrv")
				.append(" left outer join sc_sch C on A.id_scca = C.id_scca")
				.append(" left outer join sc_srv_kind_itm D on B.id_scsrvkinditm = D.id_scsrvkinditm")
				.append(" where C.id_sch = ? and A.id_srv = ?");
		SqlParam param = new SqlParam();
		param.addParam(idSch);
		param.addParam(idSrv);
		List<ScBdSrvDTO> scbdsrvList = (List<ScBdSrvDTO>) new DAFacade().execQuery(qrySql.toString(), param,
				new BeanListHandler(ScBdSrvDTO.class));
		return (ScBdSrvDTO[]) scbdsrvList.toArray(new ScBdSrvDTO[scbdsrvList.size()]);
	}
	/**
	 * 根据排班id查询排班计划中的号源释放规则中的类别明细属性的类别明细
	 * @param id_sch
	 * @return
	 * @throws DAException 
	 */
	private String getSchproptpKinditmBP(String id_sch) throws DAException
	{
		StringBuilder sql = new StringBuilder();
		sql.append(" select itm.ids_scsrvkinditm ");
		sql.append(" from sc_sch sch  ");
		sql.append(" inner join sc_pl pl on pl.id_scpl = sch.id_scpl ");
		sql.append(" inner join sc_release_rule_itm itm on itm.id_release_rule = pl.id_release_rule ");
		sql.append(" where itm.id_sch_prop_tp = ? ");
		sql.append(" and sch.fg_auto_release = 'Y' ");
		sql.append(" and sch.id_sch = ? ");
		SqlParam params = new SqlParam();
		params.addParam(IScDictCodeConst.ID_SCHPROPTP_KINDITM);
		params.addParam(id_sch);
		String itms = (String) new DAFacade().execQuery(sql.toString(), params, new ColumnHandler());
		return itms;
	}
	/**
	 * 根据类别明细获取对应类别
	 * 
	 * @param kinditms
	 * @return
	 * @throws DAException
	 */
	private Map<String, List<String>> getSrvKindByitms(String[] kinditms) throws DAException {
		StringBuilder sql = new StringBuilder();
		sql.append("select itm.Id_scsrvkinditm,itm.id_scsrvkind from sc_srv_kind_itm itm where ");
		sql.append(ScSqlUtils.getInSqlByIds("itm.id_scsrvkinditm", kinditms));
		List<ScSrvKindItm> resList = (List<ScSrvKindItm>) new DAFacade().execQuery(sql.toString(),
				new BeanListHandler(ScSrvKindItm.class));
		if (resList == null || resList.size() == 0) {
			return null;
		}
		Map<String, List<String>> result = ScAppUtils.extractStrMapFromObjs(ScSrvKindItm.ID_SCSRVKIND,
				ScSrvKindItm.ID_SCSRVKINDITM, resList.toArray(new ScSrvKindItm[0]));
		return result;

	}
	/**
	 * 医技服务互斥检查
	 * @param id_pat 患者id
	 * @param id_srv 诊疗项目id
	 * @param id_ent 就诊id
	 * @param aptTime 
	 * @param resDTO 排班数据
	 * @param d_sch 排班日期
	 * @param fg_hp 医保支付标识
	 * @throws BizException
	 * @author yzh
	 */
	private void checkSrvMutex(String id_pat, String id_srv, String id_ent,FDateTime aptTime,MtResDTO resDTO,FDate d_sch,FBoolean fg_hp) throws BizException {
		// 检查患者是否存在有效期内的互斥项目
		IScSchOutQryService schOutQryService = ServiceFinder.find(IScSchOutQryService.class);
		schOutQryService.mutexCheck4ManualMtApt(id_pat, id_srv,id_ent, aptTime,resDTO,d_sch,fg_hp);
	}
	/**
	 * 初始化
	 * @param resDTO
	 */
	private void initDaysList(MtResDTO resDTO){
		resDTO.setFg_stop_daysmsgs(FBoolean.FALSE);
		resDTO.setDays_excl_must(new FArrayList());
		resDTO.setDays_excl_hint(new FArrayList());
		resDTO.setDays_together_must(new FArrayList());
		resDTO.setDays_together_hint(new FArrayList());
		resDTO.setDays_excl_times(new FArrayList());
	}
}
