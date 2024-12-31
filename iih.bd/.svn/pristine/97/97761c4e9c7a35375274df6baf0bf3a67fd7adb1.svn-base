package iih.bd.pp.medinsurrecdiff.s;
import iih.bd.pp.medinsurrecdiff.d.MedInsurDrugRecDiffDO;
import iih.bd.pp.medinsurrecdiff.d.desc.MedInsurDrugRecDiffDODesc;
import iih.bd.pp.medinsurrecdiff.i.IMedInsurDrugRecDiffDOCudService;
import iih.bd.pp.medinsurrecdiff.i.IMedInsurDrugRecDiffDORService;
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
@Service(serviceInterfaces={IMedInsurDrugRecDiffDOCudService.class,IMedInsurDrugRecDiffDORService.class}, binding=Binding.JSONRPC)
public class MedInsurDrugRecDiffDOCrudServiceImpl extends BaseDOService<MedInsurDrugRecDiffDO> implements IMedInsurDrugRecDiffDOCudService,IMedInsurDrugRecDiffDORService {

    public MedInsurDrugRecDiffDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MedInsurDrugRecDiffDODesc.class),IAppFwTempTbl.tmp_iaw_29.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

