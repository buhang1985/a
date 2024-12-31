package iih.bl.inc.blecinccomp.s.bp.sql;

import iih.bd.base.utils.StringUtils;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class FindIncCompDataListSql implements ITransQry {
	
	private String[] _strings;
	private String _id_udidoc;
	private String _whereParam;

	public FindIncCompDataListSql(String[] strings,String id_udidoc,String whereParam) {
		this._strings = strings;
		this._id_udidoc = id_udidoc;
		this._whereParam = whereParam;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer stringbuffer) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(this._id_udidoc);
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select distinct ecinc.id_ecinccomp, ");
		sql.append("               ecinc.id_grp, ");
		sql.append("               ecinc.id_org, ");
		sql.append("               ecinc.id_comptype, ");
		sql.append("               ecinc.sd_comptype, ");
		sql.append("               ecinc.code, ");
		sql.append("               ecinc.name, ");
		sql.append("               ecinc.ecinc_code, ");
		sql.append("               ecinc.ecinc_name, ");
		sql.append("               ecinc.createdby, ");
		sql.append("               ecinc.createdtime, ");
		sql.append("               ecinc.modifiedby, ");
		sql.append("               ecinc.modifiedtime, ");
		sql.append("               udidoc.ctrl1, ");
		sql.append("               udidoc.ctrl2, ");
		sql.append("               udidoc.ctrl3 ");
		sql.append("     from  bl_ec_inc_comp  ecinc ");
		sql.append("   inner  join  bd_udidoc  udidoc ");
		sql.append("         on  ecinc.id_comptype  =  udidoc.id_udidoc ");
		sql.append("     left  join  (select  * ");
		sql.append("                               from ").append(this._strings[0]+"  ");
		if (StringUtils.isNotEmpty(_whereParam)&&this._whereParam!=null) {
			sql.append("                             where ").append(this._whereParam+" )  itm ");
		}else {
			sql.append("                            )  itm ");
		}
		
		sql.append("         on  itm.").append(this._strings[1]+" =  ecinc.code ");
		sql.append("     where  udidoc.id_udidoc=? ");

		return sql.toString();
	}

}
