package iih.bd.pp.hp.s;
import iih.bd.pp.hp.d.BdHpPrestpDO;
import iih.bd.pp.hp.d.desc.BdHpPrestpDODesc;
import iih.bd.pp.hp.i.IBdHpPrestpDOCudService;
import iih.bd.pp.hp.i.IBdHpPrestpDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 医保计划主实体CRUD服务实现
 */
@Service(serviceInterfaces={IBdHpPrestpDOCudService.class,IBdHpPrestpDORService.class}, binding=Binding.JSONRPC)
public class BdHpPrestpDOCrudServiceImpl extends BaseDOService<BdHpPrestpDO> implements IBdHpPrestpDOCudService,IBdHpPrestpDORService {

    public BdHpPrestpDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdHpPrestpDODesc.class),IAppFwTempTbl.tmp_iaw_05.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

