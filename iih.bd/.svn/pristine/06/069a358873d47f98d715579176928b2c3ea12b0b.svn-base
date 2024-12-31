package iih.bd.mhi.hospmedinsur.s;
import iih.bd.mhi.hospmedinsur.d.HpHospMedInsurDO;
import iih.bd.mhi.hospmedinsur.d.desc.HpHospMedInsurDODesc;
import iih.bd.mhi.hospmedinsur.i.IHospmedinsurCudService;
import iih.bd.mhi.hospmedinsur.i.IHospmedinsurRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;


/**
 * 医疗保险_医院医保信息AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IHospmedinsurCudService.class,IHospmedinsurRService.class}, binding=Binding.JSONRPC)
public class HospmedinsurCrudServiceImpl extends BaseDOService<HpHospMedInsurDO> implements IHospmedinsurCudService,IHospmedinsurRService {
    public HospmedinsurCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HpHospMedInsurDODesc.class),IAppFwTempTbl.tmp_iaw_28.name()); 
    }
    
    @Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(HpHospMedInsurDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
