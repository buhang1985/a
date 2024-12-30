package iih.sc.sch.s.ep;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScValidator;
import iih.sc.comm.SchPkLockUtil;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvRelDO;
import iih.sc.scbd.schedulesrv.i.IScheduleSrvRelDORService;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.i.IScschMDORService;
import iih.sc.sch.sctick.d.EuUseScope;
import iih.sc.sch.sctick.d.EuUseState;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.sctick.i.ISctickRService;
import iih.sc.sch.scticks.d.ScSchTicksDO;
import iih.sc.sch.scticks.i.IScticksRService;
import iih.sc.scp.scplan.d.ScPlanDO;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.SqlParamDTO;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 渠道号位EP
 * 
 * @author zhengcm
 * @date 2017-07-27 10:31:19
 *
 */
public class TickChlEP {

	/**
	 * 对当前排班加锁
	 *
	 * @author zhengcm
	 * 
	 * @param schId 排班ID
	 * @throws BizException
	 */
	public void lockSch(String schId) throws BizException {
		if (StringUtil.isEmptyWithTrim(schId)) {
			return;
		}
		boolean isLock = SchPkLockUtil.lock(schId);
		if (!isLock)
			throw new BizException(String.format("该排班正被他人修改，请稍后重试！[%s]", schId));
	}

	/**
	 * 根据排班ID获取票号模式
	 *
	 * @author zhengcm
	 * 
	 * @param schId 排班ID
	 * @return 票号模式编码
	 * @throws BizException
	 */
	public String getTickModeBySchId(String schId) throws BizException {
		IScschMDORService schRService = ServiceFinder.find(IScschMDORService.class);
		ScSchDO schDO = schRService.findById(schId);
		if (schDO == null) {
			throw new BizException(IScMsgConst.ERROR_SC_SCH_NOT_EXISTS);// 排班不存在
		}
		if (!FBoolean.TRUE.equals(schDO.getFg_active())) {
			throw new BizException(IScMsgConst.SC_SCH_CLOSE);// 停诊不能挂号
		}
		return schDO.getSd_tickmd();
	}
	/**
	 * 根据渠道获取排班可用最小号位
	 * 
	 * @param schId 排班id
	 * @param scchlId 渠道id
	 * @throws BizException
	 */
	public ScSchTickDO getCanUseMinTickBySchId(String schId, Integer polcn, String scchlId) throws BizException{
		String tickCond = this.getTickQueryWherePart(schId, null, null);
		SqlParamDTO param = new SqlParamDTO();
		param.addParam(EuUseState.WY);
		param.addParam(FBoolean.TRUE);
		param.addParam(EuUseScope.APT);
		param.addParam(schId);
		ISctickRService rService = ServiceFinder.find(ISctickRService.class);
		ScSchTickDO[] tickDOs = rService.find2(tickCond, param, ScSchTickDO.QUENO, FBoolean.FALSE);// 按票号升序
		if(ArrayUtil.isEmpty(tickDOs))
			throw new BizException("排班号源已用尽，请刷新后重试!");
		ScSchDO schDO = new SchEP().getById(tickDOs[0].getId_sch());
		// 按渠道过滤
		ScSchTickDO[] filterDOs = this.filterTickByChl(tickDOs, schDO, scchlId, polcn);
		if (ArrayUtil.isEmpty(filterDOs)) {
			throw new BizException(IScMsgConst.ERROR_SCH_TICK_NOT_ENOUGH);
		}
		return filterDOs[0];
	}
	/**
	 * 根据号段获取排班可用最小号位
	 * 
	 * @param ticksId 号段id
	 * @param scchlId 渠道id
	 * @throws BizException
	 */
	public ScSchTickDO getCanUseMinTickByTicksId(String ticksId, Integer polcn, String scchlId) throws BizException {
		TicksEP ticksEP = new TicksEP();
		ScSchTicksDO schTicksDO = ticksEP.getTicksById(ticksId);
		
		String tickCond = this.getTickQueryWherePart(schTicksDO.getId_sch(), null, null);
		SqlParamDTO param = new SqlParamDTO();
		param.addParam(EuUseState.WY);
		param.addParam(FBoolean.TRUE);
		param.addParam(EuUseScope.APT);
		param.addParam(schTicksDO.getId_sch());
		ISctickRService rService = ServiceFinder.find(ISctickRService.class);
		ScSchTickDO[] tickDOs = rService.find2(tickCond, param, ScSchTickDO.QUENO, FBoolean.FALSE);// 按票号升序
		if(ArrayUtil.isEmpty(tickDOs))
			throw new BizException(IScMsgConst.ERROR_SCH_TICK_NOT_ENOUGH);
		ScSchDO schDO = new SchEP().getById(schTicksDO.getId_sch());
		// 按渠道过滤
		ScSchTickDO[] filterDOs = this.filterTickByChl(tickDOs, schDO, scchlId, polcn);
		if (ArrayUtil.isEmpty(filterDOs)) {
			throw new BizException(IScMsgConst.ERROR_SCH_TICK_NOT_ENOUGH);
		}
		ScSchTickDO schTickDO = null;
		//过滤出该号段第一次个可用号位
		for(ScSchTickDO filterDO : filterDOs){
			if(ticksId.equals(filterDO.getId_ticks())){
				schTickDO = filterDO;
				break;
			}
		}
		if (schTickDO == null) {
			throw new BizException(IScMsgConst.ERROR_SCH_TICK_NOT_ENOUGH);
		}
		return schTickDO;
	}
	/**
	 * 按渠道根据排班占用排班最小号位（渠道号位优先）
	 *
	 * @author zhengcm
	 * 
	 * @param schId 排班ID
	 * @param polcn 号源池
	 * @param scchlId 排班渠道ID
	 * @return 占用的号位DO
	 * @throws BizException
	 */
	public ScSchTickDO occupyBySchId(String schId, Integer polcn, String scchlId) throws BizException {
		String tickCond = this.getTickQueryWherePart(schId, null, null);
		SqlParamDTO param = new SqlParamDTO();
		param.addParam(EuUseState.WY);
		param.addParam(FBoolean.TRUE);
		param.addParam(EuUseScope.APT);
		param.addParam(schId);
		return this.occupyTickByCond(tickCond, null, polcn, scchlId,param);
	}

