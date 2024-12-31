package iih.bd.pp.bdpripmpttpdo.s;
import iih.bd.pp.bdpripmpttpdo.d.BdPriPmPtTpDO;
import iih.bd.pp.bdpripmpttpdo.d.desc.BdPriPmPtTpDODesc;
import iih.bd.pp.bdpripmpttpdo.i.IBdpripmpttpdoCudService;
import iih.bd.pp.bdpripmpttpdo.i.IBdpripmpttpdoRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;


/**
 * 终端可用付款方式AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBdpripmpttpdoCudService.class,IBdpripmpttpdoRService.class}, binding=Binding.JSONRPC)
public class BdpripmpttpdoCrudServiceImpl extends BaseDOService<BdPriPmPtTpDO> implements IBdpripmpttpdoCudService,IBdpripmpttpdoRService {
    public BdpripmpttpdoCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdPriPmPtTpDODesc.class),IAppFwTempTbl.tmp_iaw_18.name()); 
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
    protected Validator[] getUpdateValidator(BdPriPmPtTpDO[] oldDOs) {
    	return new Validator[] { new BDUniqueRuleValidate() };
    }
    
}
