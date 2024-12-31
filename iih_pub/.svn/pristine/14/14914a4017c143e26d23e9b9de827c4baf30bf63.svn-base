package iih.nm.nca.nmncatmplca.refs;

import iih.nm.Utils.NmEnvContextUtil;
import iih.nm.nca.nmncatmplca.d.NmNcaTmplOptaDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class NcaTmplOptaRefModel extends RefGridModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 显示字段名
	 */
	@Override
	public String[] getShowFieldCode() {
		return new String[] { NmNcaTmplOptaDO.CODE, NmNcaTmplOptaDO.NAME,NmNcaTmplOptaDO.SCORE};
	}
    
	/**
	 * 显示字段中文名
	 */
	@Override
	public String[] getShowFieldName() {
		return new String[] { "选项编码", "选项名称","选项得分"};
	}
	
	/**
	 * 隐藏字段数组
	 */
	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { NmNcaTmplOptaDO.ID_NCA_TMPL_OPTA };
	}

    /**
     * 主键字段
     */
	@Override
	public String getPkFieldCode() {
		return NmNcaTmplOptaDO.ID_NCA_TMPL_OPTA ;
	}
    
	/**
	 * 编码字段
	 */
	@Override
	public String getRefCodeField() {
		return NmNcaTmplOptaDO.CODE;
	}
    
	/**
	 * 显示名称字段
	 */
	@Override
	public String getRefNameField() {
		return NmNcaTmplOptaDO.NAME;
	}
    
	/**
	 * 表名
	 */
	@Override
	public String getTableName() {
		return new NmNcaTmplOptaDO().getTableName();
	}
    
	/**
	 * 查询字段名数组
	 */
	@Override
	public String[] getBlurFields() {
		return new String[] { NmNcaTmplOptaDO.CODE, NmNcaTmplOptaDO.NAME,NmNcaTmplOptaDO.SCORE};
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
		String BdModeWherePart = NmEnvContextUtil.processEnvContext(
				new NmNcaTmplOptaDO(), false);
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
		stringBuilder.append(NmNcaTmplOptaDO.CODE);
		return stringBuilder.toString();
	}

}
