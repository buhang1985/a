package iih.bd.srv.ortpl.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.bd.srv.ortpl.d.OrTmplDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.bd.srv.ortpl.d.desc.OrTmplDODesc;
import iih.bd.srv.ortpl.d.OrtmplAggDO;
import iih.bd.srv.ortpl.i.IOrtmplCudService;
import iih.bd.srv.ortpl.i.IOrtmplRService;


/**
 * 医嘱模板AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IOrtmplCudService.class,IOrtmplRService.class}, binding=Binding.JSONRPC)
public class OrtmplCrudServiceImpl extends BaseAggService<OrtmplAggDO,OrTmplDO> implements IOrtmplCudService,IOrtmplRService {
    public OrtmplCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrTmplDODesc.class),IAppFwTempTbl.tmp_iaw_16.name()); 
    }
}
