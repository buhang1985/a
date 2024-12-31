package iih.ci.mr.knowledge.s.bp.sql;

import org.apache.commons.lang.StringUtils;

import iih.bd.utils.BdEnvContextUtil;
import iih.ci.mr.knowledge.d.KnowledgeDO;
import iih.ci.mr.knowledgetype.d.KnowledgeTypeDO;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取知识库模板分类下新序号SQL
 * 
 * @author hao_wu
 *
 */
public class GetNewSortNoByKnowledgeTypeSql implements ITransQry {

	/**
	 * 知识库模板分类
	 */
	private KnowledgeTypeDO _KnowledgeTypeDO;

	public GetNewSortNoByKnowledgeTypeSql(KnowledgeTypeDO knowledgeTypeDo) {
		this._KnowledgeTypeDO = knowledgeTypeDo;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();

		if (this._KnowledgeTypeDO != null) {
			sqlParam.addParam(this._KnowledgeTypeDO.getId_knowledge_type());
		}
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlBuilder = new StringBuilder();

		String baseSql = GetBaseSql();
		sqlBuilder.append(baseSql);

		String wherePart = GetWherePart();
		if (StringUtils.isNotEmpty(wherePart)) {
			sqlBuilder.append(" where ");
			sqlBuilder.append(wherePart);
		}

		sqlBuilder.append(" ORDER BY SORTNO DESC ");

		String sql = GetFirstRowQrySql(sqlBuilder.toString());

		return sql;
	}

	/**
	 * 获取第一行数据查询SQL
	 * 
	 * @param sql
	 * @return
	 */
	private String GetFirstRowQrySql(String sql) {

		return String.format("SELECT sortno MaxSortNo FROM (%s) WHERE rownum = 1", sql);
	}

	/**
	 * 获取基础SQL
	 * 
	 * @return
	 */
	private String GetBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();

		sqlBuilder.append("SELECT sortno FROM CI_MR_KNOWLEDGE");

		return sqlBuilder.toString();
	}

	/**
	 * 获取条件语句
	 * 
	 * @return
	 */
	private String GetWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder(" 1 = 1 ");

		String wherePart = BdEnvContextUtil.processEnvContext(new KnowledgeDO(), false);
		wherePartBuilder.append(" and ");
		wherePartBuilder.append(wherePart);

		if (this._KnowledgeTypeDO != null) {
			wherePartBuilder.append(" and Id_knowledge_type = ?");
		}

		return wherePartBuilder.toString();
	}

}
