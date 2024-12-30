package iih.sc.scp.s.ep;

import iih.sc.comm.ScValidator;
import iih.sc.scbd.screleaserule.d.ScReleaseRuleItmDO;
import iih.sc.scbd.screleaserule.d.ScaptrlsruleDO;
import iih.sc.scbd.screleaserule.i.IScReleaseRuleItmDORService;
import iih.sc.scbd.screleaserule.i.IScaptrlsruleRService;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.sctick.i.ISctickRService;
import iih.sc.sch.scticks.d.ScSchTicksDO;
import iih.sc.sch.scticks.i.IScticksRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 排班释放规则EP
 * 
 * @author yzh
 *
 */
public class ReleaseScAptTaskEP {
	/**
	 * 获取预约释放规则
	 * 
	 * @param cond 查询条件
	 * @param orderStr 排序
	 * @return ScReleaseRuleItmDO[]
	 * @throws BizException 
	 */
	public ScaptrlsruleDO[] getScaptrlsruleByCond(String cond,String orderStr) throws BizException{
		if(ScValidator.isNullOrEmpty(cond))
			return null;
		return this.getScaptrlsruleRServ().find(cond, orderStr, FBoolean.FALSE);
	}
	
	/**
	 * 获取预约释放规则查询serv
	 * @return
	 */
	public IScaptrlsruleRService getScaptrlsruleRServ(){
		return ServiceFinder.find(IScaptrlsruleRService.class);
	}
	
}
