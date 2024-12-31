package iih.bd.srv.emrtpl.i;

import iih.bd.srv.emrtpl.d.EmrTplDO;
import xap.mw.core.data.BizException;

public interface IMrtplDefaultService {
	/**
	* 根据当前科室 当前院区 选择门诊默认模板
	*  
	*/	
	public abstract EmrTplDO[] getDefaultMrtpl(String Id_org,String Id_dep,String Id_emp,String id_mrtp,String sd_su_mrtpl) throws BizException;
	
	/**
	 * 根据当前科室 当前院区 以及就诊类型选择门诊默认模板
	 * @param Id_org
	 * @param Id_dep
	 * @param Id_emp
	 * @param sd_mr_entp 就诊类型（初诊、复诊）
	 * @param sd_su_mrtpl 状态（如 已审批）
	 * @return
	 * @throws BizException
	 */
	public abstract EmrTplDO[] getDefaultMrtplByEntp(String Id_org, String Id_dep,String Id_emp, String sd_mr_entp,String sd_su_mrtpl)throws BizException;
	
	/**
	* 设置默认模板
	*  
	*/
	public abstract void setDefaultMrtpl(String Id_mrtpl,String Id_owtp,String id_mrtp) throws BizException;
	
	/**
	* 设置科室默认模板
	*  
	*/
	public abstract void setDefaultMrtplDept(String Id_mrtpl,String Id_owtp,String id_mrtp,String Id_dept) throws BizException;
	
	/**
	* 设置个人默认模板
	*  
	*/
	public abstract void setDefaultMrtplPerson(String Id_mrtpl,String Id_owtp,String id_mrtp,String Id_person) throws BizException;
	
	/**
	* 设置全院默认模板
	*  
	*/
	public abstract void setDefaultMrtplHospital(String Id_mrtpl,String Id_owtp,String id_mrtp,String Id_ownorg) throws BizException;
}