	/**
	 * 根据渠道占用指定号位
	 * 
	 * @author zhengcm
	 * 
	 * @param tickId 号位id
	 * @param polcn 号源池
	 * @param scchlId 排班渠道ID
	 * @return 占用的号位DO
	 * @throws BizException 异常
	 */
	public ScSchTickDO occupyByTickId(String tickId, Integer polcn, String scchlId) throws BizException {
		ScSchTickDO tickDO = (ScSchTickDO) new DAFacade().findByPK(ScSchTickDO.class, tickId);
		if (tickDO == null) {
			throw new BizException(IScMsgConst.ERROR_SCH_TICK_NOT_EXISTS);
		}
		// 占用号位
		return this.occupyTick(tickDO, polcn, scchlId);
	}

	/**
	 * 按渠道根据号段占用号段最小号位（渠道号位优先）
	 *
	 * @author zhengcm
	 * 
	 * @param ticksId 号段ID
	 * @param polcn 号源池
	 * @param scchlId 排班渠道ID
	 * @return 占用的号位DO
	 * @throws BizException
	 */
	public ScSchTickDO occupyByTicksId(String ticksId, Integer polcn, String scchlId) throws BizException {
		ScSchTickDO schTickDO = this.getCanUseMinTickByTicksId(ticksId, polcn, scchlId);
		return this.occupyTick(schTickDO, polcn, scchlId);
	}

