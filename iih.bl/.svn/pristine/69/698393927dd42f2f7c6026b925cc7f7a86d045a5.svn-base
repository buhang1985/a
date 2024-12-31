package iih.bl.hp.blputexrxpres.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.hp.blputexrxpres.d.desc.BlPutExRxPresDODesc;
import iih.bl.hp.blputexrxpres.d.BlPutExRxPresDO;
import iih.bl.hp.blputexrxpres.i.IBlputexrxpresCudService;
import iih.bl.hp.blputexrxpres.i.IBlputexrxpresRService;


/**
 * 外配处方上传记录AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlputexrxpresCudService.class,IBlputexrxpresRService.class}, binding=Binding.JSONRPC)
public class BlputexrxpresCrudServiceImpl extends BaseDOService<BlPutExRxPresDO> implements IBlputexrxpresCudService,IBlputexrxpresRService {
    public BlputexrxpresCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlPutExRxPresDODesc.class),IAppFwTempTbl.tmp_iaw_05.name()); 
    }
}
