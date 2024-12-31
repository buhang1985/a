package iih.en.pv.enres.s;
import iih.en.pv.enres.d.EnPlcDO;
import iih.en.pv.enres.d.desc.EnPlcDODesc;
import iih.en.pv.enres.i.IEnplcCudService;
import iih.en.pv.enres.i.IEnplcRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 患者就诊_地点AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEnplcCudService.class,IEnplcRService.class}, binding=Binding.JSONRPC)
public class EnplcCrudServiceImpl extends BaseDOService<EnPlcDO> implements IEnplcCudService,IEnplcRService {

    public EnplcCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EnPlcDODesc.class),IAppFwTempTbl.tmp_iaw_21.name()); 
    }
}

