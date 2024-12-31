package iih.en.que.board.ref;

import iih.en.que.board.d.BrdtpEnum;
import 	iih.en.que.board.d.EnBrdDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class EnBrdDORefModel extends RefGridModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 显示字段中文名
	 */
	@Override
	public String[] getShowFieldName() {
		return new String[] { "显示屏编码","显示屏名称","显示屏地址" };
	}
	
	/**
	 * 显示字段名
	 */
	@Override
	public String[] getShowFieldCode() {
		return new String[] { EnBrdDO.CODE,EnBrdDO.NAME,EnBrdDO.ADDR };
	}
	
	
	/**
	 * 隐藏字段名
	 */
	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { EnBrdDO.ID_BRD };
	}
	
	/**
	 * 显示名称字段
	 */
	@Override
	public String getRefNameField() {
		return EnBrdDO.NAME;
	}
	
	//编码字段
	@Override
	public String getRefCodeField() {
		return EnBrdDO.CODE;
	}

	//主键字段
	@Override
	public String getPkFieldCode() {
		return EnBrdDO.ID_BRD;
	}

    //参照主表名	
	@Override
	public String getTableName() {
		return new EnBrdDO().getTableName();
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new EnBrdDO(), false);
		stringBuilder.append(String.format(" and %s ", BdModeWherePart));
		stringBuilder.append(String.format(" and eu_brdtpc = '%s' ", BrdtpEnum.SECONDTRG));
		return stringBuilder.toString();
	}

	/**
	 * 构建排序语句
	 * 
	 * @return
	 */
	private String BuildOrderPart() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(String.format("%s", EnBrdDO.CODE));
		return stringBuilder.toString();
	}

}
