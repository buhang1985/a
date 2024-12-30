package iih.sc.sch.s.bp;

import java.util.HashSet;
import java.util.Set;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.comm.DateTimeUtils;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScLogUtil;
import iih.sc.comm.ScValidator;
import iih.sc.sch.s.ep.SchEP;
import iih.sc.sch.s.ep.TickChlEP;
import iih.sc.sch.s.ep.TickEP;
import iih.sc.sch.s.ep.TicksEP;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.scticks.d.ScSchTicksDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;

/**
 * 退号BP
 * 
 * @author yank
 *
 */
public class DrawbackTicketBP {
	public DrawbackTicketBP() {

	}

	/**
	 * 退号
	 * 
	 * @param tickId 号位
	 * @throws BizException
	 */
	public void exec(final String tickId) throws BizException {
		ScValidator.validateParam("tickId", tickId);// 校验参数
		TickEP tickEP = new TickEP();
		ScSchTickDO tick = tickEP.getTickById(tickId);
		if(tick == null)
			throw new BizException(IScMsgConst.ERROR_SCH_TICK_NOT_EXISTS);
		SchEP schEP = new SchEP();
		ScSchDO sch = schEP.getByPK(tick.getId_sch());
		if(sch == null)
			throw new BizException(IScMsgConst.ERROR_SC_SCH_NOT_EXISTS);
		if(IScDictCodeConst.SD_TICKMD_TIME.equals(sch.getSd_tickmd()))
			drawBackTimeMd(sch.getId_sch(), tick);
		else
			drawBackTicks(sch.getId_sch(), tickId);
	}
	/**
	 * 时间片模式退号
	 * 
	 * @author liubin
	 * 
	 * @param id_sch
	 * @param id_tick
	 * @throws BizException
	 */
	private void drawBackTimeMd(String id_sch, ScSchTickDO tick) throws BizException {
		TickEP tickEP = new TickEP();
		ScSchTickDO[] tickDOs = tickEP.getTickByCond(String.format("Id_ticks = '%s'", tick.getId_ticks()), null);
		if (ArrayUtil.isEmpty(tickDOs)) {
			throw new BizException(IScMsgConst.ERROR_SCH_TICK_NOT_EXISTS);
		}
		// 当前排班加锁 
		new TickChlEP().lockSch(tickDOs[0].getId_sch());
		if(tickDOs.length == 1){//号段只对应一个号位
			//号段合并
			mergeTicks(id_sch, tick.getId_ticks());
			//退还排班号源
			this.drawbackSch(id_sch, tick.getPolno_used(), DateTimeUtils.getMins(tick.getT_b(), tick.getT_e()));
		}
		//删除号位
		tick.setStatus(DOStatus.DELETED);
		tickEP.save(tick);
	}
	/**
	 * 号段号位模式退号
	 * 
	 * @author liubin
	 * 
	 * @param id_sch
	 * @param id_tick
	 * @throws BizException
	 */
	private void drawBackTicks(String id_sch, String id_tick) throws BizException {
		ScLogUtil.getInstance().logError("1.【DrawbackTicketBP_号段号位模式退号,开始】id_tick_"+id_tick+",id_sch_"+id_sch);
		// 获取占用票号
		TickEP tickEP = new TickEP();
		ScSchTickDO[] tickDOs = tickEP.getOccupiedTickList(id_tick);
		if (ArrayUtil.isEmpty(tickDOs)) {
			throw new BizException(IScMsgConst.ERROR_SCH_TICK_NOT_EXISTS);
		}
		ScLogUtil.getInstance().logError("2.【DrawbackTicketBP_号段号位模式退号,,获取号位信息】id_tick_"+id_tick+",id_sch_"+id_sch+"使用的号源池:"+tickDOs[0].getPolno_used()+"号段id:"+tickDOs[0].getId_ticks());
		int usedPolcn = tickDOs[0].getPolno_used();// 使用的号源池

		// 当前排班加锁 add by zhengcm 2018-03-14
		new TickChlEP().lockSch(tickDOs[0].getId_sch());
		ScLogUtil.getInstance().logError("3.【DrawbackTicketBP_号段号位模式退号,释放号位,开始】id_tick_"+id_tick+",id_sch_"+id_sch+"使用的号源池:"+tickDOs[0].getPolno_used());
		// 1、释放号位
		TickEP tickBP = new TickEP();
		tickBP.drawback(tickDOs);
		ScLogUtil.getInstance().logError("4.【DrawbackTicketBP_号段号位模式退号,退还号段资源,开始】id_tick_"+id_tick+",id_sch_"+id_sch+"使用的号源池:"+tickDOs[0].getPolno_used());
		// 2、如果是号段，则需退还号段资源
		TicksEP ticksBP = new TicksEP();
		for (ScSchTickDO tickDO : tickDOs) {
			if (!StringUtil.isEmpty(tickDO.getId_ticks()))
				ticksBP.drawback(tickDO.getId_ticks());
		}
		ScLogUtil.getInstance().logError("5.【DrawbackTicketBP_号段号位模式退号,退还排班资源,开始】id_tick_"+id_tick+",id_sch_"+id_sch+"使用的号源池:"+tickDOs[0].getPolno_used());
		// 3、退还排班号源
		drawbackSch(tickDOs[0].getId_sch(), usedPolcn, tickDOs.length);
		ScLogUtil.getInstance().logError("6.【DrawbackTicketBP_号段号位模式退号,结束】id_tick_"+id_tick+",id_sch_"+id_sch+"使用的号源池:"+tickDOs[0].getPolno_used());
	}
	/**
	 * 退还排班号源
	 * 
	 * @author liubin
	 * 
	 * @param id_sch
	 * @param polcn
	 * @param tickAmt
	 * @throws BizException
	 */
	private void drawbackSch(String id_sch, Integer polcn, Integer tickAmt) throws BizException{
		SchEP schEP = new SchEP();
		ScSchDO schDO = schEP.getByPK(id_sch);
		if (schDO == null) {
			throw new BizException(IScMsgConst.ERROR_SC_SCH_NOT_EXISTS);
		}
		schEP.drawbackTick(schDO, polcn, tickAmt);
	}
	/**
	 * 合并号段
	 * 
	 * @author liubin
	 * 
	 * @param id_ticks
	 * @throws BizException
	 */
	private void mergeTicks(String id_sch, String id_ticks) throws BizException{
		if(ScValidator.isEmptyIgnoreBlank(id_ticks))
			throw new BizException(IScMsgConst.ERROR_SCH_TICKS_NOT_EXISTS);
		TicksEP ticksEP = new TicksEP();
		ScSchTicksDO[] ticksDOs = ticksEP.getTicksByCond(String.format("Id_sch = '%s'", id_sch), ScSchTicksDO.T_B);
		if (ArrayUtil.isEmpty(ticksDOs)) {
			throw new BizException(IScMsgConst.ERROR_SCH_TICKS_NOT_EXISTS);
		}
		ScSchTicksDO preTicksDO = null;//前一个号段,p
		ScSchTicksDO nextTicksDO = null;//后一个号段
		ScSchTicksDO curTicksDO = null;//当前
		boolean isOtherUsed = false;//除id_ticks是否有被使用号段
		int len = ticksDOs.length;
		for(int i=0; i<len; i++){
			ScSchTicksDO temp = ticksDOs[i];
			if(id_ticks.equals(temp.getId_ticks())){
				curTicksDO = temp;
				if(i != 0){
					if(!FBoolean.TRUE.equals(ticksDOs[i-1].getFg_used()))
						preTicksDO = ticksDOs[i-1];
				}
				if(i != len - 1){
					if(!FBoolean.TRUE.equals(ticksDOs[i+1].getFg_used()))
						nextTicksDO = ticksDOs[i+1];
				}
			}else{
				if(FBoolean.TRUE.equals(temp.getFg_used()))
					isOtherUsed = true;
			}
		}
		if(!isOtherUsed){//除id_ticks外未被使用
			//删除所有号段
			for(ScSchTicksDO ticksDO : ticksDOs)
				ticksDO.setStatus(DOStatus.DELETED);
			ticksEP.save(ticksDOs);
			return;
		}
		if(curTicksDO == null)
			throw new BizException(IScMsgConst.ERROR_SCH_TICKS_NOT_EXISTS);
		Set<ScSchTicksDO> saveTicksList = new HashSet<ScSchTicksDO>();
		if(preTicksDO != null && nextTicksDO != null){
			curTicksDO.setStatus(DOStatus.DELETED);
			saveTicksList.add(curTicksDO);
			nextTicksDO.setStatus(DOStatus.DELETED);
			saveTicksList.add(nextTicksDO);
			preTicksDO.setStatus(DOStatus.UPDATED);
			preTicksDO.setT_e(nextTicksDO.getT_e());
			saveTicksList.add(preTicksDO);
		}else if(preTicksDO ==null && nextTicksDO == null){
			curTicksDO.setStatus(DOStatus.UPDATED);
			curTicksDO.setFg_used(FBoolean.FALSE);
			curTicksDO.setQuecn_used(0);
			saveTicksList.add(curTicksDO);
		}else{
			curTicksDO.setStatus(DOStatus.DELETED);
			saveTicksList.add(curTicksDO);
			if(nextTicksDO == null){
				preTicksDO.setStatus(DOStatus.UPDATED);
				preTicksDO.setT_e(curTicksDO.getT_e());
				saveTicksList.add(preTicksDO);
			}
			if(preTicksDO == null){
				nextTicksDO.setStatus(DOStatus.UPDATED);
				nextTicksDO.setT_b(curTicksDO.getT_b());
				saveTicksList.add(nextTicksDO);
			}
		}
		ticksEP.save(saveTicksList.toArray(new ScSchTicksDO[0]));
	}
}
