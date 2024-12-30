package iih.sc.sch.s.bp;

import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScValidator;
import iih.sc.sch.s.ep.TickEP;
import iih.sc.sch.sctick.d.EuUseState;
import iih.sc.sch.sctick.d.ScSchTickDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;

/**
 * 
 * @author yaohl
 *
 */
public class CancAndPastTickBP {
	/**
	 * 
	 * @param tickId
	 *            号位
	 * @throws BizException
	 */
	public void exec(final String tickId) throws BizException {

		// 1.校验参数
		ScValidator.validateParam("tickId", tickId);

		// 2.获取已使用号位，包括占用号位
		ScSchTickDO tickDO = this.getUsedTicks(tickId);
		
		// 3.将当前号位设置为过期
		this.pastTick(tickDO );
	}

	/**
	 * 保存号位
	 * 
	 * @param tickDOs
	 * @throws BizException
	 */
	private void pastTick(ScSchTickDO tickDO) throws BizException {
		tickDO.setStatus(DOStatus.UPDATED);
		tickDO.setEu_used(EuUseState.GQ);
		TickEP tickEP = new TickEP();
		tickEP.save(tickDO);
	}

	/**
	 * 获取已使用号位，包括占用号位
	 * 
	 * @param tickId
	 * @return
	 * @throws BizException
	 */
	private ScSchTickDO getUsedTicks(String tickId) throws BizException {
		TickEP tickEP = new TickEP();
		ScSchTickDO tickDO = tickEP.getTickById(tickId);
		if (tickDO == null)
			throw new BizException(IScMsgConst.ERROR_SCH_TICK_NOT_EXISTS);
		return tickDO;
	}
}
