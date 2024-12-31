package iih.bl.hp.hprecon.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.hp.hprecon.d.desc.BlHpReconciliationDODesc;
import iih.bl.hp.hprecon.d.BlHpReconciliationDO;
import iih.bl.hp.hprecon.i.IHpreconCudService;
import iih.bl.hp.hprecon.i.IHpreconRService;


/**
 * 医保对账下载数据AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IHpreconCudService.class,IHpreconRService.class}, binding=Binding.JSONRPC)
public class HpreconCrudServiceImpl extends BaseDOService<BlHpReconciliationDO> implements IHpreconCudService,IHpreconRService {
    public HpreconCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlHpReconciliationDODesc.class),IAppFwTempTbl.tmp_iaw_12.name()); 
    }
}
