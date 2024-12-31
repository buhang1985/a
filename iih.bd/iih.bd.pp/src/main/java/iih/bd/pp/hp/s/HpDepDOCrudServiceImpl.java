package iih.bd.pp.hp.s;
import iih.bd.pp.hp.d.HpDepDO;
import iih.bd.pp.hp.d.desc.HpDepDODesc;
import iih.bd.pp.hp.i.IHpDepDOCudService;
import iih.bd.pp.hp.i.IHpDepDORService;
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
@Service(serviceInterfaces={IHpDepDOCudService.class,IHpDepDORService.class}, binding=Binding.JSONRPC)
public class HpDepDOCrudServiceImpl extends BaseDOService<HpDepDO> implements IHpDepDOCudService,IHpDepDORService {

    public HpDepDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HpDepDODesc.class),IAppFwTempTbl.tmp_iaw_11.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

