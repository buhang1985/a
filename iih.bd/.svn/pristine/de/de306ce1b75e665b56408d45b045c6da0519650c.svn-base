package iih.bd.pp.hp.s;
import iih.bd.pp.hp.d.HpFreqDO;
import iih.bd.pp.hp.d.desc.HpFreqDODesc;
import iih.bd.pp.hp.i.IHpFreqDOCudService;
import iih.bd.pp.hp.i.IHpFreqDORService;
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
@Service(serviceInterfaces={IHpFreqDOCudService.class,IHpFreqDORService.class}, binding=Binding.JSONRPC)
public class HpFreqDOCrudServiceImpl extends BaseDOService<HpFreqDO> implements IHpFreqDOCudService,IHpFreqDORService {

    public HpFreqDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HpFreqDODesc.class),IAppFwTempTbl.tmp_iaw_19.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

