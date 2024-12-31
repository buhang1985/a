package iih.bd.pp.hp.s;
import iih.bd.pp.hp.d.HpDiDO;
import iih.bd.pp.hp.d.desc.HpDiDODesc;
import iih.bd.pp.hp.i.IHpDiDOCudService;
import iih.bd.pp.hp.i.IHpDiDORService;
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
@Service(serviceInterfaces={IHpDiDOCudService.class,IHpDiDORService.class}, binding=Binding.JSONRPC)
public class HpDiDOCrudServiceImpl extends BaseDOService<HpDiDO> implements IHpDiDOCudService,IHpDiDORService {

    public HpDiDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HpDiDODesc.class),IAppFwTempTbl.tmp_iaw_11.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

