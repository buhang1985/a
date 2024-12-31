package iih.mi.mibd.referralstatus.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.mi.mibd.referralstatus.d.desc.ReferralStatusDODesc;
import iih.mi.mibd.referralstatus.d.ReferralStatusDO;
import iih.mi.mibd.referralstatus.i.IReferralstatusCudService;
import iih.mi.mibd.referralstatus.i.IReferralstatusRService;


/**
 * 医保平台_转诊状态AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IReferralstatusCudService.class,IReferralstatusRService.class}, binding=Binding.JSONRPC)
public class ReferralstatusCrudServiceImpl extends BaseDOService<ReferralStatusDO> implements IReferralstatusCudService,IReferralstatusRService {
    public ReferralstatusCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ReferralStatusDODesc.class),IAppFwTempTbl.tmp_iaw_11.name()); 
    }
    @Override
    protected Validator[] getInsertValidator() {
    	return new Validator[] {new BDUniqueRuleValidate(),};
    }
    
    @Override
    protected Validator[] getUpdateValidator(ReferralStatusDO[] oldDOs) {
    	
    	return new Validator[] { new BDUniqueRuleValidate()};
    }
    
    @Override
    protected Validator[] getDeleteValidator() {
    	return new Validator[] { BDReferenceChecker.getInstance() };
    }
}
