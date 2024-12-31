package iih.ci.rcm.hosmiddle.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.rcm.hosmiddle.d.desc.HOSMIDDLEDODesc;
import iih.ci.rcm.hosmiddle.d.HOSMIDDLEDO;
import iih.ci.rcm.hosmiddle.i.IHosmiddleCudService;
import iih.ci.rcm.hosmiddle.i.IHosmiddleRService;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IHosmiddleCudService.class,IHosmiddleRService.class}, binding=Binding.JSONRPC)
public class HosmiddleCrudServiceImpl extends BaseDOService<HOSMIDDLEDO> implements IHosmiddleCudService,IHosmiddleRService {
    public HosmiddleCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HOSMIDDLEDODesc.class),IAppFwTempTbl.tmp_iaw_27.name()); 
    }
}
