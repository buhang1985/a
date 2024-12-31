package iih.bl.st.opfeeout.bp.qry;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetBlStItemInfoDTOQry implements ITransQry {

	List<String> id_stoeps;

	/***
	 * 查询费用信息
	 * @param ID_STOEPs
	 * @throws BizException
	 * @author liwenqiang f 2017.11.27
	 */
	public GetBlStItemInfoDTOQry(List<String> ID_STOEPs) throws BizException {

		this.id_stoeps = ID_STOEPs;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();

		for (String id_stoep : id_stoeps) {
			param.addParam(id_stoep);
		}
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append(" select");
		sql.append(" ST.id_stoep id_stoep,");
		sql.append(" incitm.NAME NAME,");
		sql.append(" NVL(INCITM.AMT_RATIO, 0) AMT ");
		sql.append(" FROM BL_INC_ITM_OEP incitm");
		sql.append(" INNER JOIN BL_INC_OEP inc ON INC.ID_INCOEP=INCITM.ID_INCOEP ");
		sql.append(" INNER JOIN BL_ST_OEP st ON ST.id_stoep=INC.id_stoep ");
		sql.append(" WHERE ST.eu_direct = '1'");
		sql.append(" AND ST.ID_STOEP IN(");
		for (String id_stoep : this.id_stoeps) {
			sql.append("?,");
		}
		sql.append("'0') ");
		return sql.toString();
	}

}
