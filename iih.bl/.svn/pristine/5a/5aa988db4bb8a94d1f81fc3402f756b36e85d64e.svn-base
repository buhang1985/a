package iih.bl.hp.blinterfaceacttime.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.hp.blinterfaceacttime.d.desc.BlInterfaceActTimeDODesc;
import iih.bl.hp.blinterfaceacttime.d.BlInterfaceActTimeDO;
import iih.bl.hp.blinterfaceacttime.i.IBlinterfaceacttimeCudService;
import iih.bl.hp.blinterfaceacttime.i.IBlinterfaceacttimeRService;


/**
 * 接口业务时间AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlinterfaceacttimeCudService.class,IBlinterfaceacttimeRService.class}, binding=Binding.JSONRPC)
public class BlinterfaceacttimeCrudServiceImpl extends BaseDOService<BlInterfaceActTimeDO> implements IBlinterfaceacttimeCudService,IBlinterfaceacttimeRService {
    public BlinterfaceacttimeCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlInterfaceActTimeDODesc.class),IAppFwTempTbl.tmp_iaw_06.name()); 
    }
}
