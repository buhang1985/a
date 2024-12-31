package iih.bd.res.mtassist.s;
import iih.bd.res.mtassist.d.MtAssistDO;
import iih.bd.res.mtassist.d.desc.MtAssistDODesc;
import iih.bd.res.mtassist.i.IMtassistMDOCudService;
import iih.bd.res.mtassist.i.IMtassistMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医技辅主实体CRUD服务实现
 */
@Service(serviceInterfaces={IMtassistMDOCudService.class,IMtassistMDORService.class}, binding=Binding.JSONRPC)
public class MtassistMDOCrudServiceImpl extends BaseDOService<MtAssistDO> implements IMtassistMDOCudService,IMtassistMDORService {

    public MtassistMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MtAssistDODesc.class),IAppFwTempTbl.tmp_iaw_22.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(MtAssistDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}

