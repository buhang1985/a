package iih.ei.std.s.v1.bp.pe.pacsdata.qry;

import iih.pe.papt.pepsncatsel.d.PePsnapptCatDO;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.permfw.pub.EnvContextUtil;

public class GetPeObsApOrInfoSql implements ITransQry{

	private String frefix = "1001";
	private String apply_no; //申请单号

	public GetPeObsApOrInfoSql(String apply_no) {
		super();
		this.apply_no = apply_no;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		
		if (!StringUtil.isEmptyWithTrim(apply_no)) {
			param.addParam(frefix + apply_no);
		}
		return param;
	}

	@Override
	public String getQrySQLStr() {

		StringBuffer sql = new StringBuffer();
		sql.append(" select cior.id_pepsnapptcat as id_or, ");// 医嘱编码
		sql.append(" substr(cior.id_pepsnapptcat, 5, 16) as applyno, ");  //申请单号
		sql.append(" cior.id_pepsnappt as id_en,             ");
		sql.append(" cior.no_apply,             ");
		sql.append(" cior.no_barcode,         ");
		sql.append(" app.id_srv         ");
		sql.append(" from pe_apt_pepsnapptcat cior inner join pe_itm_pesrvcastapp app on cior.id_pesrvcatlog = app.id_pesrvbcatlog");
		sql.append(" where cior.id_pepsnapptcat = ?");

		return sql.toString();
	}

}