package iih.bd.pp.hp.refs;

import java.util.List;

import iih.bd.pp.hp.d.HpDepDO;
import iih.bd.pp.hp.d.HpDepDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class HPDepRefModel extends RefGridModel{

	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { HpDepDO.CODE_HP, HpDepDO.NAME_HP };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { HpDepDO.ID_HP_DEP };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { HpDepDO.CODE_HP, HpDepDO.NAME_HP };
	}

	@Override
	public String getRefTitle() {
		return super.getRefTitle();
	}

	@Override
	public String getPkFieldCode() {
		return HpDepDO.ID_HP_DEP;
	}

	@Override
	public String getRefCodeField() {
		return HpDepDO.CODE_HP;
	}

	@Override
	public String getRefNameField() {
		return HpDepDO.NAME_HP;
	}

	@Override
	public String getTableName() {
		return new HpDepDO().getTableName();
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new HpDepDO(), false);
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
		stringBuilder.append(String.format("%s", HpDepDO.CODE_HP));
		return stringBuilder.toString();
	}
}
