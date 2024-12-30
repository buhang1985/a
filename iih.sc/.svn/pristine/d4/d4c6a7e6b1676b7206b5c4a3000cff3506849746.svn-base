package iih.sc.sch.s.bp;

import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScValidator;
import iih.sc.sch.s.ep.SchEP;
import iih.sc.sch.s.ep.TickChlEP;
import iih.sc.sch.s.ep.TickEP;
import iih.sc.sch.s.ep.TicksEP;
import iih.sc.sch.sctick.d.ScSchTickDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;

/**
 * 占用特定的号位
 * 
 * @author yank
 *
 */
public class OccupyTickBP {
	/**
	 * 占用号位
	 * 
	 * @param tickId 号位id
	 * @param polcn 号源池编号，0-9，默认为0
	 * @return 号位DO
	 * @throws BizException 异常
	 */
	public ScSchTickDO exec(String tickId, Integer polcn) throws BizException {
		ScValidator.validateParam("tickId", tickId);
		if (polcn == null || polcn < 0 || polcn > 10) {
			throw new BizException(IScMsgConst.ERROR_SC_SCH_POLCN_OUT_OF_RANGE);
		}

		// 1、占用号位
		TickEP tickBP = new TickEP();
		ScSchTickDO tickDO = tickBP.occupy(tickId, polcn);

		// 当前排班加锁 add by zhengcm 2018-03-14
		new TickChlEP().lockSch(tickDO.getId_sch());

		// 2、如果是号段，则需占用号段
		if (!StringUtil.isEmpty(tickDO.getId_ticks())) {
			TicksEP ticksBP = new TicksEP();
			ticksBP.occupy(tickDO.getId_ticks());
		}

		// 3、占用排班号源
		SchEP schBP = new SchEP();
		schBP.occupyTick(tickDO.getId_sch(), polcn);

		return tickDO;
	}
}
