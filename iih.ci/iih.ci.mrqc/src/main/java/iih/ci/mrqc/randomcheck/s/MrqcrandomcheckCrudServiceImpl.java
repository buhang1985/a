package iih.ci.mrqc.randomcheck.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.ci.mrqc.randomcheck.d.CiMrQcRandomRecordDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.ci.mrqc.randomcheck.d.desc.CiMrQcRandomRecordDODesc;
import iih.ci.mrqc.randomcheck.d.MrqcrandomcheckAggDO;
import iih.ci.mrqc.randomcheck.i.IMrqcrandomcheckCudService;
import iih.ci.mrqc.randomcheck.i.IMrqcrandomcheckRService;


/**
 * 门诊病历抽查AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMrqcrandomcheckCudService.class,IMrqcrandomcheckRService.class}, binding=Binding.JSONRPC)
public class MrqcrandomcheckCrudServiceImpl extends BaseAggService<MrqcrandomcheckAggDO,CiMrQcRandomRecordDO> implements IMrqcrandomcheckCudService,IMrqcrandomcheckRService {
    public MrqcrandomcheckCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrQcRandomRecordDODesc.class),IAppFwTempTbl.tmp_iaw_19.name()); 
    }
}
