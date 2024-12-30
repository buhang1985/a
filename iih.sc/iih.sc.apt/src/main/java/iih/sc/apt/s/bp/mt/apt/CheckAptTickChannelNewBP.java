package iih.sc.apt.s.bp.mt.apt;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.s.ep.OralAptEP;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScSqlUtils;
import iih.sc.comm.ScValidator;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvRelDO;
import iih.sc.scbd.schedulesrv.i.IScheduleSrvRelDORService;
import iih.sc.sch.dto.d.SchTickMdTimeDTO;
import iih.sc.sch.i.IScSchOutQryService;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.d.ScSchOptsrvDO;
import iih.sc.sch.scsch.i.IScSchOptsrvDORService;
import iih.sc.sch.scsch.i.IScschMDORService;
import iih.sc.sch.sctick.d.EuUseScope;
import iih.sc.sch.sctick.d.EuUseState;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.scticks.d.ScSchTicksDO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.SqlParamDTO;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 检查预约号位渠道BP
 * 
 * @author zhengcm
 * @date 2017-12-18 10:19:06
 *
 */
public class CheckAptTickChannelNewBP {
	/**
	 * 检查预约号位渠道：当前渠道剩余可预约数小于或等于包含了当前渠道的可预约号位数量时，只可预约当前渠道的号位
	 * 
	 * @author zhengcm
	 * @date 2017-12-19 08:25:03
	 *
	 * @param sd_tickmd 号位模式
	 * @param id 号位或号段ID
	 * @param id_scchl 排班渠道ID
	 * @param id_srv 医疗服务ID
	 * @param idEnttp
	 * @throws BizException
	 */
	public void exec(String sd_tickmd, String id, String id_scchl, String id_srv,String idEnttp,Map<String, Map<Integer,Integer>> polcnMap) throws BizException {
		ScValidator.validateParam("sd_tickmd", sd_tickmd);
		ScValidator.validateParam("id_scchl", id_scchl);
		if (IScDictCodeConst.SD_TICKMD_TICK.equals(sd_tickmd)) {
			//号位模式
			checkAptTick4TickMdAndPolcn(id, id_scchl, id_srv,idEnttp,polcnMap);
		} else if (IScDictCodeConst.SD_TICKMD_TICKS.equals(sd_tickmd)) {
			//号段模式
			checkAptTick4TicksMdAndPolcn(id, id_scchl, id_srv, idEnttp,polcnMap);
		}
	}
	/**
	 * 时间片模式
	 * 
	 * @param schTickMdTime
	 * @param id_scchl
	 * @param id_srv
	 * @throws BizException
	 */
	public void exec(SchTickMdTimeDTO schTickMdTime, String id_scchl, String id_srv) throws BizException {
		
	}
	
