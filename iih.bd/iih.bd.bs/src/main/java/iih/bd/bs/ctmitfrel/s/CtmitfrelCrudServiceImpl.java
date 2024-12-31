package iih.bd.bs.ctmitfrel.s;
import iih.bd.bs.ctmitfrel.d.CtmItfRelDO;
import iih.bd.bs.ctmitfrel.d.desc.CtmItfRelDODesc;
import iih.bd.bs.ctmitfrel.i.ICtmitfrelCudService;
import iih.bd.bs.ctmitfrel.i.ICtmitfrelRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 客开接口实现关系AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICtmitfrelCudService.class,ICtmitfrelRService.class}, binding=Binding.JSONRPC)
public class CtmitfrelCrudServiceImpl extends BaseDOService<CtmItfRelDO> implements ICtmitfrelCudService,ICtmitfrelRService {
    public CtmitfrelCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CtmItfRelDODesc.class),IAppFwTempTbl.tmp_iaw_06.name()); 
    }
}
