package iih.bd.srv.emrsourceprop.d;

import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;


/**
 * @author wyl
 * 报卡-源参照模型
 */
public class EmrSourcePropDORefModel extends RefGridModel {
	
	/**
	 * 
	 */
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
		return new String[] { EmrSourcePropDO.CODE,EmrSourcePropDO.NAME };
	}
	
	
	/**
	 * 隐藏字段名
	 */
	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { EmrSourcePropDO.ID_BD_RCM_SO };
	}
	
	/**
	 * 显示名称字段
	 */
	@Override
	public String getRefNameField() {
		return EmrSourcePropDO.NAME;
	}
	
	//编码字段
	@Override
	public String getRefCodeField() {
		return EmrSourcePropDO.CODE;
	}

	//主键字段
	@Override
	public String getPkFieldCode() {
		return EmrSourcePropDO.ID_BD_RCM_SO;
	}

    //参照主表名	
	@Override
	public String getTableName() {
		return new EmrSourcePropDO().getTableName();
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new EmrSourcePropDO(), false);
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
		stringBuilder.append(String.format("%s", EmrSourcePropDO.CODE));
		return stringBuilder.toString();
	}

}
