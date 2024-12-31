package iih.ci.mrm.mrmarchiveinfo.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrm.mrmarchiveinfo.d.desc.MrmArchiveInfoDODesc;
import iih.ci.mrm.mrmarchiveinfo.d.MrmArchiveInfoDO;
import iih.ci.mrm.mrmarchiveinfo.i.IMrmarchiveinfoCudService;
import iih.ci.mrm.mrmarchiveinfo.i.IMrmarchiveinfoRService;


/**
 * 病案归档信息AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMrmarchiveinfoCudService.class,IMrmarchiveinfoRService.class}, binding=Binding.JSONRPC)
public class MrmarchiveinfoCrudServiceImpl extends BaseDOService<MrmArchiveInfoDO> implements IMrmarchiveinfoCudService,IMrmarchiveinfoRService {
    public MrmarchiveinfoCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MrmArchiveInfoDODesc.class),IAppFwTempTbl.tmp_iaw_14.name()); 
    }
}
