package iih.ei.itf.eiitfparamdo.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ei.itf.eiitfparamdo.d.desc.EiItfParamDODesc;
import iih.ei.itf.eiitfparamdo.d.EiItfParamDO;
import iih.ei.itf.eiitfparamdo.i.IEiitfparamdoCudService;
import iih.ei.itf.eiitfparamdo.i.IEiitfparamdoRService;


/**
 * 接口入参DOAggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEiitfparamdoCudService.class,IEiitfparamdoRService.class}, binding=Binding.JSONRPC)
public class EiitfparamdoCrudServiceImpl extends BaseDOService<EiItfParamDO> implements IEiitfparamdoCudService,IEiitfparamdoRService {
    public EiitfparamdoCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EiItfParamDODesc.class),IAppFwTempTbl.tmp_iaw_09.name()); 
    }
}
