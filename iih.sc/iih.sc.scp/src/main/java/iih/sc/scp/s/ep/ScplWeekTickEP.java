package iih.sc.scp.s.ep;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.sf.core.util.ServiceFinder;
import iih.sc.comm.ScValidator;
import iih.sc.scp.scpltick.d.ScPlanWeekTickDO;
import iih.sc.scp.scpltick.i.IScpltickCudService;
import iih.sc.scp.scpltick.i.IScpltickRService;

/**
 * 周计划号位EP
 * 
 * @author liubin
 *
 */
public class ScplWeekTickEP {
	
	
	/**
	 * 获取周计划号位
	 * 
	 * @param scplWeekIds
	 * @return
	 * @throws BizException 
	 */
	public ScPlanWeekTickDO[] getTickByWeekIds(String[] scplWeekIds) throws BizException{
		if(ScValidator.isNullOrEmpty(scplWeekIds))
			return null;
		return getRServ().findByAttrValStrings(ScPlanWeekTickDO.ID_SCPLWEEK, scplWeekIds);
	}
	/**
	 * 保存周计划号位
	 *
	 * @param planWeekTickDOs
	 * @return
	 * @throws BizException
	 */
	public ScPlanWeekTickDO[] save(ScPlanWeekTickDO[] planWeekTickDOs) throws BizException {
		if(ScValidator.isNullOrEmpty(planWeekTickDOs))
			return null;
		return getCudServ().save(planWeekTickDOs);
	}
	/**
	 * 删除周计划号位
	 * 
	 * @param weekTick
	 * @throws BizException
	 */
	public void delete(String[] scplWeekIds) throws BizException{
		ScPlanWeekTickDO[] weekTick = getTickByWeekIds(scplWeekIds);
		if(ScValidator.isNullOrEmpty(weekTick))
			return;
		getCudServ().delete(weekTick);
	}
	/**
	 * 删除周计划号位
	 * 
	 * @param weekTick
	 * @throws BizException
	 */
	public void delete(ScPlanWeekTickDO[] weekTick) throws BizException{
		if(ScValidator.isNullOrEmpty(weekTick))
			return;
		getCudServ().delete(weekTick);
	}

	/**
	 * 获取查询服务
	 * 
	 * @return
	 */
	public IScpltickRService getRServ(){
		return ServiceFinder.find(IScpltickRService.class);
	}
	/**
	 * 获取CUD服务
	 * 
	 * @return
	 */
	public IScpltickCudService getCudServ(){
		return ServiceFinder.find(IScpltickCudService.class);
	}
}
