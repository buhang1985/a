package iih.bl.pay.s.provide.mbh.qry;

import iih.bd.bc.udi.pub.IBlDictCodeConst;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询患者住院预交金冲退记录
 * @author ly 2018/08/09
 *
 */
public class GetIpPrepayRecordQry implements ITransQry{

	private String entId;
	
	public GetIpPrepayRecordQry(String entId){
		this.entId = entId;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer sqlSb) {
		
		SqlParam param = new SqlParam();
		sqlSb.append("where prepay.sd_paytp = ? ");
		sqlSb.append("and prepay.id_ent = ? ");
		
		param.addParam(IBlDictCodeConst.SD_PAYTP_IPPREPAY);
		param.addParam(this.entId);
		
		sqlSb.append("order by prepay.dt_pay ");
		
		return param;
	}

	@Override
	public String getQrySQLStr() {
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select prepay.id_ent,");
		sqlSb.append("prepay.code_rep,");
		sqlSb.append("(prepay.eu_direct * prepay.amt) amt,");
		sqlSb.append("pm.name name_pm,");
		sqlSb.append("prepay.dt_pay,");
		sqlSb.append("dep.name name_dep_pay,");
		sqlSb.append("psn.name name_emp_pay ");
		sqlSb.append("from bl_prepay_pat prepay ");
		sqlSb.append("left join bd_pri_pm pm ");
		sqlSb.append("on prepay.id_pm = pm.id_pm ");
		sqlSb.append("left join bd_dep dep ");
		sqlSb.append("on prepay.id_dep_pay = dep.id_dep ");
		sqlSb.append("left join bd_psndoc psn ");
		sqlSb.append("on prepay.id_emp_pay = psn.id_psndoc ");
		
		return sqlSb.toString();
	}
}
