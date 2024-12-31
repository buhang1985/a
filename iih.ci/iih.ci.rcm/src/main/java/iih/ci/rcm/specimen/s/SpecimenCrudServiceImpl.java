package iih.ci.rcm.specimen.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.rcm.specimen.d.desc.SpecimenDODesc;
import iih.ci.rcm.specimen.d.SpecimenDO;
import iih.ci.rcm.specimen.i.ISpecimenCudService;
import iih.ci.rcm.specimen.i.ISpecimenRService;


/**
 * ICU病例监测_标本AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ISpecimenCudService.class,ISpecimenRService.class}, binding=Binding.JSONRPC)
public class SpecimenCrudServiceImpl extends BaseDOService<SpecimenDO> implements ISpecimenCudService,ISpecimenRService {
    public SpecimenCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(SpecimenDODesc.class),IAppFwTempTbl.tmp_iaw_28.name()); 
    }
}
