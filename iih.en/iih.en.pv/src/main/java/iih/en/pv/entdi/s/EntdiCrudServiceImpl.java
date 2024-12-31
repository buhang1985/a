package iih.en.pv.entdi.s;
import iih.en.pv.entdi.d.EntDiDO;
import iih.en.pv.entdi.d.desc.EntDiDODesc;
import iih.en.pv.entdi.i.IEntdiCudService;
import iih.en.pv.entdi.i.IEntdiRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 就诊临床诊断AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEntdiCudService.class,IEntdiRService.class}, binding=Binding.JSONRPC)
public class EntdiCrudServiceImpl extends BaseDOService<EntDiDO> implements IEntdiCudService,IEntdiRService {
    public EntdiCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EntDiDODesc.class),IAppFwTempTbl.tmp_iaw_15.name()); 
    }
}
