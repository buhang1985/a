package iih.sc.sch.s.ep.mt.apt.auto;

import iih.sc.apt.dto.d.MtResDTO;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScParamUtils;
import iih.sc.comm.ScSqlUtils;
import iih.sc.comm.ScValidator;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvRelDO;
import iih.sc.scbd.schedulesrv.i.IScheduleSrvRelDORService;
import iih.sc.sch.s.bp.BatchGetScTickBP;
import iih.sc.sch.s.ep.mt.apt.Sch4MtAptEP;
import iih.sc.sch.s.ep.mt.apt.SchChl4MtAptEP;
import iih.sc.sch.s.ep.mt.apt.SchPl4MtAptEP;
import iih.sc.sch.s.ep.mt.apt.TickChl4MtAptEP;
import iih.sc.sch.scsch.d.ScSchChlDO;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.sctick.d.EuAddTickMod;
import iih.sc.sch.sctick.d.EuUseScope;
import iih.sc.sch.sctick.d.EuUseState;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.sctick.d.desc.ScSchTickDODesc;
import iih.sc.sch.sctick.i.ISctickCudService;
import iih.sc.sch.sctick.i.ISctickRService;
import iih.sc.sch.scticks.d.ScSchTicksDO;
import iih.sc.sch.scticks.i.IScticksRService;
import iih.sc.scp.scplan.d.ScPlanDO;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.SqlParamDTO;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 号位BP
 * 
 * @author yankan
 *
 */
public class Tick4AutoMtAptEP {
	/**
	 * 号位加号
	 * 
	 * @param schId 排班ID
	 * @param addEmpId 加号人员
	 * @param addNum 加号数量
	 * @param addEuTp 加号类型
	 * @return
	 * @throws BizException
	 */
	public ScSchTickDO[] addTicket(String schId, String addEmpId, int addNum, Integer addEuTp,String scchlId) throws BizException {
		ISctickRService tkRService = ServiceFinder.find(ISctickRService.class);
		String whereStr = String.format("%s.ID_SCH=?", ScSchTickDODesc.TABLE_ALIAS_NAME);
		String orderStr = String.format("%s.QUENO DESC", ScSchTickDODesc.TABLE_ALIAS_NAME);
		SqlParamDTO param = new SqlParamDTO();
		param.addParam(schId);
		ScSchTickDO[] ticksDOs = tkRService.find2(whereStr, param, orderStr, FBoolean.FALSE);
		if (ArrayUtil.isEmpty(ticksDOs)) {
			throw new BizException(IScMsgConst.ERROR_SCH_TICK_NOT_EXISTS);
		} else {
			ScSchTickDO addTicks[] = new ScSchTickDO[addNum];
			for (int i = 0; i < addNum; i++) {
				ScSchTickDO tick = (ScSchTickDO) ticksDOs[0].clone();
				tick.setId_tick(null);
				tick.setCode("add" + addEmpId);
				tick.setName("加号");
				tick.setIds_scchl(scchlId);
				tick.setStatus(DOStatus.NEW);
				tick.setQueno(tick.getQueno() + i + 1);
				tick.setEu_used(EuUseState.WY);
				tick.setEu_usescope(EuUseScope.APT);// 可挂号
				tick.setFg_active(FBoolean.TRUE);
				tick.setEu_add(addEuTp);
				addTicks[i] = tick;
			}
			return this.save(addTicks);
		}
	}

