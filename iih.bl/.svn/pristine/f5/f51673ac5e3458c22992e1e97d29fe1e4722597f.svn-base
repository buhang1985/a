package iih.bl.cc.s.bp;

import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;


public class GetBlPaypatIpDTOBeforeBP implements ITransQry {
	 private FMap map = null;
	 private PaginationInfo pageInfo = null;
	 
	 public GetBlPaypatIpDTOBeforeBP() {
		 
	 }
	 
	 public GetBlPaypatIpDTOBeforeBP(FMap map,PaginationInfo pageInfo) {
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
	/**
	 * 结账前分页查询	
	 */
	public String getQrySQLStr() {
		StringBuffer sb = new StringBuffer();
		
		sb.append(" select distinct A.id_paypatip,B.Id_Payitmpatip, C.code as code_pat,");
		sb.append("	C.name as name_pat,E.Name as name_enttp,A.Eu_Direct,B.eu_direct as payitem_eudirect,");
		sb.append("	case when B.eu_direct=1 then '收款' else '退款' end as pay_direct,");
		sb.append(" F.name as name_emppay,G.name as name_deppay,H.name as name_pm, ");
		sb.append(" A.eu_direct * B.eu_direct as sign_eudirect,");
		sb.append(" case  when ( A.eu_direct * B.eu_direct)=1 then '否' else '是' end as change ,");
		sb.append(" B.AMT as amt_payitm,B.Paymodenode,B.bankno,K.id_stip,K.Code_St, A.Dt_Pay ,etp.code_amr_ip ");
		sb.append(" from bl_pay_pat_ip  A ");
		sb.append(" join bl_pay_itm_pat_ip  B on  A.Id_Paypatip=B.id_paypatip  ");
		sb.append(" join pi_pat C on A.id_pat=C.id_pat  ");
		sb.append(" left join bd_entp E on A.id_enttp=E.Id_Entp ");
		sb.append(" left join bd_psndoc F on A.id_emp_pay=F.id_psndoc ");
		sb.append(" left  join bd_dep G on A.id_dep_pay=G.id_dep  left join bl_st_ip K on A.Id_stip=K.Id_stip ");
		sb.append(" join bd_pri_pm   H on B.id_pm=H.id_pm  ");
		sb.append(" inner join en_ent_ip etp on etp.id_ent = A.id_ent ");
		sb.append(" where A.FG_CC = 'N'  and A.ID_EMP_PAY = ? and A.DT_PAY < ?"); 
		sb.append(" AND B.FG_REALPAY='Y'");
		sb.append(" order by A.Dt_Pay desc");
		return sb.toString();
	}

}