	/**
	 * 号位模式预约渠道检查
	 * 
	 * @param id_tick
	 * @param id_scchl
	 * @param id_srv
	 * @throws BizException
	 */
	private void checkAptTick4TickMd(String id_tick, String id_scchl, String id_srv) throws BizException {
		ScValidator.validateParam("id_tick", id_tick);
		OralAptEP aptEP = new OralAptEP();
		ScSchTickDO tickDO = aptEP.getSchTickById(id_tick);
		// 检查当前渠道的剩余可预约数
		List<String> schIdList = new ArrayList<String>();
		schIdList.add(tickDO.getId_sch());
		Map<String, Map<Integer,Integer>> map = ServiceFinder.find(IScSchOutQryService.class).batchGetChlSchRemainFilterEntpAmount(
				schIdList,null, id_scchl);
		if (null == map || map.isEmpty() || !map.containsKey(schIdList.get(0)) || null == map.get(schIdList.get(0))) {
			throw new BizException("渠道剩余可用数量不足，请检查！");
		}
		int remain = map.get(schIdList.get(0)).get(IScDictCodeConst.SC_CHL_REMAIN);
		// 查询当前排班号位
		String cond = "id_sch = ?";
		SqlParamDTO param = new SqlParamDTO();
		param.addParam(tickDO.getId_sch());
		ScSchTickDO[] tickDOs = aptEP.getSchTickByWhere(cond,param);
		Map<String, List<String>> srvMap = this.getSrvMap(this.getTickScsrvIds(tickDOs),tickDO.getId_sch());
		// 指定了当前渠道且可预约的号位数量
		int canuse = 0;
		for (ScSchTickDO tick : tickDOs) {
			if (tick.getFg_active().booleanValue() && !StringUtil.isEmptyWithTrim(tick.getIds_scchl())
					&& tick.getIds_scchl().contains(id_scchl) && tick.getEu_usescope() == EuUseScope.APT
					&& tick.getEu_used() == EuUseState.WY) {
				canuse = canuse + 1;
			}
		}
		if (remain <= canuse) {// 只能预约指定渠道的号位
			// 检查当前号位
			if (StringUtil.isEmptyWithTrim(tickDO.getIds_scchl()) || !tickDO.getIds_scchl().contains(id_scchl)) {
				throw new BizException("当前渠道剩余可预约数量只能预约指定渠道的号位，请检查！");
			} else {
				if (StringUtil.isEmptyWithTrim(id_srv)) {
					return;
				}
				if (null != srvMap && null != srvMap.get(tickDO.getId_scsrv())
						&& srvMap.get(tickDO.getId_scsrv()).contains(id_srv)) {
					return;
				} else {
					throw new BizException("当前预约的项目与号位指定的项目不符，请检查！");
				}
			}
		} else {
			// 检查当前号位
			if (StringUtil.isEmptyWithTrim(tickDO.getIds_scchl()) || tickDO.getIds_scchl().contains(id_scchl)) {
				if (StringUtil.isEmptyWithTrim(id_srv)) {
					return;
				}
				if (null != srvMap && null != srvMap.get(tickDO.getId_scsrv())
						&& srvMap.get(tickDO.getId_scsrv()).contains(id_srv)) {
					return;
				} else {
					throw new BizException("当前预约的项目与号位指定的项目不符，请检查！");
				}
			} else {
				throw new BizException("当前渠道不可以预约该号位，请检查！");
			}
		}
	}
	
	
	/**
	 * 号位模式预约渠道检查
	 * 
	 * @param id_tick
	 * @param id_scchl
	 * @param id_srv
	 * @throws BizException
	 */
	private void checkAptTick4TickMdAndPolcn(String id_tick, String id_scchl, String id_srv,String idEnttp,Map<String, Map<Integer,Integer>> polcnMap) throws BizException {
		ScValidator.validateParam("id_tick", id_tick);
		OralAptEP aptEP = new OralAptEP();
		ScSchTickDO tickDO = aptEP.getSchTickById(id_tick);
		// 检查当前渠道的剩余可预约数
		List<String> schIdList = new ArrayList<String>();
		schIdList.add(tickDO.getId_sch());
		//Map<String, Map<Integer,Integer>> map = ServiceFinder.find(IScSchOutQryService.class).batchGetChlSchRemainFilterEntpAmount(
		//		schIdList,idEnttp, id_scchl);
		if (null == polcnMap || polcnMap.isEmpty() || !polcnMap.containsKey(schIdList.get(0)) || null == polcnMap.get(schIdList.get(0))) {
			throw new BizException("渠道剩余可用数量不足，请检查！");
		}
		int remain = polcnMap.get(schIdList.get(0)).get(IScDictCodeConst.SC_CHL_REMAIN);
		// 查询当前排班号位
		String cond = "id_sch = ?";
		SqlParamDTO param = new SqlParamDTO();
		param.addParam(tickDO.getId_sch());
		ScSchTickDO[] tickDOs = aptEP.getSchTickByWhere(cond,param);
		//Map<String, List<String>> srvMap = this.getSrvMap(this.getTickScsrvIds(tickDOs),tickDO.getId_sch());
		// 指定了当前渠道且可预约的号位数量
		int canuse = 0;
		for (ScSchTickDO tick : tickDOs) {
			if (tick.getFg_active().booleanValue() && !StringUtil.isEmptyWithTrim(tick.getIds_scchl())
					&& tick.getIds_scchl().contains(id_scchl) && tick.getEu_usescope() == EuUseScope.APT
					&& tick.getEu_used() == EuUseState.WY) {
				canuse = canuse + 1;
			}
		}
		if (remain <= canuse) {// 只能预约指定渠道的号位
			// 检查当前号位
			if (StringUtil.isEmptyWithTrim(tickDO.getIds_scchl()) || !tickDO.getIds_scchl().contains(id_scchl)) {
				throw new BizException("当前渠道剩余可预约数量只能预约指定渠道的号位，请检查！");
			} else {
				//if (StringUtil.isEmptyWithTrim(id_srv)) {
					return;
				//}
				//if (null != srvMap && null != srvMap.get(tickDO.getId_scsrv()) && srvMap.get(tickDO.getId_scsrv()).contains(id_srv)) {
				//	return;
				//} else {
				//	throw new BizException("当前预约的项目与号位指定的项目不符，请检查！");
				//}
			}
		} else {
			// 检查当前号位
			if (StringUtil.isEmptyWithTrim(tickDO.getIds_scchl()) || tickDO.getIds_scchl().contains(id_scchl)) {
				//if (StringUtil.isEmptyWithTrim(id_srv)) {
					return;
				//}
				//if (null != srvMap && null != srvMap.get(tickDO.getId_scsrv()) && srvMap.get(tickDO.getId_scsrv()).contains(id_srv)) {
				//	return;
				//} else {
				//	throw new BizException("当前预约的项目与号位指定的项目不符，请检查！");
				//}
			} else {
				throw new BizException("当前渠道不可以预约该号位，请检查！");
			}
		}
	}
	/**
	 * 号段模式预约渠道检查
	 * 
	 * @param id_ticks
	 * @param id_scchl
	 * @param id_srv
	 * @throws BizException
	 */
	private void checkAptTick4TicksMd(String id_ticks, String id_scchl, String id_srv) throws BizException {
		ScValidator.validateParam("id_ticks", id_ticks);
		OralAptEP aptEP = new OralAptEP();
		ScSchTicksDO ticksDO = aptEP.getSchTicksByWhere(String.format("id_ticks = '%s'", id_ticks), null)[0];
		// 检查当前渠道的剩余可预约数
		List<String> schIdList = new ArrayList<String>();
		schIdList.add(ticksDO.getId_sch());
		Map<String, Map<Integer,Integer>> map = ServiceFinder.find(IScSchOutQryService.class).batchGetChlSchRemainFilterEntpAmount(
				schIdList,null, id_scchl);
		if (null == map || map.isEmpty() || !map.containsKey(schIdList.get(0)) || null == map.get(schIdList.get(0))) {
			throw new BizException("渠道剩余可用数量不足，请检查！");
		}
		int remain = map.get(schIdList.get(0)).get(IScDictCodeConst.SC_CHL_REMAIN);
		// 查询当前排班所有号段
		String cond = String.format("id_sch = '%s'", ticksDO.getId_sch());
		ScSchTicksDO[] ticksDOs = aptEP.getSchTicksByWhere(cond, "t_b");
		Map<String, List<String>> srvMap = this.getSrvMap(this.getTicksScsrvIds(ticksDOs),ticksDO.getId_sch());
		List<String> ticksIds = new ArrayList<String>();
		for (ScSchTicksDO ticks : ticksDOs) {
			ticksIds.add(ticks.getId_ticks());
		}
		String where = String.format(ScSqlUtils.getInSqlByIds("id_ticks", ticksIds));
		ScSchTickDO[] tickDOs = aptEP.getSchTickByWhereStr(where);
		Map<String, List<ScSchTickDO>> ticksMap = new HashMap<String, List<ScSchTickDO>>();
		for (ScSchTickDO tickDO : tickDOs) {
			String key = tickDO.getId_ticks();
			if (ticksMap.containsKey(key)) {
				ticksMap.get(key).add(tickDO);
			} else {
				List<ScSchTickDO> list = new ArrayList<ScSchTickDO>();
				list.add(tickDO);
				ticksMap.put(key, list);
			}
		}
		// 指定了当前渠道且可预约的号位数量
		int canuse = 0;
		for (ScSchTickDO tick : tickDOs) {
			if (tick.getFg_active().booleanValue() && !StringUtil.isEmptyWithTrim(tick.getIds_scchl())
					&& tick.getIds_scchl().contains(id_scchl) && tick.getEu_usescope() == EuUseScope.APT
					&& tick.getEu_used() == EuUseState.WY) {
				canuse = canuse + 1;
			}
		}
		// 检查当前号段
		List<ScSchTickDO> currTickDOs = ticksMap.get(id_ticks);
		if (remain <= canuse) {// 预约的号段需要包含指定渠道的号位
			boolean isFind = false;
			for (ScSchTickDO tickDO : currTickDOs) {
				if (tickDO.getFg_active().booleanValue() && !StringUtil.isEmptyWithTrim(tickDO.getIds_scchl())
						&& tickDO.getIds_scchl().contains(id_scchl) && tickDO.getEu_usescope() == EuUseScope.APT
						&& tickDO.getEu_used() == EuUseState.WY) {
					if (StringUtil.isEmptyWithTrim(id_srv)
							|| (null != srvMap && null != srvMap.get(tickDO.getId_scsrv()) && srvMap.get(
									tickDO.getId_scsrv()).contains(id_srv))) {
						isFind = true;
						break;
					}
				}
			}
			if (!isFind) {
				throw new BizException(IScMsgConst.SC_SCH_TICK_NO_CHL);
			}
		} else {
			boolean hasCanUse = false;
			for (ScSchTickDO tickDO : currTickDOs) {
				if (tickDO.getFg_active().booleanValue()
						&& (StringUtil.isEmptyWithTrim(tickDO.getIds_scchl()) || tickDO.getIds_scchl().contains(
								id_scchl)) && tickDO.getEu_usescope() == EuUseScope.APT
						&& tickDO.getEu_used() == EuUseState.WY) {
					if (StringUtil.isEmptyWithTrim(id_srv)
							|| (null != srvMap && null != srvMap.get(tickDO.getId_scsrv()) && srvMap.get(
									tickDO.getId_scsrv()).contains(id_srv))) {
						hasCanUse = true;
						return;
					}
				}
			}
			if (!hasCanUse) {
				throw new BizException("该号段不包含适用的对应号位，请检查！");
			}
		}
	}
	/**
	 * 号段模式预约渠道检查
	 * 
	 * @param id_ticks
	 * @param id_scchl
	 * @param id_srv
	 * @throws BizException
	 */
	private Map<String, Map<Integer,Integer>> checkAptTick4TicksMdAndPolcn(String id_ticks, String id_scchl, String id_srv,String idEnttp,Map<String, Map<Integer,Integer>> polcnMap) throws BizException {
		ScValidator.validateParam("id_ticks", id_ticks);
		OralAptEP aptEP = new OralAptEP();
		ScSchTicksDO ticksDO = aptEP.getSchTicksByWhere(String.format("id_ticks = '%s'", id_ticks), null)[0];
		// 检查当前渠道的剩余可预约数
		List<String> schIdList = new ArrayList<String>();
		schIdList.add(ticksDO.getId_sch());
		IScschMDORService schRService = ServiceFinder.find(IScschMDORService.class);
		ScSchDO schDO = schRService.findById(ticksDO.getId_sch());
		//Map<String, Map<Integer,Integer>> map = ServiceFinder.find(IScSchOutQryService.class).batchGetChlSchRemainFilterEntpAmount(schIdList,idEnttp, id_scchl);
		if (null == polcnMap || polcnMap.isEmpty() || !polcnMap.containsKey(schIdList.get(0)) || null == polcnMap.get(schIdList.get(0))) {
			throw new BizException("渠道剩余可用数量不足，请检查！");
		}
		int remain = polcnMap.get(schIdList.get(0)).get(IScDictCodeConst.SC_CHL_REMAIN);
		Map<Integer,Integer> polcnNumMap = polcnMap.get(ticksDO.getId_sch());
		// 查询当前排班所有号段
		String cond = String.format("id_sch = '%s'", ticksDO.getId_sch());
		ScSchTicksDO[] ticksDOs = aptEP.getSchTicksByWhere(cond, "t_b");
		List<String> ticksIds = new ArrayList<String>();
		// 同号源池且不包含当前渠道的号位数量
		int other = 0;
		// 有渠道号位
		List<ScSchTickDO> haveChlList = new ArrayList<ScSchTickDO>();
		// 可占用的号位：空渠道或包含当前渠道的号位
		List<ScSchTickDO> canUseList = new ArrayList<ScSchTickDO>();
		// 同号源池且不包含当前渠道的号位数量
		for (ScSchTicksDO ticks : ticksDOs) {
			ticksIds.add(ticks.getId_ticks());
		}
		String where = String.format(ScSqlUtils.getInSqlByIds("id_ticks", ticksIds));
		ScSchTickDO[] alltickDOs = aptEP.getSchTickByWhereStr(where);
		for (ScSchTickDO tickDO : alltickDOs) {
			if (tickDO.getFg_active().booleanValue() && tickDO.getEu_usescope() == EuUseScope.APT
					&& tickDO.getEu_used() == EuUseState.WY && StringUtil.isEmptyWithTrim(tickDO.getIds_scchl())) {
				canUseList.add(tickDO);
			}
			for (Integer polcn : polcnNumMap.keySet()) {
				if (tickDO.getFg_active().booleanValue() && tickDO.getEu_usescope() == EuUseScope.APT
						&& tickDO.getEu_used() == EuUseState.WY && !StringUtil.isEmptyWithTrim(tickDO.getIds_scchl()) && tickDO.getIds_scchl().contains(id_scchl) && tickDO.getPolno() == polcn) {
					haveChlList.add(tickDO);
					canUseList.add(tickDO);
				} else if (tickDO.getFg_active().booleanValue() && tickDO.getEu_usescope() == EuUseScope.APT
						&& tickDO.getEu_used() == EuUseState.WY && tickDO.getPolno() == polcn && !StringUtil.isEmptyWithTrim(tickDO.getIds_scchl()) && !tickDO.getIds_scchl().contains(id_scchl)) {
					other = other + 1;
				}
			}
		}
		int remainNum = 0;
		for (Integer polcn : polcnNumMap.keySet()) {
			// 当前号源池剩余可预约数量
			remainNum += (schDO.getAttrVal("Quan" + polcn + "_appt") == null ? 0 : (int) schDO.getAttrVal("Quan" + polcn
					+ "_appt"))
					- (schDO.getAttrVal("Quan" + polcn + "_used") == null ? 0 : (int) schDO.getAttrVal("Quan" + polcn
							+ "_used"));
		}
		remainNum = remainNum - other;
		if (remainNum <= 0) {
			throw new BizException("渠道剩余可用数量不足，请检查！");
		}
		Map<String, List<ScSchTickDO>> ticksMap = new HashMap<String, List<ScSchTickDO>>();
		for (ScSchTickDO tickDO : alltickDOs) {
			String key = tickDO.getId_ticks();
			if (ticksMap.containsKey(key)) {
				ticksMap.get(key).add(tickDO);
			} else {
				List<ScSchTickDO> list = new ArrayList<ScSchTickDO>();
				list.add(tickDO);
				ticksMap.put(key, list);
			}
		}
		// 当前所选号段下所有号位
		List<ScSchTickDO> currTickDOs = ticksMap.get(id_ticks);
		//筛选出当前号段启用的未使用的可预约的号位
		List<ScSchTickDO> resultTicks = new ArrayList<ScSchTickDO>();
			for (ScSchTickDO tickDO : currTickDOs) {
			if(tickDO.getFg_active().booleanValue() && tickDO.getEu_usescope() == EuUseScope.APT
						&& tickDO.getEu_used() == EuUseState.WY){
				resultTicks.add(tickDO);
					}
				}
		//从包含渠道并且可预约的号位中过滤出属于当前所选号段的可预约号位
		List<ScSchTickDO> isHaveChl = this.isContains(haveChlList, resultTicks);
		//从有渠道和无渠道的可预约号位中过滤出属于当前所选号段的可预约号位
		List<ScSchTickDO> isCanUse = this.isContains(canUseList, resultTicks);
		// 若剩余可预约数量比指定当前渠道的号位数量多，则可预约号位包括有渠道和无渠道
		if (remain > haveChlList.size()) {
			// 顺序占用空渠道或者包含当前渠道的最小号位
			if (!ListUtil.isEmpty(isCanUse)) {
				return polcnMap;
			}else{
				throw new BizException("渠道剩余可用数量不足，请检查！");
			}
		} else {
			// 若剩余可预约数量小于等于指定当前渠道的号位,则只能从有渠道号位中预约
			if (!ListUtil.isEmpty(isHaveChl)) {
				return polcnMap;
			}else{
				throw new BizException(IScMsgConst.ERROR_SCH_TICK_NOT_MATCH_CHL);
			}
		}
	}
	/**
	 * 获取号位的所有排班服务ID
	 * 
	 * @author zhengcm
	 * @date 2017-12-18 11:51:22
	 *
	 * @param tickDOs
	 * @return
	 * @throws BizException
	 */
	private List<String> getTickScsrvIds(ScSchTickDO[] tickDOs) throws BizException {
		List<String> ids = new ArrayList<String>();
		for (ScSchTickDO tickDO : tickDOs) {
			if (!StringUtil.isEmptyWithTrim(tickDO.getId_scsrv()) && !ids.contains(tickDO.getId_scsrv())) {
				ids.add(tickDO.getId_scsrv());
			}
		}
		return ids;
	}

