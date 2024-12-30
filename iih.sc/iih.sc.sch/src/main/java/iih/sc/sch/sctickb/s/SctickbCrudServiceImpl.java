package iih.sc.sch.sctickb.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.sc.sch.sctickb.d.desc.ScSchTickBDODesc;
import iih.sc.sch.sctickb.d.ScSchTickBDO;
import iih.sc.sch.sctickb.i.ISctickbCudService;
import iih.sc.sch.sctickb.i.ISctickbRService;


/**
 * 计划排班_号位BAggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ISctickbCudService.class,ISctickbRService.class}, binding=Binding.JSONRPC)
public class SctickbCrudServiceImpl extends BaseDOService<ScSchTickBDO> implements ISctickbCudService,ISctickbRService {
    public SctickbCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScSchTickBDODesc.class),IAppFwTempTbl.tmp_iaw_27.name()); 
    }
}
