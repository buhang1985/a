package iih.bd.pp.hp.s;
import iih.bd.pp.hp.d.HPSegDO;
import iih.bd.pp.hp.d.desc.HPSegDODesc;
import iih.bd.pp.hp.i.IHPSegDOCudService;
import iih.bd.pp.hp.i.IHPSegDORService;
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
@Service(serviceInterfaces={IHPSegDOCudService.class,IHPSegDORService.class}, binding=Binding.JSONRPC)
public class HPSegDOCrudServiceImpl extends BaseDOService<HPSegDO> implements IHPSegDOCudService,IHPSegDORService {

    public HPSegDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HPSegDODesc.class),IAppFwTempTbl.tmp_iaw_29.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

