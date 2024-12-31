package iih.bd.pp.s.external.provide.bp.qry;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.incca.d.IncCaItmRelDO;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.permfw.pub.EnvContextUtil;

/**
 * 批量获取票据分类对照检索类
 * @author ly 2018/06/28
 *
 */
public class FindCaItmRelBySrvQry implements ITransQry {

	private String sdIncca;
	private String[] srvIds;
	
	
	public FindCaItmRelBySrvQry(String sdIncca, String[] srvIds){
		this.sdIncca = sdIncca;
		this.srvIds = srvIds;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(this.sdIncca);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select ");
		sqlSb.append("itmrel.id_srv,");
		sqlSb.append("caitm.code inccaitm_code,");
		sqlSb.append("caitm.name inccaitm_name ");
		sqlSb.append("");
		sqlSb.append("from bd_incca_itm_rel itmrel ");
		sqlSb.append("inner join bd_incca_itm caitm ");
		sqlSb.append("on itmrel.id_inccaitm = caitm.id_inccaitm ");
		sqlSb.append("where itmrel.sd_incca = ? ");
		
		String orgSql = EnvContextUtil.processEnvContext("", new IncCaItmRelDO(), "itmrel");
		sqlSb.append(" and " + orgSql);
		
		String srvInSql = SqlUtils.getInSqlByIds("itmrel.id_srv", this.srvIds);
		sqlSb.append(" and " + srvInSql);
		
		return sqlSb.toString();
	}

}
