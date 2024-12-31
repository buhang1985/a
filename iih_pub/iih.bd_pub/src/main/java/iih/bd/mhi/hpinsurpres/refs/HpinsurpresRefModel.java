/**  
 * Project Name:iih.bd_pub  
 * File Name:HpinsurpresRefModel.java  
 * Package Name:iih.bd.mhi.hpinsurpres.refs  
 * Date:2018年7月17日下午2:44:18  
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.  
 *  
*/  
  
package iih.bd.mhi.hpinsurpres.refs;

import iih.bd.mhi.hpinsurpres.d.HpInsurPresDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

/**  
 * ClassName:HpinsurpresRefModel <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2018年7月17日 下午2:44:18 <br/>  
 * @author   zmyang  
 * @version    
 * @since    JDK 1.7.0_80  
 * @see        
 */
public class HpinsurpresRefModel extends RefGridModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { HpInsurPresDO.CODE, HpInsurPresDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { HpInsurPresDO.ID_HPRP };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { HpInsurPresDO.CODE, HpInsurPresDO.NAME };
	}

	@Override
	public String getRefTitle() {
		return super.getRefTitle();
	}

	@Override
	public String getPkFieldCode() {
		return HpInsurPresDO.ID_HPRP;
	}

	@Override
	public String getRefCodeField() {
		return HpInsurPresDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return HpInsurPresDO.NAME;
	}

	@Override
	public String getTableName() {
		return new HpInsurPresDO().getTableName();
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new HpInsurPresDO(), false);
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
		stringBuilder.append(String.format("%s", HpInsurPresDO.CODE));
		return stringBuilder.toString();
	}
}
  