	/**
	 * 号位减号
	 * 
	 * @param schId 排班ID
	 * @param addEmpId 加号人员
	 * @param addNum 加号数量
	 * @param addEuTp 加号类型
	 * @return
	 * @throws BizException
	 */
	public ScSchTickDO[] subTicket(String schId, String addEmpId, int addNum) throws BizException {
		ISctickRService rService = ServiceFinder.find(ISctickRService.class);
		String whereStr = "id_sch=? and eu_used=? and fg_active=? and eu_usescope=?";// 使用范围为：预约
		SqlParamDTO param = new SqlParamDTO();
		param.addParam(schId);
		param.addParam(EuUseState.WY);
		param.addParam(FBoolean.TRUE);
		param.addParam(EuUseScope.APT);
		String orderStr = "queno desc";// 按票号倒叙排列
		ScSchTickDO[] tickDOArray = rService.find2(whereStr, param, orderStr, FBoolean.FALSE);
		if (ArrayUtil.isEmpty(tickDOArray)) {
			throw new BizException(IScMsgConst.ERROR_SCH_TICK_NOT_EXISTS);
		} else if (tickDOArray.length < addNum) {
			throw new BizException(IScMsgConst.ERROR_SCH_TICK_NOT_ENOUGH_FOR_SUB);
		} else {
			ScSchTickDO subTicks[] = new ScSchTickDO[addNum];
			for (int i = 0; i < addNum; i++) {
				ScSchTickDO tick = tickDOArray[i];
				tick.setFg_active(FBoolean.FALSE);// 只更新可用，eu_used不作更新，只有挂号，才取消
				tick.setStatus(DOStatus.UPDATED);
				subTicks[i] = tick;
			}
			return this.save(subTicks);
		}
	}
	/**
	 * 号位加号
	 * 
	 * @param schId 排班ID
	 * @param addEmpId 加号人员
	 * @param addNum 加号数量
	 * @param addEuTp 加号类型
	 * @return
	 * @throws BizException
	 */
	public ScSchTickDO[] addTicketWithPolcn(String schId, String addEmpId, int addNum, Integer addEuTp,String scchlId,Integer polCn) throws BizException {
		ISctickRService tkRService = ServiceFinder.find(ISctickRService.class);
		String whereStr = String.format("%s.ID_SCH=?", ScSchTickDODesc.TABLE_ALIAS_NAME);
		String orderStr = String.format("%s.QUENO DESC", ScSchTickDODesc.TABLE_ALIAS_NAME);
		SqlParamDTO param = new SqlParamDTO();
		param.addParam(schId);
		ScSchTickDO[] ticksDOs = tkRService.find2(whereStr, param, orderStr, FBoolean.FALSE);
		if (ArrayUtil.isEmpty(ticksDOs)) {
			throw new BizException(IScMsgConst.ERROR_SCH_TICK_NOT_EXISTS);
		} else {
			ScSchTickDO addTicks[] = new ScSchTickDO[addNum];
			for (int i = 0; i < addNum; i++) {
				ScSchTickDO tick = (ScSchTickDO) ticksDOs[0].clone();
				tick.setId_tick(null);
				tick.setCode("add" + addEmpId);
				tick.setName("加号");
				tick.setIds_scchl(scchlId);
				tick.setStatus(DOStatus.NEW);
				tick.setQueno(tick.getQueno() + i + 1);
				if(StringUtil.isEmpty(scchlId)){
					tick.setPolno(null);
				}else{
					tick.setPolno(polCn);
				}
				tick.setEu_used(EuUseState.WY);
				tick.setEu_usescope(EuUseScope.APT);// 可挂号
				tick.setFg_active(FBoolean.TRUE);
				tick.setEu_add(addEuTp);
				addTicks[i] = tick;
			}
			return this.save(addTicks);
		}
	}
	/**
	 * 占用号位最小号，如果没有可用资源抛异常
	 * 
	 * @param schId 排班id
	 * @param polcn 号源池
	 * @param scchlId 渠道id
	 * @return 号位
	 * @throws BizException 异常
	 */
	public ScSchTickDO occupyBySchId(String schId, Integer polcn, String scchlId,String idEnttp) throws BizException {
		ScSchTickDO schTickDO = getCanUseMinTickBySchId(schId, scchlId,idEnttp);
		if (schTickDO == null)
			throw new BizException(IScMsgConst.ERROR_SCH_TICK_NOT_ENOUGH);
		return this.occupy(schTickDO, polcn);
	}

