package iih.bd.fc.mdwfconfig.s;
import iih.bd.fc.mdwfconfig.d.MdWfDO;
import iih.bd.fc.mdwfconfig.d.desc.MdWfDODesc;
import iih.bd.fc.mdwfconfig.i.IMdWfDOCudService;
import iih.bd.fc.mdwfconfig.i.IMdWfDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 组件主实体CRUD服务实现
 */
@Service(serviceInterfaces={IMdWfDOCudService.class,IMdWfDORService.class}, binding=Binding.JSONRPC)
public class MdWfDOCrudServiceImpl extends BaseDOService<MdWfDO> implements IMdWfDOCudService,IMdWfDORService {

    public MdWfDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MdWfDODesc.class),IAppFwTempTbl.tmp_iaw_06.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}
