package iih.ci.rcm.infectionoutbreakreport.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.ci.rcm.infectionoutbreakreport.d.InfectionOutbreakReportDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.ci.rcm.infectionoutbreakreport.d.desc.InfectionOutbreakReportDODesc;
import iih.ci.rcm.infectionoutbreakreport.d.InfectionoutbreakreportAggDO;
import iih.ci.rcm.infectionoutbreakreport.i.IInfectionoutbreakreportCudService;
import iih.ci.rcm.infectionoutbreakreport.i.IInfectionoutbreakreportRService;


/**
 * 医院感染暴发报告登记表AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IInfectionoutbreakreportCudService.class,IInfectionoutbreakreportRService.class}, binding=Binding.JSONRPC)
public class InfectionoutbreakreportCrudServiceImpl extends BaseAggService<InfectionoutbreakreportAggDO,InfectionOutbreakReportDO> implements IInfectionoutbreakreportCudService,IInfectionoutbreakreportRService {
    public InfectionoutbreakreportCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(InfectionOutbreakReportDODesc.class),IAppFwTempTbl.tmp_iaw_06.name()); 
    }
}
