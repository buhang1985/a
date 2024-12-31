package iih.bl.inc.blincoeppaper.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.inc.blincoeppaper.d.desc.BlIncOepPaperDODesc;
import iih.bl.inc.blincoeppaper.d.BlIncOepPaperDO;
import iih.bl.inc.blincoeppaper.i.IBlincoeppaperCudService;
import iih.bl.inc.blincoeppaper.i.IBlincoeppaperRService;


/**
 * 门急诊纸质发票AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlincoeppaperCudService.class,IBlincoeppaperRService.class}, binding=Binding.JSONRPC)
public class BlincoeppaperCrudServiceImpl extends BaseDOService<BlIncOepPaperDO> implements IBlincoeppaperCudService,IBlincoeppaperRService {
    public BlincoeppaperCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlIncOepPaperDODesc.class),IAppFwTempTbl.tmp_iaw_03.name()); 
    }
}
