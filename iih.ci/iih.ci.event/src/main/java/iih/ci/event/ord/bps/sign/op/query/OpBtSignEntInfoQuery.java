package iih.ci.event.ord.bps.sign.op.query;

import iih.ci.event.ord.bps.sign.op.sql.OpBtSignSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * BS008-备血 门诊签署 就诊申请信息
 * @author F
 *
 * @date 2019年8月22日上午10:56:24
 *
 * @classpath iih.ci.event.ord.bps.sign.op.query.OpBtSignEntInfoQuery
 */
public class OpBtSignEntInfoQuery implements ITransQry{

	private String id_ors;
	
	public OpBtSignEntInfoQuery(String id_ors){
		this.id_ors = id_ors;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		return getSql();
	}
   
	/**
	 * 获得查询sql串
	 * @return
	 */
	 private String getSql(){//【IEOpBtOrEnDTO】
		 String id_or4sql=OrdEventUtil.getSqlInOrEqualStrs(id_ors);
		 String formatsql=new OpBtSignSql().getOpBtSignEntInfoSql(id_or4sql);
		 OrdEventLogger.info(this.getClass().getSimpleName(), "BS008-备血 门诊签署 就诊申请信息 sql:"+formatsql);
		 return formatsql;
	 }
}
