package iih.bd.cmp.marplan.s;
import iih.bd.cmp.marplan.d.BdCmpMarFreeDO;
import iih.bd.cmp.marplan.d.desc.BdCmpMarFreeDODesc;
import iih.bd.cmp.marplan.i.IBdCmpMarFreeDOCudService;
import iih.bd.cmp.marplan.i.IBdCmpMarFreeDORService;
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
@Service(serviceInterfaces={IBdCmpMarFreeDOCudService.class,IBdCmpMarFreeDORService.class}, binding=Binding.JSONRPC)
public class BdCmpMarFreeDOCrudServiceImpl extends BaseDOService<BdCmpMarFreeDO> implements IBdCmpMarFreeDOCudService,IBdCmpMarFreeDORService {

    public BdCmpMarFreeDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdCmpMarFreeDODesc.class),IAppFwTempTbl.tmp_iaw_15.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

