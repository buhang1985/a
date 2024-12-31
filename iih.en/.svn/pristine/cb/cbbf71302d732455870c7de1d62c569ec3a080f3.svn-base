package iih.en.pv.enfee.s;
import iih.en.pv.enfee.d.EnFixedFeeDO;
import iih.en.pv.enfee.d.desc.EnFixedFeeDODesc;
import iih.en.pv.enfee.i.IEnfixedfeeMDOCudService;
import iih.en.pv.enfee.i.IEnfixedfeeMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 患者就诊_固定费用主实体CRUD服务实现
 */
@Service(serviceInterfaces={IEnfixedfeeMDOCudService.class,IEnfixedfeeMDORService.class}, binding=Binding.JSONRPC)
public class EnfixedfeeMDOCrudServiceImpl extends BaseDOService<EnFixedFeeDO> implements IEnfixedfeeMDOCudService,IEnfixedfeeMDORService {

    public EnfixedfeeMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EnFixedFeeDODesc.class),IAppFwTempTbl.tmp_iaw_04.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

