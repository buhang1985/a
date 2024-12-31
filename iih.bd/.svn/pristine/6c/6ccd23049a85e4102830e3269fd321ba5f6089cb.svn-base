package iih.bd.pp.hp.s;
import iih.bd.pp.hp.d.BdHpCtrDO;
import iih.bd.pp.hp.d.desc.BdHpCtrDODesc;
import iih.bd.pp.hp.i.IBdHpCtrDOCudService;
import iih.bd.pp.hp.i.IBdHpCtrDORService;
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
@Service(serviceInterfaces={IBdHpCtrDOCudService.class,IBdHpCtrDORService.class}, binding=Binding.JSONRPC)
public class BdHpCtrDOCrudServiceImpl extends BaseDOService<BdHpCtrDO> implements IBdHpCtrDOCudService,IBdHpCtrDORService {

    public BdHpCtrDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdHpCtrDODesc.class),IAppFwTempTbl.tmp_iaw_24.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

