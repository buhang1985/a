package iih.bd.mm.drugcombctl.s.bp.qry;

import iih.bd.mm.drugcombctl.d.DrugCombCtlDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询联合用药限制信息SQL
 * 
 * @author hao_wu 2018-11-6
 *
 */
public class FindDrugCombCtlQry implements ITransQry {

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT Id_drugcombctl AS Id_drugcombctl,");
		sqlBuilder.append(" Eu_ctltp AS Eu_ctltp,");
		sqlBuilder.append(" DECODE(Eu_ctltp,'0',id_mmca,'1',id_mmca_ctm,'2',id_srvca,'3',id_srvca_ctm,'') AS Id_cas,");
		sqlBuilder.append(" Eu_ctlmode AS Eu_ctlmode ,");
		sqlBuilder.append(" Msg_hint AS Msg_hint ");
		sqlBuilder.append("FROM BD_DRUGCOMPCTLCA ");
		sqlBuilder.append("WHERE DS = '0' ");

		String wherePart = BdEnvContextUtil.processEnvContext(new DrugCombCtlDO(), false);
		sqlBuilder.append(" AND ");
		sqlBuilder.append(wherePart);

		return sqlBuilder.toString();
	}

}