	/**
	 * 占用号位最小号，如果没有可用资源抛异常
	 * 
	 * @param ticksId 号段id
	 * @param polcn 号源池
	 * @return 号位
	 * @throws BizException 异常
	 */
	public ScSchTickDO occupyByTicksId(String ticksId, Integer polcn, String scchlId,String idEnttp) throws BizException {
		ScSchTickDO schTickDO = getCanUseMinTickByTicksId(ticksId, scchlId,idEnttp);
		if (schTickDO == null)
			throw new BizException(IScMsgConst.ERROR_SCH_TICK_NOT_ENOUGH);
		return this.occupy(schTickDO, polcn);
	}

	/**
	 * 根据排班和服务占用号位
	 * 
	 * @param schId 排班ID
	 * @param polcn 号源池
	 * @param srvId 服务ID
	 * @return 号位DO
	 * @throws BizException
	 * @author zhengcm
	 */
	public ScSchTickDO occpuyBySchAndSrv(String schId, Integer polcn, String srvId) throws BizException {
		// 参数校验
		ScValidator.validateParam(schId, srvId);
		// 排班服务查询服务
		ISctickRService rService = ServiceFinder.find(ISctickRService.class);
		String whereStr = String.format("id_sch='%s' and eu_used='%s' and fg_active='Y'", schId, EuUseState.WY);
		whereStr += " and eu_usescope=" + EuUseScope.APT;// 预约

		ScSchDO schDO = new Sch4MtAptEP().getById(schId);
		ScPlanDO planDO = new SchPl4MtAptEP().getScPl(schDO.getId_scpl());

		// 根据【医技预约检查项目类型】参数增加对服务的检查
		String wherePart = this.getWherePartBySysParam(srvId, planDO.getId_dep());
		if (!StringUtil.isEmptyWithTrim(wherePart)) {
			whereStr += wherePart;
		}

		String orderStr = "queno";// 按票号正序排列
		ScSchTickDO[] tickDOArray = rService.find(whereStr, orderStr, FBoolean.FALSE);
		if (tickDOArray != null && tickDOArray.length > 0) {
			return this.occupy(tickDOArray[0], polcn);
		} else {
			throw new BizException(IScMsgConst.ERROR_SCH_TICK_NOT_ENOUGH);
		}
	}

	/**
	 * 根据号段和服务 占用号位最小号，如果没有可用资源抛异常
	 * 
	 * @param ticksId 号段id
	 * @param polcn 号源池
	 * @param srvId 排班服务id
	 * @param
	 * @return 号位DO
	 * @throws BizException 异常
	 * @author zhengcm
	 */
	public ScSchTickDO occupyByTicksAndSrv(String ticksId, Integer polcn, String srvId) throws BizException {
		// 参数校验
		ScValidator.validateParam(ticksId, srvId);
		// 排班服务查询服务
		ISctickRService rService = ServiceFinder.find(ISctickRService.class);
		String whereStr = String.format("id_ticks='%s' and eu_used='%s' and fg_active='Y'", ticksId, EuUseState.WY);
		whereStr += " and eu_usescope=" + EuUseScope.APT;// 预约

		IScticksRService ticksQryService = ServiceFinder.find(IScticksRService.class);
		ScSchTicksDO tempDO = ticksQryService.findById(ticksId);
		ScSchDO schDO = new Sch4MtAptEP().getById(tempDO.getId_sch());
		ScPlanDO planDO = new SchPl4MtAptEP().getScPl(schDO.getId_scpl());

		// 根据【医技预约检查项目类型】参数增加对服务的检查
		String wherePart = this.getWherePartBySysParam(srvId, planDO.getId_dep());
		if (!StringUtil.isEmptyWithTrim(wherePart)) {
			whereStr += wherePart;
		}

		String orderStr = "queno";// 按票号正序排列
		ScSchTickDO[] tickDOArray = rService.find(whereStr, orderStr, FBoolean.FALSE);
		if (tickDOArray != null && tickDOArray.length > 0) {
			return this.occupy(tickDOArray[0], polcn);
		} else {
			throw new BizException(IScMsgConst.ERROR_SCH_TICK_NOT_ENOUGH);
		}
	}

