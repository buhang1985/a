package iih.bd.pp.statvsacca.refs;

import iih.bd.pp.statvsacca.d.StatVsaCcaDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefTreeModel;

public class StatvsaCcaRefModel extends RefTreeModel{

	@Override
	public String[] getShowFieldCode() {
		return new String[] { StatVsaCcaDO.CODE, StatVsaCcaDO.NAME };
	}
	
	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}
	
	@Override
	public String getPkFieldCode() {
		return StatVsaCcaDO.ID_STATVSACCA;
	}

	@Override
	public String getRefCodeField() {
		return StatVsaCcaDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return StatVsaCcaDO.NAME;
	}

	@Override
	public String getTableName() {
		return new StatVsaCcaDO().getTableName();
	}

	@Override
	public String getFatherField() {
		return StatVsaCcaDO.ID_PAR;
	}

	@Override
	public String getChildField() {
		return StatVsaCcaDO.ID_STATVSACCA;
	}
	@Override
	public String[] getBlurFields() {
		return new String[] { StatVsaCcaDO.CODE, StatVsaCcaDO.NAME,StatVsaCcaDO.PYCODE, StatVsaCcaDO.WBCODE,
				StatVsaCcaDO.INSTR  };
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
	
	private String BuildWherePart() {
		StringBuilder stringBuilder = new StringBuilder("1 = 1");
		stringBuilder.append(" and ds = 0 ");
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new StatVsaCcaDO(), false);
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
		stringBuilder.append(String.format("%s", StatVsaCcaDO.CODE));
		return stringBuilder.toString();
	}
}
