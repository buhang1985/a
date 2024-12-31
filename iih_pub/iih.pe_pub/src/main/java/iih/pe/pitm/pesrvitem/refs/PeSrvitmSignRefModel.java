package iih.pe.pitm.pesrvitem.refs;

import iih.pe.pitm.pesrvitem.d.PeSrvitmSignDO;
import iih.pe.comm.utils.PeEnvContextUtil;
import xap.sys.appfw.refinfo.RefTreeModel;

public class PeSrvitmSignRefModel extends RefTreeModel {

	@Override
	public String[] getShowFieldCode() {
		return new String[] { PeSrvitmSignDO.CODE, PeSrvitmSignDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PeSrvitmSignDO.ID_PESRVITMSIGN, PeSrvitmSignDO.ID_PESRVITMSIGN_PAR};
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称"};
	}

	@Override
	public String getTableName() {
		return new PeSrvitmSignDO().getTableName();
	}

	@Override
	public String getPkFieldCode() {
		return PeSrvitmSignDO.ID_PESRVITMSIGN;
	}

	@Override
	public String getRefCodeField() {
		return PeSrvitmSignDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PeSrvitmSignDO.NAME;
	}

	@Override
	public String getChildField() {
		return PeSrvitmSignDO.ID_PESRVITMSIGN;
	}

	@Override
	public String getFatherField() {
		return PeSrvitmSignDO.ID_PESRVITMSIGN_PAR;
	}


	@Override
	public String afterBuilderSql(String sql) {

		return super.afterBuilderSql(sql);
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { PeSrvitmSignDO.NAME, PeSrvitmSignDO.CODE };
	}

	/**
	 * 构建条件语句
	 * 
	 * @return
	 */
	private String BuildWherePart() {

		StringBuilder stringBuilder = new StringBuilder(" 1 = 1 ");

		String id_pesrvitem = (String) this.getExtendAttributeValue("id_pesrvitem");

		if (id_pesrvitem != null && !id_pesrvitem.equals("")) {
			stringBuilder.append(" and id_pesrvitem = '" + id_pesrvitem + "' ");
		}
		return stringBuilder.toString();
	}
	
	@Override
	public String getRefSql() {
		String wherePart = BuildWherePart();
		String refSql;
		try {
			if (wherePart != null && !"".equals(wherePart)) {
				this.getWherePart().add(wherePart);
			}
			refSql = super.getRefSql();

		} finally {
			if (wherePart != null && !"".equals(wherePart)) {
				this.getWherePart().remove(wherePart);
			}
		}

		return refSql;
	}
}
