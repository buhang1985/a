package iih.sc.sch.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.comm.ScContextUtils;
import iih.sc.scbd.scapptrule.d.ScapptruleDO;
import iih.sc.scbd.scapptrule.i.IScapptruleRService;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.sctick.d.EuUseScope;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.scticks.d.ScSchTicksDO;
import iih.sc.scp.scpltick.d.ScPlanWeekTickDO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 根据号段设置号位数据
 * @author renying
 *
 */
public class SetTickDOBP {
	/**
	 * 根据号段设置号位数据--无计划
	 * @param ticksDO
	 * @param schdo
	 * @return
	 * @throws BizException
	 */
	public List<ScSchTickDO> setTickDos(ScSchTicksDO ticksDO, ScSchDO schdo) throws BizException{
		
		if(ticksDO.getQuecn()==null || ticksDO.getQuecn() ==0)
			return null;
		List<ScSchTickDO> tickList = new ArrayList<ScSchTickDO>();
		this.setTickValue(ticksDO, schdo,tickList);
		String sd_schrule = this.getSdApprule(schdo.getId_apptru());
		this.SetEu_usecope(ticksDO.getQuecn_appt(), tickList, sd_schrule);
		return tickList;
	}
	
	/**
	 * 设置有计划号位的值
	 * @param ticksDO
	 * @param schdo
	 * @param tickList
	 */
	public void setTickValueWithPlTick(ScSchTicksDO ticksDO, ScSchDO schdo,List<ScSchTickDO> tickList ){
		  
			FTime  dt_b =ticksDO.getT_b();
		    int suggestMin = schdo.getSugest_num_mint() == null ?0: schdo.getSugest_num_mint();
		    int suggestNum = schdo.getSugest_num_tick() == null ? 0:schdo.getSugest_num_tick();
			for(int i = 1; i<=ticksDO.getQuecn().intValue();i++){
				ScSchTickDO tickDO = tickList.get(i-1);
				tickDO.setStatus(DOStatus.NEW);
				tickDO.setId_grp(ScContextUtils.getGrpId());
				tickDO.setId_org(ScContextUtils.getOrgId());
				tickDO.setId_sch(schdo.getId_sch());
				tickDO.setId_ticks(ticksDO.getId_ticks());
				tickDO.setQueno(ticksDO.getQueno_b()+i-1);
				if(suggestMin == 0 || suggestNum == 0 ){//号数 分钟 
					tickDO.setT_b(ticksDO.getT_b());
					tickDO.setT_e(ticksDO.getT_e());							
				}else{
					 if(new FTime( dt_b.getMillis()+ suggestMin*60000) .getMillis() >=ticksDO.getT_e().getMillis() ){
						 tickDO.setT_b(dt_b);
						 tickDO.setT_e(ticksDO.getT_e());	
					 }
					 else if(i% suggestNum  == 0){												
						tickDO.setT_b(dt_b);
						tickDO.setT_e(new FTime(dt_b.getMillis()+ suggestMin*60000));	
						dt_b =new FTime( dt_b.getMillis()+ suggestMin*60000) ;		
					}else  {
						tickDO.setT_b(dt_b);
						tickDO.setT_e(new FTime(dt_b.getMillis()+ suggestMin*60000));		
					}
				}
				tickDO.setId_scsrv(ticksDO.getId_scsrv());
				tickDO.setFg_active(FBoolean.TRUE);
				tickDO.setEu_used(0);
				tickDO.setEu_add(0);// 加号标识						
				tickDO.setIds_kinditm(ticksDO.getIds_kinditm());
			}
			
	}

