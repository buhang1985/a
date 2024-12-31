package iih.mi.bd.miudidoccomp.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.mi.bd.miudidoccomp.d.desc.MiUdidocCompDODesc;
import iih.mi.bd.miudidoccomp.d.MiUdidocCompDO;
import iih.mi.bd.miudidoccomp.i.IMiudidoccompCudService;
import iih.mi.bd.miudidoccomp.i.IMiudidoccompRService;


/**
 * 医保基础编码对照AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMiudidoccompCudService.class,IMiudidoccompRService.class}, binding=Binding.JSONRPC)
public class MiudidoccompCrudServiceImpl extends BaseDOService<MiUdidocCompDO> implements IMiudidoccompCudService,IMiudidoccompRService {
    public MiudidoccompCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MiUdidocCompDODesc.class),IAppFwTempTbl.tmp_iaw_20.name()); 
    }
}
