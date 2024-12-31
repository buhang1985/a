package iih.en.pv.enres.s;
import iih.en.pv.enres.d.EnEvtDO;
import iih.en.pv.enres.d.desc.EnEvtDODesc;
import iih.en.pv.enres.i.IEnevtCudService;
import iih.en.pv.enres.i.IEnevtRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 就诊事件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEnevtCudService.class,IEnevtRService.class}, binding=Binding.JSONRPC)
public class EnevtCrudServiceImpl extends BaseDOService<EnEvtDO> implements IEnevtCudService,IEnevtRService {
    public EnevtCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EnEvtDODesc.class),IAppFwTempTbl.tmp_iaw_23.name()); 
    }
}
