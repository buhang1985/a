package iih.bd.pp.hpdivshisdto.s.bp.sql;

import iih.bd.bc.udi.pub.IBdBcDictCodeConst;
import iih.bd.pp.hpsrvorca.d.HpStatusEnum;
import xap.mw.core.data.Context;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 自动对照SQL
 * 
 * @author hao_wu
 *
 */
public class AutoCompInsurDiSql implements ITransQry {
	
	private String _idHp;
	
	public AutoCompInsurDiSql() {
	}

	public AutoCompInsurDiSql(String idHp) {
		this._idHp = idHp;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(Context.get().getGroupId());
		sqlParam.addParam(Context.get().getOrgId());
		sqlParam.addParam(this._idHp);
		sqlParam.addParam(HpStatusEnum.NOT_MATCHED);
		sqlParam.addParam(HpStatusEnum.REVIEW);
		sqlParam.addParam(HpStatusEnum.REVIEW);
		sqlParam.addParam(HpStatusEnum.REVIEW);
		sqlParam.addParam(this._idHp);
		sqlParam.addParam(IBdBcDictCodeConst.SD_CDSYSTP_DIAG_SHOUSHU);
		sqlParam.addParam(IBdBcDictCodeConst.SD_CDSYSTP_DIAG_ZHONGYI);
		sqlParam.addParam("Y");
		sqlParam.addParam(HpStatusEnum.REVIEW);
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT 																");
		sqlBuilder.append("  ?                                      AS ID_GRP,					");// 集团
		sqlBuilder.append("  ?                                      AS ID_ORG,					");// 组织
		sqlBuilder.append("  ?   AS ID_HP,	");// 医保计划主键
		sqlBuilder.append("  DI_DEF.ID_DIDEF                         AS ID_DIDEF,				");// His诊断主键
		sqlBuilder.append("  DECODE(B.CODE,NULL,DECODE(C.CODE,NULL,HP_DI_ORGINAL.CODE,C.CODE),B.CODE)   AS CODE,					");// 医保诊断编码
		sqlBuilder.append("  DECODE(B.CODE,NULL,DECODE(C.CODE,NULL,HP_DI_ORGINAL.NAME,C.NAME),B.NAME)   AS NAME,					");// 医保诊断名称
		sqlBuilder.append("  DECODE(B.CODE,NULL,DECODE(C.CODE,NULL,DECODE(HP_DI_ORGINAL.CODE,NULL,?,?),?),?) AS EU_STATUS				");// 所属状态
		sqlBuilder.append("FROM BD_DI_DEF DI_DEF								");
		sqlBuilder.append("LEFT JOIN (SELECT NAME, MIN(CODE) ONLYCODE FROM BD_HP_DI_ORGINAL GROUP BY NAME) A	");
		sqlBuilder.append("ON A.NAME = DI_DEF.NAME					");
		sqlBuilder.append("LEFT JOIN BD_HP_DI_ORGINAL HP_DI_ORGINAL						");
		sqlBuilder.append("ON HP_DI_ORGINAL.CODE      = A.ONLYCODE						");
		sqlBuilder.append("LEFT JOIN BD_HP_DI_ORGINAL B						");
		sqlBuilder.append("ON B.CODE      = DI_DEF.CODE AND B.NAME = DI_DEF.NAME	");
		sqlBuilder.append("AND B.ID_HP = ?	");
		sqlBuilder.append("LEFT JOIN BD_HP_DI_ORGINAL C						");
		sqlBuilder.append("ON C.CODE      = DI_DEF.CODE						");
		sqlBuilder.append("WHERE DI_DEF.FG_ACTIVE = 'Y' AND DI_DEF.SD_CDSYSTP <> ? AND (DI_DEF.SD_CDSYSTP <> ? OR DI_DEF.FG_DS <> ? ) 			");
		sqlBuilder.append(" AND DI_DEF.ID_DIDEF NOT IN								");
		sqlBuilder.append("  (SELECT ID_DIDEF FROM BD_HP_DI_VS_HIS WHERE BD_HP_DI_VS_HIS.EU_STATUS = ?  )	");
		return sqlBuilder.toString();
	}

}
