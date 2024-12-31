package iih.bl.cc.s.bp;

import xap.mw.core.data.FMap;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class IpCcPayPatDetailQry implements ITransQry {

	private FMap map=null;
	
	public IpCcPayPatDetailQry() {
		
	}
	
	public IpCcPayPatDetailQry(FMap map)
	{
		this.map=map;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		String strFgCc="Y";
		String strIdcc=(String)map.get("id_cc");
		if(StringUtil.isEmptyWithTrim(strIdcc))
		{
			strFgCc="N";
			strIdcc="~";
		}
		String strEndTime=(String)map.get("end_time");
		String strIdUser=(String)map.get("id_user");
		SqlParam param=new SqlParam();
		param.addParam(strFgCc);
		param.addParam(strIdUser);
		param.addParam(strEndTime);
		param.addParam(strIdcc);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sb = new StringBuffer();		
		sb.append(" select distinct A.id_paypatip,B.Id_Payitmpatip, C.code as code_pat,");
		sb.append("	C.name as name_pat,E.Name as name_enttp,A.Eu_Direct,B.eu_direct as payitem_eudirect,");
		sb.append("	case when B.eu_direct=1 then '收款' else '退款' end as pay_direct,");
		sb.append(" F.name as name_emppay,G.name as name_deppay,H.name as name_pm, ");
		sb.append(" A.eu_direct * B.eu_direct as sign_eudirect,");
		sb.append(" case  when ( A.eu_direct * B.eu_direct)=1 then '否' else '是' end as change ,");
		sb.append(" B.AMT as amt_payitm,B.Paymodenode,K.Code_St, A.Dt_Pay ");
		sb.append(" from bl_pay_pat_ip  A ");
		sb.append(" join bl_pay_itm_pat_ip  B on  A.Id_Paypatip=B.id_paypatip  ");
		sb.append(" join pi_pat C on A.id_pat=C.id_pat  ");
		sb.append(" left join bd_entp E on A.id_enttp=E.Id_Entp ");
		sb.append(" left join bd_psndoc F on A.id_emp_pay=F.id_psndoc ");
		sb.append(" left  join bd_dep G on A.id_dep_pay=G.id_dep  left join bl_st_ip K on A.Id_stip=K.Id_stip ");
		sb.append(" join bd_pri_pm   H on B.id_pm=H.id_pm  ");
		sb.append(" where A.FG_CC =?  and A.ID_EMP_PAY = ? and A.DT_PAY < ?"); 
		sb.append(" AND B.FG_REALPAY='Y' AND A.ID_CC=?");
		sb.append(" order by A.Dt_Pay desc");
		return sb.toString();
	}

}
