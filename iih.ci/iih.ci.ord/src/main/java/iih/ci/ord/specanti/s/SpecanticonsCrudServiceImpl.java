package iih.ci.ord.specanti.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.ci.ord.specanti.d.SpecAntiConsDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.ci.ord.specanti.d.desc.SpecAntiConsDODesc;
import iih.ci.ord.specanti.d.SpecanticonsAggDO;
import iih.ci.ord.specanti.i.ISpecanticonsCudService;
import iih.ci.ord.specanti.i.ISpecanticonsRService;


/**
 * 特殊使用级抗菌药物会诊申请AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ISpecanticonsCudService.class,ISpecanticonsRService.class}, binding=Binding.JSONRPC)
public class SpecanticonsCrudServiceImpl extends BaseAggService<SpecanticonsAggDO,SpecAntiConsDO> implements ISpecanticonsCudService,ISpecanticonsRService {
    public SpecanticonsCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(SpecAntiConsDODesc.class),IAppFwTempTbl.tmp_iaw_11.name()); 
    }
}
