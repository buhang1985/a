package iih.ci.mr.cimrknowledgedto.i;

import iih.ci.mr.cimrknowledgedto.d.CiMrKnowledgeDTO;
import iih.ci.mr.knowledge.d.KnowledgeDO;
import xap.mw.core.data.BizException;

public interface CiMrKnowledgeCrudService {
	
	/**
	 * 将病历中选中的内容保存到个人知识库
	 * @param knowledgeDo
	 * @return
	 */
	public abstract KnowledgeDO[] saveKnowledgeDO(CiMrKnowledgeDTO knowledgeDTO) throws BizException;
	/**
	 * 查询已有的序号，获取新增的序号
	 * @return
	 * @throws BizException
	 */
	public abstract int checkAndTakeSortNo(String idUser) throws BizException;
	
}
