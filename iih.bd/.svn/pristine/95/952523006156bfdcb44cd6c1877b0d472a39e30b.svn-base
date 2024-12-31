package iih.bd.pp.medinsurrecdiff.s;
import iih.bd.pp.medinsurrecdiff.d.MedInsurSrvFacRecDiffDO;
import iih.bd.pp.medinsurrecdiff.d.desc.MedInsurSrvFacRecDiffDODesc;
import iih.bd.pp.medinsurrecdiff.i.IMedInsurSrvFacRecDiffDOCudService;
import iih.bd.pp.medinsurrecdiff.i.IMedInsurSrvFacRecDiffDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 医保记录差异主实体CRUD服务实现
 */
@Service(serviceInterfaces={IMedInsurSrvFacRecDiffDOCudService.class,IMedInsurSrvFacRecDiffDORService.class}, binding=Binding.JSONRPC)
public class MedInsurSrvFacRecDiffDOCrudServiceImpl extends BaseDOService<MedInsurSrvFacRecDiffDO> implements IMedInsurSrvFacRecDiffDOCudService,IMedInsurSrvFacRecDiffDORService {

    public MedInsurSrvFacRecDiffDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MedInsurSrvFacRecDiffDODesc.class),IAppFwTempTbl.tmp_iaw_20.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

