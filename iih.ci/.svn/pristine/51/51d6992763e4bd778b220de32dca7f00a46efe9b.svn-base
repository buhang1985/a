package iih.ci.rcm.au.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.rcm.au.d.desc.AntibioticUseDODesc;
import iih.ci.rcm.au.d.AntibioticUseDO;
import iih.ci.rcm.au.i.IAntibioticusedoCudService;
import iih.ci.rcm.au.i.IAntibioticusedoRService;


/**
 * 抗菌用药AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IAntibioticusedoCudService.class,IAntibioticusedoRService.class}, binding=Binding.JSONRPC)
public class AntibioticusedoCrudServiceImpl extends BaseDOService<AntibioticUseDO> implements IAntibioticusedoCudService,IAntibioticusedoRService {
    public AntibioticusedoCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(AntibioticUseDODesc.class),IAppFwTempTbl.tmp_iaw_06.name()); 
    }
}
