package iih.mi.bd.cataloguploadrcd.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询可用数据
 * Title: FindUseringDataSql.java
 * @author zhang.hw
 * @date 2019年5月16日  
 * @version 1.0
 */
public class FindUseringDataSql implements ITransQry {

	private String idHp;
	private String miSrvTp;
	
	public FindUseringDataSql(String idHp,String miSrvTp){
		this.idHp = idHp;
		this.miSrvTp = miSrvTp;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(this.idHp);
		sqlParam.addParam(this.miSrvTp);
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append(" select * from mi_catg_up_rcd a where a.id_hp=? and a.eu_hpsrvtp=? order by a.dt_download desc ");
		return sql.toString();
	}

}