	/**
	 * 占用多个号位，已第一个号位主号位，其余号位被主号位占用
	 * 
	 * @param tickDOs 多个号位
	 * @param polcn 号源池
	 * @throws BizException
	 */
	public ScSchTickDO[] occupy(ScSchTickDO[] tickDOs, Integer polcn) throws BizException {
		if (ArrayUtil.isEmpty(tickDOs)) {
			return null;
		}
		String mainTickId = tickDOs[0].getId_tick();
		boolean isMain = true;
		for (ScSchTickDO tickDO : tickDOs) {
			this.checkIsAvailable(tickDO);// 检查是否可用

			tickDO.setEu_used(EuUseState.SY);
			tickDO.setPolno_used(polcn);// 指定号源池
			if (isMain) {
				isMain = false;
				// 主号位占用ID清空(处理当有垃圾数据时该字段未清空) add by zhengcm 2018-01-11
				tickDO.setId_tick_occupier(null);
			} else {
				tickDO.setId_tick_occupier(mainTickId);
			}
			tickDO.setStatus(DOStatus.UPDATED);
		}
		return this.save(tickDOs);
	}

	/**
	 * 占用指定号位
	 * 
	 * @param tickId 号位id
	 * @param polcn 号源池
	 * @return 号位
	 * @throws BizException 异常
	 */
	public ScSchTickDO occupy(String tickId, Integer polcn) throws BizException {
		ScSchTickDO tickDO = (ScSchTickDO) new DAFacade().findByPK(ScSchTickDO.class, tickId);
		if (tickDO == null) {
			throw new BizException(IScMsgConst.ERROR_SCH_TICK_NOT_EXISTS);
		}
		return this.occupy(tickDO, polcn);
	}

	/**
	 * 占用票号
	 * 
	 * @param tickDO 票号
	 * @param polcn 号源池
	 * @return
	 * @throws BizException
	 */
	public ScSchTickDO occupy(ScSchTickDO tickDO, Integer polcn) throws BizException {
		// 检查是否可用
		this.checkIsAvailable(tickDO);

		tickDO.setEu_used(EuUseState.SY);
		tickDO.setPolno_used(polcn);// 指定号源池
		tickDO.setStatus(DOStatus.UPDATED);
		// 主号位占用ID清空(处理当有垃圾数据时该字段未清空) add by zhengcm 2018-01-11
		tickDO.setId_tick_occupier(null);
		this.save(tickDO);
		// new DAFacade().updateDO(tickDO);
		return tickDO;
	}
	
	/**
	 * 占用票号
	 * 
	 * @param tickDO 票号
	 * @param polcn 号源池
	 * @return
	 * @throws BizException
	 */
	public ScSchTickDO occupy(ScSchTickDO tickDO, Integer polcn,boolean isMin) throws BizException {
		// 检查是否可用
		this.checkIsAvailable(tickDO);

		tickDO.setEu_used(EuUseState.SY);
		
		if(tickDO.getPolno() == null){
			if (isMin) {
				tickDO.setPolno(polcn);
				tickDO.setPolno_used(polcn);// 指定号源池
			}else{
				return null;
			}
		}else{
			tickDO.setPolno_used(tickDO.getPolno());
		}
		tickDO.setStatus(DOStatus.UPDATED);
		// 主号位占用ID清空(处理当有垃圾数据时该字段未清空) add by zhengcm 2018-01-11
		tickDO.setId_tick_occupier(null);
		this.save(tickDO);
		// new DAFacade().updateDO(tickDO);
		return tickDO;

	}
	/**
	 * 时间片模式插入号位
	 * 
	 * @author liubin
	 * 
	 * @param schTicks
	 * @param polcn
	 * @return
	 * @throws BizException
	 */
	public ScSchTickDO[] insert4TimeMd(ScSchTicksDO schTicks, Integer polcn) throws BizException {
		ScSchTickDO schTickDO = new ScSchTickDO();
		schTickDO.setStatus(DOStatus.NEW);
		schTickDO.setId_grp(schTicks.getId_grp());
		schTickDO.setId_org(schTicks.getId_org());
		schTickDO.setId_sch(schTicks.getId_sch());
		schTickDO.setId_ticks(schTicks.getId_ticks());
		schTickDO.setQueno(0);
		schTickDO.setT_b(schTicks.getT_b());
		schTickDO.setT_e(schTicks.getT_e());
		schTickDO.setFg_active(FBoolean.TRUE);
		schTickDO.setEu_usescope(EuUseScope.APT);
		schTickDO.setEu_used(EuUseState.SY);
		schTickDO.setEu_add(EuAddTickMod.ZCH);
		schTickDO.setPolno_used(polcn);
		return save(new ScSchTickDO[]{schTickDO});
	}

