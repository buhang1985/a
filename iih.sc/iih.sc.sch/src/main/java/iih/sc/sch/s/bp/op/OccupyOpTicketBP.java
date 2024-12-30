package iih.sc.sch.s.bp.op;

import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScValidator;
import iih.sc.sch.s.ep.SchChlEP;
import iih.sc.sch.s.ep.TickChlEP;
import iih.sc.sch.s.ep.TickEP;
import iih.sc.sch.s.ep.TicksEP;
import iih.sc.sch.scsch.d.ScSchChlDO;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.scticks.d.ScSchTicksDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 占用门诊号源
 * 
 * @author liubin
 *
 */
public class OccupyOpTicketBP {
	/**
	 * 号段模式占用号段和号位
	 * （通过排班）
	 * @param schId 排班id
	 * @param scchlId 渠道id
	 * @return
	 * @throws BizException
	 */
	public ScSchTickDO occupyTicketOfTicksModeBySchId(String schId, String scchlId,FBoolean fg_uselock) throws BizException{
		SchChlEP scChlEp = new SchChlEP();
		ScSchChlDO[] scChls = scChlEp.getSchChl(schId, scchlId);
		if (ArrayUtil.isEmpty(scChls))
			throw new BizException("渠道:" + scchlId + "不存在！");
		TickEP tickEP = new TickEP();
		ScSchTickDO schTickDO = tickEP.getCanUseMinTickBySchId(schId, scchlId);
		if (schTickDO == null)
			throw new BizException(IScMsgConst.ERROR_SCH_TICK_NOT_ENOUGH);
		ScSchTickDO[] schTickDOs = tickEP.occupy(new ScSchTickDO[]{schTickDO}, scChls[0].getScpolcn(),fg_uselock);
		if(ArrayUtil.isEmpty(schTickDOs))
			throw new BizException("占用号位失败！");
		schTickDO = schTickDOs[0];
		if (ScValidator.isEmptyIgnoreBlank(schTickDO.getId_ticks()))
			throw new BizException("可用号段为空！");
		ScSchTicksDO tickSectDO = (ScSchTicksDO) new DAFacade().findByPK(ScSchTicksDO.class, schTickDO.getId_ticks());
		if (tickSectDO == null)
			throw new BizException("可用号段为空！");
		TicksEP ticksEP = new TicksEP();
		ticksEP.occupy(tickSectDO);
		return schTickDO;
	}
	/**
	 * 号段模式占用号段和号位
	 * （通过选定号段）
	 * @param schId
	 * @param ticksId
	 * @param scchlId
	 * @return
	 * @throws BizException
	 */
	public ScSchTickDO occupyTicketOfTicksModeBySchId(String schId, String ticksId, String scchlId,FBoolean fg_uselock) throws BizException{
		SchChlEP scChlEp = new SchChlEP();
		ScSchChlDO[] scChls = scChlEp.getSchChl(schId, scchlId);
		if (ArrayUtil.isEmpty(scChls))
			throw new BizException("渠道:" + scchlId + "不存在！");
		TickChlEP tickChlEp = new TickChlEP();
		ScSchTickDO schTickDO = tickChlEp.occupyByTicksId(ticksId, scChls[0].getScpolcn(), scchlId);
		if (schTickDO == null) {
			throw new BizException(IScMsgConst.ERROR_SCH_TICK_NOT_ENOUGH);
		}
		ScSchTicksDO tickSectDO = (ScSchTicksDO) new DAFacade().findByPK(ScSchTicksDO.class, schTickDO.getId_ticks());
		if (tickSectDO == null)
			throw new BizException("可用号段为空！");
		TicksEP ticksEP = new TicksEP();
		ticksEP.occupy(tickSectDO);
		return schTickDO;
	}
	/**
	 * 号位模式占用号位
	 * （通过排班）
	 * @param schId 排班id
	 * @param scchlId 渠道id
	 * @return
	 * @throws BizException
	 */
	public ScSchTickDO occupyTicketOfTickModeBySchId(String schId, String scchlId,FBoolean fg_uselock) throws BizException{
		SchChlEP scChlEp = new SchChlEP();
		ScSchChlDO[] scChls = scChlEp.getSchChl(schId, scchlId);
		if (ArrayUtil.isEmpty(scChls))
			throw new BizException("渠道:" + scchlId + "不存在！");
		TickEP tickEP = new TickEP();
		ScSchTickDO schTickDO = tickEP.getCanUseMinTickBySchId(schId, scchlId);
		if (schTickDO == null)
			throw new BizException(IScMsgConst.ERROR_SCH_TICK_NOT_ENOUGH);
		ScSchTickDO[] schTickDOs = tickEP.occupy(new ScSchTickDO[]{schTickDO}, scChls[0].getScpolcn(),fg_uselock);
		if(ArrayUtil.isEmpty(schTickDOs))
			throw new BizException("占用号位失败！");
		return schTickDOs[0];
	}
	/**
	 * 号位模式占用号位
	 * （通过选定号位）
	 * @param schId
	 * @param tickId
	 * @param scchlId
	 * @return
	 * @throws BizException
	 */
	public ScSchTickDO occupyTicketOfTickModeBySchId(String schId, String tickId, String scchlId) throws BizException{
		return null;
	}
}
