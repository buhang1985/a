package iih.mi.mibd.admstatus.s;
import iih.mi.mibd.admstatus.d.AdmStatusDO;
import iih.mi.mibd.admstatus.d.desc.AdmStatusDODesc;
import iih.mi.mibd.admstatus.i.IAdmstatusCudService;
import iih.mi.mibd.admstatus.i.IAdmstatusRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;


/**
 * 医保平台_入院状态AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IAdmstatusCudService.class,IAdmstatusRService.class}, binding=Binding.JSONRPC)
public class AdmstatusCrudServiceImpl extends BaseDOService<AdmStatusDO> implements IAdmstatusCudService,IAdmstatusRService {
    public AdmstatusCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(AdmStatusDODesc.class),IAppFwTempTbl.tmp_iaw_12.name()); 
    }
    
    @Override
    protected Validator[] getInsertValidator() {
    	return new Validator[] {new BDUniqueRuleValidate(),};
    }
    
    @Override
    protected Validator[] getUpdateValidator(AdmStatusDO[] oldDOs) {
    	
    	return new Validator[] { new BDUniqueRuleValidate()};
    }
    
    @Override
    protected Validator[] getDeleteValidator() {
    	return new Validator[] { BDReferenceChecker.getInstance() };
    }
    
}
