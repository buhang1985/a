package iih.bl.st.blpaypatip.s;
import iih.bl.st.blpaypatip.d.BlPayItmPatIpDO;
import iih.bl.st.blpaypatip.d.desc.BlPayItmPatIpDODesc;
import iih.bl.st.blpaypatip.i.IBlPayItmPatIpDOCudService;
import iih.bl.st.blpaypatip.i.IBlPayItmPatIpDORService;
import iih.bl.st.blpaypatip.s.rule.BlPayPatItemIpInsertAfterRule;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 住院患者结算收付款主实体CRUD服务实现
 */
@Service(serviceInterfaces={IBlPayItmPatIpDOCudService.class,IBlPayItmPatIpDORService.class}, binding=Binding.JSONRPC)
public class BlPayItmPatIpDOCrudServiceImpl extends BaseDOService<BlPayItmPatIpDO> implements IBlPayItmPatIpDOCudService,IBlPayItmPatIpDORService {

    public BlPayItmPatIpDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlPayItmPatIpDODesc.class),IAppFwTempTbl.tmp_iaw_19.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
    
	@SuppressWarnings("unchecked")
	@Override
    protected void addInsertAfterRule(AroundProcesser<BlPayItmPatIpDO> processor) {
    	processor.addAfterRule(new BlPayPatItemIpInsertAfterRule());
    	super.addInsertAfterRule(processor);
    }
}

