package iih.sc.scbd.schedulesrv.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.sc.scbd.schedulesrv.d.ScSrvKindDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.sc.scbd.schedulesrv.d.desc.ScSrvKindDODesc;
import iih.sc.scbd.schedulesrv.d.ScsrvkinddoAggDO;
import iih.sc.scbd.schedulesrv.i.IScsrvkinddoCudService;
import iih.sc.scbd.schedulesrv.i.IScsrvkinddoRService;


/**
 * 排班服务类别AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IScsrvkinddoCudService.class,IScsrvkinddoRService.class}, binding=Binding.JSONRPC)
public class ScsrvkinddoCrudServiceImpl extends BaseAggService<ScsrvkinddoAggDO,ScSrvKindDO> implements IScsrvkinddoCudService,IScsrvkinddoRService {
    public ScsrvkinddoCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScSrvKindDODesc.class),IAppFwTempTbl.tmp_iaw_26.name()); 
    }
}
