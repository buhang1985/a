package iih.bl.cc.s.bp;

import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetBlPaypatOepDtosPageBeforeInfoBP implements ITransQry{
	 private FMap map = null;
	 private PaginationInfo pageInfo = null;
	 
	 public GetBlPaypatOepDtosPageBeforeInfoBP() {
		 
	 }
	 
	 public GetBlPaypatOepDtosPageBeforeInfoBP(FMap map,PaginationInfo pageInfo) {
		 this.map = map;
		 this.pageInfo=pageInfo;
	 }

	@Override
	public SqlParam getQryParameter(StringBuffer sql) {
		String id_user = map.get("id_user").toString();
		FDateTime end_time = new FDateTime(map.get("end_time").toString());		
		SqlParam param = new SqlParam();
		param.addParam(id_user);
		param.addParam(end_time);
		return param;	
		
	}

	@Override
	public String getQrySQLStr() {
		//只查出这些付款明细中 费用来源为非挂号的明细
		
		StringBuffer sb = new StringBuffer();
		sb.append("  select   x.id_paypatoep,x.id_enttp,t3.name as entp_name,x.id_pat,x.pat_code,x.pat_name,x.amt,x.id_dep_pay,x.id_paytp,");
		sb.append("   decode(x.eu_direct,1,'收款',-1,'退款') direct,x.payitem_eudirect,x.payitem_eudirect eu_direct, ");
		sb.append("   x.id_emp_pay,x.id_blcc,x.paymodenode,x.bankno,t4.name as dept_name,t5.name as emp_name,t6.name as pm_name,");
		sb.append("   x.sign_eudirect, case when x.sign_eudirect=1 then '否'  else '是' end as change,x.dt_pay ,x.id_stoep,x.code_st ");
		sb.append("   from   ");
		sb.append("   (select  t1.id_paypatoep,t1.id_enttp,t1.id_pat,B.amt,st.id_stoep,st.code_st, ");
		sb.append("   t1.id_dep_pay,t1.id_emp_pay,id_paytp,B.eu_direct as payitem_eudirect,T1.Eu_direct,t1.id_cc as id_blcc,");
		sb.append("   B.id_pm,C.CODE as pat_code,C.name as pat_name,B.paymodenode ,b.bankno,");
		sb.append("   t1.eu_direct * B.EU_DIRECT as sign_eudirect,t1.dt_pay,B.id_payitmpatoep   from bl_pay_pat_oep t1  ");
		sb.append("    JOIN BL_PAY_ITM_PAT_OEP B ON t1.ID_PAYPATOEP = B.ID_PAYPATOEP ");
		sb.append("    inner  join  bl_st_oep  st  on  st.id_paypatoep = B.id_paypatoep "); 
		sb.append("    JOIN PI_PAT C ON t1.ID_PAT = C.ID_PAT   ");
		sb.append("    where  t1.FG_CC = 'N'  and t1.ID_EMP_PAY = ? and t1.DT_PAY < ? ");
		sb.append("    and B.fg_realpay='Y' ) x              "); //增加了条件：只显示实收（退）付款段
		sb.append("  left join bd_entp t3 on  x.id_enttp=t3.id_entp ");
		sb.append("  left join bd_dep t4  on   x.id_dep_pay=t4.id_dep ");
		sb.append("  left join bd_psndoc t5 on x.id_emp_pay=t5.id_psndoc");	
		sb.append("  join bd_pri_pm t6 on  x.id_pm=t6.id_pm   ");
		//sb.append(" left JOIN BL_INC_OEP inc on inc.id_stoep = x.id_stoep ");
		sb.append("order by x.dt_pay desc ");		
		return sb.toString();
	}
}
