package iih.bd.res.bizgrp.refs;

import org.apache.commons.lang.StringUtils;

import iih.bd.res.bizgrp.d.BizGroupDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 业务组标标准参照模型
 * 
 * @author hao_wu
 *
 */
public class BizGrpRefModel extends RefGridModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { BizGroupDO.CODE, BizGroupDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { BizGroupDO.ID_WG };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return BizGroupDO.ID_WG;
	}

	@Override
	public String getRefCodeField() {
		return BizGroupDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return BizGroupDO.NAME;
	}

	@Override
	public String getTableName() {
		return new BizGroupDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { BizGroupDO.CODE, BizGroupDO.NAME, BizGroupDO.WBCODE, BizGroupDO.PYCODE,
				BizGroupDO.INSTR };
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

		// 科室主键
		String depId = (String) getExtendAttributeValue("id_dep");

		StringBuilder stringBuilder = new StringBuilder("1 = 1 and ds = 0 and fg_active = 'Y'");

		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new BizGroupDO(), false);
		stringBuilder.append(String.format(" and %s ", BdModeWherePart));

		if (StringUtils.isNotEmpty(depId)) {
			String wherePart = String.format(" and id_dep = '%s'", depId);
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
		stringBuilder.append(BizGroupDO.CODE);
		return stringBuilder.toString();
	}
}
