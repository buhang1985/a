package iih.bd.srv.ortpl.s;
import iih.bd.srv.ortpl.d.OrTplDO;
import iih.bd.srv.ortpl.d.desc.OrTplDODesc;
import iih.bd.srv.ortpl.i.ISrvortplCudService;
import iih.bd.srv.ortpl.i.ISrvortplRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医嘱模板AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ISrvortplCudService.class,ISrvortplRService.class}, binding=Binding.JSONRPC)
public class SrvortplCrudServiceImpl extends BaseDOService<OrTplDO> implements ISrvortplCudService,ISrvortplRService {

    public SrvortplCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrTplDODesc.class),IAppFwTempTbl.tmp_iaw_19.name()); 
    }
}

