package iih.mi.mibd.didircomp.s.bp.sql;

import org.apache.commons.lang.StringUtils;

import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.mi.mibd.di.d.DiDO;
import iih.mi.mibd.didircomp.d.DidircompDO;
import iih.mi.mibd.docenum.d.DirCompState;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @ClassName: FindDiCompsql
 * @Description: 病种参照查询sql
 * @author: dj.zhang
 * @date: 2018年2月6日 上午8:57:13
 */
public class FindDiCompsql implements ITransQry {

	String _misId;
	String _wherePart;

	public FindDiCompsql(String misId, String wherePart) {
		this._misId = misId;
		this._wherePart = wherePart;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer paramStringBuffer) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(DirCompState.NOT_COMP);
		sqlParam.addParam(this._misId);
		sqlParam.addParam(this._misId);
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		String baseSql = getBaseSql();
		String wherePart = getWherePart();
		return String.format("%s WHERE %s", baseSql, wherePart);
	}

	/**
	 * @Title: getWherePart
	 * @Description: 查询条件
	 * @return
	 */
	private String getWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");

		String wherePart = BdEnvContextUtil.processEnvContext(new DiagDefDO(), "BD_DI_DEF");
		if (StringUtils.isNotEmpty(wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(wherePart);
		}

		if (this._wherePart != null) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(this._wherePart);
		}
		return wherePartBuilder.toString();
	}

	/**
	 * @Title: getBaseSql
	 * @Description: 生成基本查询sql
	 * @return
	 */
	private String getBaseSql() {
		StringBuilder baseSQL = new StringBuilder();
		baseSQL.append(" SELECT MI_BD_COMP_DI.ID_COMP_DI AS ID_DICOMP,");
		baseSQL.append(" MI_BD_COMP_DI.ID_GRP AS ID_GRP,		");
		baseSQL.append(" MI_BD_COMP_DI.ID_ORG AS ID_ORG,		");
		baseSQL.append(" MI_BD_COMP_DI.ID_MIS AS ID_MIS,		");
		baseSQL.append(" MI_BD_COMP_DI.CODE AS CODE,			");
		baseSQL.append(" DECODE(MI_BD_COMP_DI.EU_STATUS,NULL,?,	");
		baseSQL.append(" MI_BD_COMP_DI.EU_STATUS) AS EU_STATUS,	");
		baseSQL.append(" MI_BD_COMP_DI.DT_APPROVED,			");
		baseSQL.append(" MI_BD_COMP_DI.CREATEDBY,			");
		baseSQL.append(" MI_BD_COMP_DI.CREATEDTIME,			");
		baseSQL.append(" MI_BD_COMP_DI.MODIFIEDBY,			");
		baseSQL.append(" MI_BD_COMP_DI.MODIFIEDTIME,			");
		baseSQL.append(" MI_BD_COMP_DI.DS,				");
		baseSQL.append(" MI_BD_COMP_DI.SV,				");

		baseSQL.append(" BD_DI_DEF.ID_DIDEF AS ID_DI,		   	");
		baseSQL.append(" BD_DI_DEF.NAME AS DI_NAME,			");
		baseSQL.append(" BD_DI_DEF.CODE AS DI_CODE,			");

		baseSQL.append(" MI_BD_DI.NAME AS NAME			");

		baseSQL.append(" FROM BD_DI_DEF 				");
		baseSQL.append(" LEFT JOIN MI_BD_COMP_DI			");
		baseSQL.append(" ON BD_DI_DEF.ID_DIDEF = MI_BD_COMP_DI.ID_DI	");
		baseSQL.append(" AND MI_BD_COMP_DI.ID_MIS = ?		   	");

		String wherePart = BdEnvContextUtil.processEnvContext(new DidircompDO(), "MI_BD_COMP_DI");
		if (StringUtils.isNotEmpty(wherePart)) {
			baseSQL.append(" AND ");
			baseSQL.append(wherePart);
		}

		baseSQL.append(" LEFT JOIN MI_BD_DI				");
		baseSQL.append(" ON MI_BD_DI.CODE = MI_BD_COMP_DI.CODE	");
		baseSQL.append(" AND MI_BD_DI.ID_MIS = ?			");

		wherePart = BdEnvContextUtil.processEnvContext(new DiDO(), "MI_BD_DI");
		if (StringUtils.isNotEmpty(wherePart)) {
			baseSQL.append(" AND ");
			baseSQL.append(wherePart);
		}

		return baseSQL.toString();
	}

}
