package iih.mi.mibd.dischargedstatus.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.mi.mibd.dischargedstatus.d.desc.DischargedStatusDODesc;
import iih.mi.mibd.dischargedstatus.d.DischargedStatusDO;
import iih.mi.mibd.dischargedstatus.i.IDischargedstatusCudService;
import iih.mi.mibd.dischargedstatus.i.IDischargedstatusRService;



/**
 * 医保平台_出院状态AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IDischargedstatusCudService.class,IDischargedstatusRService.class}, binding=Binding.JSONRPC)
public class DischargedstatusCrudServiceImpl extends BaseDOService<DischargedStatusDO> implements IDischargedstatusCudService,IDischargedstatusRService {
    public DischargedstatusCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(DischargedStatusDODesc.class),IAppFwTempTbl.tmp_iaw_10.name()); 
    }
    
    
    
    @Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate(), };
	}

	@Override
	protected Validator[] getUpdateValidator(DischargedStatusDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate()};
	}
	
	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
