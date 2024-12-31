package iih.ci.diag.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询指定就诊的诊断明细
 * @author hums
 *
 */
public class GetCiDiagItemsBPQry implements ITransQry{

	// 就诊id
	private String id_en;
	// 诊断类型编码
	private String sd_ditp;

	public GetCiDiagItemsBPQry(String id_en,String sd_ditp) {

			this.id_en = id_en;
			this.sd_ditp = sd_ditp;
		}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {

		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(this.id_en);
		sqlParam.addParam(this.sd_ditp);
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {

		String sql = "select t.* from ci_di_itm t, ci_di p where t.id_di = p.id_di and p.id_en=?"
				+ " and p.fg_sign = 'Y' and p.sd_ditp = ?";

		return sql;
	}
}
