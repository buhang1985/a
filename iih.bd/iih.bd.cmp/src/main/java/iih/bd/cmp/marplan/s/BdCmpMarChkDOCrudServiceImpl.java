package iih.bd.cmp.marplan.s;
import iih.bd.cmp.marplan.d.BdCmpMarChkDO;
import iih.bd.cmp.marplan.d.desc.BdCmpMarChkDODesc;
import iih.bd.cmp.marplan.i.IBdCmpMarChkDOCudService;
import iih.bd.cmp.marplan.i.IBdCmpMarChkDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 营销方案主实体CRUD服务实现
 */
@Service(serviceInterfaces={IBdCmpMarChkDOCudService.class,IBdCmpMarChkDORService.class}, binding=Binding.JSONRPC)
public class BdCmpMarChkDOCrudServiceImpl extends BaseDOService<BdCmpMarChkDO> implements IBdCmpMarChkDOCudService,IBdCmpMarChkDORService {

    public BdCmpMarChkDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdCmpMarChkDODesc.class),IAppFwTempTbl.tmp_iaw_06.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

