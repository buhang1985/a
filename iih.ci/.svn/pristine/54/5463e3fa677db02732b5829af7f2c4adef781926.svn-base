package iih.ci.mr.knowledge.s;
import iih.ci.mr.knowledge.d.KnowledgeDO;
import iih.ci.mr.knowledge.d.desc.KnowledgeDODesc;
import iih.ci.mr.knowledge.i.IKnowledgeCudService;
import iih.ci.mr.knowledge.i.IKnowledgeRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;


/**
 * 知识库AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IKnowledgeCudService.class,IKnowledgeRService.class}, binding=Binding.JSONRPC)
public class KnowledgeCrudServiceImpl extends BaseDOService<KnowledgeDO> implements IKnowledgeCudService,IKnowledgeRService {
    public KnowledgeCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(KnowledgeDODesc.class),IAppFwTempTbl.tmp_iaw_23.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(KnowledgeDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
