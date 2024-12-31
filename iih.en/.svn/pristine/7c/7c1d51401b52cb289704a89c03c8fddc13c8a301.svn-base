package iih.en.pv.pativisit.s;
import iih.en.pv.pativisit.d.EnHpTransinDO;
import iih.en.pv.pativisit.d.desc.EnHpTransinDODesc;
import iih.en.pv.pativisit.i.IEnhptransinCudService;
import iih.en.pv.pativisit.i.IEnhptransinRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医保转诊转入记录单AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEnhptransinCudService.class,IEnhptransinRService.class}, binding=Binding.JSONRPC)
public class EnhptransinCrudServiceImpl extends BaseDOService<EnHpTransinDO> implements IEnhptransinCudService,IEnhptransinRService {
    public EnhptransinCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EnHpTransinDODesc.class),IAppFwTempTbl.tmp_iaw_14.name()); 
    }
}
