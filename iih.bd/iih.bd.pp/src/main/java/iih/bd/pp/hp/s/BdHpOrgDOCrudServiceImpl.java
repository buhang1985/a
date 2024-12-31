package iih.bd.pp.hp.s;
import iih.bd.pp.hp.d.BdHpOrgDO;
import iih.bd.pp.hp.d.desc.BdHpOrgDODesc;
import iih.bd.pp.hp.i.IBdHpOrgDOCudService;
import iih.bd.pp.hp.i.IBdHpOrgDORService;
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
@Service(serviceInterfaces={IBdHpOrgDOCudService.class,IBdHpOrgDORService.class}, binding=Binding.JSONRPC)
public class BdHpOrgDOCrudServiceImpl extends BaseDOService<BdHpOrgDO> implements IBdHpOrgDOCudService,IBdHpOrgDORService {

    public BdHpOrgDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdHpOrgDODesc.class),IAppFwTempTbl.tmp_iaw_10.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

