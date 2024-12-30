package iih.sc.scbd.log.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.sc.scbd.log.d.desc.ScLogRecDODesc;
import iih.sc.scbd.log.d.ScLogRecDO;
import iih.sc.scbd.log.i.ISclogrecCudService;
import iih.sc.scbd.log.i.ISclogrecRService;


/**
 * 日志记录AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ISclogrecCudService.class,ISclogrecRService.class}, binding=Binding.JSONRPC)
public class SclogrecCrudServiceImpl extends BaseDOService<ScLogRecDO> implements ISclogrecCudService,ISclogrecRService {
    public SclogrecCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScLogRecDODesc.class),IAppFwTempTbl.tmp_iaw_13.name()); 
    }
}
