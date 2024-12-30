package iih.sc.sch.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScValidator;
import iih.sc.sch.s.bp.op.OccupyOpTicketBP;
import iih.sc.sch.s.ep.SchEP;
import iih.sc.sch.s.ep.TickChlEP;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.sctick.d.ScSchTickDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 占用票号
 * @author yank
 *
 */
public class OccupyTickBySchBP {
	/**
	 * 占用号位最小号，如果没有可用资源抛异常
	 * @param schId 排班id
	 * @param polcn 号源池编号，0-9，默认为0
	 * @param ticksId 号段id，可为null
	 * @param scchlId 渠道id
	 * @return 号位
	 * @throws BizException 异常
	 */
	public ScSchTickDO exec(String schId,Integer polcn, String ticksId, String scchlId,FBoolean fg_uselock) throws BizException{
		//校验参数
		this.validateParam(schId, polcn, ticksId);
		
		TickChlEP tickEP = new TickChlEP();
		
		//获取票号模式
		String tickMd = this.getTickMode(schId);
		
		// 当前排班加锁
		tickEP.lockSch(schId);
		ScSchTickDO tickDO = null;
		OccupyOpTicketBP occupyBp = new OccupyOpTicketBP();
		//1、如果是号段，则需占用号段
		if(IScDictCodeConst.SD_TICKMD_TICKS.equals(tickMd)){
			if(!StringUtil.isEmpty(ticksId)){				
				//根据选定号段占用号段和号位
				tickDO  = occupyBp.occupyTicketOfTicksModeBySchId(schId, ticksId, scchlId,fg_uselock);
			}else{
				//根据排班占用号段和号位
				tickDO  = occupyBp.occupyTicketOfTicksModeBySchId(schId, scchlId,fg_uselock);
			}
		}else{
			//占用号位
			tickDO = occupyBp.occupyTicketOfTickModeBySchId(schId, scchlId,fg_uselock);
		}
		//3、占用排班号源
		SchEP schBP = new SchEP();
		schBP.occupyTick(schId,polcn);
		
		return tickDO;
	}
	/**
	 * 校验参数
	 * @param schId
	 * @param polcn
	 * @param ticksId
	 * @throws BizException
	 */
	private void validateParam(String schId,Integer polcn, String ticksId) throws BizException{
		//参数校验
		ScValidator.validateParam("schId", schId);
		if(polcn==null || polcn<0 || polcn>10){
			throw new BizException(IScMsgConst.ERROR_SC_SCH_POLCN_OUT_OF_RANGE);
		}		
	}
	/**
	 * 获取票号模式
	 * 
	 * @param schId
	 * @return
	 * @throws BizException
	 */
	private String getTickMode(String schId) throws BizException{
		ScSchDO schDO = (ScSchDO) new DAFacade().findByPK(ScSchDO.class, schId, 
				new String[]{ScSchDO.ID_SCH, ScSchDO.FG_ACTIVE, ScSchDO.SD_TICKMD});
		if(schDO==null){
			throw new BizException(IScMsgConst.ERROR_SC_SCH_NOT_EXISTS);
		}
		if(!FBoolean.TRUE.equals(schDO.getFg_active())){
			throw new BizException(IScMsgConst.SC_SCH_CLOSE);//停诊不能挂号
		}
		return schDO.getSd_tickmd();
	}
}
