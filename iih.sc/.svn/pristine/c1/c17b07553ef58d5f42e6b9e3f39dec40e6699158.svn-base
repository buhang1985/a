package iih.sc.apt.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.i.IScschMDOCudService;
import iih.sc.sch.scsch.i.IScschMDORService;
import iih.sc.sch.sctick.d.EuUseScope;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.sctick.i.ISctickCudService;
import iih.sc.sch.sctick.i.ISctickRService;
import iih.sc.sch.scticks.d.ScSchTicksDO;
import iih.sc.sch.scticks.i.IScticksCudService;
import iih.sc.sch.scticks.i.IScticksRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class ReserveTickBP {
	
	/**
	 * 将号位设置成保留状态
	 * @author yaohl
	 * @param id_tick
	 * @throws BizException 
	 */
	public void exec(String id_tick) throws BizException{
		//1.获取号位DO
		ISctickRService tickRService = ServiceFinder.find(ISctickRService.class);
		ScSchTickDO tickDO = tickRService.findById(id_tick);
		if(tickDO != null){
			if(tickDO.getEu_used() == 1) {
				throw new BizException("该号位已被使用！" );
			}else{
				//2.获取排班
				IScschMDORService schRService = ServiceFinder.find(IScschMDORService.class);
				ScSchDO schDO = schRService.findById(tickDO.getId_sch());
			//3.更新排班
				this.saveSch(schDO, tickDO.getPolno());
			//4.更新号段|号位
				if(IScDictCodeConst.SD_TICKMD_TICKS.equals(schDO.getSd_tickmd())){
					this.saveTicks(tickDO.getId_ticks());
				this.saveTick(tickDO);
				}else if(IScDictCodeConst.SD_TICKMD_TICK.equals(schDO.getSd_tickmd())){
				this.saveTick(tickDO);
			}
			}
		}else{
			throw new BizException("号位信息不存在！");
		}
	}
	/**
	 * 更新排班
	 * @param id_sch
	 * @throws BizException 
	 */
	private void saveSch(ScSchDO schDO,Integer polno) throws BizException{
		if(schDO != null){
			ScSchDO scSchDO = new ScSchDO();
			if(polno != null){//设置了号源池渠道
				scSchDO = (ScSchDO) schDO.clone();
				scSchDO.setQuan_total_appt(schDO.getQuan_total_appt()-1);
				String quan_appt_attr = String.format("Quan%s_appt", polno);
				Integer quan_appt_polno = Integer.parseInt(schDO.getAttrVal(quan_appt_attr) == null ? "0" : schDO
						.getAttrVal(quan_appt_attr).toString());
				if(quan_appt_polno >= 1){
					scSchDO.setAttrVal(quan_appt_attr, quan_appt_polno-1);
				}
			}else{
				scSchDO = (ScSchDO) schDO.clone();
				scSchDO.setQuan_total_appt(schDO.getQuan_total_appt()-1);
				String quan_appt_attr = String.format("Quan%s_appt", 0);
				Integer quan_appt_polno = Integer.parseInt(schDO.getAttrVal(quan_appt_attr) == null ? "0" : schDO
						.getAttrVal(quan_appt_attr).toString());
				if(quan_appt_polno >= 1){
					scSchDO.setAttrVal(quan_appt_attr, quan_appt_polno-1);
				}
			}
			scSchDO.setStatus(DOStatus.UPDATED);
			IScschMDOCudService schCudService = ServiceFinder.find(IScschMDOCudService.class);
			schCudService.save(new ScSchDO[] { scSchDO });
		}else{
			throw new BizException("号位所在的排班不存在！");
		}
	}
	
	/**
	 * 更新号段
	 * @param id_ticks
	 */
	private void saveTicks(String id_ticks) throws BizException{
		IScticksRService scticksRService = ServiceFinder.find(IScticksRService.class);
		ScSchTicksDO scTicksDO = scticksRService.findById(id_ticks);
		ScSchTicksDO ticksDO = (ScSchTicksDO) scTicksDO.clone();
		if(scTicksDO.getQuecn_appt() != null && scTicksDO.getQuecn_appt() >= 1){
			ticksDO.setQuecn_appt(scTicksDO.getQuecn_appt()-1);
			if(scTicksDO.getQuecn_appt()-1 == 0){
				ticksDO.setFg_used(FBoolean.TRUE);
			}
		}
		ticksDO.setStatus(DOStatus.UPDATED);
		IScticksCudService scticksCudService = ServiceFinder.find(IScticksCudService.class);
		scticksCudService.save(new ScSchTicksDO[]{ ticksDO});
	}
	
	/**
	 * 更新号位
	 * @param tickDO
	 */
	private void saveTick(ScSchTickDO tickDO) throws BizException{
		ScSchTickDO clone = (ScSchTickDO) tickDO.clone();
		clone.setEu_usescope(EuUseScope.REG);
		clone.setStatus(DOStatus.UPDATED);
		ISctickCudService sctickCudService = ServiceFinder.find(ISctickCudService.class);
		sctickCudService.save(new ScSchTickDO[]{ clone});
	}
	
}