	/**
	 * 按渠道根据排班和服务占用最小号位（渠道号位优先）
	 *
	 * @author zhengcm
	 * 
	 * @param schId 排班ID
	 * @param polcn 号源池
	 * @param srvId 医疗服务ID
	 * @param scchlId 排班渠道ID
	 * @return 占用的号位DO
	 * @throws BizException
	 */
	public ScSchTickDO occpuyBySchAndSrv(String schId, Integer polcn, String srvId, String scchlId) throws BizException {
		// 参数校验
		ScValidator.validateParam(schId, srvId, scchlId);
		// 号位查询
		String tickCond = String.format(this.getTickQueryWherePart(schId, null, null), EuUseState.WY, EuUseScope.APT,
				schId);
		ScSchDO schDO = new SchEP().getById(schId);
		ScPlanDO planDO = new SchPlEP().getScPl(schDO.getId_scpl());
		// 根据【医技预约检查项目类型】参数增加对服务的检查
		String wherePart = new TickEP().getWherePartBySysParam(srvId, planDO.getId_dep());
		String where = this.processWherePart(srvId, planDO);
		if (null != where) {
			wherePart = where;
		}
		if (!StringUtil.isEmptyWithTrim(wherePart)) {
			tickCond += wherePart;
		}
		return this.occupyTickByCond(tickCond, schDO, polcn, scchlId, null);
	}

	/**
	 * 按渠道根据号段和服务占用最小号位（渠道号位优先）
	 *
	 * @author zhengcm
	 * 
	 * @param ticksId 号段ID
	 * @param polcn 号源池
	 * @param srvId 医疗服务ID
	 * @param scchlId 排班渠道ID
	 * @return 占用的号位DO
	 * @throws BizException
	 */
	public ScSchTickDO occupyByTicksAndSrv(String ticksId, Integer polcn, String srvId, String scchlId)
			throws BizException {
		// 参数校验
		ScValidator.validateParam(ticksId, srvId, scchlId);
		// 查询号位
		String tickCond = String.format(this.getTickQueryWherePart(null, ticksId, null), EuUseState.WY, EuUseScope.APT,
				ticksId);

		IScticksRService ticksQryService = ServiceFinder.find(IScticksRService.class);
		ScSchTicksDO tempDO = ticksQryService.findById(ticksId);
		ScSchDO schDO = new SchEP().getById(tempDO.getId_sch());
		ScPlanDO planDO = new SchPlEP().getScPl(schDO.getId_scpl());
		// 根据【医技预约检查项目类型】参数增加对服务的检查
		String wherePart = new TickEP().getWherePartBySysParam(srvId, planDO.getId_dep());
		String where = this.processWherePart(srvId, planDO);
		if (null != where) {
			wherePart = where;
		}
		if (!StringUtil.isEmptyWithTrim(wherePart)) {
			tickCond += wherePart;
		}
		return this.occupyTickByCond(tickCond, schDO, polcn, scchlId, null);
	}

	/**
	 * 按渠道根据服务占用指定号位
	 *
	 * @author zhengcm
	 * 
	 * @param tickId 号位ID
	 * @param polcn 号源池
	 * @param srvId 服务ID
	 * @param scchlId 排班渠道ID
	 * @return 占用的号位DO
	 * @throws BizException
	 */
	public ScSchTickDO occupyTickBySrv(String tickId, Integer polcn, String srvId, String scchlId) throws BizException {
		// 参数校验
		ScValidator.validateParam(tickId, srvId, scchlId);
		// 查询号位
		String tickCond = String.format(this.getTickQueryWherePart(null, null, tickId), EuUseState.WY, EuUseScope.APT,
				tickId);

		ScSchTickDO tickDO = (ScSchTickDO) new DAFacade().findByPK(ScSchTickDO.class, tickId);
		ScSchDO schDO = new SchEP().getById(tickDO.getId_sch());
		ScPlanDO planDO = new SchPlEP().getScPl(schDO.getId_scpl());
		// 根据【医技预约检查项目类型】参数增加对服务的检查
		String wherePart = new TickEP().getWherePartBySysParam(srvId, planDO.getId_dep());
		String where = this.processWherePart(srvId, planDO);
		if (null != where) {
			wherePart = where;
		}
		if (!StringUtil.isEmptyWithTrim(wherePart)) {
			tickCond += wherePart;
		}
		return this.occupyTickByCond(tickCond, schDO, polcn, scchlId, null);
	}

