package iih.bl.cg.blcgoep.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.bl.cg.blcgoep.d.BlCgOepDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.bl.cg.blcgoep.d.desc.BlCgOepDODesc;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgoep.i.IBlcgoepCudService;
import iih.bl.cg.blcgoep.i.IBlcgoepRService;
import iih.bl.cg.blcgoep.s.rule.BlCgOepItemInsertBefRule;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlcgoepCudService.class,IBlcgoepRService.class}, binding=Binding.JSONRPC)
public class BlcgoepCrudServiceImpl extends BaseAggService<BlcgoepAggDO,BlCgOepDO> implements IBlcgoepCudService,IBlcgoepRService {
    public BlcgoepCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlCgOepDODesc.class),IAppFwTempTbl.tmp_iaw_05.name()); 
    }
    
	@SuppressWarnings("unchecked")
	@Override
	protected void addInsertBeforeRule(AroundProcesser<BlcgoepAggDO> processer) {
		processer.addBeforeRule(new BlCgOepItemInsertBefRule());
		super.addInsertBeforeRule(processer);
	}    
}
