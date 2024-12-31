package iih.ci.ord.s.bp.iemsg.qry;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.qry.sql.Sur4IESql;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import xap.mw.core.data.Context;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class CiSugAssistInfoQry implements ITransQry {

	private String _id_or;
	
	public CiSugAssistInfoQry(String id_or){
		this._id_or = id_or;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlpram = new SqlParam();
		return sqlpram;
	}

	@Override
	public String getQrySQLStr() {
		
		return  getSql();
	}
	
	/**
	 * 获得查询sql串
	 * @return
	 */
	 private String getSql(){
		 String id_or4sql=CiOrdUtils.getSqlInOrEqualStrs(_id_or);
		 String formatsql= new Sur4IESql().IpSugAssistInfoSql(id_or4sql);
		 CiEnContextDTO ctx = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		 OrdBizLogger.info(ctx, "BS007 住院手术 助手护士信息 IESugAssistDTO sql:"+formatsql);
		 return formatsql;
	 }

}
