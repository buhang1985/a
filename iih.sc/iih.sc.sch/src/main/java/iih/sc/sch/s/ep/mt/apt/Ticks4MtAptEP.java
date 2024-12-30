package iih.sc.sch.s.ep.mt.apt;

import iih.sc.apt.dto.d.MtResDTO;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScSqlUtils;
import iih.sc.comm.ScValidator;
import iih.sc.scbd.i.IScBdOutQryService;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.sch.reg.dto.d.PeriodResDTO;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.i.IScschMDORService;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.scticks.d.ScSchTicksDO;
import iih.sc.sch.scticks.d.desc.ScSchTicksDODesc;
import iih.sc.sch.scticks.i.IScticksCudService;
import iih.sc.sch.scticks.i.IScticksRService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.MapListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 号段BP
 * 
 * @author yank
 *
 */
public class Ticks4MtAptEP {
	/**
	 * 根据排班获取号段列表
	 * 
	 * @param schId 排班id
	 * @return
	 * @throws BizException
	 */
	public PeriodResDTO[] getTicksBySch(String schId) throws BizException {
		ScValidator.validateParam("schId", schId);

		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("	SELECT TRIM(T_B) ||'-'|| TRIM(T_E) AS PERIOD,");
		sqlBuilder.append("	(QUECN_APPT -  NVL(QUENO_USED,0)) AS REMAIN,");
		sqlBuilder.append("	QUECN_APPT AS TOTAL,ID_TICKS");
		sqlBuilder.append("	FROM SC_TICKS SC_TICKS	");
		sqlBuilder.append(" WHERE ID_SCH='" + schId + "'");
		sqlBuilder.append(" ORDER BY T_B ");// 开始时间排序

		@SuppressWarnings("unchecked")
		List<PeriodResDTO> prdResList = (List<PeriodResDTO>) new DAFacade().execQuery(sqlBuilder.toString(),
				new BeanListHandler(PeriodResDTO.class));
		if (!ListUtil.isEmpty(prdResList)) {
			return prdResList.toArray(new PeriodResDTO[0]);
		}

		return null;
	}

	/**
	 * 根据排班获取号段列表 4点可挂1点的号，取当前可用的第一个排班即可，当天和预约同样处理
	 * 
	 * @param schId 排班id
	 * @param chlTp 渠道类型
	 * @return
	 * @throws BizException
	 */
	public PeriodResDTO getRecentAvlTicks(String schId, String chlTp,String idEnttp) throws BizException {
		ScValidator.validateParam("排班id", schId);
		ScValidator.validateParam("渠道类型", chlTp);
		IScBdOutQryService serv = ServiceFinder.find(IScBdOutQryService.class);
		@SuppressWarnings("unchecked")
		SchedulechlDO[] chls  = serv.getChlByTp(chlTp);
		if(ArrayUtil.isEmpty(chls))
			throw new BizException("渠道:" + chlTp + "不存在！");
		Tick4MtAptEP tickEP = new Tick4MtAptEP();
		ScSchTickDO schTickDO = tickEP.getCanUseMinTickBySchId(schId, chls[0].getId_scchl(),idEnttp);
		if(schTickDO == null)
			throw new BizException(IScMsgConst.ERROR_SCH_TICK_NOT_ENOUGH);
		if(ScValidator.isEmptyIgnoreBlank(schTickDO.getId_ticks()))
			throw new BizException("可用号段为空！");
		ScSchTicksDO tickSectDO = (ScSchTicksDO) new DAFacade().findByPK(ScSchTicksDO.class, 
				schTickDO.getId_ticks());
		if (tickSectDO == null)
			throw new BizException(IScMsgConst.ERROR_SCH_TICK_NOT_ENOUGH);
		PeriodResDTO recentPeriod = transToPeriodDTO(tickSectDO);
		return recentPeriod;
	}

