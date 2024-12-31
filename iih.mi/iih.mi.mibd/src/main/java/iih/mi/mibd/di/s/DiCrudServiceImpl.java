package iih.mi.mibd.di.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.mi.mibd.di.d.desc.DiDODesc;
import iih.mi.mibd.di.d.DiDO;
import iih.mi.mibd.di.i.IDiCudService;
import iih.mi.mibd.di.i.IDiRService;


/**
 * 医保平台_病种AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IDiCudService.class,IDiRService.class}, binding=Binding.JSONRPC)
public class DiCrudServiceImpl extends BaseDOService<DiDO> implements IDiCudService,IDiRService {
    public DiCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(DiDODesc.class),IAppFwTempTbl.tmp_iaw_08.name()); 
    }
}
