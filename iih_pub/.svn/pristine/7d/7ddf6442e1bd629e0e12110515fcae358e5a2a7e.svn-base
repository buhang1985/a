package iih.bd.mm.custcategoryitem.refs;

import org.apache.commons.lang.StringUtils;

import iih.bd.mm.custcategoryitem.d.CustCategoryItemDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

/**  
 * ClassName:MmCustCategoryitemRefmodel <br/>  
 * Function: 物品自定义分类项目参照 <br/>  
 * Date:     2019年4月15日 下午6:02:26 <br/>  
 * @author   zmyang  
 * @version    
 * @since    JDK 1.7.0_76       
 */
public class MmCustCategoryitemRefmodel extends RefGridModel{

	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { CustCategoryItemDO.NAME, CustCategoryItemDO.CODE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "名称", "编码" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { CustCategoryItemDO.ID_MMCAUSITM };
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { CustCategoryItemDO.NAME, CustCategoryItemDO.CODE};
	}

	@Override
	public String getPkFieldCode() {
		return CustCategoryItemDO.ID_MMCAUSITM;
	}

	@Override
	public String getRefCodeField() {
		return CustCategoryItemDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return CustCategoryItemDO.NAME;
	}

	@Override
	public String getTableName() {
		return new CustCategoryItemDO().getTableName();
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

		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new CustCategoryItemDO(), false);
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
		stringBuilder.append(String.format("%s", CustCategoryItemDO.CODE));
		return stringBuilder.toString();
	}

}
  
