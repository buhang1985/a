package iih.ci.ord.ciaphvconsumables.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.ci.ord.ciaphvconsumables.d.CiApHvconsumblesDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.ci.ord.ciaphvconsumables.d.desc.CiApHvconsumblesDODesc;
import iih.ci.ord.ciaphvconsumables.d.CiaphvconsumablesAggDO;
import iih.ci.ord.ciaphvconsumables.i.ICiaphvconsumablesCudService;
import iih.ci.ord.ciaphvconsumables.i.ICiaphvconsumablesRService;


/**
 * 医嘱高值耗材申请 AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICiaphvconsumablesCudService.class,ICiaphvconsumablesRService.class}, binding=Binding.JSONRPC)
public class CiaphvconsumablesCrudServiceImpl extends BaseAggService<CiaphvconsumablesAggDO,CiApHvconsumblesDO> implements ICiaphvconsumablesCudService,ICiaphvconsumablesRService {
    public CiaphvconsumablesCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiApHvconsumblesDODesc.class),IAppFwTempTbl.tmp_iaw_21.name()); 
    }
}
