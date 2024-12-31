package iih.bl.hp.hptransactahip.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.bl.hp.hptransactahip.d.HpTransActAhIpDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.bl.hp.hptransactahip.d.desc.HpTransActAhIpDODesc;
import iih.bl.hp.hptransactahip.d.HptransactahipAggDO;
import iih.bl.hp.hptransactahip.i.IHptransactahipCudService;
import iih.bl.hp.hptransactahip.i.IHptransactahipRService;


/**
 * 安徽医保住院AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IHptransactahipCudService.class,IHptransactahipRService.class}, binding=Binding.JSONRPC)
public class HptransactahipCrudServiceImpl extends BaseAggService<HptransactahipAggDO,HpTransActAhIpDO> implements IHptransactahipCudService,IHptransactahipRService {
    public HptransactahipCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HpTransActAhIpDODesc.class),IAppFwTempTbl.tmp_iaw_08.name()); 
    }
}
