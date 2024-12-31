package iih.bd.pp.hp.s;
import iih.bd.pp.hp.d.HpDosageDO;
import iih.bd.pp.hp.d.desc.HpDosageDODesc;
import iih.bd.pp.hp.i.IHpDosageDOCudService;
import iih.bd.pp.hp.i.IHpDosageDORService;
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
@Service(serviceInterfaces={IHpDosageDOCudService.class,IHpDosageDORService.class}, binding=Binding.JSONRPC)
public class HpDosageDOCrudServiceImpl extends BaseDOService<HpDosageDO> implements IHpDosageDOCudService,IHpDosageDORService {

    public HpDosageDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HpDosageDODesc.class),IAppFwTempTbl.tmp_iaw_29.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