	/**
	 * 退还票号
	 * 
	 * @param schId 排班id
	 * @param tickno 票号
	 * @throws BizException
	 */
	public void drawbackTickno(String schId, int tickno) throws BizException {
		ISctickRService rService = ServiceFinder.find(ISctickRService.class);
		String whereStr = "id_sch=? and queno=?";
		SqlParamDTO param = new SqlParamDTO();
		param.addParam(schId);
		param.addParam(tickno);
		ScSchTickDO[] tickDOArray = rService.find2(whereStr, param, null, FBoolean.FALSE);
		if (ArrayUtils.isEmpty(tickDOArray)) {
			throw new BizException(IScMsgConst.ERROR_SCH_TICK_NOT_EXISTS);
		}
		// 退号
		this.drawback(tickDOArray[0]);
	}

	/**
	 * 退还票号
	 * 
	 * @param tickId 票号
	 * @throws BizException
	 */
	public void drawback(String tickId) throws BizException {
		ISctickRService rService = ServiceFinder.find(ISctickRService.class);
		ScSchTickDO tickDO = rService.findById(tickId);
		if (tickDO == null) {
			throw new BizException(IScMsgConst.ERROR_SCH_TICK_NOT_EXISTS);
		}
		this.drawback(tickDO);
	}

	/**
	 * 退还票号
	 * 
	 * @param tickDO 票号
	 * @throws BizException
	 */
	public void drawback(ScSchTickDO tickDO) throws BizException {
		this.drawback(new ScSchTickDO[] { tickDO });
	}

	/**
	 * 退还票号
	 * 
	 * @param tickDOs 票号集合
	 * @throws BizException
	 */
	public void drawback(ScSchTickDO[] tickDOs) throws BizException {
		ScValidator.validateParam("tickDO", tickDOs);
		for (ScSchTickDO tickDO : tickDOs) {
			tickDO.setEu_used(EuUseState.WY);
			tickDO.setId_tick_occupier(null);
			tickDO.setPolno_used(null);// 使用号源池清空
			tickDO.setSd_reserve_rsn(null);// 保留原因
			tickDO.setId_reserve_rsn("~");
			tickDO.setNote_reserve(null);// 保留原因
			tickDO.setStatus(DOStatus.UPDATED);
		}
		this.save(tickDOs);
	}

	/**
	 * 作废票号
	 * 
	 * @param tickDO 票号
	 * @throws BizException
	 */
	public void revoke(ScSchTickDO tickDO) throws BizException {
		this.revoke(new ScSchTickDO[] { tickDO });
	}

	/**
	 * 作废票号
	 * 
	 * @param tickDOs 票号集合
	 * @throws BizException
	 */
	public void revoke(ScSchTickDO[] tickDOs) throws BizException {
		if (ArrayUtil.isEmpty(tickDOs)) {
			throw new BizException(IScMsgConst.ERROR_SCH_TICK_NOT_EXISTS);
		}
		for (ScSchTickDO tickDO : tickDOs) {
			tickDO.setFg_active(FBoolean.FALSE);
			tickDO.setEu_used(EuUseState.QXSY);
			tickDO.setId_tick_occupier(null);
			tickDO.setStatus(DOStatus.UPDATED);
		}
		this.save(tickDOs);
	}

