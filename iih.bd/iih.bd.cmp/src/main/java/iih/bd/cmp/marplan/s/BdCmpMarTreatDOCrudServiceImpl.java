package iih.bd.cmp.marplan.s;
import iih.bd.cmp.marplan.d.BdCmpMarTreatDO;
import iih.bd.cmp.marplan.d.desc.BdCmpMarTreatDODesc;
import iih.bd.cmp.marplan.i.IBdCmpMarTreatDOCudService;
import iih.bd.cmp.marplan.i.IBdCmpMarTreatDORService;
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
@Service(serviceInterfaces={IBdCmpMarTreatDOCudService.class,IBdCmpMarTreatDORService.class}, binding=Binding.JSONRPC)
public class BdCmpMarTreatDOCrudServiceImpl extends BaseDOService<BdCmpMarTreatDO> implements IBdCmpMarTreatDOCudService,IBdCmpMarTreatDORService {

    public BdCmpMarTreatDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdCmpMarTreatDODesc.class),IAppFwTempTbl.tmp_iaw_23.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

