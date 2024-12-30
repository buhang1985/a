package iih.sc.scp.s.ep;

import iih.sc.comm.ScValidator;
import iih.sc.scp.scplticks.d.ScPlanWeekTicksDO;
import iih.sc.scp.scplticks.i.IScplticksCudService;
import iih.sc.scp.scplticks.i.IScplticksRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 周计划号段EP
 * 
 * @author liubin
 *
 */
public class ScplWeekTicksEP {
	/**
	 * 获取周计划号段
	 * 
	 * @param scplWeekIds
	 * @return
	 * @throws BizException 
	 */
	public ScPlanWeekTicksDO[] getTicksByWeekIds(String[] scplWeekIds) throws BizException{
		if(ScValidator.isNullOrEmpty(scplWeekIds))
			return null;
		return getRServ().findByAttrValStrings(ScPlanWeekTicksDO.ID_SCPLWEEK, scplWeekIds);
	}
	/**
	 * 保存周计划号位
	 * @param planWeekTicksDOs
	 * @return
	 * @throws BizException
	 */
	public ScPlanWeekTicksDO[] save(ScPlanWeekTicksDO[] planWeekTicksDOs) throws BizException {
		if(ScValidator.isNullOrEmpty(planWeekTicksDOs))
			return null;
		return getCudServ().save(planWeekTicksDOs);
	}
	/**
	 * 删除周计划号段
	 * 
	 * @param weekTick
	 * @throws BizException
	 */
	public void delete(String[] scplWeekIds) throws BizException{
		ScPlanWeekTicksDO[] weekTick = getTicksByWeekIds(scplWeekIds);
		if(ScValidator.isNullOrEmpty(weekTick))
			return;
		getCudServ().delete(weekTick);
	}
	/**
	 * 删除周计划号段
	 * 
	 * @param weekTick
	 * @throws BizException
	 */
	public void delete(ScPlanWeekTicksDO[] weekTick) throws BizException{
		if(ScValidator.isNullOrEmpty(weekTick))
			return;
		getCudServ().delete(weekTick);
	}

	/**
	 * 获取查询服务
	 * 
	 * @return
	 */
	public IScplticksRService getRServ(){
		return ServiceFinder.find(IScplticksRService.class);
	}
	/**
	 * 获取CUD服务
	 * 
	 * @return
	 */
	public IScplticksCudService getCudServ(){
		return ServiceFinder.find(IScplticksCudService.class);
	}
}
