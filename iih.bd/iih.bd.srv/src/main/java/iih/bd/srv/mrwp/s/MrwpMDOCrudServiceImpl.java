package iih.bd.srv.mrwp.s;
import iih.bd.srv.mrwp.d.MrWritePowerDO;
import iih.bd.srv.mrwp.d.desc.MrWritePowerDODesc;
import iih.bd.srv.mrwp.i.IMrwpMDOCudService;
import iih.bd.srv.mrwp.i.IMrwpMDORService;
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
@Service(serviceInterfaces={IMrwpMDOCudService.class,IMrwpMDORService.class}, binding=Binding.JSONRPC)
public class MrwpMDOCrudServiceImpl extends BaseDOService<MrWritePowerDO> implements IMrwpMDOCudService,IMrwpMDORService {

    public MrwpMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MrWritePowerDODesc.class),IAppFwTempTbl.tmp_iaw_21.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
    
	
}

