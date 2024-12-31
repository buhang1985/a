package iih.ei.itf.eiitfresultdo.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ei.itf.eiitfresultdo.d.desc.EiItfResultDODesc;
import iih.ei.itf.eiitfresultdo.d.EiItfResultDO;
import iih.ei.itf.eiitfresultdo.i.IEiitfresultdoCudService;
import iih.ei.itf.eiitfresultdo.i.IEiitfresultdoRService;


/**
 * 接口出参DOAggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEiitfresultdoCudService.class,IEiitfresultdoRService.class}, binding=Binding.JSONRPC)
public class EiitfresultdoCrudServiceImpl extends BaseDOService<EiItfResultDO> implements IEiitfresultdoCudService,IEiitfresultdoRService {
    public EiitfresultdoCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EiItfResultDODesc.class),IAppFwTempTbl.tmp_iaw_14.name()); 
    }
}