	/**
	 * 获取ID获取号位
	 * 
	 * @param tickId 号位ID
	 * @return 号位DO
	 * @throws BizException
	 */
	public ScSchTickDO getTickById(String tickId) throws BizException {
		ISctickRService tickRService = ServiceFinder.find(ISctickRService.class);
		ScSchTickDO tickDO = tickRService.findById(tickId);
		return tickDO;
	}

	/**
	 * 获取占用的号位
	 * 
	 * @param tickId 号位ID
	 * @return 号位DO集合
	 * @throws BizException
	 */
	public ScSchTickDO[] getOccupiedTickList(String tickId) throws BizException {
		String whereStr = String.format("%s.id_tick=? or %s.id_tick_occupier=?",
				ScSchTickDODesc.TABLE_ALIAS_NAME, ScSchTickDODesc.TABLE_ALIAS_NAME);
		SqlParamDTO param = new SqlParamDTO();
		param.addParam(tickId);
		param.addParam(tickId);
		ISctickRService tickRService = ServiceFinder.find(ISctickRService.class);
		ScSchTickDO[] tickDOs = tickRService.find2(whereStr, param, null, FBoolean.FALSE);
		return tickDOs;
	}

	/**
	 * 批量获取占用的号位
	 * 
	 * @param tickIds 号位ID集合
	 * @return 号位对象Map
	 * @throws BizException
	 */
	public Map<String, ScSchTickDO[]> batchGetOccupiedTickList(String[] tickIds) throws BizException {
		ScValidator.validateParam("号位ID数组", tickIds);
		List<ScSchTickDO> dataList = new BatchGetScTickBP().exec(tickIds);
		Map<String, ScSchTickDO[]> tickMap = new LinkedHashMap<String, ScSchTickDO[]>();
		List<ScSchTickDO> tickList = new ArrayList<ScSchTickDO>();
		for (String tickId : tickIds) {
			if (StringUtil.isEmpty(tickId))
				continue;
			if (tickMap.containsKey(tickId))
				continue;
			if (!dataList.isEmpty()) {
				for (ScSchTickDO tickDO : dataList) {
					if (tickDO.getId_tick().equals(tickId) || tickId.equals(tickDO.getId_tick_occupier())) {
						tickList.add(tickDO);
					}
				}
			}
			tickMap.put(tickId, tickList.toArray(new ScSchTickDO[0]));
		}
		return tickMap;
	}

	/**
	 * 保存
	 * 
	 * @param tickDO 号位
	 * @return 号位DO
	 * @throws BizException
	 */
	public ScSchTickDO save(ScSchTickDO tickDO) throws BizException {
		if (tickDO == null) {
			return null;
		}
		ScSchTickDO[] tickDOs = this.save(new ScSchTickDO[] { tickDO });
		if(ArrayUtil.isEmpty(tickDOs))
			return null;
		return tickDOs[0];
	}

	/**
	 * 保存
	 * 
	 * @param tickDOs 号位集合
	 * @return 号位DO
	 * @throws BizException
	 */
	public ScSchTickDO[] save(ScSchTickDO[] tickDOs) throws BizException {
		if (ArrayUtil.isEmpty(tickDOs)) {
			return null;
		}
		ISctickCudService cudService = ServiceFinder.find(ISctickCudService.class);
		tickDOs = cudService.save(tickDOs);
		return tickDOs;
	}

