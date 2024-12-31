package iih.ci.mr.knowledge.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.ci.mr.knowledge.d.KnowledgeDO;
import iih.ci.mr.knowledge.i.IKnowledgeRService;
import iih.ci.mr.knowledgetype.d.Attribute;
import iih.ci.mr.knowledgetype.d.KnowledgeTypeDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 根据查询方案和知识库模板分类查询知识库模板分页数据业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FindPagingByQcondAndKnowledgeTypeBp {

	public PagingRtnData<KnowledgeDO> exec(Integer attribute, KnowledgeTypeDO knowledgeTypeDo,
			QryRootNodeDTO qryRootNodeDto, PaginationInfo pg) throws BizException {

		PagingRtnData<KnowledgeDO> result = FindPagingByQcondAndKnowledgeType(attribute, knowledgeTypeDo,
				qryRootNodeDto, pg);
		return result;
	}

	/**
	 * 根据查询方案和知识库模板分类查询知识库模板分页数据
	 * 
	 * @param knowledgeTypeDo
	 * @param qryRootNodeDto
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<KnowledgeDO> FindPagingByQcondAndKnowledgeType(Integer attribute,
			KnowledgeTypeDO knowledgeTypeDo, QryRootNodeDTO qryRootNodeDto, PaginationInfo pg) throws BizException {
		String wherePart = GetWherePart(attribute, knowledgeTypeDo, qryRootNodeDto);
		PagingRtnData<KnowledgeDO> result = FindPagingByWherePart(wherePart, pg);
		return result;
	}

	/**
	 * 根据查询方案和知识库模板分类获取条件语句
	 * 
	 * @param knowledgeTypeDo
	 * @param qryRootNodeDto
	 * @return
	 * @throws BizException
	 */
	private String GetWherePart(Integer attribute, KnowledgeTypeDO knowledgeTypeDo, QryRootNodeDTO qryRootNodeDto)
			throws BizException {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");

		String wherePart;
		if (knowledgeTypeDo != null) {
			wherePart = String.format(" and Id_knowledge_type = '%s'", knowledgeTypeDo.getId_knowledge_type());
			wherePartBuilder.append(wherePart);
		}

		wherePart = SqlUtils.getWherePartByQCond(qryRootNodeDto, KnowledgeDO.class.getName());
		if (StringUtils.isNotEmpty(wherePart)) {
			wherePartBuilder.append(" and ");
			wherePartBuilder.append(wherePart);
		}

		if (Attribute.DEPT.equals(attribute)) {
			wherePart = String.format(" and Id_dept = '%s'", Context.get().getDeptId());
		} else if (Attribute.PERSONAL.equals(attribute)) {
			wherePart = String.format(" and Id_user = '%s'", Context.get().getUserId());
		}
		wherePartBuilder.append(wherePart);

		return wherePartBuilder.toString();
	}

	/**
	 * 根据条件语句查询分页数据
	 * 
	 * @param wherePart
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<KnowledgeDO> FindPagingByWherePart(String wherePart, PaginationInfo pg) throws BizException {
		IKnowledgeRService knowledgeRService = ServiceFinder.find(IKnowledgeRService.class);
		PagingRtnData<KnowledgeDO> result = knowledgeRService.findByPageInfo(pg, wherePart, "sortno");
		return result;
	}

}
