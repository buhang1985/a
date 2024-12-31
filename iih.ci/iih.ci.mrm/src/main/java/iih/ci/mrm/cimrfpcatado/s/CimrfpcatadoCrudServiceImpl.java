package iih.ci.mrm.cimrfpcatado.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrm.cimrfpcatado.d.desc.CiMrFpCataDODesc;
import iih.ci.mrm.cimrfpcatado.d.CiMrFpCataDO;
import iih.ci.mrm.cimrfpcatado.i.ICimrfpcatadoCudService;
import iih.ci.mrm.cimrfpcatado.i.ICimrfpcatadoRService;


/**
 * 病案编目主表AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICimrfpcatadoCudService.class,ICimrfpcatadoRService.class}, binding=Binding.JSONRPC)
public class CimrfpcatadoCrudServiceImpl extends BaseDOService<CiMrFpCataDO> implements ICimrfpcatadoCudService,ICimrfpcatadoRService {
    public CimrfpcatadoCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrFpCataDODesc.class),IAppFwTempTbl.tmp_iaw_26.name()); 
    }
}
