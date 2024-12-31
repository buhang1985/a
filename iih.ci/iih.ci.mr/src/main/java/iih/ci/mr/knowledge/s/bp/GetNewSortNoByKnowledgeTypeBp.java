package iih.ci.mr.knowledge.s.bp;

import iih.ci.mr.knowledge.s.bp.sql.GetNewSortNoByKnowledgeTypeSql;
import iih.ci.mr.knowledgetype.d.KnowledgeTypeDO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;

/**
 * 获取知识库模板分类下新序号业务逻辑
 * 
 * @author hao_wu
 *
 */
public class GetNewSortNoByKnowledgeTypeBp {

	public Integer exec(KnowledgeTypeDO knowledgeTypeDo) throws BizException {
		GetNewSortNoByKnowledgeTypeSql sql = new GetNewSortNoByKnowledgeTypeSql(knowledgeTypeDo);

		DAFacade daFacade = new DAFacade();
		Integer maxSortNo = (Integer) daFacade.execQuery(sql.getQrySQLStr(), sql.getQryParameter(null),
				new ColumnHandler("MaxSortNo"));
		if (maxSortNo != null) {
			return maxSortNo + 1;
		}
		return 1;
	}

}
