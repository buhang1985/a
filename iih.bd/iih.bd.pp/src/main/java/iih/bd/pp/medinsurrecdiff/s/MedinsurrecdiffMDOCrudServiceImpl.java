package iih.bd.pp.medinsurrecdiff.s;
import iih.bd.pp.medinsurrecdiff.d.MedInsurRecDiffDO;
import iih.bd.pp.medinsurrecdiff.d.desc.MedInsurRecDiffDODesc;
import iih.bd.pp.medinsurrecdiff.i.IMedinsurrecdiffMDOCudService;
import iih.bd.pp.medinsurrecdiff.i.IMedinsurrecdiffMDORService;
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
@Service(serviceInterfaces={IMedinsurrecdiffMDOCudService.class,IMedinsurrecdiffMDORService.class}, binding=Binding.JSONRPC)
public class MedinsurrecdiffMDOCrudServiceImpl extends BaseDOService<MedInsurRecDiffDO> implements IMedinsurrecdiffMDOCudService,IMedinsurrecdiffMDORService {

    public MedinsurrecdiffMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MedInsurRecDiffDODesc.class),IAppFwTempTbl.tmp_iaw_17.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

