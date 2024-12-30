package iih.sc.sch.s.bp;

import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScValidator;
import iih.sc.sch.s.ep.SchEP;
import iih.sc.sch.s.ep.TickChlEP;
import iih.sc.sch.s.ep.TickEP;
import iih.sc.sch.s.ep.TicksEP;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.sctick.d.EuUseState;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.scticks.d.ScSchTicksDO;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 作废号源并补号
 * 
 * @author liubin
 *
 */
public class InvalidAndSupplyTicketBP {
	/**
	 * 作废号源并补号
	 * 
	 * @param tickId 号位
	 * @throws BizException
	 */
	public void exec(final String tickId) throws BizException {
		// 1.校验参数
		ScValidator.validateParam("tickId", tickId);// 校验参数
		// 2.获取已使用号位，包括占用号位
		ScSchTickDO[] tickDOs = this.getUsedTicks(tickId);

		// 当前排班加锁 add by zhengcm 2018-03-14
		new TickChlEP().lockSch(tickDOs[0].getId_sch());

		// 3.退还排班号源
		this.drawbackSch(tickDOs[0].getId_sch(), tickDOs[0].getPolno_used(), tickDOs.length);
		// 4.作废原号位
		this.invalidTickDOs(tickDOs);
		// 5.处理原号段
		this.invalidTicksDOs(tickDOs);
		// 6.号位和号段补号
		this.supplyTicket(tickDOs);
	}

	/**
	 * 获取已使用号位，包括占用号位
	 * 
	 * @param tickId
	 * @return
	 * @throws BizException
	 */
	private ScSchTickDO[] getUsedTicks(String tickId) throws BizException {
		TickEP tickEP = new TickEP();
		ScSchTickDO[] tickDOs = tickEP.getOccupiedTickList(tickId);
		if (tickDOs == null)
			throw new BizException(IScMsgConst.ERROR_SCH_TICK_NOT_EXISTS);
		return tickDOs;
	}

	/**
	 * 退还排班号源
	 * 
	 * @param schId 排班id
	 * @param polno 号源池
	 * @param tickAmt 号源数量
	 * @throws BizException
	 */
	private void drawbackSch(String schId, Integer polno, Integer tickAmt) throws BizException {
		SchEP schEP = new SchEP();
		ScSchDO schDO = schEP.getByPK(schId);
		if (schDO == null)
			throw new BizException(IScMsgConst.ERROR_SC_SCH_NOT_EXISTS);
		schEP.drawbackTick(schDO, polno, tickAmt);
	}

	/**
	 * 作废原号位
	 * 
	 * @param tickDOs
	 * @throws BizException
	 */
	private void invalidTickDOs(ScSchTickDO[] tickDOs) throws BizException {
		TickEP ep = new TickEP();
		ep.revoke(tickDOs);
	}

	/**
	 * 处理原号段信息
	 * 
	 * @param tickDOs
	 * @throws BizException
	 */
	private void invalidTicksDOs(ScSchTickDO[] tickDOs) throws BizException {
		TicksEP ep = new TicksEP();
		ep.revoke(tickDOs);
	}

	/**
	 * 号段号位补号
	 * 
	 * @param origTicks 原号位
	 * @throws BizException
	 */
	private void supplyTicket(ScSchTickDO[] origTicks) throws BizException {
		String schId = origTicks[0].getId_sch();
		String sql = "select top 1 * from (select tk.* from sc_tick tk where tk.id_sch = '" + schId
				+ "' order by queno desc) sc_tick ";
		@SuppressWarnings("unchecked")
		List<ScSchTickDO> scSchTicks = (List<ScSchTickDO>) new DAFacade().execQuery(sql, new BeanListHandler(
				ScSchTickDO.class));
		if (ListUtil.isEmpty(scSchTicks))
			throw new BizException(IScMsgConst.ERROR_SCH_TICK_NOT_EXISTS);
		ScSchTickDO scSchTick = scSchTicks.get(0);
		// 号位补号
		this.supplyScTick(origTicks, scSchTick);
		// 号段补号
		if (!StringUtil.isEmpty(scSchTick.getId_ticks()))
			this.supplyScTicks(scSchTick.getId_ticks(), origTicks.length);
	}

	/**
	 * 号位补号
	 * 
	 * @param scSchTick
	 * @param tickAmt
	 * @throws BizException
	 */
	private void supplyScTick(ScSchTickDO[] origTicks, ScSchTickDO scSchTick) throws BizException {
		Integer queno = scSchTick.getQueno();
		List<ScSchTickDO> list = new ArrayList<>();
		for (ScSchTickDO origTick : origTicks) {
			// 号位补号
			ScSchTickDO nTickDO = (ScSchTickDO) origTick.clone();
			nTickDO.setId_tick(null);// 清空ID
			nTickDO.setId_tick_occupier(null);// 占用为空
			nTickDO.setEu_used(EuUseState.WY);// 未用
			nTickDO.setQueno(++queno);
			nTickDO.setId_ticks(scSchTick.getId_ticks());
			nTickDO.setT_b(scSchTick.getT_b());
			nTickDO.setT_e(scSchTick.getT_e());
			nTickDO.setIds_scchl(null);
			nTickDO.setPolno(null);
			nTickDO.setPolno_used(null);
			nTickDO.setStatus(DOStatus.NEW);
			nTickDO.setFg_active(FBoolean.TRUE);
			list.add(nTickDO);
		}
		TickEP ep = new TickEP();
		ep.save(list.toArray(new ScSchTickDO[0]));
	}

	/**
	 * 号段补号
	 * 
	 * @param ticksId
	 * @param tickAmt
	 * @throws BizException
	 */
	private void supplyScTicks(String ticksId, int tickAmt) throws BizException {
		TicksEP ep = new TicksEP();
		ScSchTicksDO tks = ep.getTicksById(ticksId);
		if (tks == null)
			throw new BizException(IScMsgConst.ERROR_SCH_TICKS_NOT_EXISTS);
		tks.setStatus(DOStatus.UPDATED);
		tks.setQuecn((tks.getQuecn() != null ? tks.getQuecn() : 0) + tickAmt);
		tks.setQuecn_appt((tks.getQuecn_appt() != null ? tks.getQuecn_appt() : 0) + tickAmt);
		tks.setFg_used(new FBoolean(tks.getQuecn_used() >= tks.getQuecn_appt()));
		ep.save(tks);
	}
}
