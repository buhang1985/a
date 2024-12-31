package iih.bl.hp.hptransactip.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.hp.hptransactip.d.desc.HpTransactIpDODesc;
import iih.bl.hp.hptransactip.d.HpTransactIpDO;
import iih.bl.hp.hptransactip.i.IHptransactipCudService;
import iih.bl.hp.hptransactip.i.IHptransactipRService;


/**
 * 住院交易记录表AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IHptransactipCudService.class,IHptransactipRService.class}, binding=Binding.JSONRPC)
public class HptransactipCrudServiceImpl extends BaseDOService<HpTransactIpDO> implements IHptransactipCudService,IHptransactipRService {
    public HptransactipCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HpTransactIpDODesc.class),IAppFwTempTbl.tmp_iaw_07.name()); 
    }
}
