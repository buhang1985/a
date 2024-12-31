package iih.bd.srv.nurcustomca.s;
import iih.bd.srv.nurcustomca.d.NurCustomcaItmDO;
import iih.bd.srv.nurcustomca.d.desc.NurCustomcaItmDODesc;
import iih.bd.srv.nurcustomca.i.INurCustomcaItmDOCudService;
import iih.bd.srv.nurcustomca.i.INurCustomcaItmDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 医疗记录_护理文书分类主实体CRUD服务实现
 */
@Service(serviceInterfaces={INurCustomcaItmDOCudService.class,INurCustomcaItmDORService.class}, binding=Binding.JSONRPC)
public class NurCustomcaItmDOCrudServiceImpl extends BaseDOService<NurCustomcaItmDO> implements INurCustomcaItmDOCudService,INurCustomcaItmDORService {

    public NurCustomcaItmDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(NurCustomcaItmDODesc.class),IAppFwTempTbl.tmp_iaw_13.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

