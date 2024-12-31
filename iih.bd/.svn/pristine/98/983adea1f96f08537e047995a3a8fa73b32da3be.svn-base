package iih.bd.pp.medinsurrecdiff.s;
import iih.bd.pp.medinsurrecdiff.d.MedInsurTreatRecDiffDO;
import iih.bd.pp.medinsurrecdiff.d.desc.MedInsurTreatRecDiffDODesc;
import iih.bd.pp.medinsurrecdiff.i.IMedInsurTreatRecDiffDOCudService;
import iih.bd.pp.medinsurrecdiff.i.IMedInsurTreatRecDiffDORService;
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
@Service(serviceInterfaces={IMedInsurTreatRecDiffDOCudService.class,IMedInsurTreatRecDiffDORService.class}, binding=Binding.JSONRPC)
public class MedInsurTreatRecDiffDOCrudServiceImpl extends BaseDOService<MedInsurTreatRecDiffDO> implements IMedInsurTreatRecDiffDOCudService,IMedInsurTreatRecDiffDORService {

    public MedInsurTreatRecDiffDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MedInsurTreatRecDiffDODesc.class),IAppFwTempTbl.tmp_iaw_03.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

