package iih.bd.srv.mrctmca.refs;

import org.apache.commons.lang.StringUtils;

import iih.bd.srv.mrctmca.d.MrCtmCaDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefTreeModel;

public class MrctmcaRefModel extends RefTreeModel {
	@Override
	public String[] getShowFieldCode() {
		return new String[] { MrCtmCaDO.CODE, MrCtmCaDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { MrCtmCaDO.ID_MRCACTM, MrCtmCaDO.ID_PARENT };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getTableName() {
		return new MrCtmCaDO().getTableName();
	}

	@Override
	public String getPkFieldCode() {
		return MrCtmCaDO.ID_MRCACTM;
	}

	@Override
	public String getRefCodeField() {
		return MrCtmCaDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return MrCtmCaDO.NAME;
	}

	@Override
	public String getChildField() {
		return MrCtmCaDO.ID_MRCACTM;
	}

	@Override
	public String getFatherField() {
		return MrCtmCaDO.ID_PARENT;
	}

	@Override
	public String[] getBlurFields() {

		return new String[] { MrCtmCaDO.CODE, MrCtmCaDO.NAME, MrCtmCaDO.PYCODE, MrCtmCaDO.WBCODE, MrCtmCaDO.MNECODE };

	}

	@Override
	public String getRefSql() {
		String wherePart = BuildWherePart();
		String orderPart = BuildOrderPart();
		String refSql;
		try {
			if(wherePart != null && !"".equals(wherePart))  {this.getWherePart().add(wherePart);}
			if(orderPart != null && !"".equals(orderPart))  {this.getOrderPart().add(orderPart);}
			refSql = super.getRefSql();

		} finally {
			if(wherePart != null && !"".equals(wherePart))  {this.getWherePart().remove(wherePart);}
			if(orderPart != null && !"".equals(orderPart))  {this.getOrderPart().remove(orderPart);}
		}

		return refSql;
	}

	/**
	 * 构建条件语句
	 * 
	 * @return
	 */
	private String BuildWherePart() {

		StringBuilder stringBuilder = new StringBuilder("1 = 1");
		stringBuilder.append(" and ds = 0 ");
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new MrCtmCaDO(), false);
		stringBuilder.append(String.format(" and %s ", BdModeWherePart));

		String Code_entp = (String) this.getExtendAttributeValue("Code_entp");
		String Docornurs = (String) this.getExtendAttributeValue("Docornurs");

		if (!StringUtils.isBlank(Code_entp)) {
			stringBuilder.append(" and code_entp = '" + Code_entp + "' ");
		}

		if (!StringUtils.isBlank(Docornurs)) {
			stringBuilder.append(" and docornur in " + Docornurs + " ");
		}

		return stringBuilder.toString();
	}

	/**
	 * 构建排序语句
	 * 
	 * @return
	 */
	private String BuildOrderPart() {
		StringBuilder stringBuilder = new StringBuilder();
		return stringBuilder.toString();
	}
}
