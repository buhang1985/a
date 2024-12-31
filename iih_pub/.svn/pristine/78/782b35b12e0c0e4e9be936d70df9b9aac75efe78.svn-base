/**
 * 
 */
package iih.bd.srv.ortpl.ref;

import iih.bd.srv.ortpl.d.OrTmplDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * @ClassName: RefModelOrTmplDO
 * @Description: 医嘱模板参照
 * @author Comsys-li_zheng
 * @date 2016年10月24日 下午4:54:39
 * @Package iih.bd.srv.ortpl.ref Copyright: Copyright (c) 2011 Company:
 *          北大医疗信息技术有限责任公司
 */
public class OrTmplRefModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {
		return new String[] { OrTmplDO.CODE, OrTmplDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { OrTmplDO.ID_ORTMPL };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return OrTmplDO.ID_ORTMPL;
	}

	@Override
	public String getRefCodeField() {
		return OrTmplDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return OrTmplDO.NAME;
	}

	@Override
	public String getTableName() {
		return new OrTmplDO().getTableName();
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new OrTmplDO(), false);
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
		return stringBuilder.toString();
	}
}
