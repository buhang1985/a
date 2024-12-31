package iih.bd.srv.mrwp.s;
import iih.bd.srv.mrwp.d.MrWritePowerEmpDO;
import iih.bd.srv.mrwp.d.desc.MrWritePowerEmpDODesc;
import iih.bd.srv.mrwp.i.IMrWritePowerEmpDOCudService;
import iih.bd.srv.mrwp.i.IMrWritePowerEmpDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * mrwp主实体CRUD服务实现
 */
@Service(serviceInterfaces={IMrWritePowerEmpDOCudService.class,IMrWritePowerEmpDORService.class}, binding=Binding.JSONRPC)
public class MrWritePowerEmpDOCrudServiceImpl extends BaseDOService<MrWritePowerEmpDO> implements IMrWritePowerEmpDOCudService,IMrWritePowerEmpDORService {

    public MrWritePowerEmpDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MrWritePowerEmpDODesc.class),IAppFwTempTbl.tmp_iaw_17.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

