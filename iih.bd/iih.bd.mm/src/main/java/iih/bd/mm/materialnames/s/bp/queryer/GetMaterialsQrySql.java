package iih.bd.mm.materialnames.s.bp.queryer;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取药品通用名关联药品信息查询sql
 * 
 * @author hao_wu
 *
 */
public class GetMaterialsQrySql implements ITransQry {

	private String srvId;

	public GetMaterialsQrySql(String srvId) {
		this.srvId = srvId;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer stringbuffer) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(srvId);
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("BD_MM.id_srv AS id_materialname, ");
		sql.append("BD_MM.id_mm, ");
		sql.append("BD_MM.code AS mm_code, ");
		sql.append("BD_MM.name AS mm_name, ");
		sql.append("BD_MM.spec AS mm_spec, ");
		sql.append("BD_SUP.NAME AS mm_sup_name ");
		sql.append("FROM BD_MM ");
		sql.append("LEFT JOIN BD_SUP ");
		sql.append("ON bd_mm.ID_SUP = BD_SUP.ID_SUP ");
		sql.append("WHERE BD_MM.ID_SRV = ?");
		return sql.toString();
	}
}
