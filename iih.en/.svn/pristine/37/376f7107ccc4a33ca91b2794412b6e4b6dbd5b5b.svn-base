package iih.en.er.ip.s;
import iih.en.er.ip.d.EnEntIpErDO;
import iih.en.er.ip.d.desc.EnEntIpErDODesc;
import iih.en.er.ip.i.IEnentiperCudService;
import iih.en.er.ip.i.IEnentiperRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 急诊就诊_住院急诊AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEnentiperCudService.class,IEnentiperRService.class}, binding=Binding.JSONRPC)
public class EnentiperCrudServiceImpl extends BaseDOService<EnEntIpErDO> implements IEnentiperCudService,IEnentiperRService {
    public EnentiperCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EnEntIpErDODesc.class),IAppFwTempTbl.tmp_iaw_18.name()); 
    }
}
