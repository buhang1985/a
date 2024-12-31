package iih.mi.bd.s.bp.sql;

import iih.bd.base.utils.SqlUtils;
import iih.bd.mhi.hpdoc.d.HpDocDO;
import xap.mw.core.utils.ArrayUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.permfw.pub.EnvContextUtil;

/**
 * 医保档案数据查询
 * @author ly 2018/09/08
 *
 */
public class FindHpDocByCodesQry implements ITransQry {

	private String hpId;
	private String docTypeCode;
	private String[] docCodes;
	
	public FindHpDocByCodesQry(String hpId, String docTypeCode, String[] docCodes) {
		this.hpId = hpId;
		this.docTypeCode = docTypeCode;
		this.docCodes = docCodes;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer sqlSb) {
		
		SqlParam param = new SqlParam();
		sqlSb.append("and id_hp = ? ");
		sqlSb.append("and sd_doctype = ? ");
		
		param.addParam(this.hpId);
		param.addParam(this.docTypeCode);
		
		if(!ArrayUtil.isEmpty(this.docCodes)){
			sqlSb.append("and " + SqlUtils.getInSqlByIds("code", this.docCodes) + " ");
		}
		
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select id_hpdoc,");
		sqlSb.append("code,");
		sqlSb.append("name,");
		sqlSb.append("ctrl1,");
		sqlSb.append("ctrl2,");
		sqlSb.append("ctrl3,");
		sqlSb.append("ctrl4,");
		sqlSb.append("ctrl5 ");

		sqlSb.append("from bd_mhi_doc ");
		
		String orgSql = EnvContextUtil.processEnvContext("", new HpDocDO(), false);
		sqlSb.append("where " + orgSql + " ");
		
		return sqlSb.toString();
	}
}
