package iih.sc.apt.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.s.ep.OralAptEP;
import iih.sc.comm.ScParamUtils;
import iih.sc.comm.ScSqlUtils;
import iih.sc.comm.ScValidator;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvRelDO;
import iih.sc.scbd.schedulesrv.i.IScheduleSrvRelDORService;
import iih.sc.sch.i.IScSchOutQryService;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.sctick.d.EuUseScope;
import iih.sc.sch.sctick.d.EuUseState;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.scticks.d.ScSchTicksDO;
import iih.sc.scp.scplan.d.ScPlanDO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.SqlParamDTO;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取选号预约号位或号段BP
 * 
 * @author zhengcm
 * @date 2017-12-18 15:18:50
 *
 */
public class GetAptSchTicksBP {

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
	public FArrayList exec(String id_sch, String id_scchl, String id_srv, String sd_sctp) throws BizException {
		// 参数检查
		ScValidator.validateParam("id_sch", id_sch);
		ScValidator.validateParam("id_scchl", id_scchl);
		ScValidator.validateParam("sd_sctp", sd_sctp);

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
		Map<String,Map<Integer, Integer>> map = ServiceFinder.find(IScSchOutQryService.class).batchGetChlSchRemainAmount(schIdList,
				id_scchl);
		if (null == map || map.isEmpty() || !map.containsKey(schIdList.get(0)) || null == map.get(schIdList.get(0))) {
			throw new BizException("渠道剩余可用数量不足，请检查！");
		}
		int remain = map.get(schIdList.get(0)).get(IScDictCodeConst.SC_CHL_REMAIN);
		// 读取系统参数医技预约检查项目类型
		FBoolean isSrvCheck = ScParamUtils.getscAptCOI(planDO.getId_dep());
		// 处理号位或号段
		FArrayList flist = new FArrayList();
		if (schDO.getSd_tickmd().equals(IScDictCodeConst.SD_TICKMD_TICK)) {// 号位模式
			ScSchTickDO[] tickDOs = this.getTick(id_sch);
			if (sd_sctp.equals(IScDictCodeConst.SD_SCTP_MT) || sd_sctp.equals(IScDictCodeConst.SD_SCTP_OT)) {// 医技或手术
				
				// 根据服务过滤设置号位是否可用
				this.filterTickBySrv(tickDOs, id_srv, isSrvCheck, sd_sctp, planDO);
			}
			// 根据渠道设置号位是否可用
			this.setTickActiveByScchl(tickDOs, id_scchl, remain);
			if (!ArrayUtil.isEmpty(tickDOs)) {
				for (ScSchTickDO tickDO : tickDOs) {
					flist.add(tickDO);
				}
			}
		} else if (schDO.getSd_tickmd().equals(IScDictCodeConst.SD_TICKMD_TICKS)) {// 号段模式
			ScSchTicksDO[] ticksDOs = this.getTicks(id_sch);
			if (sd_sctp.equals(IScDictCodeConst.SD_SCTP_MT) || sd_sctp.equals(IScDictCodeConst.SD_SCTP_OT)) {// 医技
				// 读取系统参数医技预约检查项目类型
				//FBoolean isSrvCheck = ScParamUtils.getscAptCOI(planDO.getId_dep());
				// 根据服务过滤设置号段是否可用
				this.filterTicksBySrv(ticksDOs, id_srv, isSrvCheck, sd_sctp, planDO);
			}
			// 根据渠道设置号段是否可用
			this.setTicksActiveByScchl(ticksDOs, id_scchl, remain);
			if (!ArrayUtil.isEmpty(ticksDOs)) {
				for (ScSchTicksDO ticksDO : ticksDOs) {
					flist.add(ticksDO);
				}
			}
		}else if (schDO.getSd_tickmd().equals(IScDictCodeConst.SD_TICKMD_TIME)) {// 时间片模式
			ScSchTicksDO[] ticksDOs = this.getTicks(id_sch);
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
		String cond = "id_sch = ?";
		SqlParamDTO param = new SqlParamDTO();
		param.addParam(id_sch);
		return new OralAptEP().getSchTickByWhere(cond,param);
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
		return new OralAptEP().getSchTicksByWhere(cond, " to_number(code)");
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
	private void setTickActiveByScchl(ScSchTickDO[] tickDOs, String id_scchl, int remain) throws BizException {
		if (ArrayUtil.isEmpty(tickDOs) || StringUtil.isEmptyWithTrim(id_scchl)) {
			return;
		}
		// 指定了当前渠道的可预约的号位数量
		int canuse = 0;
		for (ScSchTickDO tickDO : tickDOs) {
			if (tickDO.getFg_active().booleanValue() && !StringUtil.isEmptyWithTrim(tickDO.getIds_scchl())
					&& tickDO.getIds_scchl().contains(id_scchl) && tickDO.getEu_usescope() == EuUseScope.APT
					&& tickDO.getEu_used() == EuUseState.WY) {
				canuse = canuse + 1;
			}
		}
		// 如果剩余可预约数量大于指定了当前渠道可预约的号位数量时，允许预约空渠道号位，否则只能预约指定渠道号位
		if (remain > canuse) {
			for (ScSchTickDO tickDO : tickDOs) {
				if (tickDO.getFg_active().booleanValue()
						&& (StringUtil.isEmptyWithTrim(tickDO.getIds_scchl()) || tickDO.getIds_scchl().contains(
								id_scchl)) && tickDO.getEu_usescope() == EuUseScope.APT
						&& tickDO.getEu_used() == EuUseState.WY) {
					tickDO.setFg_active(FBoolean.TRUE);
				} else {
					tickDO.setFg_active(FBoolean.FALSE);
				}
			}
		} else {
			for (ScSchTickDO tickDO : tickDOs) {
				if (tickDO.getFg_active().booleanValue() && !StringUtil.isEmptyWithTrim(tickDO.getIds_scchl())
						&& tickDO.getIds_scchl().contains(id_scchl) && tickDO.getEu_usescope() == EuUseScope.APT
						&& tickDO.getEu_used() == EuUseState.WY) {
					tickDO.setFg_active(FBoolean.TRUE);
				} else {
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
	private void setTicksActiveByScchl(ScSchTicksDO[] ticksDOs, String id_scchl, int remain) throws BizException {
		if (ArrayUtil.isEmpty(ticksDOs) || StringUtil.isEmptyWithTrim(id_scchl)) {
			return;
		}
		Map<String, FBoolean> map = new HashMap<String, FBoolean>();
		List<String> ids = new ArrayList<String>();
		for (ScSchTicksDO ticksDO : ticksDOs) {
			ids.add(ticksDO.getId_ticks());
			map.put(ticksDO.getId_ticks(), FBoolean.FALSE);
		}
		// 校验号段中是否存在可预约的号位
		String cond = String.format(
				"fg_active = 'Y' and eu_usescope = %d and eu_used = %d" + " and "
						+ ScSqlUtils.getInSqlByIds("id_ticks", ids), EuUseScope.APT.intValue(),
				EuUseState.WY.intValue());
		ScSchTickDO[] tickDOs = new OralAptEP().getSchTickByWhereStr(cond);
		if (!ArrayUtil.isEmpty(tickDOs)) {
			// 指定了当前渠道的可预约的号位数量
			int canuse = 0;
			for (ScSchTickDO tickDO : tickDOs) {
				if (tickDO.getFg_active().booleanValue() && !StringUtil.isEmptyWithTrim(tickDO.getIds_scchl())
						&& tickDO.getIds_scchl().contains(id_scchl) && tickDO.getEu_usescope() == EuUseScope.APT
						&& tickDO.getEu_used() == EuUseState.WY) {
					canuse = canuse + 1;
				}
			}
			if (remain > canuse) {
				for (ScSchTickDO tickDO : tickDOs) {
					if (tickDO.getFg_active().booleanValue()
							&& (StringUtil.isEmptyWithTrim(tickDO.getIds_scchl()) || tickDO.getIds_scchl().contains(
									id_scchl)) && tickDO.getEu_usescope() == EuUseScope.APT
							&& tickDO.getEu_used() == EuUseState.WY) {
						map.remove(tickDO.getId_ticks());
						map.put(tickDO.getId_ticks(), FBoolean.TRUE);
					}
				}
			} else {
				for (ScSchTickDO tickDO : tickDOs) {
					if (tickDO.getFg_active().booleanValue() && !StringUtil.isEmptyWithTrim(tickDO.getIds_scchl())
							&& tickDO.getIds_scchl().contains(id_scchl) && tickDO.getEu_usescope() == EuUseScope.APT
							&& tickDO.getEu_used() == EuUseState.WY) {
						map.remove(tickDO.getId_ticks());
						map.put(tickDO.getId_ticks(), FBoolean.TRUE);
					}
				}
			}
		}
		for (ScSchTicksDO ticksDO : ticksDOs) {
			if (ticksDO.getFg_active().booleanValue()) {
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
			ScPlanDO planDO) throws BizException {
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
			} else if (sd_sctp.equals(IScDictCodeConst.SD_SCTP_OT)) {// 手术取计划对应的排班服务
				scSrvIds.add(planDO.getId_scsrv());
			}
			Map<String, List<String>> map = this.getSrvMap(scSrvIds);
			for (ScSchTickDO tickDO : tickDOs) {
				String key = tickDO.getId_scsrv();
				if (sd_sctp.equals(IScDictCodeConst.SD_SCTP_OT)) {
					key = planDO.getId_scsrv();
				}
				if (StringUtil.isEmptyWithTrim(key) || null == map || !map.containsKey(key)
						|| !map.get(key).contains(id_srv)) {
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
			ScPlanDO planDO) throws BizException {
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
			} else if (sd_sctp.equals(IScDictCodeConst.SD_SCTP_OT)) {// 手术取计划对应的排班服务
				scSrvIds.add(planDO.getId_scsrv());
			}
			Map<String, List<String>> map = this.getSrvMap(scSrvIds);
			for (ScSchTicksDO ticksDO : ticksDOs) {
				String key = ticksDO.getId_scsrv();
				if (sd_sctp.equals(IScDictCodeConst.SD_SCTP_OT)) {
					key = planDO.getId_scsrv();
				}
				if (StringUtil.isEmptyWithTrim(key) || null == map || !map.containsKey(key)
						|| !map.get(key).contains(id_srv)) {
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

}
