/**  
 * Project Name:iih.bd_pub  
 * File Name:HpPhyTpRefModel.java  
 * Package Name:iih.bd.mhi.hpphytp.refs  
 * Date:2018年7月17日下午2:54:51  
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.  
 *  
*/  
  
package iih.bd.mhi.hpphytp.refs;

import iih.bd.mhi.hpphytp.d.HpPhytpDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

/**  
 * ClassName:HpPhyTpRefModel <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2018年7月17日 下午2:54:51 <br/>  
 * @author   zmyang  
 * @version    
 * @since    JDK 1.7.0_80  
 * @see        
 */
public class HpPhyTpRefModel extends RefGridModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { HpPhytpDO.CODE, HpPhytpDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { HpPhytpDO.ID_HPPHYTP };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { HpPhytpDO.CODE, HpPhytpDO.NAME };
	}

	@Override
	public String getRefTitle() {
		return super.getRefTitle();
	}

	@Override
	public String getPkFieldCode() {
		return HpPhytpDO.ID_HPPHYTP;
	}

	@Override
	public String getRefCodeField() {
		return HpPhytpDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return HpPhytpDO.NAME;
	}

	@Override
	public String getTableName() {
		return new HpPhytpDO().getTableName();
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new HpPhytpDO(), false);
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
		stringBuilder.append(String.format("%s", HpPhytpDO.CODE));
		return stringBuilder.toString();
	}

}
  