	/**
	 * 根据排班获取号段列表(备份，根据时间取当前时间后合适的排班） 就近取可用时段
	 * 
	 * @param schId 排班id
	 * @return
	 * @throws BizException
	 */
	private PeriodResDTO getRecentAvlTicksBckUp(String schId) throws BizException {
		ScValidator.validateParam("排班id", schId);
		IScschMDORService schService = ServiceFinder.find(IScschMDORService.class);
		ScSchDO schDO = schService.findById(schId);
		if (schDO == null) {
			throw new BizException("排班id:" + schId + "对应的排班不存在");
		}
		ScSchTicksDO[] ticksDOs = getAvlTicks(schId);
		if (ArrayUtil.isEmpty(ticksDOs)) {
			throw new BizException(IScMsgConst.ERROR_SCH_TICK_NOT_ENOUGH);
		}

		PeriodResDTO recentPeriod = null;
		FDate today = new FDate();
		FTime nowTime = new FTime();
		ScSchTicksDO selectSchTicks = null;
		if (schDO.getD_sch().after(today)) {
			// 如果是预约
			selectSchTicks = ticksDOs[0];
		} else {
			boolean first = true;
			for (int i = 0; i < ticksDOs.length; i++) {
				// 早于最早
				if (nowTime.before(ticksDOs[0].getT_b())) {
					selectSchTicks = ticksDOs[0];
					break;
				} else if (nowTime.after(ticksDOs[ticksDOs.length - 1].getT_e())) {
					// 晚于最晚
					selectSchTicks = ticksDOs[ticksDOs.length - 1];
					break;
				}

				// 取某一时段，默认取该时间后第一个
				if (nowTime.after(ticksDOs[i].getT_b())) {
					if (first) {
						// 根据时间，前面的号优先选择，可能有退号或者未挂满
						selectSchTicks = ticksDOs[i];
					} else {
						first = false;
					}
					if (nowTime.before(ticksDOs[i].getT_e())) {
						selectSchTicks = ticksDOs[i];
						break;
					}
				}
			}
		}
		recentPeriod = transToPeriodDTO(selectSchTicks);
		return recentPeriod;
	}

	/**
	 * 将号段DO转为时段DTO
	 * 
	 * @param ticksDO
	 * @return
	 */
	private PeriodResDTO transToPeriodDTO(ScSchTicksDO ticksDO) {
		if (ticksDO == null) {
			return null;
		}
		PeriodResDTO resDTO = new PeriodResDTO();
		resDTO.setId_sch(ticksDO.getId_sch());
		resDTO.setId_ticks(ticksDO.getId_ticks());
		resDTO.setPeriod(ticksDO.getT_b() + "-" + ticksDO.getT_e());
		resDTO.setTotal(ticksDO.getQuecn_appt());//可用数
		if (ticksDO.getQuecn_used() == null) {
			ticksDO.setQuecn_used(0);
		}
		resDTO.setRemain(ticksDO.getQuecn_appt() - ticksDO.getQuecn_used());//剩余数=可预约数-已使用数
		return resDTO;
	}

