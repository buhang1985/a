package iih.sc.scp.s.ep;

import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import iih.sc.comm.ScValidator;
import iih.sc.scp.scplweek.d.ScPlanWeekEnDO;
import iih.sc.scp.scplweek.i.IScPlanWeekEnDOCudService;
import iih.sc.scp.scplweek.i.IScPlanWeekEnDORService;

/**
 * 周计划就诊EP
 * 
 * @author yzh
 *
 */
public class ScplWeekEnEP {
	
	
	/**
	 * 获取周计划就诊类型
	 * 
	 * @param scplWeekIds
	 * @return
	 * @throws BizException 
	 */
	public ScPlanWeekEnDO[] getTickByWeekIds(String[] scplWeekIds) throws BizException{
		if(ScValidator.isNullOrEmpty(scplWeekIds))
			return null;
		return getRServ().findByAttrValStrings(ScPlanWeekEnDO.ID_SCPLWEEK, scplWeekIds);
	}
	/**
	 * 保存周计划就诊信息
	 *
	 * @param planWeekEnDOs
	 * @return
	 * @throws BizException
	 */
	public ScPlanWeekEnDO[] save(ScPlanWeekEnDO[] planWeekEnDOs) throws BizException {
		if(ScValidator.isNullOrEmpty(planWeekEnDOs))
			return null;
		return getCudServ().save(planWeekEnDOs);
	}
	/**
	 * 删除周计划就诊信息
	 * 
	 * @param weekTick
	 * @throws BizException
	 */
	public void delete(String[] scplWeekIds) throws BizException{
		ScPlanWeekEnDO[] weekTick = getTickByWeekIds(scplWeekIds);
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
	public void delete(ScPlanWeekEnDO[] weekEn) throws BizException{
		if(ScValidator.isNullOrEmpty(weekEn))
			return;
		getCudServ().delete(weekEn);
	}

	/**
	 * 获取查询服务
	 * 
	 * @return
	 */
	public IScPlanWeekEnDORService getRServ(){
		return ServiceFinder.find(IScPlanWeekEnDORService.class);
	}
	/**
	 * 获取CUD服务
	 * 
	 * @return
	 */
	public IScPlanWeekEnDOCudService getCudServ(){
		return ServiceFinder.find(IScPlanWeekEnDOCudService.class);
	}
}
