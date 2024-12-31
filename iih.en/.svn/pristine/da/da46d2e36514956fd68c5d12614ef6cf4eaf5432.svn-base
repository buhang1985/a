package iih.en.pv.vt.s;
import iih.en.pv.vt.d.EnVtSrvDO;
import iih.en.pv.vt.d.desc.EnVtSrvDODesc;
import iih.en.pv.vt.i.IEnVtSrvDOCudService;
import iih.en.pv.vt.i.IEnVtSrvDORService;
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
@Service(serviceInterfaces={IEnVtSrvDOCudService.class,IEnVtSrvDORService.class}, binding=Binding.JSONRPC)
public class EnVtSrvDOCrudServiceImpl extends BaseDOService<EnVtSrvDO> implements IEnVtSrvDOCudService,IEnVtSrvDORService {

    public EnVtSrvDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EnVtSrvDODesc.class),IAppFwTempTbl.tmp_iaw_12.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

