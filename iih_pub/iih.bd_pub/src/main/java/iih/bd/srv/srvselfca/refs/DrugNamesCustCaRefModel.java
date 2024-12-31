package iih.bd.srv.srvselfca.refs;

import org.apache.commons.lang.StringUtils;

import iih.bd.srv.srvselfca.d.SrvSlefCateDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 药品通用名自定义分类参照模型
 * 
 * @author hao_wu 2018-11-6
 *
 */
public class DrugNamesCustCaRefModel extends RefGridModel {
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { SrvSlefCateDO.NAME, SrvSlefCateDO.CODE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "名称", "编码" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { SrvSlefCateDO.ID_SRVCACTM };
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { SrvSlefCateDO.NAME, SrvSlefCateDO.CODE, SrvSlefCateDO.PYCODE, SrvSlefCateDO.WBCODE,
				SrvSlefCateDO.MNECODE };
	}

	@Override
	public String getPkFieldCode() {
		return SrvSlefCateDO.ID_SRVCACTM;
	}

	@Override
	public String getRefCodeField() {
		return SrvSlefCateDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return SrvSlefCateDO.NAME;
	}

	@Override
	public String getTableName() {
		return new SrvSlefCateDO().getTableName();
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

		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new SrvSlefCateDO(), false);
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
		stringBuilder.append(String.format("%s", SrvSlefCateDO.CODE));
		return stringBuilder.toString();
	}
}