	/**
	 * 按渠道根据号位查询条件占用号位
	 *
	 * @author zhengcm
	 * 
	 * @param tickCond 号位查询条件
	 * @param schDO 排班DO
	 * @param polcn 号源池
	 * @param scchlId 排班渠道ID
	 * @return 占用的号位DO
	 * @throws BizException
	 */
	private ScSchTickDO occupyTickByCond(String tickCond, ScSchDO schDO, Integer polcn, String scchlId,SqlParamDTO param)
			throws BizException {
		ISctickRService rService = ServiceFinder.find(ISctickRService.class);
		ScSchTickDO[] tickDOs = null;
		if(param != null){
			tickDOs = rService.find2(tickCond, param, ScSchTickDO.QUENO, FBoolean.FALSE);// 按票号升序
		}else{
			tickDOs = rService.find(tickCond, ScSchTickDO.QUENO, FBoolean.FALSE);// 按票号升序
		}
		if (null == schDO || !ArrayUtil.isEmpty(tickDOs)) {
			schDO = new SchEP().getById(tickDOs[0].getId_sch());
		}
		// 按渠道过滤
		ScSchTickDO[] filterDOs = this.filterTickByChl(tickDOs, schDO, scchlId, polcn);
		if (ArrayUtil.isEmpty(filterDOs)) {
			throw new BizException(IScMsgConst.ERROR_SCH_TICK_NOT_ENOUGH);
		}
		return this.occupyTick(filterDOs[0], polcn, scchlId);
	}

	/**
	 * 根据渠道占用指定号位
	 *
	 * @author zhengcm
	 * 
	 * @param tickDO 号位DO
	 * @param polcn 号源池
	 * @param scchlId 排班渠道ID
	 * @return 占用的号位DO
	 * @throws BizException
	 */
	private ScSchTickDO occupyTick(ScSchTickDO tickDO, Integer polcn, String scchlId) throws BizException {
		// 检查号位渠道（包含渠道或无渠道的号位才可占用）
		this.checkTickChl(tickDO, scchlId);
		// 占用号位
		return new TickEP().occupy(tickDO, polcn);
	}

	/**
	 * 获取号位查询条件
	 *
	 * @author zhengcm
	 * 
	 * @param schId 排班ID
	 * @param ticksId 号段ID
	 * @param tickId 号位ID
	 * @return 号位查询where条件
	 * @throws BizException
	 */
	private String getTickQueryWherePart(String schId, String ticksId, String tickId) throws BizException {
		String where = "eu_used = ? and fg_active = ? and eu_usescope = ?";
		if (!StringUtil.isEmptyWithTrim(schId)) {
			where = where + " and id_sch = ? ";
		}
		if (!StringUtil.isEmptyWithTrim(ticksId)) {
			where = where + " and id_ticks = ? ";
		}
		if (!StringUtil.isEmptyWithTrim(tickId)) {
			where = where + " and id_tick = ? ";
		}
		return where;
	}

