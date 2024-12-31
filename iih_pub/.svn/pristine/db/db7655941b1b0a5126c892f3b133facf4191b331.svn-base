package iih.bd.pp.primd.refs;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.refs.BdRefGridModel;
import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.primd.d.PrimdDO;
import xap.mw.coreitf.i.IBaseDO;

/**
 * 定价模式参照模型
 * 
 * @author hao_wu 2019-1-23
 *
 */
public class PrimdRefModel extends BdRefGridModel {

	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { PrimdDO.CODE, PrimdDO.NAME, PrimdDO.DES };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PrimdDO.ID_PRI };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称", "描述" };
	}

	@Override
	protected String buildWherePart() {
		StringBuilder sqlBuilder = new StringBuilder("1 = 1");

		String wherePart = super.buildWherePart();
		sqlBuilder.append(" AND ");
		sqlBuilder.append(wherePart);

		String codes = (String) this.getExtendAttributeValue("codes");
		if (!StringUtils.isBlank(codes)) {
			String[] codeList = codes.split(",");
			String wherepart = SqlUtils.getInSqlByIds("code", codeList);
			sqlBuilder.append(" AND ");
			sqlBuilder.append(wherepart);
		}

		return sqlBuilder.toString();
	}

	@Override
	protected String buildOrderPart() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(String.format("%s", PrimdDO.CODE));
		return stringBuilder.toString();
	}

	@Override
	protected IBaseDO getDo() {
		return new PrimdDO();
	}
}