	/**
	 * 根据【医技预约检查项目类型】参数增加对服务的过滤条件
	 *
	 * @param srvId 申请单服务id
	 * @param deptId 科室ID
	 * @return sql过滤条件
	 * @throws BizException
	 * @author zhengcm
	 */
	public String getWherePartBySysParam(String srvId, String deptId) throws BizException {
		// 获取系统参数：医技预约检查项目类型
		boolean isAptCheck = ScParamUtils.getscAptCOI(deptId).booleanValue();
		if (!isAptCheck) {
			return null;
		}
		// 排班服务查询服务
		IScheduleSrvRelDORService relQryService = ServiceFinder.find(IScheduleSrvRelDORService.class);
		String where = String.format(ScheduleSrvRelDO.ID_MDSRV + " = '%s'", srvId);
		ScheduleSrvRelDO[] relDOs = relQryService.find(where, null, FBoolean.FALSE);
		if (ArrayUtil.isEmpty(relDOs)) {
			throw new BizException(IScMsgConst.ERROR_SCH_TICK_NOT_ENOUGH);
		}
		List<String> scSrvIds = new ArrayList<String>();
		for (ScheduleSrvRelDO relDO : relDOs) {
			scSrvIds.add(relDO.getId_scsrv());
		}
		// 根据医嘱id过滤服务
		String wherePart = " and id_scsrv in (" + ScSqlUtils.buildIdStr(scSrvIds) + ")";
		return wherePart;
	}

	/**
	 * 号位排除计划服务
	 * 
	 * @param id_sch 排班id
	 * @param id_srv 计划对应的排班
	 * @return 如果只有计划对应的服务返回"" 返回号段所有服务
	 * @throws BizException
	 */
	public String getAllSrvName(String id_sch, String id_srv) throws BizException {
		if (StringUtils.isEmpty(id_sch) || StringUtils.isEmpty(id_srv))
			return "";
		StringBuffer stringBuffer = new StringBuffer();
		SqlParam sqlParam = new SqlParam();
		stringBuffer
				.append("select distinct srv.name as srv_name  from sc_tick tick inner join SC_SRV srv on  tick.id_scsrv = srv.id_scsrv and tick.id_sch = ?  ");
		stringBuffer.append(" and srv.id_scsrv <> ? ");
		sqlParam.addParam(id_sch);
		sqlParam.addParam(id_srv);
		List list = (List) new DAFacade().execQuery(stringBuffer.toString(), sqlParam, new MapListHandler());
		if (CollectionUtils.isEmpty(list))
			return "";
		stringBuffer.setLength(0);
		if (list.size() > 2) {
			stringBuffer.append(((Map) list.get(0)).get("srv_name"));
			stringBuffer.append("  ");
			stringBuffer.append(((Map) list.get(1)).get("srv_name"));
			stringBuffer.append("  ");
			stringBuffer.append(" ···");
		} else {
			for (Object object : list) {
				stringBuffer.append(((Map) object).get("srv_name"));
				stringBuffer.append("  ");
			}
		}
		return stringBuffer.toString();
	}

	/**
	 * 是否可用
	 * 
	 * @param tickDO
	 * @throws BizException
	 */
	private void checkIsAvailable(ScSchTickDO tickDO) throws BizException {
		ScValidator.validateParam("tickDO", tickDO);
		if (EuUseState.SY.equals(tickDO.getEu_used()))
			throw new BizException(IScMsgConst.ERROR_SCH_TICK_USED);
		if (EuUseState.QXSY.equals(tickDO.getEu_used()))
			throw new BizException(IScMsgConst.ERROR_SCH_TICK_CANCED);
	}

