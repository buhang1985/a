package iih.bd.pp.hp.s;
import iih.bd.pp.hp.d.BdHpKindDO;
import iih.bd.pp.hp.d.desc.BdHpKindDODesc;
import iih.bd.pp.hp.i.IBdHpKindDOCudService;
import iih.bd.pp.hp.i.IBdHpKindDORService;
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
@Service(serviceInterfaces={IBdHpKindDOCudService.class,IBdHpKindDORService.class}, binding=Binding.JSONRPC)
public class BdHpKindDOCrudServiceImpl extends BaseDOService<BdHpKindDO> implements IBdHpKindDOCudService,IBdHpKindDORService {

    public BdHpKindDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdHpKindDODesc.class),IAppFwTempTbl.tmp_iaw_18.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

