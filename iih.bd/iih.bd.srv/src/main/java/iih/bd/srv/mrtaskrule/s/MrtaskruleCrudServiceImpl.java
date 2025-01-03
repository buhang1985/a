package iih.bd.srv.mrtaskrule.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.bd.srv.mrtaskrule.d.MrTaskRuleDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.bd.srv.mrtaskrule.d.desc.MrTaskRuleDODesc;
import iih.bd.srv.mrtaskrule.d.MrtaskruleAggDO;
import iih.bd.srv.mrtaskrule.i.IMrtaskruleCudService;
import iih.bd.srv.mrtaskrule.i.IMrtaskruleRService;


/**
 * 病历书写任务配置AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMrtaskruleCudService.class,IMrtaskruleRService.class}, binding=Binding.JSONRPC)
public class MrtaskruleCrudServiceImpl extends BaseAggService<MrtaskruleAggDO,MrTaskRuleDO> implements IMrtaskruleCudService,IMrtaskruleRService {
    public MrtaskruleCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MrTaskRuleDODesc.class),IAppFwTempTbl.tmp_iaw_08.name()); 
    }
}
