package iih.ci.mrm.cimrcataveruledo.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrm.cimrcataveruledo.d.desc.CiMrCataVeruleDoDesc;
import iih.ci.mrm.cimrcataveruledo.d.CiMrCataVeruleDo;
import iih.ci.mrm.cimrcataveruledo.i.ICimrcataveruledoCudService;
import iih.ci.mrm.cimrcataveruledo.i.ICimrcataveruledoRService;


/**
 * 编目核查规则AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICimrcataveruledoCudService.class,ICimrcataveruledoRService.class}, binding=Binding.JSONRPC)
public class CimrcataveruledoCrudServiceImpl extends BaseDOService<CiMrCataVeruleDo> implements ICimrcataveruledoCudService,ICimrcataveruledoRService {
    public CimrcataveruledoCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrCataVeruleDoDesc.class),IAppFwTempTbl.tmp_iaw_07.name()); 
    }
}
