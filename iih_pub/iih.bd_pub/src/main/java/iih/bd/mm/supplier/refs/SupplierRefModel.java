package iih.bd.mm.supplier.refs;

import org.apache.commons.lang.StringUtils;

import iih.bd.mm.supplier.d.SupplierDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class SupplierRefModel extends RefGridModel {
	@Override
	public String[] getShowFieldCode() {
		return new String[] { SupplierDO.CODE, SupplierDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { SupplierDO.ID_SUP, SupplierDO.ID_GRP, SupplierDO.ID_ORG };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return SupplierDO.ID_SUP;
	}

	@Override
	public String getRefCodeField() {
		return SupplierDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return SupplierDO.NAME;
	}

	@Override
	public String getTableName() {
		return new SupplierDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { SupplierDO.NAME, SupplierDO.CODE, SupplierDO.PYCODE, SupplierDO.WBCODE,
				SupplierDO.INSTR };
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
		stringBuilder.append(" and ds = 0 and fg_active = 'Y' ");
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new SupplierDO(), false);
		stringBuilder.append(String.format(" and %s ", BdModeWherePart));

		String fg_fac = (String) this.getExtendAttributeValue("fg_fac");
		String fg_mm = (String) this.getExtendAttributeValue("fg_mm");
		String wheresql = (String) this.getExtendAttributeValue("wheresql");
		if (!StringUtils.isBlank(fg_fac)) {
			stringBuilder.append(String.format(" and fg_fac = '%s' ", fg_fac));
		}

		String fg_sup = (String) this.getExtendAttributeValue("fg_sup");
		if (!StringUtils.isBlank(fg_sup)) {
			stringBuilder.append(String.format(" and fg_sup = '%s' ", fg_sup));
		}
		if (!StringUtils.isBlank(fg_mm)) 
		{
			stringBuilder.append(" and fg_mm = '"+fg_mm+"' ");
		}else{
			//默认为药品厂商供应商过滤
			stringBuilder.append(" and fg_mm = 'Y' ");
		}
		if (!StringUtils.isBlank(wheresql)) 
		{
			stringBuilder.append(" "+wheresql+" ");
		}
		
		return stringBuilder.toString();
	}

	/**
	 * 构建排序语句
	 * 
	 * @return
	 */
	private String BuildOrderPart() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(String.format("%s", SupplierDO.CODE));
		return stringBuilder.toString();
	}
}
