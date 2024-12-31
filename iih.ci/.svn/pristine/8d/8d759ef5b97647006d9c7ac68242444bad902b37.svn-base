package iih.ci.mrqc.cimrrecall.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrqc.cimrrecall.d.desc.CiMrRecallDODesc;
import iih.ci.mrqc.cimrrecall.d.CiMrRecallDO;
import iih.ci.mrqc.cimrrecall.i.ICimrrecallCudService;
import iih.ci.mrqc.cimrrecall.i.ICimrrecallRService;


/**
 * 病历召回申请AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICimrrecallCudService.class,ICimrrecallRService.class}, binding=Binding.JSONRPC)
public class CimrrecallCrudServiceImpl extends BaseDOService<CiMrRecallDO> implements ICimrrecallCudService,ICimrrecallRService {
    public CimrrecallCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrRecallDODesc.class),IAppFwTempTbl.tmp_iaw_17.name()); 
    }
}
