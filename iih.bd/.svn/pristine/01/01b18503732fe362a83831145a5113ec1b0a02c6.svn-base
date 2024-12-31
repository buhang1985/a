package iih.bd.fc.orderlooptype.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 取全部说我闭环状态
 * @author huang_junhao
 *
 */
public class getOrpltpStaByOrpltpSql implements ITransQry {

	private String[] Id_orpltps;

	public getOrpltpStaByOrpltpSql(String[] id_orpltp) {
		Id_orpltps = id_orpltp;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {

		SqlParam param = new SqlParam();

		if (Id_orpltps != null && Id_orpltps.length > 0) {

			for (String id_orpltp : Id_orpltps) {

				param.addParam(id_orpltp);
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

		SqlStr.append(" select sta.* from bd_orpltpsta sta    ");
		SqlStr.append(" where sta.id_orpltpsta not in         ");
		SqlStr.append(" (                                     ");
		SqlStr.append("     select id_par from bd_orpltpsta   ");
		SqlStr.append("     where nvl(id_par,'~')<>'~'        ");
		SqlStr.append(" )                                     ");

		if (Id_orpltps != null && Id_orpltps.length > 0) {

			String whereInStr = "";

			for (int i = 0; i < Id_orpltps.length; i++) {

				whereInStr += (whereInStr.length() == 0 ? "" : ",") + "?";
			}

			SqlStr.append(" and sta.id_orpltp in(" + whereInStr + ") ");

		}

		SqlStr.append(" order by sta.sortno asc               ");

		return SqlStr.toString();

	}
}
