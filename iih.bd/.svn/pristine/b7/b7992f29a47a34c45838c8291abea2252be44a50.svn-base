package iih.bd.fc.s.bp.qry;

import iih.bd.fc.orpltp.d.OrpltpStaDO;
import iih.bd.fc.s.bp.common.BdFcEnvContextUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取闭环的叶子节点
 * @author xuxing_2017年7月11日20:41:13
 *
 */
public class GetOrpltpstaLeaveSql implements ITransQry {

	private String Id_orpltp;

	public GetOrpltpstaLeaveSql(String id_orpltp) {
		Id_orpltp = id_orpltp;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(Id_orpltp);
		return param;
	}

	@Override
	public String getQrySQLStr() {

		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select sta.*,'N' as fg_update,'N' as fg_error from bd_orpltpsta sta ");
		sqlStr.append(" where sta.id_orpltpsta not in ");
		sqlStr.append(" ( ");
		sqlStr.append("   select id_par  ");
		sqlStr.append("   from bd_orpltpsta parsta ");
		sqlStr.append("   where (id_par is not null and id_par<>'~') ");
		sqlStr.append(" ) ");
		sqlStr.append(" and sta.id_orpltp=? ");
		sqlStr.append(" and " + new BdFcEnvContextUtil().getWherePart(new OrpltpStaDO(), "sta"));
		sqlStr.append(" order by sta.sortno asc ");
		return sqlStr.toString();
	}

}
