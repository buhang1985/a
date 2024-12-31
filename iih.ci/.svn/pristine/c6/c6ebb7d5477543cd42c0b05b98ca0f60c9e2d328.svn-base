package iih.ci.mrm.cimrmsupplement.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrm.cimrmsupplement.d.desc.CiMrmSupplementDODesc;
import iih.ci.mrm.cimrmsupplement.d.CiMrmSupplementDO;
import iih.ci.mrm.cimrmsupplement.i.ICimrmsupplementCudService;
import iih.ci.mrm.cimrmsupplement.i.ICimrmsupplementRService;


/**
 * 病案补充记录AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICimrmsupplementCudService.class,ICimrmsupplementRService.class}, binding=Binding.JSONRPC)
public class CimrmsupplementCrudServiceImpl extends BaseDOService<CiMrmSupplementDO> implements ICimrmsupplementCudService,ICimrmsupplementRService {
    public CimrmsupplementCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrmSupplementDODesc.class),IAppFwTempTbl.tmp_iaw_04.name()); 
    }
}
