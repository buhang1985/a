package iih.sc.sch.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScContextUtils;
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

/**保存排班号位
 * @author ccj
 *
 */
public class SaveSchTickBp {
	
	/**保存排班号位
	 * @param beginTime  开始时间
	 * @param endTime  结束时间
	 * @param id_sch  排班id
	 * @param total 总数
	 * @param total_appt  总可预约数
	 * @param beginTicket  开始票号
	 * @param endTicket  结束票号
	 * @param id_dayslot  日期分组时段id
	 * @param id_ticks  号段id
	 * @param sd_schrule 规则编码
	 * @return  ScSchTickDO[]
	 * @throws BizException
	 */
	public List<ScSchTickDO> exec(FTime beginTime,FTime endTime,String id_sch,Integer total,Integer total_appt,Integer beginTicket,Integer endTicket,String id_ticks,String sd_schrule) throws BizException{
		if(beginTime == null || endTime == null || StringUtils.isEmpty(id_sch) || total == null || total == 0
				|| total_appt == null || beginTicket == null || endTicket == null 
				|| StringUtils.isEmpty(sd_schrule)) return new ArrayList<ScSchTickDO>();
		List<ScSchTickDO> tickList = new ArrayList<ScSchTickDO>();
		long between = (endTime.getMillis() - beginTime.getMillis()) / 1000; //除以1000是为了毫秒转换成秒
	    long num = between/total; //平均一个号位多少秒
	    Integer addNumber = 0; // 加权预约数
	    Integer totalAppt = total_appt;  // 总可预约数
	    for(int i = beginTicket;i <= endTicket;i++){
		   ScSchTickDO tickDO = new ScSchTickDO();
		   if(!StringUtils.isEmpty(id_ticks)){
			  // 号段id不为空
			  tickDO.setId_ticks(id_ticks); //  号段id 
			  //tickDO.setId_dayslotsec(id_dayslot); //日期分组时段id
		   }
		   tickDO.setEu_used(EuUseState.WY);   //使用标识
		   tickDO.setId_grp(ScContextUtils.getGrpId()); //集团
		   tickDO.setId_org(ScContextUtils.getOrgId()); //组织
		   tickDO.setEu_add(EuAddTickMod.ZCH);    //加号模式
		   tickDO.setId_sch(id_sch);
		   tickDO.setCode(Integer.toString(i));
		   tickDO.setName(i+"号");
		   tickDO.setQueno(i);
		   tickDO.setT_b(beginTime);
		   if(i == endTicket){
			   beginTime = endTime;
		   }else{
			   beginTime = ScAppUtils.addSecondsByFTime(beginTime,(int)num); 
		   }
		   tickDO.setT_e(beginTime);
		   switch (sd_schrule) {
			  case IScDictCodeConst.SCSCH_RULE_EVEN:
			  case IScDictCodeConst.SCSCH_RULE_ODD:
			     if(numberWhetherEven(totalAppt,addNumber,i,sd_schrule,tickDO).booleanValue()) addNumber++;
			     break;
			  case IScDictCodeConst.SCSCH_RULE_ALL:
				  tickDO.setEu_usescope(EuUseScope.APT);
				  break;
		   }
		   tickDO.setStatus(DOStatus.NEW);
		   tickDO.setFg_active(FBoolean.TRUE); // 启用标识
		   tickList.add(tickDO);
		}
		return tickList;
	}
	
	/**号位是否供预约使用
	 * @param totalAppt  总预约数
	 * @param addNumber	 //已经使用的预约数
	 * @param sd_schrule 预约规则  
	 * @param schTickDO  //号位do
	 * @return  true 是 false 不是
	 */
	private FBoolean numberWhetherEven(Integer totalAppt,Integer addNumber,Integer queno,String sd_schrule,ScSchTickDO schTickDO){
		 if((totalAppt-addNumber)>0){
			  if(IScDictCodeConst.SCSCH_RULE_EVEN.equals(sd_schrule) ? queno%2 == 0 : queno%2 == 1){
			     // 1 预约
				  schTickDO.setEu_usescope(EuUseScope.APT);
				 return FBoolean.TRUE;
			   }else{
				   // 2  登记
				   schTickDO.setEu_usescope(EuUseScope.REG);
				   return FBoolean.FALSE;
			   }
		   }else{
			  //可预约数设置完后其余全部为登记
			   schTickDO.setEu_usescope(EuUseScope.REG);
			   return FBoolean.FALSE;
		   }
	}
}
