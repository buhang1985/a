package iih.sc.sch.scsch.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.sc.sch.scsch.d.desc.SchOcpResDODesc;
import iih.sc.sch.scsch.d.SchOcpResDO;
import iih.sc.sch.scsch.i.ISchocpresCudService;
import iih.sc.sch.scsch.i.ISchocpresRService;


/**
 * 排班资源占用AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ISchocpresCudService.class,ISchocpresRService.class}, binding=Binding.JSONRPC)
public class SchocpresCrudServiceImpl extends BaseDOService<SchOcpResDO> implements ISchocpresCudService,ISchocpresRService {
    public SchocpresCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(SchOcpResDODesc.class),IAppFwTempTbl.tmp_iaw_08.name()); 
    }
}
