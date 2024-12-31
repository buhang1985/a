package iih.ci.ord.s.bp.iemsg.qry;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.qry.sql.Sur4IESql;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import xap.mw.core.data.Context;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

public class CiSugOrInfoQry implements ITransQry{
	private String id_ors;

	public CiSugOrInfoQry(String id_ors) {
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
	 * 获取手术医嘱
	 * @return
	 */
	public String getSql() {
		String id_or4sql=CiOrdUtils.getSqlInOrEqualStrs(id_ors);
		String formatsql=new Sur4IESql().IpSugInfoSql(id_or4sql);
		CiEnContextDTO ctx = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		OrdBizLogger.info(ctx, "BS007 门诊/住院手术 医嘱信息 IEOperationInfoDTO sql:"+formatsql);
		return formatsql;
	}
}
