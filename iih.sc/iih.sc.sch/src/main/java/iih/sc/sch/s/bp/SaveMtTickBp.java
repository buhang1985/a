package iih.sc.sch.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScContextUtils;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.i.IScschMDORService;
import iih.sc.sch.sctick.d.EuAddTickMod;
import iih.sc.sch.sctick.d.EuUseScope;
import iih.sc.sch.sctick.d.EuUseState;
import iih.sc.sch.sctick.d.ScSchTickDO;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 保存医技号位
 * @author ccj
 *
 */
public class SaveMtTickBp {
	
	/**
	 * 保存医技号位
	 * @param beginTime  开始时间
	 * @param endTime  结束时间
	 * @param id_sch 排班id
	 * @param total 总数
	 * @param total_appt  总可预约数
	 * @param beginTicket  开始票号
	 * @param endTicket  结束票号
	 * @param id_ticks  号段id
	 * @param sd_schrule 规则编码
	 * @param id_srv 排班服务id
	 * @return  ScSchTickDO[]
	 * @throws BizException
	 */
	public List<ScSchTickDO> exec(FTime beginTime,FTime endTime,String id_sch,Integer total,Integer total_appt,Integer beginTicket,Integer endTicket,String id_ticks,String sd_schrule,String id_srv) throws BizException{
		if(beginTime == null || endTime == null || StringUtils.isEmpty(id_sch)|| beginTicket == null || endTicket == null 
				|| StringUtils.isEmpty(sd_schrule) || total == 0) return new ArrayList<ScSchTickDO>();
		List<ScSchTickDO> tickList = new ArrayList<ScSchTickDO>();
		IScschMDORService iScSchService = ServiceFinder.find(IScschMDORService.class);
		ScSchDO scSchDO = iScSchService.findById(id_sch);
	    Integer addNumber = 0; // 加权预约数
	    Integer totalAppt = total_appt;  // 总可预约数
	    for(int i = beginTicket;i <= endTicket;i++){
		   ScSchTickDO tickDO = new ScSchTickDO();
		   if(StringUtils.isNotEmpty(id_ticks)){
			  // 号段id不为空
			  tickDO.setId_ticks(id_ticks); //  号段id 
		   }
		   if(StringUtils.isNotEmpty(id_srv)){
			   tickDO.setId_scsrv(id_srv);
		   }
		   tickDO.setPolno_used(0); //使用号源池号
		   tickDO.setEu_used(EuUseState.WY);   //使用标识
		   tickDO.setId_grp(ScContextUtils.getGrpId()); //集团
		   tickDO.setId_org(ScContextUtils.getOrgId()); //组织
		   tickDO.setEu_add(EuAddTickMod.ZCH);    //加号模式
		   tickDO.setId_sch(scSchDO.getId_sch()); //排班id
		   tickDO.setQueno(i);  //票号
		   if(scSchDO.getSugest_num_tick() != null && scSchDO.getSugest_num_tick() > 0){
			   //粒度存在
			   Integer num_tick = scSchDO.getSugest_num_tick();  //粒度
			   Integer num_mint = scSchDO.getSugest_num_mint();	//粒度分钟数
			   Integer minute  = (int) (Math.floor((i-beginTicket+1) / num_tick) * num_mint);
			   tickDO.setT_b(ScAppUtils.addSecondsByFTime(beginTime, minute));
			   FTime tickEndTime = ScAppUtils.addMinutesByFTime(beginTime, num_mint);  //分粒度后的结束时间
			   if(tickEndTime.compareTo(endTime)>0){
				   tickDO.setT_e(endTime);
			   }else{
				   tickDO.setT_e(tickEndTime);
			   }
		   }else{
			   tickDO.setT_b(beginTime);
			   tickDO.setT_e(endTime);
		   }
		   switch (sd_schrule) {
			  case IScDictCodeConst.SCSCH_RULE_EVEN:
			  case IScDictCodeConst.SCSCH_RULE_ODD:
			     if(numberWhetherEven(totalAppt,addNumber,i,sd_schrule,tickDO).booleanValue()) addNumber++;
			     break;
		   }
		   tickDO.setStatus(DOStatus.NEW);
		   tickDO.setFg_active(FBoolean.TRUE); // 启用标识
		   tickList.add(tickDO);
		}
		return tickList;
	}
	
	/**
	 * 号位是否供预约使用
	 * @param totalAppt  总开放数
	 * @param addNumber	 //已经使用的开放数
	 * @param sd_schrule 预约规则  
	 * @param schTickDO  //号位do
	 * @return  true 是 false 不是
	 */
	private FBoolean numberWhetherEven(Integer totalAppt,Integer addNumber,Integer queno,String sd_schrule,ScSchTickDO schTickDO){
		 if((totalAppt-addNumber)>0){
			  if(IScDictCodeConst.SCSCH_RULE_EVEN.equals(sd_schrule) ? queno%2 == 0 : queno%2 == 1){
			      // 1 开放
				 schTickDO.setEu_usescope(EuUseScope.APT);
				 return FBoolean.TRUE;
			   }else{
				   // 2 预留
				   schTickDO.setEu_usescope(EuUseScope.REG);
				   return FBoolean.FALSE;
			   }
		   }else{
			  //开放数设置完后其余全部为预留
			   schTickDO.setEu_usescope(EuUseScope.REG);
			   return FBoolean.FALSE;
		   }
	}

}
