package iih.mkr.std.valdomain.refs;

import iih.mkr.base.refs.BdMkrRefGridModel;
import iih.mkr.std.valdomain.d.ValDomainDO;
import xap.mw.coreitf.i.IBaseDO;

/**
 * 值域参照模型
 * 
 * @author hao_wu 2019-5-18
 *
 */
public class ValDomainRefModel extends BdMkrRefGridModel {

	private static final long serialVersionUID = 1L;

	@Override
	protected IBaseDO getDo() {
		return new ValDomainDO();
	}
	@Override
	public String[] getShowFieldCode() {
		return new String[] { ValDomainDO.CODE, ValDomainDO.NAME,ValDomainDO.NAME_SETCA };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称","数据集分类" };
	}
	
	@Override
	protected String getBaseRefSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("select b.Code,");
		sqlBuilder.append("b.Name,");
		sqlBuilder.append("d.Name as Name_setca");
		sqlBuilder.append(" FROM BD_VD b inner join BD_SET  d on b.ID_SETCA = d.ID_SETCA");
		return sqlBuilder.toString();
	}
	
	@Override
	protected String buildWherePart() {

		StringBuilder wherePartBuilder = new StringBuilder();

	//	String wherePart = super.buildWherePart();
	//	wherePartBuilder.append(wherePart);

		wherePartBuilder.append(" 1 = 1 ");
		return wherePartBuilder.toString();
	}
	
	
	/**
	 * 构建排序语句
	 * 
	 * @return
	 */
	@Override
	protected String buildOrderPart() {
		return "";
	}
	
}
