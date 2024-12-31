package iih.bd.fc.entpwfmr.s;
import iih.bd.fc.entpwfmr.d.BdEntpWfMrDO;
import iih.bd.fc.entpwfmr.d.desc.BdEntpWfMrDODesc;
import iih.bd.fc.entpwfmr.i.IEntpwfmrCudService;
import iih.bd.fc.entpwfmr.i.IEntpwfmrRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;


/**
 * 医疗记录计划AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEntpwfmrCudService.class,IEntpwfmrRService.class}, binding=Binding.JSONRPC)
public class EntpwfmrCrudServiceImpl extends BaseDOService<BdEntpWfMrDO> implements IEntpwfmrCudService,IEntpwfmrRService {

    public EntpwfmrCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdEntpWfMrDODesc.class),IAppFwTempTbl.tmp_iaw_10.name()); 
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
	protected Validator[] getUpdateValidator(BdEntpWfMrDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}

