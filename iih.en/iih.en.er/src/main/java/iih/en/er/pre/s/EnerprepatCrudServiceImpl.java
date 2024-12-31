package iih.en.er.pre.s;
import iih.en.er.pre.d.EnErPrePatDO;
import iih.en.er.pre.d.desc.EnErPrePatDODesc;
import iih.en.er.pre.i.IEnerprepatCudService;
import iih.en.er.pre.i.IEnerprepatRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 急诊预检_患者信息AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEnerprepatCudService.class,IEnerprepatRService.class}, binding=Binding.JSONRPC)
public class EnerprepatCrudServiceImpl extends BaseDOService<EnErPrePatDO> implements IEnerprepatCudService,IEnerprepatRService {
    public EnerprepatCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EnErPrePatDODesc.class),IAppFwTempTbl.tmp_iaw_20.name()); 
    }
}
