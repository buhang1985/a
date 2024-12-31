package iih.bd.srv.ortpl.s;
import iih.bd.srv.ortpl.d.OrTplItmDO;
import iih.bd.srv.ortpl.d.SrvortplitemAggDO;
import iih.bd.srv.ortpl.d.desc.OrTplItmDODesc;
import iih.bd.srv.ortpl.i.ISrvortplitemCudService;
import iih.bd.srv.ortpl.i.ISrvortplitemRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医嘱模板项目AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ISrvortplitemCudService.class,ISrvortplitemRService.class}, binding=Binding.JSONRPC)
public class SrvortplitemCrudServiceImpl extends BaseAggService<SrvortplitemAggDO,OrTplItmDO> implements ISrvortplitemCudService,ISrvortplitemRService {

    public SrvortplitemCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrTplItmDODesc.class),IAppFwTempTbl.tmp_iaw_17.name()); 
    }
}

