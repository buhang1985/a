package iih.bd.pp.hp.s;
import iih.bd.pp.hp.d.BdHpPatcaDO;
import iih.bd.pp.hp.d.desc.BdHpPatcaDODesc;
import iih.bd.pp.hp.i.IBdHpPatcaDOCudService;
import iih.bd.pp.hp.i.IBdHpPatcaDORService;
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
@Service(serviceInterfaces={IBdHpPatcaDOCudService.class,IBdHpPatcaDORService.class}, binding=Binding.JSONRPC)
public class BdHpPatcaDOCrudServiceImpl extends BaseDOService<BdHpPatcaDO> implements IBdHpPatcaDOCudService,IBdHpPatcaDORService {

    public BdHpPatcaDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdHpPatcaDODesc.class),IAppFwTempTbl.tmp_iaw_13.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

