package iih.bl.inc.blecinccomp.s.bp.sql;

import iih.bd.base.utils.StringUtils;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.udi.d.UdidocDO;

public class LoadTableDataSql implements ITransQry {

	private String[] _strings;
	private UdidocDO _udidocDO;
	
	public LoadTableDataSql(String[] strings,UdidocDO udidocDO) {
		this._strings = strings;
		this._udidocDO = udidocDO;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer stringbuffer) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(Context.get().getGroupId());
		sqlParam.addParam(Context.get().getOrgId());
		sqlParam.addParam(this._udidocDO.getId_udidoc());
		sqlParam.addParam(this._udidocDO.getCode());
		sqlParam.addParam(DOStatus.NEW);
		sqlParam.addParam(this._udidocDO.getCode());
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select  ?        as  id_grp, ");
		sql.append("               ?        as  id_org, ");
		sql.append("               ?        as  ID_COMPTYPE, ");
		sql.append("               ?        as  SD_COMPTYPE, ");
		
		sql.append("               ").append(this._strings[1]).append(" as code,");
		sql.append("               ").append(this._strings[2]).append(" as name,");
		sql.append("               ?        as  Status ");
		sql.append("     from ").append(this._strings[0]);
		sql.append(" where not exists (select b.* from bl_ec_inc_comp b where ").append(this._strings[0]+"."+this._strings[1]).append("=b.code and b.SD_COMPTYPE=?)");
		if (StringUtils.isNotEmpty(_udidocDO.getCtrl3())) {
			sql.append("                             and ").append(this._udidocDO.getCtrl3());
		}

		return sql.toString();
	}

}
