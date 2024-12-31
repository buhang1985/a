package iih.en.pv.pativisit.s;
import iih.en.pv.pativisit.d.EntContDO;
import iih.en.pv.pativisit.d.desc.EntContDODesc;
import iih.en.pv.pativisit.i.IEntcontCudService;
import iih.en.pv.pativisit.i.IEntcontRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 就诊联系人AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEntcontCudService.class,IEntcontRService.class}, binding=Binding.JSONRPC)
public class EntcontCrudServiceImpl extends BaseDOService<EntContDO> implements IEntcontCudService,IEntcontRService {

    public EntcontCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EntContDODesc.class),IAppFwTempTbl.tmp_iaw_26.name()); 
    }
}

