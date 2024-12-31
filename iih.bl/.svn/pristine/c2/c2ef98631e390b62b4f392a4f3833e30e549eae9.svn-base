package iih.bl.st.blstip.bp.Qry;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetHistoryStQry implements ITransQry {

	private String entId;

	/**
	 * 获取患者收费信息
	 * 
	 * @param ID_STOEPs
	 * @throws BizException
	 * @author liwenqiang 2017.11.27
	 */
	public GetHistoryStQry(String entId) throws BizException {
		this.entId = entId;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(entId);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT");
		sql.append(" id_stip id_st,");
		sql.append(" code_st code_st,");
		sql.append(" eu_direct,");
		sql.append(" fg_pay");
		sql.append(" FROM bl_St_ip WHERE id_ent=?");
		sql.append(" order by dt_st desc ");
		return sql.toString();
	}
}
