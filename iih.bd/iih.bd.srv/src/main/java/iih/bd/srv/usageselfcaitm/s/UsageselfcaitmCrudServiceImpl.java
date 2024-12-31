package iih.bd.srv.usageselfcaitm.s;
import iih.bd.srv.usageselfcaitm.d.UsageSelfCaItemDO;
import iih.bd.srv.usageselfcaitm.d.UsageselfcaitmAggDO;
import iih.bd.srv.usageselfcaitm.d.desc.UsageSelfCaItemDODesc;
import iih.bd.srv.usageselfcaitm.i.IUsageselfcaitmCudService;
import iih.bd.srv.usageselfcaitm.i.IUsageselfcaitmRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 用法自定义分类项目AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IUsageselfcaitmCudService.class,IUsageselfcaitmRService.class}, binding=Binding.JSONRPC)
public class UsageselfcaitmCrudServiceImpl extends BaseAggService<UsageselfcaitmAggDO,UsageSelfCaItemDO> implements IUsageselfcaitmCudService,IUsageselfcaitmRService {

    public UsageselfcaitmCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(UsageSelfCaItemDODesc.class),IAppFwTempTbl.tmp_iaw_20.name()); 
    }
}

