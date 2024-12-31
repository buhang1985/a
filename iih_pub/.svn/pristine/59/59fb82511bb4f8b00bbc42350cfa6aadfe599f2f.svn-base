package iih.hr.hbd.psncont.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.hr.hbd.psncont.d.desc.HbdPsnContDODesc;
import iih.hr.hbd.psncont.d.HbdPsnContDO;
import iih.hr.hbd.psncont.i.IPsncontCudService;
import iih.hr.hbd.psncont.i.IPsncontRService;


/**
 * 人员合同AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IPsncontCudService.class,IPsncontRService.class}, binding=Binding.JSONRPC)
public class PsncontCrudServiceImpl extends BaseDOService<HbdPsnContDO> implements IPsncontCudService,IPsncontRService {
    public PsncontCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HbdPsnContDODesc.class),IAppFwTempTbl.tmp_iaw_07.name()); 
    }
}