	/**
	 * 号段加号
	 * 
	 * @param schId 排班ID
	 * @param addEmpId 加号人员
	 * @param addNum 加号数量
	 * @param addEuTp 加号类型
	 * @return
	 * @throws BizException
	 */
	public ScSchTicksDO addTicket(String schId, String addEmpId, int addNum, Integer addEuTp) throws BizException {
		IScticksRService tksRService = ServiceFinder.find(IScticksRService.class);
		String whereStr = String.format("%s.ID_SCH='%s' AND %s.FG_ACTIVE = '%s'", ScSchTicksDODesc.TABLE_ALIAS_NAME,
				schId, ScSchTicksDODesc.TABLE_ALIAS_NAME, "Y");
		String orderStr = String.format("%s.QUENO_B DESC", ScSchTicksDODesc.TABLE_ALIAS_NAME);
		ScSchTicksDO[] scSchTicksDOs = tksRService.find(whereStr, orderStr, FBoolean.FALSE);
		if (ArrayUtil.isEmptyNoNull(scSchTicksDOs)) {
			throw new BizException(IScMsgConst.ERROR_SCH_TICKS_NOT_EXISTS);
		}

		// 修改号段
		ScSchTicksDO ticksDO = scSchTicksDOs[0];
		ticksDO.setStatus(DOStatus.UPDATED);
		ticksDO.setQuecn((ticksDO.getQuecn() != null ? ticksDO.getQuecn() : 0) + addNum);
		ticksDO.setQuecn_appt((ticksDO.getQuecn_appt() != null ? ticksDO.getQuecn_appt() : 0) + addNum);
		ticksDO.setFg_used(new FBoolean(ticksDO.getQuecn_used() > (ticksDO.getQuecn_appt() - 1)));
		ticksDO.setFg_add(FBoolean.TRUE);
		IScticksCudService tksCudService = ServiceFinder.find(IScticksCudService.class);
		scSchTicksDOs = tksCudService.save(new ScSchTicksDO[] { ticksDO });
		return scSchTicksDOs[0];
	}

	/**
	 * 号段加号
	 * 
	 * @param schId 排班ID
	 * @param addEmpId 加号人员
	 * @param addNum 加号数量
	 * @param addEuTp 加号类型
	 * @return
	 * @throws BizException
	 */
	public ScSchTicksDO subTicket(String schId, String addEmpId, int addNum, Integer addEuTp) throws BizException {
		IScticksRService tksRService = ServiceFinder.find(IScticksRService.class);
		String whereStr = String.format("%s.ID_SCH='%s' AND %s.FG_ACTIVE = '%s'", ScSchTicksDODesc.TABLE_ALIAS_NAME,
				schId, ScSchTicksDODesc.TABLE_ALIAS_NAME, "Y");
		String orderStr = String.format("%s.QUENO_B DESC", ScSchTicksDODesc.TABLE_ALIAS_NAME);
		ScSchTicksDO[] scSchTicksDOs = tksRService.find(whereStr, orderStr, FBoolean.FALSE);
		if (ArrayUtil.isEmptyNoNull(scSchTicksDOs)) {
			throw new BizException(IScMsgConst.ERROR_SCH_TICKS_NOT_EXISTS);
		}
		// 修改号段
		ScSchTicksDO ticksDO = scSchTicksDOs[0];
		ticksDO.setStatus(DOStatus.UPDATED);
		ticksDO.setQuecn(ticksDO.getQuecn() - addNum);
		ticksDO.setQuecn_appt(ticksDO.getQuecn_appt() - addNum);
		ticksDO.setFg_used(new FBoolean(ticksDO.getQuecn_used() > (ticksDO.getQuecn_appt() - 1)));
		ticksDO.setFg_add(FBoolean.TRUE);
		IScticksCudService tksCudService = ServiceFinder.find(IScticksCudService.class);
		tksCudService.save(new ScSchTicksDO[] { ticksDO });
		return ticksDO;
	}

