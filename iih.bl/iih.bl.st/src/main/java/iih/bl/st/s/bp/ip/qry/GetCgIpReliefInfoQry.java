package iih.bl.st.s.bp.ip.qry;

import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 记账未结算信息查寻
 * Title: GetCgIpReliefInfoQry.java
 * @author zhang.hw
 * @date 2019年5月14日  
 * @version 1.0
 */
public class GetCgIpReliefInfoQry implements ITransQry {
	String stId; 

	public GetCgIpReliefInfoQry(String stId) throws BizException {
		this.stId = stId;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(this.stId);
		return param;
	}
	
	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append("select  ");
		sql.append("st.id_stip, ");
		sql.append("cg.id_cgip, ");
		sql.append("cg.code_inccaitm,");
		sql.append("cg.name_inccaitm,");
		sql.append("cg.name_srv, ");
		sql.append("cg.name_mm, ");
		sql.append("srv.wbcode wb_srv, ");
		sql.append("srv.pycode py_srv,");
		sql.append("cg.AMT_RATIO * cg.eu_direct AMT_RATIO,  ");
		sql.append("cg.AMT* cg.eu_direct AMT, ");
		sql.append("cg.quan* cg.eu_direct quan, ");
		sql.append("cg.RATIO_PRIPAT,");
		sql.append("cg.fg_free ");
		sql.append("from bl_cg_ip cg  ");
		sql.append("left JOIN bl_st_ip st on cg.id_stip=st.id_stip  ");
		sql.append("left join bd_srv srv on cg.id_srv=srv.id_srv ");
		sql.append("left join bd_mm mm on cg.id_mm = mm.id_mm ");
		sql.append("where nvl(cg.fg_research,'N')='N' and st.id_stip=? ");
		//sql.append(" and cg.fg_refund='N' ");
		return sql.toString();
	}

}
