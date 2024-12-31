package iih.bd.pp.bddepcg.s;
import iih.bd.pp.bddepcg.d.BdDepCgItmDO;
import iih.bd.pp.bddepcg.d.desc.BdDepCgItmDODesc;
import iih.bd.pp.bddepcg.i.IBdDepCgItmDOCudService;
import iih.bd.pp.bddepcg.i.IBdDepCgItmDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 科室补费策略主实体CRUD服务实现
 */
@Service(serviceInterfaces={IBdDepCgItmDOCudService.class,IBdDepCgItmDORService.class}, binding=Binding.JSONRPC)
public class BdDepCgItmDOCrudServiceImpl extends BaseDOService<BdDepCgItmDO> implements IBdDepCgItmDOCudService,IBdDepCgItmDORService {

    public BdDepCgItmDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdDepCgItmDODesc.class),IAppFwTempTbl.tmp_iaw_21.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

