package iih.bd.pp.hpdiexpenseself.s.bp.sql;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.IBdBcDictCodeTypeConst;
import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hpdiexpenseself.d.BdHpDiExpenseSelfDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查找医保计划自费诊断数据SQL
 * 
 * @author hao_wu
 *
 */
public class FindBdHpDiExpenseSelfSql implements ITransQry {

	private HPDO _Hpdo;
	private String _id;

	public FindBdHpDiExpenseSelfSql(HPDO hpdo) {
		this._Hpdo = hpdo;
	}

	public FindBdHpDiExpenseSelfSql(String id) {
		this._id = id;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(IBdBcDictCodeTypeConst.SD_CDSYSTP);
		if (this._Hpdo != null) {
			sqlParam.addParam(this._Hpdo.getId_hp());
		}
		if (!StringUtils.isEmpty(this._id)) {
			sqlParam.addParam(this._id);
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
		sqlBuilder.append("SELECT DI_EXPENSE_SELF.ID_HPDIEXPENSESELF,");// 医保计划下自费诊断
		sqlBuilder.append("DI_EXPENSE_SELF.ID_GRP,");// 所属集团
		sqlBuilder.append("DI_EXPENSE_SELF.ID_ORG,");// 所属组织
		sqlBuilder.append("DI_EXPENSE_SELF.ID_HP,");// 医保计划
		sqlBuilder.append("HP.NAME AS HP_NAME,");// 医保计划
		sqlBuilder.append("DI_EXPENSE_SELF.ID_DIDEF,");// 疾病诊断
		sqlBuilder.append("DI_DEF.NAME AS DIDEF_NAME,");// 诊断名称
		sqlBuilder.append("DI_DEF.CODE AS DIDEF_CODE,");// 诊断编码
		sqlBuilder.append("CDSYSTP.NAME AS DIDEF_CDSYSTP,");// 疾病诊断体系
		sqlBuilder.append("DICA.NAME AS DIDEF_DISTDCA,");// 疾病诊断分类
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
		sqlBuilder.append("DI_EXPENSE_SELF.DS ");
		sqlBuilder.append("FROM BD_HP_DI_EXPENSE_SELF DI_EXPENSE_SELF ");
		sqlBuilder.append("LEFT JOIN BD_DI_DEF DI_DEF ");
		sqlBuilder.append("ON DI_EXPENSE_SELF.ID_DIDEF = DI_DEF.ID_DIDEF ");
		sqlBuilder.append("LEFT JOIN BD_UDIDOC CDSYSTP ");
		sqlBuilder.append("ON CDSYSTP.ID_UDIDOCLIST IN ");
		sqlBuilder.append("(SELECT ID_UDIDOCLIST FROM BD_UDIDOCLIST WHERE CODE = ? )");
		sqlBuilder.append("AND CDSYSTP.ID_UDIDOC = DI_DEF.ID_CDSYSTP ");
		sqlBuilder.append("LEFT JOIN BD_DICA DICA ");
		sqlBuilder.append("ON DICA.ID_DICA = DI_DEF.ID_DISTDCA ");
		sqlBuilder.append("LEFT JOIN BD_HP HP ");
		sqlBuilder.append("ON HP.ID_HP = DI_EXPENSE_SELF.ID_HP ");
		return sqlBuilder.toString();
	}

	/**
	 * 获取条件语句
	 * 
	 * @return
	 */
	private String GetWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder(" 1 = 1 ");

		String bdModeWherePart = BdEnvContextUtil.processEnvContext(new BdHpDiExpenseSelfDO(), "DI_EXPENSE_SELF");
		wherePartBuilder.append(" AND ");
		wherePartBuilder.append(bdModeWherePart);

		if (this._Hpdo != null) {
			wherePartBuilder.append(" AND DI_EXPENSE_SELF.ID_HP = ? ");
		}
		if (!StringUtils.isEmpty(this._id)) {
			wherePartBuilder.append(" AND DI_EXPENSE_SELF.ID_HPDIEXPENSESELF = ? ");
		}
		return wherePartBuilder.toString();
	}

}
