package iih.bl.pay.bp.qry;

import iih.bl.pay.blpaypat.d.BlPrePayPatDO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetBlPrePayPatDOsBp {

	/**
	 * 门诊账户对应的预交金
	 * 通过患者banner所提供的id_pat,sd_paytp来得到患者的门诊账户的收付款明细信息， ,sd_paytp 应该是门诊类型的即为“11” 或者“21”,用于显示门诊明细（左侧表格）
     * @param id_pat
     * @param sd_paytp
	 * @return  
	 * @throws BizException
	 */
	public BlPrePayPatDO[]  execQryBlPrePayPatDOsByIds(String id_pat,String sd_paytp)throws BizException{   // 门诊账户（左侧余额）
		StringBuffer sb=new StringBuffer();
		sb.append(" select t1.id_paypat ,t1.id_grp,t1.id_org,t1.id_paytp,t1.sd_paytp,t1.id_pat,t1.id_enttp,t1.code_enttp, "); 
		sb.append(" t1.id_ent,t1.eu_direct,t1.amt,t1.id_pm,t1.sd_pm,t1.id_bank,t1.bankno,t1.paymodenode,t1.dt_pay,t1.id_org_pay, "); 
        sb.append(" t1.id_dep_pay,t1.id_emp_pay,t1.id_cc,t1.id_incca,t1.code_incca,t1.code_rep,t1.fg_rep_return,t1.dt_return, "); 
        sb.append(" t1.id_emp_return,t1.id_st_mid,t1.fg_canc,t1.id_emp_canc,"); 
        sb.append(" t1.ds,t1.sv,t1.fg_cc, "); 
        sb.append(" t6.name as paymodename,t6.code as paymodecode,t2.name as emp_name,t2.code as emp_code "); 
		sb.append(" FROM BL_PREPAY_PAT t1 ");
		sb.append(" join bd_pri_pm t6    on  t1.id_pm = t6.id_pm  ");
		sb.append(" join  bd_psndoc t2   on  t1.id_emp_pay = t2.id_psndoc");
		sb.append(" WHERE t1.ID_PAT = ? AND (t1.SD_PAYTP ='11' or t1.SD_PAYTP ='21')  order by t1.dt_pay  desc");
		
		
	    SqlParam sp=new SqlParam();
		sp.addParam(id_pat);
	   @SuppressWarnings("unchecked")
	   List<BlPrePayPatDO> list= (List<BlPrePayPatDO>)new DAFacade().execQuery(sb.toString(),sp,new BeanListHandler(BlPrePayPatDO.class));
		 if(!(list.isEmpty())&&list.size()>0){
			 BlPrePayPatDO[] bldos= list.toArray(new BlPrePayPatDO[0]);
			 return bldos;   
		 }else {
			 return null;
		 }
	}
	

}