	/**
	 * 占用
	 * 
	 * @param ticksectId 号段id
	 * @return 号段DO
	 * @throws BizException
	 */
	public ScSchTicksDO occupy(String ticksectId) throws BizException {
		ScSchTicksDO tickSectDO = (ScSchTicksDO) new DAFacade().findByPK(ScSchTicksDO.class, ticksectId);
		// changed by zhengcm 2018-04-24 去掉fg_used的判断
		// if (FBoolean.TRUE.equals(tickSectDO.getFg_used())) {
		if (tickSectDO.getQuecn_appt() - tickSectDO.getQuecn_used() <= 0) {
			throw new BizException(IScMsgConst.ERROR_SCH_TICKS_USED_UP);// 如果已经用完，则抛异常
		}
		return this.occupy(tickSectDO);
	}
	/**
	 * 占用
	 * 
	 * @param ticksectId 号段id
	 * @return 号段DO
	 * @throws BizException
	 */
	public ScSchTicksDO occupy4Auto(String ticksectId) throws BizException {
		ScSchTicksDO tickSectDO = (ScSchTicksDO) new DAFacade().findByPK(ScSchTicksDO.class, ticksectId);
		// changed by zhengcm 2018-04-24 去掉fg_used的判断
		// if (FBoolean.TRUE.equals(tickSectDO.getFg_used())) {
		if (tickSectDO.getQuecn_appt() - tickSectDO.getQuecn_used() <= 0) {
			return null;
		}
		return this.occupy4Auto(tickSectDO);
	}
	/**
	 * 占用--自动定位可预约排班日期使用
	 * 
	 * @param ticksectId 号段id
	 * @return 号段DO
	 * @throws BizException
	 */
	public ScSchTicksDO occupy4AutoLocate(String ticksectId) throws BizException {
		ScSchTicksDO tickSectDO = (ScSchTicksDO) new DAFacade().findByPK(ScSchTicksDO.class, ticksectId);
		// changed by zhengcm 2018-04-24 去掉fg_used的判断
		// if (FBoolean.TRUE.equals(tickSectDO.getFg_used())) {
		if (tickSectDO.getQuecn_appt() - tickSectDO.getQuecn_used() <= 0) {
			return null;
		}
		return tickSectDO;
	}
	/**
	 * 根据排班id占号段
	 * 
	 * @param schId 排班id
	 * @param scchlId 渠道id
	 * @return
	 * @throws BizException
	 */
	public ScSchTicksDO occupyBySchId(String schId, String scchlId,String idEnttp,Map<Integer,Integer> polcnMap,MtResDTO resDTO,String idSrv) throws BizException {
		Tick4MtAptEP tickEP = new Tick4MtAptEP();
		ScSchTickDO schTickDO = tickEP.getCanUseMinTickBySchId(schId, scchlId,idEnttp,polcnMap,resDTO,idSrv);
		if(schTickDO == null){
			if (resDTO.getFg_stop_daysmsgs().booleanValue()) {
				return null;
			}else{
				throw new BizException(IScMsgConst.ERROR_SCH_TICK_NOT_ENOUGH);
			}
		}
		if(ScValidator.isEmptyIgnoreBlank(schTickDO.getId_ticks()))
			throw new BizException("可用号段为空！");
		ScSchTicksDO tickSectDO = (ScSchTicksDO) new DAFacade().findByPK(ScSchTicksDO.class, 
				schTickDO.getId_ticks());
		if (tickSectDO == null)
			throw new BizException("可用号段为空！");
		return this.occupy(tickSectDO);
	}
	/**
	 * 根据排班id占号段
	 * 
	 * @param schId 排班id
	 * @param scchlId 渠道id
	 * @return
	 * @throws BizException
	 */
	public ScSchTicksDO occupyBySchId4Auto(String schId, String scchlId,String idEnttp,Map<Integer,Integer> polcnMap,MtResDTO resDTO,String idSrv) throws BizException {
		Tick4MtAptEP tickEP = new Tick4MtAptEP();
		ScSchTickDO schTickDO = tickEP.getCanUseMinTickBySchId4Auto(schId, scchlId,idEnttp,polcnMap,resDTO,idSrv);
		if(schTickDO == null){
			return null;
		}
		if(ScValidator.isEmptyIgnoreBlank(schTickDO.getId_ticks()))
			return null;
		ScSchTicksDO tickSectDO = (ScSchTicksDO) new DAFacade().findByPK(ScSchTicksDO.class, 
				schTickDO.getId_ticks());
		if (tickSectDO == null)
			return null;
		return this.occupy4Auto(tickSectDO);
	}
	/**
	 * 根据排班id占号段--自动定位可预约排班日期
	 * 
	 * @param schId 排班id
	 * @param scchlId 渠道id
	 * @return
	 * @throws BizException
	 */
	public ScSchTicksDO occupyBySchId4AutoLocate(String schId, String scchlId,String idEnttp,Map<Integer,Integer> polcnMap,MtResDTO resDTO,String idSrv) throws BizException {
		Tick4MtAptEP tickEP = new Tick4MtAptEP();
		ScSchTickDO schTickDO = tickEP.getCanUseMinTickBySchId4Auto(schId, scchlId,idEnttp,polcnMap,resDTO,idSrv);
		if(schTickDO == null){
			return null;
		}
		if(ScValidator.isEmptyIgnoreBlank(schTickDO.getId_ticks()))
			return null;
		ScSchTicksDO tickSectDO = (ScSchTicksDO) new DAFacade().findByPK(ScSchTicksDO.class, 
				schTickDO.getId_ticks());
		if (tickSectDO == null)
			return null;
		return tickSectDO;
	}
	/**
	 * 获取可用号段 本次排班有剩余号源
	 * 
	 * @param schId 排班id
	 * @return
	 * @throws BizException
	 */
	private ScSchTicksDO[] getAvlTicks(String schId) throws BizException {
		IScticksRService ticksRService = ServiceFinder.find(IScticksRService.class);
		String whereStr = String.format("id_sch='%s' and (QUECN_APPT -  NVL(QUECN_USED, 0))>0", schId);
		String orderStr = "T_B";
		ScSchTicksDO[] tiksDOs = ticksRService.find(whereStr, orderStr, FBoolean.TRUE);
		return tiksDOs;
	}