	/**
	 * 获取号段的所有排班服务ID
	 * 
	 * @author zhengcm
	 * @date 2017-12-18 11:53:31
	 *
	 * @param ticksDOs
	 * @return
	 * @throws BizException
	 */
	private List<String> getTicksScsrvIds(ScSchTicksDO[] ticksDOs) throws BizException {
		List<String> ids = new ArrayList<String>();
		for (ScSchTicksDO ticksDO : ticksDOs) {
			if (!StringUtil.isEmptyWithTrim(ticksDO.getId_scsrv()) && !ids.contains(ticksDO.getId_scsrv())) {
				ids.add(ticksDO.getId_scsrv());
			}
		}
		return ids;
	}

	/**
	 * 获取号位或号段的排班服务对应的医疗服务
	 *
	 * @param scSrvIds
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private Map<String, List<String>> getSrvMap(List<String> scSrvIds,String id_sch) throws BizException {
		if (ListUtil.isEmpty(scSrvIds)) {
			return null;
		}
		IScheduleSrvRelDORService relQryService = ServiceFinder.find(IScheduleSrvRelDORService.class);
		//查询排班的备用排班服务
		List<String> optSrvList = new ArrayList<String>();
		IScSchOptsrvDORService iscschoptsrvdorservice = ServiceFinder.find(IScSchOptsrvDORService.class);
		ScSchOptsrvDO[] optsrvs = iscschoptsrvdorservice.find("id_sch='"+id_sch+"'", null, FBoolean.FALSE);
		if(!ArrayUtil.isEmpty(optsrvs)){
			for (ScSchOptsrvDO scSchOptsrvDO : optsrvs) {
				optSrvList.add(scSchOptsrvDO.getId_scsrv());
			}
		}
		String cond = ScSqlUtils.getInSqlByIds("id_scsrv", optSrvList);
		ScheduleSrvRelDO[] optRelDOs = relQryService.find(cond, null, FBoolean.FALSE);
		cond = ScSqlUtils.getInSqlByIds("id_scsrv", scSrvIds);
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
		
		if(MapUtils.isNotEmpty(map) && !ArrayUtil.isEmpty(optRelDOs)){
			for (Map.Entry<String, List<String>> entry : map.entrySet()) {
				List<String> idSrvList = entry.getValue();
				for (ScheduleSrvRelDO relDO : optRelDOs) {
					idSrvList.add(relDO.getId_mdsrv());
				}
			}
		}
		return map;
	}
	
	/**
	 * 返回target存在于src中的号位
	 * @param srcTicks
	 * @param resultTicks
	 * @return
	 */
	private List<ScSchTickDO> isContains(List<ScSchTickDO> srcTicks,List<ScSchTickDO> resultTicks){
		if(ListUtil.isEmpty(srcTicks) || ListUtil.isEmpty(resultTicks)) return null;
		List<ScSchTickDO> reuslt = new ArrayList<ScSchTickDO>();
		for (ScSchTickDO src : srcTicks) {
			for (ScSchTickDO target : resultTicks) {
				if(src.getId_tick().equals(target.getId_tick()) ){
					reuslt.add(target);
				}
			}
			
		}
		return reuslt;
	}
}
