package iih.bl.cc.s.bp;

import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetBlPaypatOepDtosPageAfterInfoBP implements ITransQry{
	 private FMap map = null;
	 private PaginationInfo pageInfo = null;
	 
	 public GetBlPaypatOepDtosPageAfterInfoBP() {
		 
	 }
	 
	 public GetBlPaypatOepDtosPageAfterInfoBP(FMap map,PaginationInfo pageInfo) {
		 this.map = map;
		 this.pageInfo=pageInfo;
	 }

	@Override
	public SqlParam getQryParameter(StringBuffer sql) {
		String id_cc = map.get("id_cc").toString();
		String id_emp = map.get("id_user").toString();
		SqlParam param = new SqlParam();
		param.addParam(id_cc);
		param.addParam(id_emp);
		return param;	
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sb = new StringBuffer();

		sb.append("  select   x.id_paypatoep,x.id_enttp,t3.name as entp_name,x.id_pat,x.pat_code,x.pat_name,x.amt,x.id_dep_pay,x.id_paytp,");
		sb.append("   x.payitem_eudirect eu_direct,decode(x.eu_direct,1,'收款',-1,'退款') direct, ");
		sb.append("   x.id_emp_pay,x.id_blcc,x.paymodenode,x.bankno,t4.name as dept_name,t5.name as emp_name,t6.name as pm_name,");
		sb.append("   x.sign_eudirect, case when x.sign_eudirect=1 then '否'  else '是' end as change,x.dt_pay,sto.id_stoep,sto.code_st  ");
		sb.append("   from   ");
		sb.append("   (select  t1.id_paypatoep,t1.id_enttp,t1.id_pat,B.amt,t1.id_dep_pay,t1.id_emp_pay,id_paytp,B.eu_direct payitem_eudirect,t1.eu_direct,t1.id_cc as id_blcc,B.id_pm,C.CODE as pat_code,C.name as pat_name,B.paymodenode ,B.bankno,t1.dt_pay,t1.eu_direct * B.EU_DIRECT as sign_eudirect from bl_pay_pat_oep t1  ");
		sb.append("    inner JOIN BL_PAY_ITM_PAT_OEP B ON t1.ID_PAYPATOEP = B.ID_PAYPATOEP ");		
		sb.append("    JOIN PI_PAT C ON t1.ID_PAT = C.ID_PAT   ");
		sb.append("    join  bl_cc t2  on t1.id_cc=t2.id_cc  where  t1.id_cc =?  and t1.FG_CC ='Y'  and  t1.id_emp_pay=?  ");
		sb.append("    and B.fg_realpay='Y' ) x");//增加了条件：只显示实收（退）付款段
		sb.append("  left join bd_entp t3 on  x.id_enttp=t3.id_entp ");
		sb.append("  left join bd_dep t4  on   x.id_dep_pay=t4.id_dep ");
		sb.append("  left join bd_psndoc t5 on x.id_emp_pay=t5.id_psndoc");
		
		sb.append("  left join bl_st_oep sto on sto.id_paypatoep = x.id_paypatoep");
		//sb.append("  left JOIN BL_INC_OEP inc on inc.id_stoep = sto.id_stoep");
		
		sb.append("  join bd_pri_pm t6 on  x.id_pm=t6.id_pm  order by x.dt_pay desc ");
		return sb.toString();
	}
}
