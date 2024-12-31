package iih.bd.pp.hpdiexpenseselfbatch.s.bp.sql;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.IBdBcDictCodeConst;
import iih.bd.bc.udi.pub.IBdBcDictCodeTypeConst;
import iih.bd.pp.hpdiexpenseself.d.BdHpDiExpenseSelfDO;
import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 批量维护_查询医保计划自费诊断SQL
 * 
 * @author hao_wu
 *
 */
public class FindBdHpDiExpenseSelfSql implements ITransQry {

	private String _wherePart;
	private String _idHp;

	public FindBdHpDiExpenseSelfSql(String idHp, String wherePart) {
		this._idHp = idHp;
		this._wherePart = wherePart;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(IBdBcDictCodeTypeConst.SD_CDSYSTP);
		sqlParam.addParam(this._idHp);
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
		sqlBuilder.append("SELECT * FROM ( ");
		sqlBuilder.append("SELECT DI_EXPENSE_SELF.ID_HPDIEXPENSESELF,");// 医保计划下自费诊断
		sqlBuilder.append("DI_DEF.ID_GRP,");// 所属集团
		sqlBuilder.append("DI_DEF.ID_ORG,");// 所属组织
		sqlBuilder.append("DI_EXPENSE_SELF.ID_HP,");// 医保计划
		sqlBuilder.append("DI_DEF.ID_DIDEF,");// 疾病诊断
		sqlBuilder.append("DI_DEF.NAME AS DIDEF_NAME,");// 诊断名称
		sqlBuilder.append("DI_DEF.CODE AS DIDEF_CODE,");// 诊断编码
		sqlBuilder.append("DI_DEF.ID_CDSYSTP ,");// 疾病诊断体系
		sqlBuilder.append("CDSYSTP.NAME AS DIDEF_CDSYSTP,");// 疾病诊断体系名称
		sqlBuilder.append("DI_DEF.ID_DISTDCA ,");// 疾病诊断分类
		sqlBuilder.append("DICA.NAME AS DIDEF_DISTDCA,");// 疾病诊断分类名称
		sqlBuilder.append("DI_EXPENSE_SELF.FG_ENTP_OP,");// 所属就诊标志_门诊
		sqlBuilder.append("DI_EXPENSE_SELF.FG_ENTP_ER,");// 所属就诊标志_急诊
		sqlBuilder.append("DI_EXPENSE_SELF.FG_ENTP_IP,");// 所属就诊标志_住院
		sqlBuilder.append("DI_EXPENSE_SELF.FG_ENTP_PE,");// 所属就诊标志_体检
		sqlBuilder.append("DI_EXPENSE_SELF.FG_ENTP_FM,");// 所属就诊标志_家庭病床
		sqlBuilder.append("DI_EXPENSE_SELF.CREATEDBY,");// 创建人
		sqlBuilder.append("DI_EXPENSE_SELF.CREATEDTIME,");// 创建时间
		sqlBuilder.append("DI_EXPENSE_SELF.MODIFIEDBY,");// 最后修改人
		sqlBuilder.append("DI_EXPENSE_SELF.MODIFIEDTIME,");// 最后修改时间
		sqlBuilder.append("DI_EXPENSE_SELF.SV,");
		sqlBuilder.append("DI_EXPENSE_SELF.DS,");
		sqlBuilder.append("DI_DEF.CREATEDTIME AS DIDEF_CREATEDTIME ");// 疾病诊断创建时间
		sqlBuilder.append("FROM BD_DI_DEF DI_DEF ");
		sqlBuilder.append("LEFT JOIN BD_HP_DI_EXPENSE_SELF DI_EXPENSE_SELF ");
		sqlBuilder.append("ON DI_EXPENSE_SELF.ID_DIDEF = DI_DEF.ID_DIDEF ");
		sqlBuilder.append("LEFT JOIN BD_UDIDOC CDSYSTP ");
		sqlBuilder.append(
				" ON CDSYSTP.ID_UDIDOCLIST IN (SELECT ID_UDIDOCLIST FROM BD_UDIDOCLIST WHERE CODE = ?) AND CDSYSTP.ID_UDIDOC = DI_DEF.ID_CDSYSTP ");
		sqlBuilder.append("LEFT JOIN BD_DICA DICA ");
		sqlBuilder.append("ON DICA.ID_DICA = DI_DEF.ID_DISTDCA ");

		sqlBuilder.append(" WHERE ");
		String bdModeWherePart = BdEnvContextUtil.processEnvContext(new BdHpDiExpenseSelfDO(), "DI_EXPENSE_SELF");
		sqlBuilder.append(bdModeWherePart);

		bdModeWherePart = BdEnvContextUtil.processEnvContext(new DiagDefDO(), "DI_DEF");
		sqlBuilder.append(" AND ");
		sqlBuilder.append(bdModeWherePart);

		sqlBuilder.append(" )				       ");
		return sqlBuilder.toString();
	}

	/**
	 * 获取条件语句
	 * 
	 * @return
	 */
	private String GetWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder(" 1 = 1 ");
		String wherePart = String.format(
				"ID_CDSYSTP IN (SELECT ID_UDIDOC FROM BD_UDIDOC WHERE ID_UDIDOCLIST IN (SELECT ID_UDIDOCLIST FROM BD_UDIDOCLIST WHERE CODE = '%s') AND CODE LIKE '%s%%')",
				IBdBcDictCodeTypeConst.SD_CDSYSTP, IBdBcDictCodeConst.SD_CDSYSTP_DIAG);
		wherePartBuilder.append(" AND ");
		wherePartBuilder.append(wherePart);
		wherePartBuilder.append(" AND ");
		wherePartBuilder.append(" ID_HP = ? ");

		if (!StringUtils.isEmpty(this._wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(this._wherePart);
		}

		return wherePartBuilder.toString();
	}
}
