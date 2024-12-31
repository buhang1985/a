package iih.mp.nr.opreport.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据分组标记no_grps获取分组总数量
 * 
 * @author fengjj
 * @date 2019年3月20日18:55:54 创建
 *
 */
public class getGrpNoInfosSql implements ITransQry {
	private String grp_nos;

	public getGrpNoInfosSql(String grp_nos) {
		this.grp_nos = grp_nos;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		return new SqlParam();
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" SELECT no_grp,count(no_grp) as num FROM mp_infu_grp ");
		sqlStr.append(" where no_grp in (" + this.grp_nos + ")  group by no_grp");
		return sqlStr.toString();
	}

}
