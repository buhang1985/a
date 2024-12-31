package iih.bd.srv.emrterm.s;
import iih.bd.srv.emrterm.d.EmrTermCompDO;
import iih.bd.srv.emrterm.d.desc.EmrTermCompDODesc;
import iih.bd.srv.emrterm.i.IEmrtermcompCudService;
import iih.bd.srv.emrterm.i.IEmrtermcompRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;


/**
 * 病历辅助录入组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEmrtermcompCudService.class,IEmrtermcompRService.class}, binding=Binding.JSONRPC)
public class EmrtermcompCrudServiceImpl extends BaseDOService<EmrTermCompDO> implements IEmrtermcompCudService,IEmrtermcompRService {

    public EmrtermcompCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EmrTermCompDODesc.class),IAppFwTempTbl.tmp_iaw_22.name()); 
    }
    
    @Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate(), };
	}

	@Override
	protected Validator[] getUpdateValidator(EmrTermCompDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}