	/**
	 * 根据条件获取排班号位
	 *
	 * @param cond
	 * @param order
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public ScSchTickDO[] getTickByCond(String cond, String order) throws BizException {
		if (StringUtil.isEmptyWithTrim(cond)) {
			return null;
		}
		ISctickRService tickRService = ServiceFinder.find(ISctickRService.class);
		return tickRService.find(cond, order, FBoolean.FALSE);
	}

	/**
	 * 删除排班对应的号位
	 * 
	 * @param schIdList 排班ids
	 * @throws DAException
	 */
	public void deleteTickBySchIds(List<String> schIdList) throws DAException {
		if (ListUtil.isEmpty(schIdList)) {
			return;
		}
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("  delete from sc_tick where id_sch in(");
		stringBuffer.append(ScSqlUtils.buildIdStr(schIdList));
		stringBuffer.append(")");

		new DAFacade().execUpdate(stringBuffer.toString());

	}
	/**
	 * 根据渠道获取排班可用最小号位
	 * 
	 * @param schId 排班id
	 * @param scchlId 渠道id
	 * @param idEnttp
	 * @throws BizException
	 */
	public ScSchTickDO getCanUseMinTickBySchId(String schId, String scchlId,String idEnttp) throws BizException {
		SchChl4MtAptEP scChlEp = new SchChl4MtAptEP();
		// 按照排班 渠道 和就诊类型过滤可以使用的渠道号源池
		ScSchChlDO[] scChls = scChlEp.getSchChl(schId, scchlId,idEnttp);
		if (ArrayUtil.isEmpty(scChls))
			throw new BizException("渠道:" + scchlId + "不存在！");
		List<Integer> polcnList = new ArrayList<Integer>();
		for (ScSchChlDO scSchChlDO : scChls) {
			polcnList.add(scSchChlDO.getScpolcn());
		}
		TickChl4MtAptEP ep = new TickChl4MtAptEP();
		return ep.getCanUseMinTickBySchId(schId, polcnList, scchlId);
	}
	/**
	 * 根据渠道获取排班可用最小号位
	 * 
	 * @param schId 排班id
	 * @param scchlId 渠道id
	 * @param idEnttp
	 * @throws BizException
	 */
	public ScSchTickDO getCanUseMinTickBySchId(String schId, String scchlId,String idEnttp,Map<Integer,Integer> polcnMap,MtResDTO resDTO,String idSrv) throws BizException {
		SchChl4MtAptEP scChlEp = new SchChl4MtAptEP();
		// 按照排班 渠道 和就诊类型过滤可以使用的渠道号源池
		ScSchChlDO[] scChls = scChlEp.getSchChl(schId, scchlId,idEnttp);
		if (ArrayUtil.isEmpty(scChls)){
			return null;
			//throw new BizException("渠道:" + scchlId + "不存在！");
		}
		//List<Integer> polcnList = new ArrayList<Integer>();
		//for (ScSchChlDO scSchChlDO : scChls) {
		//	polcnList.add(scSchChlDO.getScpolcn());
		//}
		TickChl4AutoMtAptEP ep = new TickChl4AutoMtAptEP();
		//return ep.getCanUseMinTickBySchId(schId, polcnList, scchlId);
 		return ep.getCanUseMinTickBySchId(schId, polcnMap, scchlId, resDTO,idEnttp,idSrv);
	}
	/**
	 * 根据号段获取排班可用最小号位
	 * 
	 * @param ticksId 号段id
	 * @param scchlId 渠道id
	 * @param idEnttp
	 * @throws BizException
	 */
	public ScSchTickDO getCanUseMinTickByTicksId(String ticksId, String scchlId,String idEnttp) throws BizException {
		Ticks4AutoMtAptEP tksEp = new Ticks4AutoMtAptEP();
		ScSchTicksDO tks = tksEp.getTicksById(ticksId);
		if(tks == null)
			throw new BizException("排班号段不存在！");
		SchChl4MtAptEP scChlEp = new SchChl4MtAptEP();
		ScSchChlDO[] scChls = scChlEp.getSchChl(tks.getId_sch(), scchlId,idEnttp);
		if (ArrayUtil.isEmpty(scChls))
			throw new BizException("渠道:" + scchlId + "不存在！");
		List<Integer> polcnList = new ArrayList<Integer>();
		for (ScSchChlDO scSchChlDO : scChls) {
			polcnList.add(scSchChlDO.getScpolcn());
		}
		TickChl4AutoMtAptEP ep = new TickChl4AutoMtAptEP();
		return ep.getCanUseMinTickByTicksId(ticksId, polcnList, scchlId);
	}

	/**
	 * 校验号位是不是被使用
	 * 
	 * @throws BizException
	 * 
	 */
	public boolean validateTickDataIsUsed(String tickID) throws BizException {
		ScValidator.validateParam(tickID, tickID);
		ScSchTickDO tickDO = this.getTickById(tickID);
		if (tickDO.getEu_used() != null && tickDO.getEu_used() != EuUseState.WY) {
			return true;
		}
		return false;
	}
}
