package iih.sc.scp.s.ep;

import iih.sc.comm.ScValidator;
import iih.sc.scbd.screleaserule.d.ScReleaseRuleItmDO;
import iih.sc.scbd.screleaserule.i.IScReleaseRuleItmDORService;
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
public class ScReleaseRuleTaskEP {
	/**
	 * 获取排班释放规则明细
	 * 
	 * @param cond 查询条件
	 * @param orderStr 排序
	 * @return ScReleaseRuleItmDO[]
	 * @throws BizException 
	 */
	public ScReleaseRuleItmDO[] getScReleaseRuleItmByCond(String cond,String orderStr) throws BizException{
		if(ScValidator.isNullOrEmpty(cond))
			return null;
		return this.getItmRServ().find(cond, orderStr, FBoolean.FALSE);
	}
	/**
	 * 获取号段
	 * @param cond
	 * @param orderStr
	 * @return
	 * @throws BizException
	 */
	public ScSchTickDO[] getScSchTickByCond(String cond,String orderStr) throws BizException{
		if(ScValidator.isNullOrEmpty(cond)){
			return null;
		}
		return this.getScTickRServ().find(cond, orderStr, FBoolean.FALSE);
	}
	/**
	 * 获取号位
	 * @param cond
	 * @param orderStr
	 * @return
	 * @throws BizException
	 */
	public ScSchTicksDO[] getScSchTicksByCond(String cond,String orderStr) throws BizException{
		if(ScValidator.isNullOrEmpty(cond)){
			return null;
		}
		return this.getScTicksRServ().find(cond, orderStr, FBoolean.FALSE);
	}
	/**
	 * 获取明细查询服务
	 * 
	 * @return
	 */
	public IScReleaseRuleItmDORService getItmRServ(){
		return ServiceFinder.find(IScReleaseRuleItmDORService.class);
	}
	/**
	 * 获取号段查询服务
	 * @return
	 */
	public ISctickRService getScTickRServ(){
		return ServiceFinder.find(ISctickRService.class);
	}
	/**
	 * 获取号位查询服务
	 * @return
	 */
	public IScticksRService getScTicksRServ(){
		return ServiceFinder.find(IScticksRService.class);
	}
	
}
