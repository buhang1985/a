package iih.bd.srv.emrimg.s;
import iih.bd.srv.emrimg.d.EmrImageDO;
import iih.bd.srv.emrimg.d.desc.EmrImageDODesc;
import iih.bd.srv.emrimg.i.IEmrimgMDOCudService;
import iih.bd.srv.emrimg.i.IEmrimgMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 医疗记录图片库管理主实体CRUD服务实现
 */
@Service(serviceInterfaces={IEmrimgMDOCudService.class,IEmrimgMDORService.class}, binding=Binding.JSONRPC)
public class EmrimgMDOCrudServiceImpl extends BaseDOService<EmrImageDO> implements IEmrimgMDOCudService,IEmrimgMDORService {

    public EmrimgMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EmrImageDODesc.class),IAppFwTempTbl.tmp_iaw_19.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

