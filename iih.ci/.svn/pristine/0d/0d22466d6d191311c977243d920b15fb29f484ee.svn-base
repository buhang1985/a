package iih.ci.mrm.cimrmmulmedfile.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrm.cimrmmulmedfile.d.desc.CiMrmMulMedFileDesc;
import iih.ci.mrm.cimrmmulmedfile.d.CiMrmMulMedFile;
import iih.ci.mrm.cimrmmulmedfile.i.ICimrmmulmedfileCudService;
import iih.ci.mrm.cimrmmulmedfile.i.ICimrmmulmedfileRService;


/**
 * 病案多媒体文件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICimrmmulmedfileCudService.class,ICimrmmulmedfileRService.class}, binding=Binding.JSONRPC)
public class CimrmmulmedfileCrudServiceImpl extends BaseDOService<CiMrmMulMedFile> implements ICimrmmulmedfileCudService,ICimrmmulmedfileRService {
    public CimrmmulmedfileCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrmMulMedFileDesc.class),IAppFwTempTbl.tmp_iaw_21.name()); 
    }
}
