package iih.ci.mr.knowledge.s;

import iih.ci.mr.knowledge.d.KnowledgeDO;
import iih.ci.mr.knowledge.i.IKnowledgeExtCudService;
import iih.ci.mr.knowledge.i.IKnowledgeExtRService;
import iih.ci.mr.knowledge.s.bp.FindPagingByQcondAndKnowledgeTypeBp;
import iih.ci.mr.knowledge.s.bp.GetNewSortNoByKnowledgeTypeBp;
import iih.ci.mr.knowledgetype.d.Attribute;
import iih.ci.mr.knowledgetype.d.KnowledgeTypeDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 知识库模板扩展服务
 * 
 * @author hao_wu
 *
 */
public class KnowledgeExtCrudServiceImpl implements IKnowledgeExtCudService, IKnowledgeExtRService {

	@Override
	public PagingRtnData<KnowledgeDO> FindPagingByQcondAndKnowledgeType(Integer attribute,
			KnowledgeTypeDO knowledgeTypeDo, QryRootNodeDTO qryRootNodeDto, PaginationInfo pg) throws BizException {
		FindPagingByQcondAndKnowledgeTypeBp bp = new FindPagingByQcondAndKnowledgeTypeBp();
		PagingRtnData<KnowledgeDO> result = bp.exec(attribute, knowledgeTypeDo, qryRootNodeDto, pg);
		return result;
	}

	@Override
	public Integer GetNewSortNoByKnowledgeType(KnowledgeTypeDO knowledgeTypeDo) throws BizException {
		GetNewSortNoByKnowledgeTypeBp bp = new GetNewSortNoByKnowledgeTypeBp();
		Integer result = bp.exec(knowledgeTypeDo);
		return result;
	}

}
