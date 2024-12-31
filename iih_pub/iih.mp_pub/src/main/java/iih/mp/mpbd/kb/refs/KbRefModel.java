package iih.mp.mpbd.kb.refs;

import iih.mp.mpbd.kb.d.KbDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class KbRefModel extends RefGridModel{

	@Override
	public String[] getShowFieldCode() {
		return new String[] { KbDO.CODE, KbDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { KbDO.ID_KB, KbDO.ID_GRP, KbDO.ID_ORG };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return KbDO.ID_KB;
	}

	@Override
	public String getRefCodeField() {
		return KbDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return KbDO.NAME;
	}

	@Override
	public String getTableName() {
		return new KbDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { KbDO.NAME, KbDO.CODE};
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
		stringBuilder.append(" and ds = 0 ");

		return stringBuilder.toString();
	}

	/**
	 * 构建排序语句
	 * 
	 * @return
	 */
	private String BuildOrderPart() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(String.format("%s", KbDO.CODE));
		return stringBuilder.toString();
	}
}
