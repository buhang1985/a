package iih.bd.srv.basemrtplfs.s;
import iih.bd.srv.basemrtplfs.d.BaseMrTplStreamDO;
import iih.bd.srv.basemrtplfs.d.desc.BaseMrTplStreamDODesc;
import iih.bd.srv.basemrtplfs.i.IBasemrtplfsCudService;
import iih.bd.srv.basemrtplfs.i.IBasemrtplfsRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医疗记录基础模板流数据AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBasemrtplfsCudService.class,IBasemrtplfsRService.class}, binding=Binding.JSONRPC)
public class BasemrtplfsCrudServiceImpl extends BaseDOService<BaseMrTplStreamDO> implements IBasemrtplfsCudService,IBasemrtplfsRService {

    public BasemrtplfsCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BaseMrTplStreamDODesc.class),IAppFwTempTbl.tmp_iaw_25.name()); 
    }
}

