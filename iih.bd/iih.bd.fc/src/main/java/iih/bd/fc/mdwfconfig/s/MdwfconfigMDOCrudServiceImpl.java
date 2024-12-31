package iih.bd.fc.mdwfconfig.s;
import iih.bd.fc.mdwfconfig.d.MdWfCaDO;
import iih.bd.fc.mdwfconfig.d.desc.MdWfCaDODesc;
import iih.bd.fc.mdwfconfig.i.IMdwfconfigMDOCudService;
import iih.bd.fc.mdwfconfig.i.IMdwfconfigMDORService;
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
@Service(serviceInterfaces={IMdwfconfigMDOCudService.class,IMdwfconfigMDORService.class}, binding=Binding.JSONRPC)
public class MdwfconfigMDOCrudServiceImpl extends BaseDOService<MdWfCaDO> implements IMdwfconfigMDOCudService,IMdwfconfigMDORService {

    public MdwfconfigMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MdWfCaDODesc.class),IAppFwTempTbl.tmp_iaw_20.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

