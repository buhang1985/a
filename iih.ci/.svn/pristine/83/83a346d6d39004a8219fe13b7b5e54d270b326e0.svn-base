package iih.ci.rcm.infectionrate.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.ci.rcm.infectionrate.d.InfectionRateDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.ci.rcm.infectionrate.d.desc.InfectionRateDODesc;
import iih.ci.rcm.infectionrate.d.InfectionrateAggDO;
import iih.ci.rcm.infectionrate.i.IInfectionrateCudService;
import iih.ci.rcm.infectionrate.i.IInfectionrateRService;


/**
 * 医院感染现患率AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IInfectionrateCudService.class,IInfectionrateRService.class}, binding=Binding.JSONRPC)
public class InfectionrateCrudServiceImpl extends BaseAggService<InfectionrateAggDO,InfectionRateDO> implements IInfectionrateCudService,IInfectionrateRService {
    public InfectionrateCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(InfectionRateDODesc.class),IAppFwTempTbl.tmp_iaw_03.name()); 
    }
}
