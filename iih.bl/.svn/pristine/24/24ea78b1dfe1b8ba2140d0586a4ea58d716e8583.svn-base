package iih.bl.pay.bp.qry;

import iih.bl.pay.blpaypat.d.BlPrePayPatDO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetBlPrePayPatDOInfoBp {
	/**
	 * 住院账户对应的预交金
	 * 通过患者banner所提供id_ent,id_pat来得到患者的当前就诊的住院就诊所包含的所有收付款信息， 用于显示  【住院明细（右侧表格）】
	 * @param id_pat
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public BlPrePayPatDO[]  execQryBlPrePayPatDOsByIdpatident(String id_pat,String id_ent)throws BizException{   // 住院明细（右侧表格）
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
		sb.append(" WHERE t1.ID_PAT = ? AND t1.id_ent =?  order by t1.dt_pay  desc");
		
	    SqlParam sp=new SqlParam();
	    sp.addParam(id_pat);
		sp.addParam(id_ent);
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
