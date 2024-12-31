package iih.mi.biz.mihporsharelog.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.mi.biz.mihporsharelog.d.desc.MiHpOrShareLogDODesc;
import iih.mi.biz.mihporsharelog.d.MiHpOrShareLogDO;
import iih.mi.biz.mihporsharelog.i.IMihporsharelogCudService;
import iih.mi.biz.mihporsharelog.i.IMihporsharelogRService;


/**
 * 医保共享信息AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMihporsharelogCudService.class,IMihporsharelogRService.class}, binding=Binding.JSONRPC)
public class MihporsharelogCrudServiceImpl extends BaseDOService<MiHpOrShareLogDO> implements IMihporsharelogCudService,IMihporsharelogRService {
    public MihporsharelogCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MiHpOrShareLogDODesc.class),IAppFwTempTbl.tmp_iaw_10.name()); 
    }
}
