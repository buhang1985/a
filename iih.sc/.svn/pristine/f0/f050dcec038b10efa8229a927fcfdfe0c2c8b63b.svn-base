package iih.sc.sch.s.bp;

import iih.sc.comm.ScValidator;
import iih.sc.sch.s.ep.SchEP;
import iih.sc.sch.s.ep.TickChlEP;
import iih.sc.sch.s.ep.TickEP;
import iih.sc.sch.sctick.d.ScSchTickDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 占用多个号位
 * 
 * @author yank
 *
 */
public class OccupyMultTickBP {
	/**
	 * 占用号位
	 * 
	 * @param tickId 号位id
	 * @param polcn 号源池编号，0-9，默认为0
	 * @return 号位DO
	 * @throws BizException 异常
	 */
	public ScSchTickDO[] exec(ScSchTickDO[] tickDOs, Integer polcn) throws BizException {
		ScValidator.validateParam("tickDOs", tickDOs);
		ScValidator.validatPolcn(polcn);

		// 当前排班加锁 add by zhengcm 2018-03-14
		new TickChlEP().lockSch(tickDOs[0].getId_sch());

		// 1、占用号位
		TickEP tickBP = new TickEP();
		ScSchTickDO[] tickDOArray = tickBP.occupy(tickDOs, polcn,FBoolean.FALSE);

		// 2、如果是号段，则需占用号段
		// if(!StringUtil.isEmpty(tickDOs[0].getId_ticks())){
		// TicksEP ticksBP = new TicksEP();
		// ticksBP.occupy(tickDOs[0].getId_ticks());//号段模式暂时不支持占用多个号位
		// }

		// 3、占用排班号源
		SchEP schBP = new SchEP();
		schBP.occupyTick(tickDOs[0].getId_sch(), polcn, tickDOs.length);

		return tickDOArray;
	}
}
