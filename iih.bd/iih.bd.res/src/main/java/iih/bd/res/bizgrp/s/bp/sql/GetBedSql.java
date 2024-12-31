package iih.bd.res.bizgrp.s.bp.sql;

import iih.bd.res.bed.d.Bdbed;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询床位表并关联上相关属性
 * @author guoyang
 *
 */
public class GetBedSql implements ITransQry {

	private String _wherePart;

	public GetBedSql(String wherePart) {
		this._wherePart = wherePart;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		return null;
	}

	@Override
	public String getQrySQLStr() {
		String sql = getBaseSql();
		String wherePart = GetWherePart();
		return String.format("%s WHERE %s", sql, wherePart);
	}

	private String getBaseSql() {
		StringBuffer sql = new StringBuffer();
		

		sql.append(" SELECT bd_bed.id_bed AS id_bed, ");
		sql.append(" 		bd_bed.code AS code, ");
		sql.append(" 		bd_bed.name AS name, ");
		sql.append(" 		bd_bed.room AS room, ");
		sql.append(" 		dep.name AS dept_name, ");
		sql.append(" 		udidoc.name AS bedsu_name, ");
		sql.append(" 		NULL             AS bedattrs ");
		sql.append(" FROM bd_bed bd_bed ");
		sql.append(" LEFT JOIN bd_dep dep ");
		sql.append(" ON bd_bed.id_dep_belong = dep.id_dep ");
		sql.append(" LEFT JOIN bd_udidoc udidoc ");
		sql.append(" ON bd_bed.id_bedsu = udidoc.ID_UDIDOC ");
		return sql.toString();
	}
	
	private String GetWherePart() {
		StringBuffer sb = new StringBuffer(" 1 = 1 ");
		String where =  BdEnvContextUtil.processEnvContext(new Bdbed(), "bd_bed");
		sb.append(" AND " + where);
		if (this._wherePart != null && !this._wherePart.isEmpty()) {
			sb.append(" AND ");
			sb.append(this._wherePart);
		}
		return sb.toString();
	}

}
