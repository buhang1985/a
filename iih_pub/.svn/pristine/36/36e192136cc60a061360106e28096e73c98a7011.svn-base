package iih.mkr.std.commonde.refs;

import org.apache.commons.lang.StringUtils;

import iih.mkr.std.commonde.d.DataElementDO;
import iih.mkr.utils.MkrEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 公共数据元参照模型
 * 
 * @author hao_wu
 *
 */
public class DeRefModel extends RefGridModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3371122101739592875L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { DataElementDO.CODE, DataElementDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { DataElementDO.ID_DE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getTableName() {
		return new DataElementDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { DataElementDO.CODE, DataElementDO.WBCODE, DataElementDO.PYCODE, DataElementDO.NAME,
				DataElementDO.MNECODE };
	}

	@Override
	public String getPkFieldCode() {
		return DataElementDO.ID_DE;
	}

	@Override
	public String getRefCodeField() {
		return DataElementDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return DataElementDO.NAME;
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
		String dgId = (String) this.getExtendAttributeValue("dgId");

		StringBuilder stringBuilder = new StringBuilder("1 = 1");
		stringBuilder.append("and fg_active = 2 ");
		String BdModeWherePart = MkrEnvContextUtil.processEnvContext(new DataElementDO(), false);
		stringBuilder.append(String.format(" and %s ", BdModeWherePart));

		if (!StringUtils.isBlank(dgId)) {
			String wherePart = String.format(" and id_de in (select id_de from bd_dg_de where id_dg = '%s') ", dgId);
			stringBuilder.append(wherePart);
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
		stringBuilder.append(String.format("%s", DataElementDO.CODE));
		return stringBuilder.toString();
	}
}
