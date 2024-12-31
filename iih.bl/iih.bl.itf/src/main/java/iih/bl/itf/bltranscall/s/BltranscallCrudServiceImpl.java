package iih.bl.itf.bltranscall.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.itf.bltranscall.d.desc.BlTransCalledRcdDODesc;
import iih.bl.itf.bltranscall.d.BlTransCalledRcdDO;
import iih.bl.itf.bltranscall.i.IBltranscallCudService;
import iih.bl.itf.bltranscall.i.IBltranscallRService;


/**
 * 费用对外交易接口调用日志AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBltranscallCudService.class,IBltranscallRService.class}, binding=Binding.JSONRPC)
public class BltranscallCrudServiceImpl extends BaseDOService<BlTransCalledRcdDO> implements IBltranscallCudService,IBltranscallRService {
    public BltranscallCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlTransCalledRcdDODesc.class),IAppFwTempTbl.tmp_iaw_13.name()); 
    }
}
