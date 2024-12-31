package iih.bd.mm.mmcategory.refs;

import org.apache.commons.lang.StringUtils;

import iih.bd.mm.mmcategory.d.MMCategoryDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefTreeModel;

public class MCCategoryRefModel extends RefTreeModel {
	@Override
	public String[] getShowFieldCode() {
		return new String[] { MMCategoryDO.CODE, MMCategoryDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { MMCategoryDO.ID_MMCA, MMCategoryDO.ID_PARENT, MMCategoryDO.INNERCODE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return MMCategoryDO.ID_MMCA;
	}

	@Override
	public String getTableName() {
		return new MMCategoryDO().getTableName();
	}

	@Override
	public String getRefCodeField() {
		return MMCategoryDO.CODE;

	}

	@Override
	public String getRefNameField() {
		return MMCategoryDO.NAME;

	}

	@Override
	public String getFatherField() {
		return MMCategoryDO.ID_PARENT;
	}

	@Override
	public String getChildField() {
		return MMCategoryDO.ID_MMCA;
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { MMCategoryDO.NAME, MMCategoryDO.CODE, MMCategoryDO.PYCODE, MMCategoryDO.WBCODE,
				MMCategoryDO.MNECODE };
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

		StringBuilder stringBuilder = new StringBuilder("1 = 1 ");
		stringBuilder.append(" and ds = 0 and  sd_mmtp like '3%' ");
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new MMCategoryDO(), false);
		stringBuilder.append(String.format(" and %s ", BdModeWherePart));

		// 物品分类类型
		String id_mmtp = (String) this.getExtendAttributeValue("id_mmtp");
		if (!StringUtils.isBlank(id_mmtp)) {
			stringBuilder.append(String.format(" and id_mmtp = '%s' ", id_mmtp));
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
		stringBuilder.append(String.format("%s", MMCategoryDO.CODE));
		return stringBuilder.toString();
	}
}
