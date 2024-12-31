package iih.ci.rcm.antibiot.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.rcm.antibiot.d.desc.AntibiotDODesc;
import iih.ci.rcm.antibiot.d.AntibiotDO;
import iih.ci.rcm.antibiot.i.IAntibiotCudService;
import iih.ci.rcm.antibiot.i.IAntibiotRService;


/**
 * 抗生素AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IAntibiotCudService.class,IAntibiotRService.class}, binding=Binding.JSONRPC)
public class AntibiotCrudServiceImpl extends BaseDOService<AntibiotDO> implements IAntibiotCudService,IAntibiotRService {
    public AntibiotCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(AntibiotDODesc.class),IAppFwTempTbl.tmp_iaw_19.name()); 
    }
}
