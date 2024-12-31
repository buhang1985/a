package iih.pi.reg.s.ws.sql;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bd.utils.BdEnvContextUtil;
import iih.pi.reg.i.PatCardTp;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PiPatHpDO;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据卡类型和卡号查询患者主键SQL
 * 
 * @author hao_wu 2018-5-31
 *
 */
public class FindPatIdByCodeTpAndCodeSql implements ITransQry {

	/**
	 * 卡类型
	 */
	private String _codeTp;

	/**
	 * 卡号
	 */
	private String _code;

	private static final String MATCH_SYMBOL = "___";

	public FindPatIdByCodeTpAndCodeSql(String codeTp, String code) {
		this._codeTp = codeTp;
		this._code = code;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();

		switch (this._codeTp) {
		case PatCardTp.CODE_IDTYPE_HPNO:
			String hpCode = this._code;
			if (this._code.length() == 9) {
				hpCode = String.format("%s%s", this._code, MATCH_SYMBOL);
			}
			sqlParam.addParam(hpCode);
			break;
		case PatCardTp.CODE_IDTYPE_IDCARD:
			sqlParam.addParam(IPiDictCodeConst.SD_IDTP_IDENTITY);
			sqlParam.addParam(this._code);
			break;
		case PatCardTp.CODE_IDTYPE_BARCODE_CHIS:
		case PatCardTp.CODE_IDTYPE_CODE:
		case PatCardTp.CODE_CARDTP_CODE:
			sqlParam.addParam(this._code);
			break;
		}
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlBuilder = new StringBuilder();
		String baseSql = GetBaseSql();
		sqlBuilder.append(baseSql);
		String wherePart = GetWherePart();
		sqlBuilder.append(" WHERE ");
		sqlBuilder.append(wherePart);
		return sqlBuilder.toString();
	}

	/**
	 * 获取基础SQL
	 * 
	 * @return
	 */
	private String GetBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT ID_PAT FROM PI_PAT PIPAT");
		return sqlBuilder.toString();
	}

	/**
	 * 获取条件语句
	 * 
	 * @return
	 */
	private String GetWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder(" PIPAT.ds = 0 and PIPAT.Fg_invd = 'N' ");

		String wherePart = BdEnvContextUtil.processEnvContext(new PatDO(), "PIPAT");
		if (StringUtils.isNotEmpty(wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(wherePart);
		}

		if (PatCardTp.CODE_IDTYPE_HPNO.equals(this._codeTp)) {
			// 医保卡情况下拼接医保计划表
			wherePartBuilder.append(" AND PIPAT.id_pat in (select pathp.id_pat from pi_pat_hp pathp where 1 = 1");
			wherePart = BdEnvContextUtil.processEnvContext(new PiPatHpDO(), "pathp");
			if (StringUtils.isNotEmpty(wherePart)) {
				wherePartBuilder.append(" AND ");
				wherePartBuilder.append(wherePart);
			}
			// 处理9位卡
			if (this._code.length() == 9) {
				wherePartBuilder.append(" AND NO_HP like ?)");
			} else {
				wherePartBuilder.append(" AND NO_HP = ?)");
			}
		} else if (PatCardTp.CODE_IDTYPE_IDCARD.equals(this._codeTp)) {
			// 身份证
			wherePartBuilder.append(" AND PIPAT.SD_IDTP = ? and PIPAT.ID_CODE = ? ");
		} else if (PatCardTp.CODE_IDTYPE_BARCODE_CHIS.equals(this._codeTp)) {
			// CHIS条码
			wherePartBuilder.append(" AND PIPAT.BARCODE_CHIS = ? ");
		} else if (PatCardTp.CODE_IDTYPE_CODE.equals(this._codeTp)) {
			// 患者编码
			wherePartBuilder.append(" AND PIPAT.CODE = ? ");
		}else if(PatCardTp.CODE_CARDTP_CODE.equals(this._codeTp)){
			//其他卡
			wherePartBuilder.append(" AND pipat.id_pat in (select card.id_pat from pi_pat_card card where card.code = ? ) ");
		}

		return wherePartBuilder.toString();
	}

}
