package iih.ci.ord.s.bp.iemsg.qry;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.qry.sql.ConsulationSql;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import xap.mw.core.data.Context;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 会诊BS318 子表数据查询
 * 
 * @author Administrator
 *
 */
public class CiConsulationDeptQry implements ITransQry{
	
	private String _id_ors;
	
	public CiConsulationDeptQry(String id_ors){
		this._id_ors = id_ors;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer var1) {
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
	 private String getSql(){
		 //获得查询条件sql串 含in 或 =
		 String id_or4sql = CiOrdUtils.getSqlInOrEqualStrs(_id_ors);
		 //主体语句
		 String formatsql = new ConsulationSql().getConsulationDeptSql(id_or4sql);
		 CiEnContextDTO ctx = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		 OrdBizLogger.info(ctx, "BS318会诊申请子表sql:"+formatsql);
		 return formatsql;
	 }
}
