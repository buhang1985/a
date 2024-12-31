package iih.ci.mr.cimrafterchido.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.TreeBaseDOService;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mr.cimrafterchido.d.desc.CiMrAfterChiDODesc;
import iih.ci.mr.cimrafterchido.d.CiMrAfterChiDO;
import iih.ci.mr.cimrafterchido.i.ICimrafterchidoCudService;
import iih.ci.mr.cimrafterchido.i.ICimrafterchidoRService;


/**
 * 产程图AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICimrafterchidoCudService.class,ICimrafterchidoRService.class}, binding=Binding.JSONRPC)
public class CimrafterchidoCrudServiceImpl extends TreeBaseDOService<CiMrAfterChiDO> implements ICimrafterchidoCudService,ICimrafterchidoRService {
    public CimrafterchidoCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrAfterChiDODesc.class),IAppFwTempTbl.tmp_iaw_17.name()); 
    }
}
