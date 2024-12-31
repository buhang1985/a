package iih.pi.reg.pattag.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.pi.reg.pattag.d.desc.PatTagDODesc;
import iih.pi.reg.pattag.d.PatTagDO;
import iih.pi.reg.pattag.i.IPattagCudService;
import iih.pi.reg.pattag.i.IPattagRService;


/**
 * 患者标签AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IPattagCudService.class,IPattagRService.class}, binding=Binding.JSONRPC)
public class PattagCrudServiceImpl extends BaseDOService<PatTagDO> implements IPattagCudService,IPattagRService {
    public PattagCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PatTagDODesc.class),IAppFwTempTbl.tmp_iaw_13.name()); 
    }
}
