package iih.nm.nca.nmncatmpl.refs;

import iih.nm.Utils.NmEnvContextUtil;
import iih.nm.nca.nmncatmpl.d.NmNcaTmplItmDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class NcaTmplItmRefModel extends RefGridModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * 显示字段名
	 */
	@Override
	public String[] getShowFieldCode() {
		return new String[] { NmNcaTmplItmDO.SORTNO, NmNcaTmplItmDO.CONTENT };
	}
    
	/**
	 * 显示字段中文名
	 */
	@Override
	public String[] getShowFieldName() {
		return new String[] { "序号", "内容" };
	}
	
	/**
	 * 隐藏字段数组
	 */
	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { NmNcaTmplItmDO.ID_NCA_TMPL_ITM };
	}

    /**
     * 主键字段
     */
	@Override
	public String getPkFieldCode() {
		return NmNcaTmplItmDO.ID_NCA_TMPL_ITM ;
	}
    
	/**
	 * 编码字段
	 */
	@Override
	public String getRefCodeField() {
		return NmNcaTmplItmDO.SORTNO;
	}
    
	/**
	 * 显示名称字段
	 */
	@Override
	public String getRefNameField() {
		return NmNcaTmplItmDO.CONTENT;
	}
    
	/**
	 * 表名
	 */
	@Override
	public String getTableName() {
		return new NmNcaTmplItmDO().getTableName();
	}
    
	/**
	 * 查询字段名数组
	 */
	@Override
	public String[] getBlurFields() {
		return new String[] { NmNcaTmplItmDO.SORTNO, NmNcaTmplItmDO.CONTENT };
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
				new NmNcaTmplItmDO(), false);
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
		stringBuilder.append(NmNcaTmplItmDO.SORTNO);
		return stringBuilder.toString();
	}

}
