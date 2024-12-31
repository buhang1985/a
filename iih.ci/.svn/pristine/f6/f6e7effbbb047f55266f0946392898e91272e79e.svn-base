package iih.ci.event.ord.bps.sign.ip.query;

import iih.ci.event.ord.bps.sign.ip.sql.IpLisSignSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * BS006 住院检验签署 所有信息
 * @author F
 *
 * @date 2019年8月26日下午1:38:29
 *
 * @classpath iih.ci.event.ord.bps.sign.ip.query.IpLisSignAllInfoQuery
 */
public class IpLisSignAllInfoQuery implements ITransQry{

	private String _id_ors;
	public IpLisSignAllInfoQuery(String id_ors){
		this._id_ors = id_ors;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlpram = new SqlParam();
		sqlpram.addParam(OrdEventUtil.ID_SU_BL_1); 
		sqlpram.addParam(OrdEventUtil.SD_SU_BL);
		return sqlpram;
	}

	@Override
	public String getQrySQLStr() {
		return getSql();
	}
   
	/**
	 * 获得查询sql串
	 * @return
	 */
	 private String getSql(){//就诊【IEOpLisOrEnDTO】 申请单【IEOpLisOrDTO】 医嘱项目【IEOpLisOrItmDTO】
		 String id_or4sql=OrdEventUtil.getSqlInOrEqualStrs(_id_ors);
		 String formatsql=new IpLisSignSql().getIpLisSignAllInfoSql(id_or4sql);
		 OrdEventLogger.info(this.getClass().getSimpleName(), "BS006 住院检验签署 所有信息 sql:"+formatsql+"param:"+"@@@@AA10000000026638,@@@@ZZ2000000000005S");
		 return formatsql;
	 }
}
