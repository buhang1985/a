package iih.en.pv.enres.s;
import iih.en.pv.enres.d.EnPsnDO;
import iih.en.pv.enres.d.desc.EnPsnDODesc;
import iih.en.pv.enres.i.IEnpsnCudService;
import iih.en.pv.enres.i.IEnpsnRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 患者就诊_人员AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEnpsnCudService.class,IEnpsnRService.class}, binding=Binding.JSONRPC)
public class EnpsnCrudServiceImpl extends BaseDOService<EnPsnDO> implements IEnpsnCudService,IEnpsnRService {

    public EnpsnCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EnPsnDODesc.class),IAppFwTempTbl.tmp_iaw_29.name()); 
    }
}