	/**
	 * 占用
	 * 
	 * @param tickSectDO 号段DO
	 * @return 号段DO
	 * @throws BizException
	 */
	public ScSchTicksDO occupy(ScSchTicksDO tickSectDO) throws BizException {
		// 如果已经用完，则抛异常 changed by zhengcm 2018-04-24 去掉对fg_used的判断
		// if (tickSectDO.getFg_used().booleanValue() || (tickSectDO.getQuecn_appt() - tickSectDO.getQuecn_used()) <= 0)
		// {
		if (tickSectDO.getQuecn_appt() - tickSectDO.getQuecn_used() <= 0) {
			throw new BizException(IScMsgConst.ERROR_SCH_TICKS_USED_UP);
		}

		// 占用一个号
		if (tickSectDO.getQuecn_used() == null)
			tickSectDO.setQuecn_used(0);
		tickSectDO.setQuecn_used(tickSectDO.getQuecn_used() + 1);// 更新已使用总数
		FBoolean fg_used = new FBoolean(tickSectDO.getQuecn_used() >= tickSectDO.getQuecn_appt());// 是否已经用完
		tickSectDO.setFg_used(fg_used);
		tickSectDO.setStatus(DOStatus.UPDATED);
//		return this.update(new ScSchTicksDO[]{tickSectDO})[0];
		this.save(tickSectDO);
		//new DAFacade().updateDO(tickSectDO);
		return tickSectDO;
	}
	/**
	 * 占用
	 * 
	 * @param tickSectDO 号段DO
	 * @return 号段DO
	 * @throws BizException
	 */
	public ScSchTicksDO occupy4Auto(ScSchTicksDO tickSectDO) throws BizException {
		// 如果已经用完，则抛异常 changed by zhengcm 2018-04-24 去掉对fg_used的判断
		// if (tickSectDO.getFg_used().booleanValue() || (tickSectDO.getQuecn_appt() - tickSectDO.getQuecn_used()) <= 0)
		// {
		if (tickSectDO.getQuecn_appt() - tickSectDO.getQuecn_used() <= 0) {
			return null;
		}

		// 占用一个号
		if (tickSectDO.getQuecn_used() == null)
			tickSectDO.setQuecn_used(0);
		tickSectDO.setQuecn_used(tickSectDO.getQuecn_used() + 1);// 更新已使用总数
		FBoolean fg_used = new FBoolean(tickSectDO.getQuecn_used() >= tickSectDO.getQuecn_appt());// 是否已经用完
		tickSectDO.setFg_used(fg_used);
		tickSectDO.setStatus(DOStatus.UPDATED);
//		return this.update(new ScSchTicksDO[]{tickSectDO})[0];
		this.save(tickSectDO);
		//new DAFacade().updateDO(tickSectDO);
		return tickSectDO;
	}
	/**
	 * 退号
	 * 
	 * @param ticksectId 号段id
	 * @return 号段DO
	 * @throws BizException
	 */
	public ScSchTicksDO drawback(String ticksectId) throws BizException {
		return this.drawback(ticksectId, 1);
	}

