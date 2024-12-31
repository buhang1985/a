package iih.ci.event.ord.bps.revert.op.query;

import iih.bd.bc.udi.pub.ICiDictCodeTypeConst;
import iih.ci.event.ord.bps.revert.op.sql.OpLisRevertSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * BS006门检验撤回所有信息
 * @author F
 *
 * @date 2019年9月11日上午11:59:35
 *
 * @classpath iih.ci.event.ord.bps.revert.op.query.OpLisRevertAllInfoQuery
 */
public class OpLisRevertAllInfoQuery implements ITransQry{
	
	private String _id_ors;
	
	public OpLisRevertAllInfoQuery(String id_ors){
		this._id_ors = id_ors;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlpram = new SqlParam();
		sqlpram.addParam(ICiDictCodeTypeConst.ID_SU_BL_1); 
		sqlpram.addParam(ICiDictCodeTypeConst.SD_SU_BL);
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
		 String formatsql=new OpLisRevertSql().getOpLisWithDrawAllInfoSql(id_or4sql);
		 OrdEventLogger.info(this.getClass().getSimpleName(), "BS006门检验撤回所有信息sql:"+formatsql+"param:"+"@@@@AA10000000026638,@@@@ZZ2000000000005S");
		 return formatsql;
	 }

}
