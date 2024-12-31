package iih.bd.fc.s.bp.qry;

import iih.bd.fc.orpltpstafunc.d.OrpltpStaFuncDO;
import iih.bd.fc.s.bp.common.BdFcEnvContextUtil;
import iih.bd.fc.wf.d.WfDO;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetorpltpStaByFunCodesSql implements ITransQry {

	private String[] Fun_codes;

	public GetorpltpStaByFunCodesSql(String[] fun_codes) {
		Fun_codes = fun_codes;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {

		SqlParam param = new SqlParam();

		if (Fun_codes != null && Fun_codes.length > 0) {

			for (String fun_code : Fun_codes) {

				param.addParam(fun_code);
			}
		}

		return param;
	}

	@Override
	public String getQrySQLStr() {

		return getSqlStr();
	}

	public String getSqlStr() {

		StringBuffer SqlStr = new StringBuffer();

		SqlStr.append(" select                                                               ");
		SqlStr.append(" func.*,                                                              ");
		SqlStr.append(" sta.sortno                                                           ");
		SqlStr.append(" from BD_ORPLTPSTA_FUNC func                                          ");
		SqlStr.append(" left join bd_orpltpsta sta on sta.id_orpltpsta=func.id_orpltpsta     ");
		SqlStr.append(" where func.ds=0                                                      ");
		SqlStr.append(" and " + new BdFcEnvContextUtil().getWherePart(new OrpltpStaFuncDO(), "func"));

		if (Fun_codes != null && Fun_codes.length > 0) {

			if (Fun_codes.length > 1) {

				String whereStr = "";

				for (int i = 0; i < Fun_codes.length; i++) {

					whereStr += (whereStr.length() == 0 ? "" : ",") + "?";
				}

				SqlStr.append(" and func.fun_code in(" + whereStr + ") ");

			} else {

				SqlStr.append(" and func.fun_code = ? ");
			}

		} else {

			SqlStr.append(" and 1=2 ");
		}
		return SqlStr.toString();
	}
}
