package iih.ci.event.ord.bps.sign.ip.query;

import iih.ci.event.ord.bps.sign.ip.sql.IpConCompleteSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * BS340住院会诊完成-医师信息集合
 * @author zhengqiang
 *
 */
public class IpConCompleteDocInfoQuery implements ITransQry {

private String _id_ors;
	
	public IpConCompleteDocInfoQuery(String id_ors){
		this._id_ors = id_ors;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer paramStringBuffer) {
		SqlParam sqlParam = new SqlParam();
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		return getSql();
	}
	/**
	 * 获取IpConCompleteSql查询的数据
	 * @return
	 */
	private String getSql() {
		 //获得查询条件sql串 含in 或 =
		 String id_or4sql = OrdEventUtil.getSqlInOrEqualStrs(_id_ors);
		 //主体语句
		 String formatsql = new IpConCompleteSql().getIpConCompleteDocInfoSql(id_or4sql);
		 OrdEventLogger.info(this.getClass().getSimpleName(), "BS340 住院会诊完成医师信息sql："+formatsql);
		 return formatsql;
	}

}
