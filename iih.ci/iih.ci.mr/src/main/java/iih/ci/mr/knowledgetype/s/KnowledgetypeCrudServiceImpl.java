package iih.ci.mr.knowledgetype.s;
import iih.ci.mr.knowledgetype.d.KnowledgeTypeDO;
import iih.ci.mr.knowledgetype.d.desc.KnowledgeTypeDODesc;
import iih.ci.mr.knowledgetype.i.IKnowledgetypeCudService;
import iih.ci.mr.knowledgetype.i.IKnowledgetypeRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;


/**
 * 知识库类型AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IKnowledgetypeCudService.class,IKnowledgetypeRService.class}, binding=Binding.JSONRPC)
public class KnowledgetypeCrudServiceImpl extends BaseDOService<KnowledgeTypeDO> implements IKnowledgetypeCudService,IKnowledgetypeRService {
    public KnowledgetypeCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(KnowledgeTypeDODesc.class),IAppFwTempTbl.tmp_iaw_11.name()); 
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
	protected Validator[] getUpdateValidator(KnowledgeTypeDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
