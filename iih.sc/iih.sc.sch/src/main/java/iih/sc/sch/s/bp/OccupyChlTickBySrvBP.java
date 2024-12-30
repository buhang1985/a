package iih.sc.sch.s.bp;

import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScValidator;
import iih.sc.sch.s.ep.SchEP;
import iih.sc.sch.s.ep.TickChlEP;
import iih.sc.sch.s.ep.TicksEP;
import iih.sc.sch.sctick.d.ScSchTickDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;

/**
 * 按渠道根据服务占用号位BP
 * 
 * @author zhengcm
 * @date 2017-07-27 10:35:32
 *
 */
public class OccupyChlTickBySrvBP {
	/**
	 * 按渠道占用号位
	 * 
	 * @author zhengcm
	 *
	 * @param tickId 号位ID
	 * @param polcn 号源池
	 * @param srvId 服务ID
	 * @param chlId 渠道ID
	 * @return 号位DO
	 * @throws BizException
	 */
	public ScSchTickDO exec(String tickId, Integer polcn, String srvId, String chlId) throws BizException {
		ScValidator.validateParam("tickId", tickId);
		ScValidator.validateParam("srvId", srvId);
		ScValidator.validateParam("chlId", chlId);
		if (polcn == null || polcn < 0 || polcn > 10) {
			throw new BizException(IScMsgConst.ERROR_SC_SCH_POLCN_OUT_OF_RANGE);
		}

		// 1、占用号位
		ScSchTickDO tickDO = new TickChlEP().occupyTickBySrv(tickId, polcn, srvId, chlId);

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
