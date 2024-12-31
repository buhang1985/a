package iih.bd.srv.emrsourcepropdetail.d;

import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * @author wyl
 * 报卡--属性参照模型
 */
public class EmrSourcePropDetailDORefModel extends RefGridModel {
	
	private static final long serialVersionUID = 1L;

	/**
	 * 显示字段中文名
	 */
	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码","名称" };
	}
	
	/**
	 * 显示字段名
	 */
	@Override
	public String[] getShowFieldCode() {
		return new String[] { EmrSourcePropDetailDO.CODE,EmrSourcePropDetailDO.NAME };
	}
	
	
	/**
	 * 隐藏字段名
	 */
	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { EmrSourcePropDetailDO.ID_BD_RCM_PR };
	}
	
	/**
	 * 显示名称字段
	 */
	@Override
	public String getRefNameField() {
		return EmrSourcePropDetailDO.NAME;
	}
	
	//编码字段
	@Override
	public String getRefCodeField() {
		return EmrSourcePropDetailDO.CODE;
	}

	//主键字段
	@Override
	public String getPkFieldCode() {
		return EmrSourcePropDetailDO.ID_BD_RCM_PR;
	}

    //参照主表名	
	@Override
	public String getTableName() {
		return new EmrSourcePropDetailDO().getTableName();
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new EmrSourcePropDetailDO(), false);
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
		stringBuilder.append(String.format("%s", EmrSourcePropDetailDO.CODE));
		return stringBuilder.toString();
	}

}
