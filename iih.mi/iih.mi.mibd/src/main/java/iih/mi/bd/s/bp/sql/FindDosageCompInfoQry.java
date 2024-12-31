package iih.mi.bd.s.bp.sql;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.hp.d.HpDosageDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.mw.core.utils.ArrayUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 
 * 剂型对照查询
 * @author ly 2018/09/13
 *
 */
public class FindDosageCompInfoQry implements ITransQry {

	private String hpId;
	private String[] dosageCodes;
	
	public FindDosageCompInfoQry(String hpId, String[] dosageCodes){
		this.hpId = hpId;
		this.dosageCodes = dosageCodes;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer sqlSb) {
		
		SqlParam param = new SqlParam();
		sqlSb.append("and dosage.id_hp = ? ");
		param.addParam(this.hpId);
		
		if(!ArrayUtil.isEmpty(this.dosageCodes)){
			sqlSb.append("and " + SqlUtils.getInSqlByIds("udidoc.code", this.dosageCodes) + " ");
		}
		
		return param;
	}

	@Override
	public String getQrySQLStr() {
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select id_hp_dosage,");
		sqlSb.append("dosage.id_hp,");
		sqlSb.append("dosage.code_hp code_dosage_hp,");
		sqlSb.append("dosage.name_hp name_dosage_hp,");
		sqlSb.append("dosage.id_dosage id_dosage_his,");
		sqlSb.append("udidoc.code sd_dosage_his ");
		
		sqlSb.append("from bd_hp_dosage dosage ");
		sqlSb.append("inner join bd_udidoc udidoc ");
		sqlSb.append("on dosage.id_dosage = udidoc.id_udidoc ");
		sqlSb.append("where ");
		String orgSql =  BdEnvContextUtil.processEnvContext(new HpDosageDO(), "dosage");
		sqlSb.append(orgSql + " ");
		
		return sqlSb.toString();
	}
}
