package iih.ci.mrm.cimrmfileinfo.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrm.cimrmfileinfo.d.desc.CiMrmFileInfoDODesc;
import iih.ci.mrm.cimrmfileinfo.d.CiMrmFileInfoDO;
import iih.ci.mrm.cimrmfileinfo.i.ICimrmfileinfoCudService;
import iih.ci.mrm.cimrmfileinfo.i.ICimrmfileinfoRService;


/**
 * 病案文件信息AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICimrmfileinfoCudService.class,ICimrmfileinfoRService.class}, binding=Binding.JSONRPC)
public class CimrmfileinfoCrudServiceImpl extends BaseDOService<CiMrmFileInfoDO> implements ICimrmfileinfoCudService,ICimrmfileinfoRService {
    public CimrmfileinfoCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrmFileInfoDODesc.class),IAppFwTempTbl.tmp_iaw_14.name()); 
    }
}
