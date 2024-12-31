package iih.bd.fc.orpltp.refs;

import iih.bd.fc.orpltp.d.OrpltpStaDO;
import iih.bd.fc.orpltp.d.desc.OrpltpStaDODesc;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class OrpltpStaRefModel extends RefGridModel {

	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { OrpltpStaDO.CODE, OrpltpStaDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { OrpltpStaDO.ID_ORPLTPSTA };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return OrpltpStaDO.ID_ORPLTPSTA;
	}

	@Override
	public String getRefCodeField() {
		return OrpltpStaDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return OrpltpStaDO.NAME;
	}

	@Override
	public String getTableName() {
		return OrpltpStaDODesc.TABLE_NAME;
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { OrpltpStaDO.CODE, OrpltpStaDO.NAME };
	}

	@Override
	public String getRefSql() {
		String wherePart = BuildWherePart();
		String orderPart = BuildOrderPart();
		String refSql;
		try {
			if (wherePart != null && !"".equals(wherePart)) {
				this.getWherePart().add(wherePart);
			}
			if (orderPart != null && !"".equals(orderPart)) {
				this.getOrderPart().add(orderPart);
			}
			refSql = super.getRefSql();

		} finally {
			if (wherePart != null && !"".equals(wherePart)) {
				this.getWherePart().remove(wherePart);
			}
			if (orderPart != null && !"".equals(orderPart)) {
				this.getOrderPart().remove(orderPart);
			}
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new OrpltpStaDO(), false);
		stringBuilder.append(String.format(" and %s ", BdModeWherePart));

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
