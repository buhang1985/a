package iih.mi.bd.s.bp.sql;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.hp.d.HpDosageDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.mw.core.utils.ArrayUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class FindDiDefCompInfoQry implements ITransQry {

	private String hpId;
	private String[] diDefCodes;
	
	public FindDiDefCompInfoQry(String hpId, String[] diDefCodes){
		this.hpId = hpId;
		this.diDefCodes = diDefCodes;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer sqlSb) {
		
		SqlParam param = new SqlParam();
		sqlSb.append("and vs.id_hp = ? ");
		param.addParam(this.hpId);
		
		if(!ArrayUtil.isEmpty(this.diDefCodes)){
			sqlSb.append("and " + SqlUtils.getInSqlByIds("def.code", this.diDefCodes) + " ");
		}
		
		return param;
	}

	@Override
	public String getQrySQLStr() {
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select                   ");
		sqlSb.append("vs.code code_di_hp,      ");
		sqlSb.append("vs.name name_di_hp,      ");
		sqlSb.append("def.id_didef id_didef,   ");
		sqlSb.append("def.code code_di_his,    ");
		sqlSb.append("def.name name_di_his,    ");
		sqlSb.append("vs.id_hp id_hp           ");
		sqlSb.append(" from bd_hp_di_vs_his vs ");
		sqlSb.append("inner join bd_di_def def on def.id_didef=vs.id_didef ");
		sqlSb.append("where ");
		String orgSql =  BdEnvContextUtil.processEnvContext(new HpDosageDO(), "vs");
		sqlSb.append(orgSql + " ");
		
		return sqlSb.toString();
	}
}
