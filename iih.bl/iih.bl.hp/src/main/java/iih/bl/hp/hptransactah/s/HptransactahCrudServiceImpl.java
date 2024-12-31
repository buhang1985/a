package iih.bl.hp.hptransactah.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.bl.hp.hptransactah.d.HpTransActAhDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.bl.hp.hptransactah.d.desc.HpTransActAhDODesc;
import iih.bl.hp.hptransactah.d.HptransactahAggDO;
import iih.bl.hp.hptransactah.i.IHptransactahCudService;
import iih.bl.hp.hptransactah.i.IHptransactahRService;


/**
 * 安徽医保交易记录AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IHptransactahCudService.class,IHptransactahRService.class}, binding=Binding.JSONRPC)
public class HptransactahCrudServiceImpl extends BaseAggService<HptransactahAggDO,HpTransActAhDO> implements IHptransactahCudService,IHptransactahRService {
    public HptransactahCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HpTransActAhDODesc.class),IAppFwTempTbl.tmp_iaw_28.name()); 
    }
}
