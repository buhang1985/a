package iih.bd.mm.custcategory.refs;

import org.apache.commons.lang.StringUtils;

import iih.bd.mm.custcategory.d.CustCategoryDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 药品自定义分类参照模型
 * 
 * @author hao_wu 2018-11-6
 *
 */
public class DrugCustCaRefModel extends RefGridModel {

	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { CustCategoryDO.NAME, CustCategoryDO.CODE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "名称", "编码" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { CustCategoryDO.ID_MMCAUS };
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { CustCategoryDO.NAME, CustCategoryDO.CODE, CustCategoryDO.PYCODE, CustCategoryDO.WBCODE,
				CustCategoryDO.MNECODE };
	}

	@Override
	public String getPkFieldCode() {
		return CustCategoryDO.ID_MMCAUS;
	}

	@Override
	public String getRefCodeField() {
		return CustCategoryDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return CustCategoryDO.NAME;
	}

	@Override
	public String getTableName() {
		return new CustCategoryDO().getTableName();
	}

	@Override
	public String getRefSql() {
		String wherePart = BuildWherePart();
		String orderPart = BuildOrderPart();
		String refSql;
		try {
			if (StringUtils.isNotEmpty(wherePart)) {
				this.getWherePart().add(wherePart);
			}
			if (StringUtils.isNotEmpty(orderPart)) {
				this.getOrderPart().add(orderPart);
			}
			refSql = super.getRefSql();

		} finally {
			if (StringUtils.isNotEmpty(wherePart)) {
				this.getWherePart().remove(wherePart);
			}
			if (StringUtils.isNotEmpty(orderPart)) {
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

		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new CustCategoryDO(), false);
		stringBuilder.append(" and ");
		stringBuilder.append(BdModeWherePart);

		return stringBuilder.toString();
	}

	/**
	 * 构建排序语句
	 * 
	 * @return
	 */
	private String BuildOrderPart() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(String.format("%s", CustCategoryDO.CODE));
		return stringBuilder.toString();
	}

}
