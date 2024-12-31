package iih.crm.conm.i;

import iih.crm.conm.dto.d.CrmConDataShowDTO;
import iih.crm.conm.dto.d.CrmConQryCondDTO;
import iih.crm.conm.dto.d.CrmConRelationPatDTO;
import iih.crm.conm.dto.d.MarPlanShowDataDTO;
import xap.mw.core.data.BizException;

/**
 * 
* @ClassName: ICrmConmQryService  
* @Description: 客户关系客户标准查询服务 
* @author xy.zhou
* @date 2019年3月19日
 */
public interface ICrmConmQryService {

	/***
	 * 
	* @Title: getCrmCnoDataQry  
	* @Description: 根据查询条件获取客户合同
	* @param conQryCondDTO
	* @throws BizException  
	* @return CrmConDataShowDTO[] 
	* @author xy.zhou
	 */
	public abstract CrmConDataShowDTO[] getCrmConDataQry(CrmConQryCondDTO conQryCondDTO)throws BizException;
	
	/**
	 * 
	* @Title: getMarPlanData  
	* @Description: 获取营销方案信息
	* @param id_marplans
	* @throws BizException  
	* @return MarPlanShowDataDTO[] 
	* @author xy.zhou
	 */
	public abstract MarPlanShowDataDTO[] getMarPlanData(String [] id_marplans)throws BizException;
	
	/**
	 * 
	* @Title: getRelationPatData  
	* @Description: 获取合同关联患者信息
	* @throws BizException  
	* @return CrmConRelationPatDTO[] 
	* @author xy.zhou
	 */
	public abstract CrmConRelationPatDTO[] getRelationPatData(String [] id_pats)throws BizException;
	
	/**
	 * 
	* @Title: getRelationshipPatData  
	* @Description: 获取合同已经关联患者
	* @param  id_cons
	* @throws BizException  
	* @return CrmConRelationPatDTO[] 
	* @author xy.zhou
	 */
	public CrmConRelationPatDTO [] getRelationshipPatData(String [] id_cons)throws BizException;
	
	/**
	 * 查询改患者的有效合同
	 * @param patId
	 * @param conId
	 * @return
	 * @throws BizException
	 */
	public CrmConDataShowDTO[] getEffectiveContract(String patId, String marplanId)  throws BizException;
	 
}
