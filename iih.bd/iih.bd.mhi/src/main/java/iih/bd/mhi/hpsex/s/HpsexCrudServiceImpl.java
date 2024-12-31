package iih.bd.mhi.hpsex.s;
import iih.bd.mhi.hpsex.d.HpSexDO;
import iih.bd.mhi.hpsex.d.desc.HpSexDODesc;
import iih.bd.mhi.hpsex.i.IHpsexCudService;
import iih.bd.mhi.hpsex.i.IHpsexRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医保计划性别AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IHpsexCudService.class,IHpsexRService.class}, binding=Binding.JSONRPC)
public class HpsexCrudServiceImpl extends BaseDOService<HpSexDO> implements IHpsexCudService,IHpsexRService {
    public HpsexCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HpSexDODesc.class),IAppFwTempTbl.tmp_iaw_23.name()); 
    }
}
