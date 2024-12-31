package iih.bl.cg.blcgquery.s;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.blcgquery.d.desc.BlCgIpDODesc;
import iih.bl.cg.blcgquery.i.IBlcgqueryCudService;
import iih.bl.cg.blcgquery.i.IBlcgqueryRService;
import iih.bl.cg.blcgquery.s.rule.BlCgIpInsertBefRule;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 住院记账AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlcgqueryCudService.class,IBlcgqueryRService.class}, binding=Binding.JSONRPC)
public class BlcgqueryCrudServiceImpl extends BaseDOService<BlCgIpDO> implements IBlcgqueryCudService,IBlcgqueryRService {
    public BlcgqueryCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlCgIpDODesc.class),IAppFwTempTbl.tmp_iaw_08.name()); 
    }
  
    @SuppressWarnings("unchecked")
	@Override
    protected void addInsertBeforeRule(AroundProcesser<BlCgIpDO> processer) {
    	processer.addBeforeRule(new BlCgIpInsertBefRule());
    	super.addInsertBeforeRule(processer);
    }
}