	/**
	 * 退号 
	 * 
	 * @param ticksectId 号段id
	 * @return 号段DO
	 * @param tickAmt 号位数量
	 * @throws BizException
	 */
	public ScSchTicksDO drawback(String ticksectId, Integer tickAmt) throws BizException {
		ScSchTicksDO ticksDO = this.getTicksById(ticksectId);
		if (ticksDO == null) {
			throw new BizException(IScMsgConst.ERROR_SCH_TICKS_NOT_EXISTS);
		}
		ticksDO.setQuecn_used(ticksDO.getQuecn_used() - tickAmt);// 使用数减少
		ticksDO.setFg_used(new FBoolean(ticksDO.getQuecn_used() >= ticksDO.getQuecn()));// 是否用尽
		ticksDO.setStatus(DOStatus.UPDATED);
		return this.save(ticksDO);
	}

	/**
	 * 根据ID获取号段
	 * 
	 * @param ticksectId 号段ID
	 * @return
	 * @throws BizException
	 */
	public ScSchTicksDO getTicksById(String ticksectId) throws BizException {
		IScticksRService ticksRService = ServiceFinder.find(IScticksRService.class);
		ScSchTicksDO ticksDO = ticksRService.findById(ticksectId);
		return ticksDO;
	}

	/**
	 * 保存号段
	 * 
	 * @param ticksDO 号段
	 * @return
	 * @throws BizException
	 */
	public ScSchTicksDO save(ScSchTicksDO ticksDO) throws BizException {
		ScSchTicksDO[] ticksDOArray = this.save(new ScSchTicksDO[] { ticksDO });
		return ticksDOArray[0];
	}

	/**
	 * 保存号段
	 * 
	 * @param ticksDOs 号段集合
	 * @return 号段集合
	 * @throws BizException
	 */
	public ScSchTicksDO[] save(ScSchTicksDO[] ticksDOs) throws BizException {
		IScticksCudService ticksCudService = ServiceFinder.find(IScticksCudService.class);
		ScSchTicksDO[] ticksDOArray = ticksCudService.save(ticksDOs);
		return ticksDOArray;
	}
	/**
	 * 保存号段
	 * 
	 * @param ticksDOs 号段集合
	 * @return 号段集合
	 * @throws BizException
	 */
	public ScSchTicksDO[] update(ScSchTicksDO[] ticksDOs) throws BizException {
		IScticksCudService ticksCudService = ServiceFinder.find(IScticksCudService.class);
		ScSchTicksDO[] ticksDOArray = ticksCudService.update(ticksDOs);
		return ticksDOArray;
	}

