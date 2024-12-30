package iih.sc.sch.s.ep;

import java.util.List;

import iih.sc.comm.ScValidator;
import iih.sc.scp.scplan.d.ScPlanDO;
import iih.sc.scp.scplan.i.IScplanRService;
import iih.sc.scp.scplweek.d.ScPlanWeekDO;
import iih.sc.scp.scplweek.d.ScplweekAggDO;
import iih.sc.scp.scplweek.i.IScplweekMDORService;
import iih.sc.scp.scplweek.i.IScplweekRService;

import java.util.List;
import xap.mw.core.utils.StringUtil;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 计划EP
 * @author ren_ying
 *
 */
public class SchPlEP {
	/**
	 * 获取周计划
	 * @param plWeekId
	 * @return
	 * @throws BizException 
	 */
	public ScplweekAggDO[] getPlWeekById(String[] plWeekIds) throws BizException{
		if(plWeekIds ==null || plWeekIds.length ==0)
			return null;
		return getMRServ().findByBIds(plWeekIds,FBoolean.FALSE);
	}
	/**
	 * 获取排班计划
	 * 
	 * @param scplId
	 * @return
	 * @throws BizException 
	 */
	public ScPlanDO getScPl(String scplId) throws BizException{
		if(ScValidator.isEmptyIgnoreBlank(scplId))
			return null;
		return getRServ().findById(scplId);
	}
	
	/**
	 * 获取排班计划
	 * 
	 * @param scplId
	 * @return
	 * @throws BizException 
	 */
	public ScPlanDO[] getScPls(List<String> scplIdList) throws BizException{
		if(ScValidator.isNullOrEmpty(scplIdList))
			return null;
		return getRServ().findByIds(scplIdList.toArray(new String[]{}),FBoolean.FALSE);
	}
	/**
	 * 根据条件获取排班计划
	 * 
	 * @author zhengcm
	 * @date 2017-11-29 10:28:11
	 *
	 * @param where
	 * @return
	 * @throws BizException
	 */
	public ScPlanDO[] getScPlanByWhere(String where) throws BizException {
		if (StringUtil.isEmptyWithTrim(where)) {
			return null;
		}
		return this.getRServ().find(where, null, FBoolean.FALSE);
	}
	
	/**
	 * 获取主DO查询服务
	 * 
	 * @return
	 */
	public IScplweekRService getMRServ(){
		return ServiceFinder.find(IScplweekRService.class);
	}
	
	/**
	 * 获取查询服务
	 * 
	 * @return
	 */
	public IScplanRService getRServ(){
		return ServiceFinder.find(IScplanRService.class);
	}
}
