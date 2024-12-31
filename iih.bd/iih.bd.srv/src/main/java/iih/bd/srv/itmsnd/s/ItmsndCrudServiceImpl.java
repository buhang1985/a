package iih.bd.srv.itmsnd.s;
import iih.bd.srv.itmsnd.d.ItmSndDO;
import iih.bd.srv.itmsnd.d.desc.ItmSndDODesc;
import iih.bd.srv.itmsnd.i.IItmsndCudService;
import iih.bd.srv.itmsnd.i.IItmsndRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 质控项目二级分类AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IItmsndCudService.class,IItmsndRService.class}, binding=Binding.JSONRPC)
public class ItmsndCrudServiceImpl extends BaseDOService<ItmSndDO> implements IItmsndCudService,IItmsndRService {
    public ItmsndCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ItmSndDODesc.class),IAppFwTempTbl.tmp_iaw_22.name()); 
    }
}
