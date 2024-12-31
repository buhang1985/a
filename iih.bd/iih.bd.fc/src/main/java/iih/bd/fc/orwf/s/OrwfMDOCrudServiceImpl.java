package iih.bd.fc.orwf.s;
import iih.bd.fc.orwf.d.OrWfCfgDO;
import iih.bd.fc.orwf.d.desc.OrWfCfgDODesc;
import iih.bd.fc.orwf.i.IOrwfMDOCudService;
import iih.bd.fc.orwf.i.IOrwfMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 医嘱流向主实体CRUD服务实现
 */
@Service(serviceInterfaces={IOrwfMDOCudService.class,IOrwfMDORService.class}, binding=Binding.JSONRPC)
public class OrwfMDOCrudServiceImpl extends BaseDOService<OrWfCfgDO> implements IOrwfMDOCudService,IOrwfMDORService {

    public OrwfMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrWfCfgDODesc.class),IAppFwTempTbl.tmp_iaw_27.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}
