package iih.nm.nbd.nbddepca.refs;

import iih.nm.Utils.NmEnvContextUtil;
import iih.nm.nbd.nbddepca.d.NbdDepDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class NbdDepRefModel extends RefGridModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 显示字段名
	 */
	@Override
	public String[] getShowFieldCode() {
		return new String[] { NbdDepDO.CODE, NbdDepDO.NAME };
	}

	/**
	 * 显示字段中文名
	 */
	@Override
	public String[] getShowFieldName() {
		return new String[] { "护理单元编码", "护理单元名称" };
	}

	/**
	 * 隐藏字段数组
	 */
	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { NbdDepDO.ID_NBD_DEP, NbdDepDO.ID_DEP };
	}

	/**
	 * 主键字段
	 */
	@Override
	public String getPkFieldCode() {
		return NbdDepDO.ID_NBD_DEP;
	}

	/**
	 * 编码字段
	 */
	@Override
	public String getRefCodeField() {
		return NbdDepDO.CODE;
	}

	/**
	 * 显示名称字段
	 */
	@Override
	public String getRefNameField() {
		return NbdDepDO.NAME;
	}

	/**
	 * 表名
	 */
	@Override
	public String getTableName() {
		return new NbdDepDO().getTableName();
	}

	/**
	 * 查询字段名数组
	 */
	@Override
	public String[] getBlurFields() {
		return new String[] { NbdDepDO.CODE, NbdDepDO.NAME };
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
		String BdModeWherePart = NmEnvContextUtil.processEnvContext(new NbdDepDO(), false);
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
		stringBuilder.append(NbdDepDO.CODE);
		return stringBuilder.toString();
	}

}
