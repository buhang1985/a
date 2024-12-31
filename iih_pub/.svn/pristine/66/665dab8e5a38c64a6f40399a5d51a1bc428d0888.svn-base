package iih.bd.srv.medsrv.refs;

import iih.bd.srv.medsrv.d.MedSrvDO;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.permfw.pub.EnvContextUtil;

public class MedSrv4EnStatusRefModel extends RefGridModel {
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
		
		String refSql = super.getRefSql();
		String sqlContext = " and " + EnvContextUtil.processEnvContext("", new MedSrvDO(), "bd_srv");//增加组织隔离
		return refSql+sqlContext;
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { MedSrvDO.NAME, MedSrvDO.CODE, MedSrvDO.PYCODE, MedSrvDO.MNECODE };
	}

}
