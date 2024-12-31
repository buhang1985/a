package iih.en.pv.vt.s;
import iih.en.pv.vt.d.EnVtDO;
import iih.en.pv.vt.d.desc.EnVtDODesc;
import iih.en.pv.vt.i.IEnvtMDOCudService;
import iih.en.pv.vt.i.IEnvtMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 就诊_体征主实体CRUD服务实现
 */
@Service(serviceInterfaces={IEnvtMDOCudService.class,IEnvtMDORService.class}, binding=Binding.JSONRPC)
public class EnvtMDOCrudServiceImpl extends BaseDOService<EnVtDO> implements IEnvtMDOCudService,IEnvtMDORService {

    public EnvtMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EnVtDODesc.class),IAppFwTempTbl.tmp_iaw_14.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

