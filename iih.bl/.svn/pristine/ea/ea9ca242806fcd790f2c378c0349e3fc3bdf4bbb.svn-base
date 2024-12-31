package iih.bl.hp.rule.qry;


import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取当前就诊与药品是否是特病药
 * @author yang.lu
 *
 */
public class GetFgSpecillByRuleQry  implements ITransQry {
	String mmId;
	String entId;
	
	public GetFgSpecillByRuleQry(String mmId,String entId) {
		this.mmId=mmId;
		this.entId=entId;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();

		if (!StringUtil.isEmptyWithTrim(entId)) {
			sqlParam.addParam(entId);
		}
		if (!StringUtil.isEmptyWithTrim(mmId)) {
			sqlParam.addParam(mmId);
		}
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlb = new StringBuilder();
		sqlb.append(" select spec.code_di,specdi.NAME_DI, srv.id_mm ,srv.code,srv.name FROM bd_hp_spec spec");
		sqlb.append(" inner join bd_hp_spec_drug drug on spec.id_hpspec = drug.id_hpspec");
		sqlb.append(" inner join bd_hp_srvorca srv  on drug.code_hp = srv.code");
		sqlb.append(" inner join bl_hp_pat_spec_di specdi on specdi.code_di =  spec.code_di");
		sqlb.append(" inner join bl_hp_pat_spec patspec on patspec.id_hppatspec = specdi.id_hppatspec");
		sqlb.append(" INNER JOIN EN_ENT_HP enthp on enthp.id_hp=srv.id_hp and patspec.no_hp=enthp.no_hp");
		sqlb.append(" where enthp.ID_ENT=? AND srv.id_mm=?");
		return sqlb.toString();
	}

}
