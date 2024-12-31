package iih.bd.pp.bddepcg.s;
import iih.bd.pp.bddepcg.d.BdDepCgDO;
import iih.bd.pp.bddepcg.d.BddepcgAggDO;
import iih.bd.pp.bddepcg.d.desc.BdDepCgDODesc;
import iih.bd.pp.bddepcg.i.IBddepcgCudService;
import iih.bd.pp.bddepcg.i.IBddepcgRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.AggBDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;


/**
 * 科室补费策略AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBddepcgCudService.class,IBddepcgRService.class}, binding=Binding.JSONRPC)
public class BddepcgCrudServiceImpl extends BaseAggService<BddepcgAggDO,BdDepCgDO> implements IBddepcgCudService,IBddepcgRService {
    public BddepcgCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdDepCgDODesc.class),IAppFwTempTbl.tmp_iaw_09.name()); 
    }
    
    @Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate(), };
	}

	@Override
	protected Validator[] getUpdateValidator(BddepcgAggDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { AggBDReferenceChecker.getInstance() };
	}
}
