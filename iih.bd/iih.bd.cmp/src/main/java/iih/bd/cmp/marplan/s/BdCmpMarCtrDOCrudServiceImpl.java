package iih.bd.cmp.marplan.s;
import iih.bd.cmp.marplan.d.BdCmpMarCtrDO;
import iih.bd.cmp.marplan.d.desc.BdCmpMarCtrDODesc;
import iih.bd.cmp.marplan.i.IBdCmpMarCtrDOCudService;
import iih.bd.cmp.marplan.i.IBdCmpMarCtrDORService;
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
@Service(serviceInterfaces={IBdCmpMarCtrDOCudService.class,IBdCmpMarCtrDORService.class}, binding=Binding.JSONRPC)
public class BdCmpMarCtrDOCrudServiceImpl extends BaseDOService<BdCmpMarCtrDO> implements IBdCmpMarCtrDOCudService,IBdCmpMarCtrDORService {

    public BdCmpMarCtrDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdCmpMarCtrDODesc.class),IAppFwTempTbl.tmp_iaw_03.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

