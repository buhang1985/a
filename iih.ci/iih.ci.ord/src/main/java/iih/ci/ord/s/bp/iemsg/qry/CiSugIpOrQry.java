package iih.ci.ord.s.bp.iemsg.qry;

import iih.bd.bc.udi.pub.ICiDictCodeTypeConst;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.qry.sql.Sur4IESql;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import xap.mw.core.data.Context;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * BS007 ：住院手术
 *
 */
public class CiSugIpOrQry implements ITransQry {

	private String _id_ors;
	
	public CiSugIpOrQry(String id_ors){
		this._id_ors = id_ors;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlpram = new SqlParam();
		sqlpram.addParam( ICiDictCodeTypeConst.ID_SU_BL_1 );
		sqlpram.addParam( ICiDictCodeTypeConst.SD_SU_BL );
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
	 private String getSql(){
		 String id_or4sql=CiOrdUtils.getSqlInOrEqualStrs(_id_ors);
		 String formatsql=new Sur4IESql().CiIeOropSql(id_or4sql);
		 CiEnContextDTO ctx = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		 OrdBizLogger.info(ctx, "BS007  手术 住院 sql:"+formatsql+"param:@@@@AA10000000026638,@@@@ZZ2000000000005S");
		 return formatsql;
	 }

}
