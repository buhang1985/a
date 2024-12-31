package iih.bd.srv.nurcustomca.s;
import iih.bd.srv.nurcustomca.d.NurCustomcaDO;
import iih.bd.srv.nurcustomca.d.desc.NurCustomcaDODesc;
import iih.bd.srv.nurcustomca.i.INurcustomcaMDOCudService;
import iih.bd.srv.nurcustomca.i.INurcustomcaMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.TreeBaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 医疗记录_护理文书分类主实体CRUD服务实现
 */
@Service(serviceInterfaces={INurcustomcaMDOCudService.class,INurcustomcaMDORService.class}, binding=Binding.JSONRPC)
public class NurcustomcaMDOCrudServiceImpl extends TreeBaseDOService<NurCustomcaDO> implements INurcustomcaMDOCudService,INurcustomcaMDORService {

    public NurcustomcaMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(NurCustomcaDODesc.class),IAppFwTempTbl.tmp_iaw_19.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

