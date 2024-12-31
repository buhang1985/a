package iih.bd.srv.urgentsrv.s.bp.qry;

import org.apache.commons.lang.StringUtils;

import iih.bd.fc.entp.d.EnTypeDO;
import iih.bd.srv.medsrv.d.MedSrvAttrMaping;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.mw.core.data.SqlParamDTO;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询加急服务项目
 * 
 * @author hao_wu 2020-1-7
 *
 */
public class FindUrgentSrvQry implements ITransQry {

	private EnTypeDO _enTypeDo;
	private String _whereStr;
	private SqlParamDTO _sqlParamDTO;
	private String _orderStr;

	public FindUrgentSrvQry(EnTypeDO enTypeDo, String whereStr, SqlParamDTO sqlParamDTO, String orderStr) {
		this._enTypeDo = enTypeDo;
		this._whereStr = whereStr;
		this._sqlParamDTO = sqlParamDTO;
		this._orderStr = orderStr;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer paramStringBuffer) {
		SqlParam sqlParam = new SqlParam();
		if (this._sqlParamDTO != null && this._sqlParamDTO.getCountParams() > 0) {
			int paramCount = this._sqlParamDTO.getCountParams();
			for (int i = 0; i < paramCount; i++) {
				sqlParam.addParam(this._sqlParamDTO.get(i));
			}
		}
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlBuilder = new StringBuilder();

		sqlBuilder.append(this.getBaseSql());

		String whereStr = this.getWhereStr();
		if (StringUtils.isNotBlank(whereStr)) {
			sqlBuilder.append(" where ");
			sqlBuilder.append(whereStr);
		}

		if (StringUtils.isNotBlank(this._orderStr)) {
			sqlBuilder.append(" order by ");
			sqlBuilder.append(this._orderStr);
		}

		return sqlBuilder.toString();
	}

	private String getBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("select bd_srv.id_srv,");
		sqlBuilder.append("bd_srv.code,");
		sqlBuilder.append("bd_srv.name,");
		sqlBuilder.append("bd_srv.pycode,");
		sqlBuilder.append("bd_srv.wbcode,");
		sqlBuilder.append("bd_srv.mnecode,");
		String sql = String.format("bd_srv.%s as fg_urgent_def ",
				MedSrvAttrMaping.getDefUrgentAttrName(this._enTypeDo.getCode()));
		sqlBuilder.append(sql);
		sqlBuilder.append("from bd_srv ");
		return sqlBuilder.toString();
	}

	private String getWhereStr() {
		StringBuilder whereStrBuilder = new StringBuilder("1 = 1");

		String wherePart = BdEnvContextUtil.processEnvContext(new MedSrvDO(), "bd_srv");
		if (StringUtils.isNotBlank(wherePart)) {
			whereStrBuilder.append(" and ");
			whereStrBuilder.append(wherePart);
		}

		wherePart = String.format(" and bd_srv.%s = 'Y'", MedSrvAttrMaping.getUrgentAttrName(this._enTypeDo.getCode()));
		whereStrBuilder.append(wherePart);

		if (StringUtils.isNotBlank(this._whereStr)) {
			whereStrBuilder.append(" and ");
			whereStrBuilder.append(this._whereStr);
		}

		return whereStrBuilder.toString();
	}

}
