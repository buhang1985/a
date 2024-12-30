package iih.sc.scp.s.ep;

import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScValidator;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.i.IScschMDORService;
import iih.sc.scp.scplan.d.ScPlanDO;
import iih.sc.scp.scplan.i.IScplanCudService;
import iih.sc.scp.scplan.i.IScplanRService;

import org.apache.commons.lang.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 计划ep
 * @author ccj
 * @author liubin
 *
 */
public class ScplEp {
	
	/**
	 * 修改计划里 最后排班日期
	 * @param lastSchDate  最后排班日期
	 * @param id_scpl 计划id
	 * @throws BizException
	 */
	public void updateLastSchDate(String lastSchDate,String id_scpl) throws BizException{
		if(StringUtils.isEmpty(lastSchDate) || StringUtils.isEmpty(id_scpl) ) return;
		ScPlanDO scPlanDO = getRServ().findById(id_scpl);
		if(scPlanDO == null) return;
		if(scPlanDO.getD_last_sch() == null || scPlanDO.getD_last_sch().compareTo(new FDate(lastSchDate)) < 0 ){
			scPlanDO.setD_last_sch(new FDate(lastSchDate));
			scPlanDO.setStatus(DOStatus.UPDATED);
			getCudServ().save(new ScPlanDO[]{scPlanDO});
		}
	}
	/**
	 * 根据查询条件获取计划
	 * 
	 * @param whereStr
	 * @param orderStr
	 * @return
	 * @throws BizException
	 */
	public ScPlanDO[] getScPls(String whereStr, String orderStr) throws BizException{
		if(ScValidator.isEmptyIgnoreBlank(whereStr))
			return null;
		return this.getRServ().find(whereStr, orderStr, FBoolean.FALSE);
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
	 * 删除排班计划
	 * 
	 * @param scPlDOs
	 * @throws BizException
	 */
	public void delate(ScPlanDO[] scPlDOs) throws BizException{
		if(ScValidator.isNullOrEmpty(scPlDOs))
			return;
		getCudServ().delete(scPlDOs);
	}
	/**
	 * 保存计划
	 * 
	 * @param scPlDOs
	 * @return
	 * @throws BizException
	 */
	public ScPlanDO[] save(ScPlanDO[] scPlDOs) throws BizException{
		if(ScValidator.isNullOrEmpty(scPlDOs))
			return null;
		return getCudServ().save(scPlDOs);
	}
	
	/**
	 * 获取查询服务
	 * 
	 * @return
	 */
	public IScplanRService getRServ(){
		return ServiceFinder.find(IScplanRService.class);
	}
	/**
	 * 获取CUD服务
	 * 
	 * @return
	 */
	public IScplanCudService getCudServ(){
		return ServiceFinder.find(IScplanCudService.class);
	}
	/**
	 * 验证计划是否被使用
	 * @param plId
	 * @return
	 * @throws BizException
	 */
	public boolean isPlUsed(String plId) throws BizException{
		IScschMDORService schRService = ServiceFinder.find(IScschMDORService.class);
		ScSchDO[] schDOs = schRService.find("id_scpl ='"+plId+"'" +" and d_sch >='"+ScAppUtils.getServerDate()+"'", "", FBoolean.FALSE);
		if(ArrayUtil.isEmpty(schDOs))
			return false;
		return true;
	}
}
