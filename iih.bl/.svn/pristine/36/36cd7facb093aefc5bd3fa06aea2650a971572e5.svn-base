package iih.bl.cc.s.bp;

import xap.mw.core.data.FMap;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetBlPaypatIpDTOAfterBP implements ITransQry {
	 private FMap map = null;
	 private PaginationInfo pageInfo = null;
	 
	 public GetBlPaypatIpDTOAfterBP() {
		 
	 }
	 
	 public GetBlPaypatIpDTOAfterBP(FMap map,PaginationInfo pageInfo) {
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

		sb.append("select  distinct  A.id_paypatip,B.Id_Payitmpatip, C.code as code_pat,C.name as name_pat, E.Name as name_enttp, ");
		sb.append("       A.AMT,A.Eu_Direct,B.EU_DIRECT as payitem_eudirect, case when B.eu_direct=1 then '收款' else '退款' end as pay_direct, ");
		sb.append("       F.name as name_emppay,G.name as name_deppay,H.name as name_pm, ");
		sb.append("       A.eu_direct * B.eu_direct as sign_eudirect,case  when ( A.eu_direct * B.eu_direct)=1 then '否' else '是' end as change , ");
		sb.append("       B.AMT as amt_payitm,B.Paymodenode,B.bankno,K.id_stip,K.Code_St,A.Dt_Pay ,etp.code_amr_ip ");
		sb.append("   from bl_pay_pat_ip  A   ");
		sb.append(" inner join  bl_pay_itm_pat_ip  B  on   A.Id_Paypatip=B.id_paypatip  ");
		sb.append(" join  pi_pat             C  on   A.id_pat=C.id_pat  ");
		sb.append(" join  bl_cc              D  on   A.id_cc=D.id_cc ");
		sb.append(" left  join   bd_entp     E  on   A.id_enttp=E.Id_Entp ");
		sb.append(" left  join   bd_psndoc   F  on   A.id_emp_pay=F.id_psndoc ");
		sb.append(" left  join   bd_dep      G  on   A.id_dep_pay=G.id_dep   ");
		sb.append(" left  join   bl_st_ip    K  on   A.Id_stip   =K.Id_stip ");
		sb.append(" join bd_pri_pm   H on B.id_pm=H.id_pm    ");
		sb.append(" inner join en_ent_ip etp on etp.id_ent = A.id_ent ");
		sb.append(" where A.id_cc=?  and  A.Fg_cc='Y'  and A.id_emp_pay=?  ");
		sb.append(" order by A.Dt_Pay desc");	
		return sb.toString();
	}
}