	/**
	 * 号段排除计划服务
	 * 
	 * @param id_sch 排班id
	 * @param id_srv 计划对应的id_srv
	 * @return 如果只有计划对应的服务返回"" 返回号段所有服务
	 * @throws BizException
	 * @author ccj
	 */
	public String getAllSrvName(String id_sch, String id_srv) throws BizException {
		if (StringUtil.isEmpty(id_sch) || StringUtil.isEmpty(id_srv))
			return "";
		StringBuffer stringBuffer = new StringBuffer();
		SqlParam sqlParam = new SqlParam();
		stringBuffer.append(
				"select distinct srv.name as srv_name  from sc_ticks ticks inner join SC_SRV srv on  ticks.id_scsrv = srv.id_scsrv and ticks.id_sch = ? ");
		stringBuffer.append(" and srv.id_scsrv <> ? ");
		sqlParam.addParam(id_sch);
		sqlParam.addParam(id_srv);
		List list = (List) new DAFacade().execQuery(stringBuffer.toString(), sqlParam, new MapListHandler());
		if (ListUtil.isEmpty(list))
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
	 * 根据条件获取排班号段
	 *
	 * @param cond
	 * @param order
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public ScSchTicksDO[] getTicksByCond(String cond, String order) throws BizException {
		if (StringUtil.isEmptyWithTrim(cond)) {
			return null;
		}
		IScticksRService tksRService = ServiceFinder.find(IScticksRService.class);
		return tksRService.find(cond, order, FBoolean.FALSE);
	}

	/**
	 * 删除排班对应的号段和号位
	 * 
	 * @param schIdList 排班ids
	 * @throws DAException
	 */
	public void deleteTicksBySchIds(List<String> schIdList) throws DAException {
		if (ListUtil.isEmpty(schIdList)) {
			return;
		}
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("  delete from sc_ticks  where id_sch in(");
		stringBuffer.append(ScSqlUtils.buildIdStr(schIdList));
		stringBuffer.append(")");

		new DAFacade().execUpdate(stringBuffer.toString());

		Tick4MtAptEP tickEP = new Tick4MtAptEP();
		tickEP.deleteTickBySchIds(schIdList);
	}
	/**
	 * 作废号段票号
	 * 
	 * @param tickDOs 票号集合
	 * @throws BizException
	 */
	public void revoke(ScSchTickDO[] tickDOs) throws BizException {
		Map<String, Integer> map = this.assemlyMap(tickDOs);
		if(map == null || map.isEmpty())
			return;
		@SuppressWarnings("unchecked")
		List<ScSchTicksDO> ticksDOs = (List<ScSchTicksDO>) new DAFacade().findByPKs(ScSchTicksDO.class, 
				map.keySet().toArray(new String[0]));
		if(ListUtil.isEmpty(ticksDOs))
			return;
		for(ScSchTicksDO ticksDO : ticksDOs){
			Integer tickAmt = map.get(ticksDO.getId_ticks());
			ticksDO.setQuecn(ticksDO.getQuecn() - tickAmt);//总数减少
			ticksDO.setQuecn_appt(ticksDO.getQuecn_appt() - tickAmt);// 可使用数减少
			ticksDO.setQuecn_used(ticksDO.getQuecn_used() - tickAmt);// 已使用数减少
			ticksDO.setFg_used(new FBoolean(ticksDO.getQuecn_used() >= ticksDO.getQuecn()));// 是否用尽
			ticksDO.setStatus(DOStatus.UPDATED);
		}
		this.save(ticksDOs.toArray(new ScSchTicksDO[0]));
	}
	/**
	 * 根据号位信息组装号段和数量关系字典
	 * 
	 * @param tickDOs
	 * @return
	 */
	public Map<String, Integer> assemlyMap(ScSchTickDO[] tickDOs){
		if(ArrayUtil.isEmpty(tickDOs))
			return null;
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(ScSchTickDO tickDO : tickDOs){
			if(ScValidator.isEmptyIgnoreBlank(tickDO.getId_ticks()))
				continue;
			if(map.containsKey(tickDO.getId_ticks())){
				Integer value = map.get(tickDO.getId_ticks());
				map.remove(tickDO.getId_ticks());
				map.put(tickDO.getId_ticks(), value + 1);
			}else
				map.put(tickDO.getId_ticks(), 1);
		}
		return map;
	}
}
