package iih.bd.srv.medsrv.refs;

import java.util.List;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.permfw.pub.EnvContextUtil;

public class MedSrvMmRefModel extends RefGridModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { MedSrvDO.NAME, MedSrvDO.CODE, MedSrvDO.MNECODE };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { MedSrvDO.FG_MM, MedSrvDO.ID_SRV, MedSrvDO.ID_SRVTP, MedSrvDO.FG_OR, MedSrvDO.FG_ACTIVE,
				MedSrvDO.QUAN_MED, MedSrvDO.ID_UNIT_MED, MedSrvDO.FG_SET, MedSrvDO.ID_SRVCA, MedSrvDO.SD_SRVTP,
				MedSrvDO.PRI, MedSrvDO.DS, MedSrvDO.SHORTNAME, MedSrvDO.FG_CTM };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "服务名称", "编码", "助记码" };
	}

	@Override
	public String getPkFieldCode() {
		return MedSrvDO.ID_SRV;
	}

	@Override
	public String getRefCodeField() {
		return MedSrvDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return MedSrvDO.NAME;
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

		String sql = this.getMySqlStr();
		String sqlContext = " and " + EnvContextUtil.processEnvContext("", new MedSrvDO(), "bd_srv");//增加组织隔离
		sql+=sqlContext;
		
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new MedSrvDO(), false);
		sql += String.format(" and %s ", BdModeWherePart);

		List<String> whereParts = this.getWherePart();
		for (String wherepart : whereParts) {
			sql += " and " + wherepart;
		}

		sql += " order by bd_srv.code ";
		return sql;
	}

	public String getMySqlStr() {
		String sql = "select bd_srv.Name,bd_srv.Code,bd_srv.Mnecode,bd_srv.Fg_mm,bd_srv.Id_srv,bd_srv.Id_srvtp,"
				+ "bd_srv.Fg_or,bd_srv.Fg_active,bd_srv.Quan_med,bd_srv.Id_unit_med,bd_srv.Fg_set,bd_srv.Id_srvca,"
				+ "bd_srv.Sd_srvtp,bd_srv.Pri,bd_srv.Ds,bd_srv.Shortname,bd_srv.Fg_ctm " + "from bd_srv bd_srv "
				+ "left join bd_mm bd_mm on bd_mm.id_srv = bd_srv.id_srv "
				+ " where (bd_srv.fg_mm = 'N' or (bd_srv.fg_mm = 'Y' and bd_mm.fg_charge = 'N'))  ";
		// + "and bd_srv.fg_bl='Y' and bd_srv.fg_active='Y' and bd_srv.ds=0 "
		// +" and bd_srv.id_primd in (select id_pri from bd_pri where code='00'
		// or code='04') ";
		return sql;
	}

	@Override
	public String afterBuilderSql(String sql) {
		return super.afterBuilderSql(sql);
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { MedSrvDO.NAME, MedSrvDO.CODE, MedSrvDO.PYCODE, MedSrvDO.MNECODE };
	}	

}