	/**
	 * 按渠道过滤号位并排序（渠道优先）
	 *
	 * @author zhengcm
	 * 
	 * @param tickDOs 号位DO数组
	 * @param schDO 排班DO
	 * @param scchlId 排班渠道ID
	 * @param polcn 号源池
	 * @return 过滤排序后的号位DO数组
	 * @throws BizException
	 */
	private ScSchTickDO[] filterTickByChl(ScSchTickDO[] tickDOs, ScSchDO schDO, String scchlId, Integer polcn)
			throws BizException {
		if (ArrayUtil.isEmpty(tickDOs) || null == schDO) {
			return null;
		}
		// 有渠道号位
		List<ScSchTickDO> haveChlList = new ArrayList<ScSchTickDO>();
		// 可占用的号位：空渠道或包含当前渠道的号位
		List<ScSchTickDO> canUseList = new ArrayList<ScSchTickDO>();
		// 同号源池且不包含当前渠道的号位数量
		int other = 0;
		for (ScSchTickDO tickDO : tickDOs) {
			if (StringUtil.isEmptyWithTrim(tickDO.getIds_scchl())) {
				canUseList.add(tickDO);
			} else if (tickDO.getIds_scchl().contains(scchlId)) {
				haveChlList.add(tickDO);
				canUseList.add(tickDO);
			} else if (tickDO.getPolno() == polcn && !tickDO.getIds_scchl().contains(scchlId)) {
				other = other + 1;
			}
		}
		// 当前号源池剩余可预约数量
		int remain = (schDO.getAttrVal("Quan" + polcn + "_appt") == null ? 0 : (int) schDO.getAttrVal("Quan" + polcn
				+ "_appt"))
				- (schDO.getAttrVal("Quan" + polcn + "_used") == null ? 0 : (int) schDO.getAttrVal("Quan" + polcn
						+ "_used")) - other;
		if (remain <= 0) {
			throw new BizException("渠道剩余可用数量不足，请检查！");
		}
		// 若剩余可预约数量比指定当前渠道的号位数量多，则顺序占用可使用的最小号位
		if (remain > haveChlList.size()) {
			// 顺序占用空渠道或者包含当前渠道的最小号位
			if (!ListUtil.isEmpty(canUseList)) {
				return canUseList.toArray(new ScSchTickDO[0]);
			}
		} else {
			// 占用有渠道号位
			if (!ListUtil.isEmpty(haveChlList)) {
				return haveChlList.toArray(new ScSchTickDO[0]);
			}
		}
		return null;
	}

	/**
	 * 检查号位渠道（号位渠道是否包含指定渠道）
	 *
	 * @author zhengcm
	 * 
	 * @param tickDO 号位DO
	 * @param scchlId 排班渠道ID
	 * @throws BizException
	 */
	private void checkTickChl(ScSchTickDO tickDO, String scchlId) throws BizException {
		if (tickDO == null) {
			return;
		}
		// 检查号位渠道（渠道匹配或者无渠道的号位才可占用）
		if (!StringUtil.isEmptyWithTrim(tickDO.getIds_scchl()) && !tickDO.getIds_scchl().contains(scchlId)) {
			throw new BizException(IScMsgConst.ERROR_SCH_TICK_NOT_MATCH_CHL);
		}
	}

	/**
	 * 处理号位号段根据服务过滤条件（医技和手术有别，针对手术特殊处理）
	 * 
	 * @author zhengcm
	 *
	 * @param id_srv
	 * @param planDO
	 * @throws BizException
	 */
	private String processWherePart(String id_srv, ScPlanDO planDO) throws BizException {
		// 手术排班检查对应计划的排班服务
		if (planDO.getSd_sctp().equals(IScDictCodeConst.SD_SCTP_OT)) {
			String wherePart = null;
			// 排班服务查询服务
			IScheduleSrvRelDORService relQryService = ServiceFinder.find(IScheduleSrvRelDORService.class);
			String where = String.format(ScheduleSrvRelDO.ID_MDSRV + " = '%s'", id_srv);
			ScheduleSrvRelDO[] relDOs = relQryService.find(where, null, FBoolean.FALSE);
			if (ArrayUtil.isEmpty(relDOs)) {
				wherePart = " and 1 = 2";
			}
			boolean isHas = false;
			for (ScheduleSrvRelDO relDO : relDOs) {
				if (relDO.getId_scsrv().equals(planDO.getId_scsrv())) {
					isHas = true;
					break;
				}
			}
			if (isHas) {
				wherePart = " and 1 = 1";
			} else {
				wherePart = " and 1 = 2";
			}
			return wherePart;
		}
		return null;
	}

}
