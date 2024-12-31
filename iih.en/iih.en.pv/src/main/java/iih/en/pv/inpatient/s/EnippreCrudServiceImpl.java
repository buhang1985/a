package iih.en.pv.inpatient.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.en.pv.inpatient.d.desc.EnIppreDODesc;
import iih.en.pv.inpatient.d.EnIppreDO;
import iih.en.pv.inpatient.i.IEnippreCudService;
import iih.en.pv.inpatient.i.IEnippreRService;


/**
 * 预住院AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEnippreCudService.class,IEnippreRService.class}, binding=Binding.JSONRPC)
public class EnippreCrudServiceImpl extends BaseDOService<EnIppreDO> implements IEnippreCudService,IEnippreRService {
    public EnippreCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EnIppreDODesc.class),IAppFwTempTbl.tmp_iaw_16.name()); 
    }
}
