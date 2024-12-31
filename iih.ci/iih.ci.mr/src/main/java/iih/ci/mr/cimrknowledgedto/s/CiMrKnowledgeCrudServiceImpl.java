package iih.ci.mr.cimrknowledgedto.s;

import iih.ci.mr.cimrknowledgedto.d.CiMrKnowledgeDTO;
import iih.ci.mr.cimrknowledgedto.i.CiMrKnowledgeCrudService;
import iih.ci.mr.knowledge.d.KnowledgeDO;
import iih.ci.mr.knowledge.i.IKnowledgeCudService;
import iih.ci.mr.knowledge.i.IKnowledgeRService;
import iih.ci.mr.knowledgetype.d.KnowledgeTypeDO;
import iih.ci.mr.knowledgetype.i.IKnowledgetypeCudService;
import iih.ci.mr.knowledgetype.i.IKnowledgetypeRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

@Service(serviceInterfaces = { CiMrKnowledgeCrudService.class }, binding = Binding.JSONRPC)
public class CiMrKnowledgeCrudServiceImpl implements CiMrKnowledgeCrudService {

	/**
	 * 将病历中选中的内容保存到个人知识库
	 */
	public KnowledgeDO[] saveKnowledgeDO(CiMrKnowledgeDTO knowledgeDTO) throws BizException {
		//另存为知识库自由编辑时，当知识库分类输入为：/分类名称
		if( null==knowledgeDTO.getId_knowledge_type()&& null!=knowledgeDTO.getName_knowledge_type()){
			knowledgeDTO=getCiMrKnowledgeDTO(knowledgeDTO);
		}
		if(null!=knowledgeDTO){
		IKnowledgeRService knowledgeRService = ServiceFinder.find(IKnowledgeRService.class);
		IKnowledgeCudService knowledgeCudService = ServiceFinder.find(IKnowledgeCudService.class);
		// 待保存DO
		KnowledgeDO knowledgeDO = new KnowledgeDO();
		// 模板名称重复情况处理
		int num = 0;
		String numStr = "";
		
		while(true){
			if (num != 0) {
				numStr = "(" + num + ")";
			}
			KnowledgeDO[] knowledgeDOs = knowledgeRService.find(" a0.name = '" + knowledgeDTO.getName() + numStr + "' ", "", FBoolean.FALSE);
			// 如果已有此名称，则将名称后面加上数字标识
			if (knowledgeDOs != null && knowledgeDOs.length > 0) {
				num++;
				continue;
			} else {
				knowledgeDO.setName(knowledgeDTO.getName() + numStr);
				break;
			}
		}
		knowledgeDO.setId_knowledge(knowledgeDTO.getId_knowledge());
		knowledgeDO.setId_grp(knowledgeDTO.getId_grp());
		knowledgeDO.setId_org(knowledgeDTO.getId_org());
		knowledgeDO.setSortno(knowledgeDTO.getSortno());
		knowledgeDO.setCode(knowledgeDTO.getCode());
		knowledgeDO.setPycode(knowledgeDTO.getPycode());
		knowledgeDO.setWbcode(knowledgeDTO.getWbcode());
		knowledgeDO.setMnecode(knowledgeDTO.getMnecode());
		knowledgeDO.setKnowledge_content(knowledgeDTO.getKnowledge_content());
		knowledgeDO.setId_knowledge_type(knowledgeDTO.getId_knowledge_type());
		knowledgeDO.setId_dept(knowledgeDTO.getId_dept());
		knowledgeDO.setId_user(knowledgeDTO.getId_user());
		knowledgeDO.setFg_active(knowledgeDTO.getFg_active());
		knowledgeDO.setStatus(DOStatus.NEW);

		KnowledgeDO[] result = knowledgeCudService.save(new KnowledgeDO[] { knowledgeDO });
		return result;
		}
		return null;
	}

	/**
	 * 查询已有的序号，获取新增的序号
	 */
	public int checkAndTakeSortNo(String idUser) throws BizException {
		IKnowledgeRService knowledgeRService = ServiceFinder.find(IKnowledgeRService.class);
		// 根据当前登录用户查询所有的知识库模板，并倒序排序
		KnowledgeDO[] knowledgeDOs = knowledgeRService.find(" a0.id_user = '" + idUser + "' ", " a0.sortno desc ", FBoolean.FALSE);
		
		if (knowledgeDOs == null || knowledgeDOs.length <= 0) {
			return 1;
		}
		// 根据最大的序号设置新增序号的值
		Integer sortno = knowledgeDOs[0].getSortno();
		return ++sortno;
	}

	/**
	 * 另存为知识库自由编辑时，当知识库分类输入为：/分类名称
	 * @throws BizException 
	 */
	public CiMrKnowledgeDTO getCiMrKnowledgeDTO(CiMrKnowledgeDTO knowledgeDTO) throws BizException{
		String str=knowledgeDTO.getName_knowledge_type().trim();
		if(str.length()>1 && "/".equals(str.substring(0, 1))){
			//剪切字符串得到分类名称
			String typeName=str.substring(1, str.length());
			IKnowledgetypeRService servR= ServiceFinder.find(IKnowledgetypeRService.class);
			IKnowledgetypeCudService servCub= ServiceFinder.find(IKnowledgetypeCudService.class);
			//根据名称和用户查询是否存在
			KnowledgeTypeDO [] typeDos=servR.find(" a0.name='"+typeName+"' and a0.id_user='"+knowledgeDTO.getId_user()+"' ", " sv desc ", FBoolean.FALSE);
			if(null!=typeDos && typeDos.length>0){//存在直接将相关字段set进DTO
				knowledgeDTO.setId_knowledge_type(typeDos[0].getId_knowledge_type());
				knowledgeDTO.setSd_knowledge_type(typeDos[0].getCode());
				knowledgeDTO.setName_knowledge_type(typeDos[0].getName());
				return knowledgeDTO;
			}else{//不存在时根据名称和用户先创建知识库分类，再将相关字段set进DTO
				KnowledgeTypeDO typeDO=new KnowledgeTypeDO();
				typeDO.setName(typeName);
				typeDO.setCode(typeName);
				typeDO.setPycode(typeName);
				typeDO.setWbcode(typeName);
				typeDO.setMnecode(typeName);
				typeDO.setId_grp(knowledgeDTO.getId_grp());
				typeDO.setId_org(knowledgeDTO.getId_org());
				typeDO.setId_dept(knowledgeDTO.getId_dept());
				typeDO.setId_user(knowledgeDTO.getId_user());
				typeDO.setPersonal(FBoolean.TRUE);
				typeDO.setAttribute(1);
				// 根据当前登录用户查询所有的知识库类型，并倒序排序
				KnowledgeTypeDO [] knowledgeDOs = servR.find(" a0.id_user = '" + knowledgeDTO.getId_user() + "' ", " a0.sortno desc ", FBoolean.FALSE);
				if (knowledgeDOs == null || knowledgeDOs.length <= 0) {
					typeDO.setSortno(1);
				}
				// 根据最大的序号设置新增序号的值
				typeDO.setSortno(knowledgeDOs[0].getSortno()+1); 
				
				KnowledgeTypeDO[] types=servCub.insert(new KnowledgeTypeDO[]{typeDO});
				if(null!=types && types.length>0){
					knowledgeDTO.setId_knowledge_type(types[0].getId_knowledge_type());
					knowledgeDTO.setSd_knowledge_type(types[0].getCode());
					knowledgeDTO.setName_knowledge_type(types[0].getName());
					return knowledgeDTO;
				}
			}
		}
		return null;
	}
	

	
}
