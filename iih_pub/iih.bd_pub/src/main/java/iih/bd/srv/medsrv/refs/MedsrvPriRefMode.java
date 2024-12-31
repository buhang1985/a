package iih.bd.srv.medsrv.refs;

import iih.bd.pp.primd.i.IBdPrimdCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class MedsrvPriRefMode extends RefGridModel {
	@Override
	public String[] getShowFieldCode() {
		return new String[] { "name", "code", "wbcode" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { "id_srv", "id_srvca", "id_unit_med", "code_unit_med", "name_unit_med", "quan_med",
				"fg_set", "id_primd", "srvca_name" };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "服务名称", "编码", "助记码" };
	}

	@Override
	public String getPkFieldCode() {
		return "id_srv";
	}

	@Override
	public String getRefCodeField() {
		return "code";
	}

	@Override
	public String getRefNameField() {
		return "name";
	}

	@Override
	public String getTableName() {
		return new MedSrvDO().getTableName();
	}

	@Override
	public void addWherePart(String wherePart) {

		getWherePart().add(wherePart);
	}

	@Override
	public String getRefSql() {

		String primdcode = (String) this.getExtendAttributeValue("pricode");
		String sql = "select p.name as name, p.code as code, p.wbcode,p.id_srv,p.id_srvca,id_unit_med,"
				+ " t.code  as code_unit_med,t.name as name_unit_med, quan_med, fg_set,id_primd,c.name as srvca_name from bd_srv p"
				+ "  left outer join bd_measdoc t on p.id_unit_med = t.id_measdoc left join bd_srvca c on p.id_srvca= c.id_srvca";
		if (primdcode.equals(IBdPrimdCodeConst.CODE_PRI_SRVSET_AMOUNT)
				|| primdcode.equals(IBdPrimdCodeConst.CODE_PRI_SRVSET_MU)
				|| primdcode.equals(IBdPrimdCodeConst.CODE_PRI_SRVSET_FIX)) {
			sql += " where p.ds=0 and p.Fg_set='Y'";
		}

		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new MedSrvDO(), "p");
		sql += String.format(" and %s ", BdModeWherePart);

		// SqlParam param=new SqlParam();
		// param.addParam(priId);
		return sql;
	}

	@Override
	public String afterBuilderSql(String sql) {

		return super.afterBuilderSql(sql);
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { "name", "code", "wbcode" };
	}

}
