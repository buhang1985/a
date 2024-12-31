package iih.bd.pp.bdbltpl.s.bp.qry;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.bdbltpl.d.BdBlTplDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取费用模板价格字典
 * 
 * @author hao_wu 2019-12-12
 *
 */
public class GetTplPriceMapQry implements ITransQry {

	private String[] _tplIds;

	public GetTplPriceMapQry(String[] tplIds) {
		this._tplIds = tplIds;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer paramStringBuffer) {
		return new SqlParam();
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlBuilder = new StringBuilder();

		sqlBuilder.append(this.getBaseSql());

		String wherePart = this.getWherepPart();
		if (StringUtils.isNotBlank(wherePart)) {
			sqlBuilder.append(" where ");
			sqlBuilder.append(wherePart);
		}

		String groupPart = this.getGroupPart();
		if (StringUtils.isNotBlank(groupPart)) {
			sqlBuilder.append(" group by ");
			sqlBuilder.append(groupPart);
		}
		return sqlBuilder.toString();
	}

	/**
	 * 获取分组字段
	 * 
	 * @return
	 */
	private String getGroupPart() {
		return "tplitm.id_bltpl";
	}

	/**
	 * 获取基础SQL
	 * 
	 * @return
	 */
	private String getBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("select tplitm.id_bltpl,");
		sqlBuilder.append("sum(price.price_ratio*tplitm.quan_medu) as price ");
		sqlBuilder.append("from bd_bltpl_itm tplitm ");
		sqlBuilder.append("inner join view_price_rp price ");
		sqlBuilder.append("on tplitm.id_srv = price.id_srv ");
		sqlBuilder.append("and tplitm.id_mm = price.id_mm ");
		return sqlBuilder.toString();
	}

	/**
	 * 获取条件语句
	 * 
	 * @return
	 */
	private String getWherepPart() {
		StringBuilder wherePartBuilder = new StringBuilder();
		wherePartBuilder.append("tplitm.ds = 0 and price.id_pripat = '@@@@Z8100000002YL8PO'");

		String wherePart = BdEnvContextUtil.processEnvContext(new BdBlTplDO(), "tplitm");
		if (StringUtils.isNotBlank(wherePart)) {
			wherePartBuilder.append(" and ");
			wherePartBuilder.append(wherePart);
		}

		wherePart = SqlUtils.getInSqlByIds("tplitm.id_bltpl", this._tplIds);
		if (StringUtils.isNotBlank(wherePart)) {
			wherePartBuilder.append(" and ");
			wherePartBuilder.append(wherePart);
		}
		return wherePartBuilder.toString();
	}

}
