package iih.bd.srv.medvalidate.s;
import iih.bd.srv.medvalidate.d.BDErrorInfoDO;
import iih.bd.srv.medvalidate.d.desc.BDErrorInfoDODesc;
import iih.bd.srv.medvalidate.i.IMedvalidateMDOCudService;
import iih.bd.srv.medvalidate.i.IMedvalidateMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 基础数据服务校验主实体CRUD服务实现
 */
@Service(serviceInterfaces={IMedvalidateMDOCudService.class,IMedvalidateMDORService.class}, binding=Binding.JSONRPC)
public class MedvalidateMDOCrudServiceImpl extends BaseDOService<BDErrorInfoDO> implements IMedvalidateMDOCudService,IMedvalidateMDORService {

    public MedvalidateMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BDErrorInfoDODesc.class),IAppFwTempTbl.tmp_iaw_06.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

