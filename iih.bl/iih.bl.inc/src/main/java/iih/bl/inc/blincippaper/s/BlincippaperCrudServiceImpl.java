package iih.bl.inc.blincippaper.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.inc.blincippaper.d.desc.BlIncIpPaperDODesc;
import iih.bl.inc.blincippaper.d.BlIncIpPaperDO;
import iih.bl.inc.blincippaper.i.IBlincippaperCudService;
import iih.bl.inc.blincippaper.i.IBlincippaperRService;


/**
 * 住院纸质发票AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlincippaperCudService.class,IBlincippaperRService.class}, binding=Binding.JSONRPC)
public class BlincippaperCrudServiceImpl extends BaseDOService<BlIncIpPaperDO> implements IBlincippaperCudService,IBlincippaperRService {
    public BlincippaperCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlIncIpPaperDODesc.class),IAppFwTempTbl.tmp_iaw_11.name()); 
    }
}
