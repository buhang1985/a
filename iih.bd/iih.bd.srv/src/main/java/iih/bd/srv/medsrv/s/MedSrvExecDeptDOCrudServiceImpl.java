package iih.bd.srv.medsrv.s;
import iih.bd.srv.medsrv.d.MedSrvExecDeptDO;
import iih.bd.srv.medsrv.d.desc.MedSrvExecDeptDODesc;
import iih.bd.srv.medsrv.i.IMedSrvExecDeptDOCudService;
import iih.bd.srv.medsrv.i.IMedSrvExecDeptDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 医疗服务主实体CRUD服务实现
 */
@Service(serviceInterfaces={IMedSrvExecDeptDOCudService.class,IMedSrvExecDeptDORService.class}, binding=Binding.JSONRPC)
public class MedSrvExecDeptDOCrudServiceImpl extends BaseDOService<MedSrvExecDeptDO> implements IMedSrvExecDeptDOCudService,IMedSrvExecDeptDORService {

    public MedSrvExecDeptDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MedSrvExecDeptDODesc.class),IAppFwTempTbl.tmp_iaw_12.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}
