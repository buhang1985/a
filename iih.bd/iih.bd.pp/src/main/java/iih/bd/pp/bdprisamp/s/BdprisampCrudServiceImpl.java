package iih.bd.pp.bdprisamp.s;
import iih.bd.pp.bdprisamp.d.BdPriSampDO;
import iih.bd.pp.bdprisamp.d.desc.BdPriSampDODesc;
import iih.bd.pp.bdprisamp.i.IBdprisampCudService;
import iih.bd.pp.bdprisamp.i.IBdprisampRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;


/**
 * 标本采集费用对照AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBdprisampCudService.class,IBdprisampRService.class}, binding=Binding.JSONRPC)
public class BdprisampCrudServiceImpl extends BaseDOService<BdPriSampDO> implements IBdprisampCudService,IBdprisampRService {

    public BdprisampCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdPriSampDODesc.class),IAppFwTempTbl.tmp_iaw_10.name()); 
    }
    
    @Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate(), };
	}

	@Override
	protected Validator[] getUpdateValidator(BdPriSampDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}

