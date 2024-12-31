package iih.bd.mhi.hpdepdircomp.s;
import iih.bd.mhi.hpdepdircomp.d.HpDepDirCompDO;
import iih.bd.mhi.hpdepdircomp.d.desc.HpDepDirCompDODesc;
import iih.bd.mhi.hpdepdircomp.i.IHpdepdircompCudService;
import iih.bd.mhi.hpdepdircomp.i.IHpdepdircompRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医保产品_科别对照AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IHpdepdircompCudService.class,IHpdepdircompRService.class}, binding=Binding.JSONRPC)
public class HpdepdircompCrudServiceImpl extends BaseDOService<HpDepDirCompDO> implements IHpdepdircompCudService,IHpdepdircompRService {
    public HpdepdircompCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HpDepDirCompDODesc.class),IAppFwTempTbl.tmp_iaw_09.name()); 
    }
}
