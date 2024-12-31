package iih.mi.mibd.referraltp.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.mi.mibd.referraltp.d.desc.ReferralTpDODesc;
import iih.mi.mibd.referraltp.d.ReferralTpDO;
import iih.mi.mibd.referraltp.i.IReferraltpCudService;
import iih.mi.mibd.referraltp.i.IReferraltpRService;


/**
 * 医保平台_转诊类型AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IReferraltpCudService.class,IReferraltpRService.class}, binding=Binding.JSONRPC)
public class ReferraltpCrudServiceImpl extends BaseDOService<ReferralTpDO> implements IReferraltpCudService,IReferraltpRService {
    public ReferraltpCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ReferralTpDODesc.class),IAppFwTempTbl.tmp_iaw_02.name()); 
    }
    
    
    
    @Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate(), };
	}

	@Override
	protected Validator[] getUpdateValidator(ReferralTpDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate()};
	}
	
	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
