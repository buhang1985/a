package iih.bd.pp.hp.s;
import iih.bd.pp.hp.d.BdHpLimitPsdDO;
import iih.bd.pp.hp.d.desc.BdHpLimitPsdDODesc;
import iih.bd.pp.hp.i.IBdHpLimitPsdDOCudService;
import iih.bd.pp.hp.i.IBdHpLimitPsdDORService;
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
@Service(serviceInterfaces={IBdHpLimitPsdDOCudService.class,IBdHpLimitPsdDORService.class}, binding=Binding.JSONRPC)
public class BdHpLimitPsdDOCrudServiceImpl extends BaseDOService<BdHpLimitPsdDO> implements IBdHpLimitPsdDOCudService,IBdHpLimitPsdDORService {

    public BdHpLimitPsdDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdHpLimitPsdDODesc.class),IAppFwTempTbl.tmp_iaw_25.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

