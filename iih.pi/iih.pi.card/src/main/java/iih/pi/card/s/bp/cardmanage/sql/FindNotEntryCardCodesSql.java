package iih.pi.card.s.bp.cardmanage.sql;

import java.text.NumberFormat;
import java.util.ArrayList;

import iih.bd.utils.BdEnvContextUtil;
import iih.pi.card.card.d.PiCardDO;
import xap.sys.appfw.orm.dataaccess.TmpTableFactory;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询未录入卡编码SQL
 * 
 * @author hao_wu 2018-9-15
 *
 */
public class FindNotEntryCardCodesSql implements ITransQry {

	/**
	 * 开始编码
	 */
	private String _beginCode;
	/**
	 * 结束编码
	 */
	private String _endCode;

	public FindNotEntryCardCodesSql(String beginCode, String endCode) {
		this._beginCode = beginCode;
		this._endCode = endCode;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(this._beginCode);
		sqlParam.addParam(this._endCode);
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlBuilder = new StringBuilder();

		String baseSql = getBaseSql();
		sqlBuilder.append(baseSql);

		String wherePart = getWherePart();
		sqlBuilder.append(" where ");
		sqlBuilder.append(wherePart);

		sqlBuilder.append(" order by id");

		return String.format("select code from (%s) where rownum <= 20", sqlBuilder.toString());
	}

	private String getBaseSql() {

		String cardCodeTmpTableName = getCardCodeTmpTableName();

		String sql = String.format("select id1 from %s", cardCodeTmpTableName);
		return sql;
	}

	/**
	 * 获取卡编码临时表名
	 * 
	 * @return
	 */
	private String getCardCodeTmpTableName() {

		ArrayList<String> cardCodeList = new ArrayList<String>();
		long beginCode = Long.parseLong(this._beginCode);
		long endCode = Long.parseLong(this._endCode);

		// 得到一个NumberFormat的实例
		NumberFormat format = NumberFormat.getInstance();
		// 设置是否使用分组
		format.setGroupingUsed(false);
		// 设置最大整数位数
		format.setMaximumIntegerDigits(this._beginCode.length());
		// 设置最小整数位数
		format.setMinimumIntegerDigits(this._beginCode.length());

		for (long code = beginCode; code <= endCode; code++) {
			cardCodeList.add(format.format(code));
		}

		TmpTableFactory factory = new TmpTableFactory();
		String tmpTbName = factory.get(cardCodeList.toArray(new String[0]));
		return tmpTbName;
	}

	private String getWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder();
		wherePartBuilder.append("id not in (select code from pi_card where code >= ? and code <= ?");

		String wherePart = BdEnvContextUtil.processEnvContext(new PiCardDO(), false);
		wherePartBuilder.append(" and ");
		wherePartBuilder.append(wherePart);

		wherePartBuilder.append(")");

		return wherePartBuilder.toString();
	}
}
