package iih.ci.ord.s.ems.op.orderv1.bp.qry;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetCiOrderDOs4CancelQry implements ITransQry {

	private String id_ors = "";

	public GetCiOrderDOs4CancelQry(String id_ors) {
		this.id_ors = id_ors;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		return new SqlParam();
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		String sqlStr = "select Id_or from ci_order "
				+ "where Fg_sign='Y' and Fg_canc='N' and Fg_uncancelable='N'"
				+ "and Sd_su_bl in ('" + ICiDictCodeConst.SD_SU_BL_NONE + "','" + ICiDictCodeConst.SD_SU_BL_REFOUND + "') "
				+ "and Id_or in (" + this.id_ors + "))";
		return sqlStr;
	}

}
