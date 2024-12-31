package iih.bd.pp.bddepcg.s;
import iih.bd.pp.bddepcg.d.BdDepCgDO;
import iih.bd.pp.bddepcg.d.desc.BdDepCgDODesc;
import iih.bd.pp.bddepcg.i.IBddepcgMDOCudService;
import iih.bd.pp.bddepcg.i.IBddepcgMDORService;
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
@Service(serviceInterfaces={IBddepcgMDOCudService.class,IBddepcgMDORService.class}, binding=Binding.JSONRPC)
public class BddepcgMDOCrudServiceImpl extends BaseDOService<BdDepCgDO> implements IBddepcgMDOCudService,IBddepcgMDORService {

    public BddepcgMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdDepCgDODesc.class),IAppFwTempTbl.tmp_iaw_15.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

