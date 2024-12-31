package iih.en.er.pre.s;
import iih.en.er.pre.d.EnErPreDO;
import iih.en.er.pre.d.desc.EnErPreDODesc;
import iih.en.er.pre.i.IEnerpreCudService;
import iih.en.er.pre.i.IEnerpreRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 急诊预检AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEnerpreCudService.class,IEnerpreRService.class}, binding=Binding.JSONRPC)
public class EnerpreCrudServiceImpl extends BaseDOService<EnErPreDO> implements IEnerpreCudService,IEnerpreRService {
    public EnerpreCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EnErPreDODesc.class),IAppFwTempTbl.tmp_iaw_28.name()); 
    }
}
