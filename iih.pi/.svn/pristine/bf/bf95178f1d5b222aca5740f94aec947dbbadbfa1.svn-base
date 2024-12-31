package iih.pi.reg.patbbr.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.pi.reg.patbbr.d.desc.PiPatBbrDODesc;
import iih.pi.reg.patbbr.d.PiPatBbrDO;
import iih.pi.reg.patbbr.i.IPatbbrCudService;
import iih.pi.reg.patbbr.i.IPatbbrRService;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IPatbbrCudService.class,IPatbbrRService.class}, binding=Binding.JSONRPC)
public class PatbbrCrudServiceImpl extends BaseDOService<PiPatBbrDO> implements IPatbbrCudService,IPatbbrRService {

    public PatbbrCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PiPatBbrDODesc.class),IAppFwTempTbl.tmp_iaw_19.name()); 
    }
}

