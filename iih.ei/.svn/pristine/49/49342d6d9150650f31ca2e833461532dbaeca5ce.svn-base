package iih.ei.hwi.eihwiregdo.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ei.hwi.eihwiregdo.d.desc.EiHwiRegDODesc;
import iih.ei.hwi.eihwiregdo.d.EiHwiRegDO;
import iih.ei.hwi.eihwiregdo.i.IEihwiregdoCudService;
import iih.ei.hwi.eihwiregdo.i.IEihwiregdoRService;


/**
 * EiHwiRegDOAggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEihwiregdoCudService.class,IEihwiregdoRService.class}, binding=Binding.JSONRPC)
public class EihwiregdoCrudServiceImpl extends BaseDOService<EiHwiRegDO> implements IEihwiregdoCudService,IEihwiregdoRService {
    public EihwiregdoCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EiHwiRegDODesc.class),IAppFwTempTbl.tmp_iaw_13.name()); 
    }
}
