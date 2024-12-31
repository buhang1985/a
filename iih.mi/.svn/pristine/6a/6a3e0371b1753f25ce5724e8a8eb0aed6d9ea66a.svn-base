package iih.mi.bd.s.bp.sql;

import iih.bd.base.utils.SqlUtils;
import iih.bd.mhi.hpfeeca.d.HpFeecaDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 费别对照查询
 * @author ly 2018/09/13
 *
 */
public class FindFeeCaCompInfoQry implements ITransQry {

	private String hpId;
	private String inccaId;
	private String[] codeInccaItms;
	
	public FindFeeCaCompInfoQry(String hpId,String inccaId,String[] codeInccaItms){
		this.hpId = hpId;
		this.inccaId = inccaId;
		this.codeInccaItms = codeInccaItms;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer sqlSb) {
		
		SqlParam param = new SqlParam();
		
		sqlSb.append("and id_hp = ? ");
		param.addParam(this.hpId);
		
		if(!StringUtil.isEmpty(this.inccaId)){
			sqlSb.append("and id_incca = ? ");
			param.addParam(this.inccaId);
		}
		
		if(!ArrayUtil.isEmpty(this.codeInccaItms)){
			sqlSb.append("and " + SqlUtils.getInSqlByIds("code_inccaitm", this.codeInccaItms) + " " );
		}
		
		return param;
	}

	@Override
	public String getQrySQLStr() {
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select id_hpfeeca,");
		sqlSb.append("id_hp,");
		sqlSb.append("code,");
		sqlSb.append("name,");
		sqlSb.append("id_incca,");
		sqlSb.append("code_inccaitm ");
		sqlSb.append("from bd_hp_feeca ");
		
		sqlSb.append("where ");
		String orgSql =  BdEnvContextUtil.processEnvContext(new HpFeecaDO(), false);
		sqlSb.append(orgSql + " ");
		return sqlSb.toString();
	}
}
