package iih.bd.bs.ctmitfrel.s.bp.qry;

import org.apache.commons.lang.StringUtils;

import xap.mw.core.data.Context;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询客开接口和实现类关系
 * 
 * @author hao_wu 2019-6-14
 *
 */
public class FindRelByItfsQry implements ITransQry {

	private String _wherePart;

	public FindRelByItfsQry(String wherePart) {
		this._wherePart = wherePart;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(Context.get().getGroupId());
		sqlParam.addParam(Context.get().getOrgId());
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlBuilder = new StringBuilder();

		String baseSql = getBaseSql();
		sqlBuilder.append(baseSql);

		String wherePart = getWherePart();
		sqlBuilder.append(" WHERE ");
		sqlBuilder.append(wherePart);

		return sqlBuilder.toString();
	}

	private String getBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT bd_itf_ctm_rel.ID_CTMITFREL,");// 客开接口实现关系主键
		sqlBuilder.append("NVL(bd_itf_ctm_rel.ID_GRP,?) AS ID_GRP,");// 集团
		sqlBuilder.append("NVL(bd_itf_ctm_rel.ID_ORG,?) AS ID_ORG,");// 组织
		sqlBuilder.append("bd_itf_ctm.ID_CTMITF,");// 客开接口主键
		sqlBuilder.append("bd_itf_ctm.NOTE AS NOTE_CTMITF,");// 备注
		sqlBuilder.append("bd_itf_ctm.NAME AS NAME_ITF,");// 名称
		sqlBuilder.append("bd_itf_ctm.CODE AS CODE_ITF,");// 编码
		sqlBuilder.append("BD_ITF_CTM.DLLNAME AS DLLNAME_ITF,");// 接口动态库名称
		sqlBuilder.append("BD_ITF_CTM.CLASSNAME AS CLASSNAME_ITF,");// 接口全类名
		sqlBuilder.append("bd_itf_ctm_rel.ID_CTMIMPL,");// 客开实现主键
		sqlBuilder.append("bd_ctm_impl.NAME AS NAME_IMPL,");// 名称
		sqlBuilder.append("bd_ctm_impl.CODE AS CODE_IMPL,");// 编码
		sqlBuilder.append("bd_itf_ctm_rel.EU_IMPLTYPE,");// 实现类类型
		sqlBuilder.append("bd_itf_ctm_rel.DLLNAME_IMPL,");// 实现类动态库名称
		sqlBuilder.append("bd_itf_ctm_rel.CLASSNAME_IMPL,");// 实现类全类名
		sqlBuilder.append("bd_ctm_impl.FG_SYS,");// 产品自带实现类
		sqlBuilder.append("bd_itf_ctm_rel.CREATEDBY,");// 创建人
		sqlBuilder.append("bd_itf_ctm_rel.CREATEDTIME,");// 创建时间
		sqlBuilder.append("bd_itf_ctm_rel.MODIFIEDBY,");// 最后修改人
		sqlBuilder.append("bd_itf_ctm_rel.MODIFIEDTIME,");// 最后修改时间
		sqlBuilder.append("bd_itf_ctm_rel.ds,");
		sqlBuilder.append("bd_itf_ctm_rel.sv ");
		sqlBuilder.append("FROM bd_itf_ctm ");
		sqlBuilder.append("LEFT JOIN bd_itf_ctm_rel ");
		sqlBuilder.append("ON bd_itf_ctm_rel.ID_CTMITF = bd_itf_ctm.ID_CTMITF ");
		sqlBuilder.append("LEFT JOIN bd_ctm_impl ");
		sqlBuilder.append("ON bd_itf_ctm_rel.ID_CTMIMPL = bd_ctm_impl.ID_CTMIMPL ");
		return sqlBuilder.toString();
	}

	private String getWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");

		if (StringUtils.isNotBlank(this._wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(this._wherePart);
		}
		return wherePartBuilder.toString();
	}
}
