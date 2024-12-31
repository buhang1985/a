package iih.bl.st.blpaypatip.s;
import iih.bl.st.blpaypatip.d.BlPayPatIpDO;
import iih.bl.st.blpaypatip.d.BlpaypatipAggDO;
import iih.bl.st.blpaypatip.d.desc.BlPayPatIpDODesc;
import iih.bl.st.blpaypatip.i.IBlpaypatipCudService;
import iih.bl.st.blpaypatip.i.IBlpaypatipRService;
import iih.bl.st.blpaypatip.s.rule.BlpaypatipAggDOInsertAfterRule;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 住院患者结算收付款AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlpaypatipCudService.class,IBlpaypatipRService.class}, binding=Binding.JSONRPC)
public class BlpaypatipCrudServiceImpl extends BaseAggService<BlpaypatipAggDO,BlPayPatIpDO> implements IBlpaypatipCudService,IBlpaypatipRService {

    public BlpaypatipCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlPayPatIpDODesc.class),IAppFwTempTbl.tmp_iaw_15.name()); 
    }
    
    @SuppressWarnings("unchecked")
	@Override
    protected void addInsertAfterRule(AroundProcesser<BlpaypatipAggDO> processor) {
    	processor.addAfterRule(new BlpaypatipAggDOInsertAfterRule());
    	super.addInsertAfterRule(processor);
    }
}

