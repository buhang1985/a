package iih.bl.inc.blincoep.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.bl.inc.blincoep.d.BlIncOepDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.bl.inc.blincoep.d.desc.BlIncOepDODesc;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.inc.blincoep.i.IBlincoepCudService;
import iih.bl.inc.blincoep.i.IBlincoepRService;
import iih.bl.inc.blincoep.s.rule.BlIncOepInsertBeforeRule;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlincoepCudService.class,IBlincoepRService.class}, binding=Binding.JSONRPC)
public class BlincoepCrudServiceImpl extends BaseAggService<BlincoepAggDO,BlIncOepDO> implements IBlincoepCudService,IBlincoepRService {
    public BlincoepCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlIncOepDODesc.class),IAppFwTempTbl.tmp_iaw_19.name()); 
    }
    
    @SuppressWarnings("unchecked")
	@Override
    protected void addInsertBeforeRule(AroundProcesser<BlincoepAggDO> processer) {
    	processer.addBeforeRule(new BlIncOepInsertBeforeRule());
    	super.addInsertBeforeRule(processer);
    	
    }
}