	/**
	 * 设置号位的值
	 * @param ticksDO
	 * @param schdo
	 * @param tickList
	 */
	private void setTickValue(ScSchTicksDO ticksDO, ScSchDO schdo,List<ScSchTickDO> tickList ){
		  
			FTime  dt_b =ticksDO.getT_b();
		    int suggestMin = schdo.getSugest_num_mint() == null ?0: schdo.getSugest_num_mint();
		    int suggestNum = schdo.getSugest_num_tick() == null ? 0:schdo.getSugest_num_tick();
			for(int i = 1; i<=ticksDO.getQuecn().intValue();i++){
				ScSchTickDO tickDO = new ScSchTickDO();
				tickDO.setStatus(DOStatus.NEW);
				tickDO.setId_grp(ScContextUtils.getGrpId());
				tickDO.setId_org(ScContextUtils.getOrgId());
				tickDO.setId_sch(schdo.getId_sch());
				tickDO.setId_ticks(ticksDO.getId_ticks());
				tickDO.setQueno(ticksDO.getQueno_b()+i-1);
				if(suggestMin == 0 || suggestNum == 0 ){//号数 分钟 
					tickDO.setT_b(ticksDO.getT_b());
					tickDO.setT_e(ticksDO.getT_e());							
				}else{
					 if(new FTime( dt_b.getMillis()+ suggestMin*60000) .getMillis() >=ticksDO.getT_e().getMillis() ){
						 tickDO.setT_b(dt_b);
						 tickDO.setT_e(ticksDO.getT_e());	
					 }
					 else if(i% suggestNum  == 0){												
						tickDO.setT_b(dt_b);
						tickDO.setT_e(new FTime(dt_b.getMillis()+ suggestMin*60000));	
						dt_b =new FTime( dt_b.getMillis()+ suggestMin*60000) ;		
					}else  {
						tickDO.setT_b(dt_b);
						tickDO.setT_e(new FTime(dt_b.getMillis()+ suggestMin*60000));		
					}
				}
				tickDO.setId_scsrv(ticksDO.getId_scsrv());
				tickDO.setFg_active(FBoolean.TRUE);
				tickDO.setEu_used(0);
				tickDO.setEu_add(0);// 加号标识						
				tickList.add(tickDO);
			}
			
	}
	/**
	 * 获取预约规则
	 * @param apprule
	 * @return
	 * @throws BizException
	 */
	private String  getSdApprule(String apprule) throws BizException{
		IScapptruleRService rservice = ServiceFinder.find(IScapptruleRService.class);
		ScapptruleDO ruleDO = rservice.findById(apprule);
		if(ruleDO == null || StringUtil.isEmptyWithTrim(ruleDO.getSd_schrule())){
			throw new BizException("未取到对应的规则");
		}
		return ruleDO.getSd_schrule();
	}
	
	/**号位是否供预约使用
	 * @param totalAppt  总预约数
	 * @param addNumber	 //已经使用的预约数
	 * @param sd_schrule 预约规则  
	 * @param schTickDO  //号位do
	 * @return  true 是 false 不是
	 */
	private void SetEu_usecope(Integer totalAppt, List<ScSchTickDO> tickList,String sd_schrule) {
		int i = 0;

		for (ScSchTickDO schTickDO : tickList) {
			if (i == totalAppt){
				schTickDO.setEu_usescope(EuUseScope.REG);
				continue;
			}
			switch (sd_schrule) {
				case IScDictCodeConst.SCSCH_RULE_EVEN:
					i = this.SetEu_usecopeValue(0, schTickDO,i);
					break;
				case IScDictCodeConst.SCSCH_RULE_ODD:
					i =this.SetEu_usecopeValue(1, schTickDO,i);
					break;
				default:
					schTickDO.setEu_usescope(EuUseScope.REG);
					break;
			}

		}
		
		if(i<totalAppt){
			for(ScSchTickDO schTickDO : tickList){
				if(i>=totalAppt )
					return;
				else if (schTickDO.getEu_usescope() == null|| schTickDO.getEu_usescope() ==EuUseScope.REG){
					schTickDO.setEu_usescope(EuUseScope.APT);
					i++;
				}
			}
		}
	}
	
	/**
	 * 设置具体使用范围的值
	 * @param i
	 * @param schTickDO
	 */
	private int  SetEu_usecopeValue( int value,ScSchTickDO schTickDO,int i){
		if (schTickDO.getQueno() % 2 == value) {
			schTickDO.setEu_usescope(EuUseScope.APT);
			return ++i ;
		} else {
			schTickDO.setEu_usescope(EuUseScope.REG);
			return i;
		}
	}

	
}
