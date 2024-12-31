package iih.ci.mrqc.cimrrecalladd.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrqc.cimrrecalladd.d.desc.CiMrRecallAddDODesc;
import iih.ci.mrqc.cimrrecalladd.d.CiMrRecallAddDO;
import iih.ci.mrqc.cimrrecalladd.i.ICimrrecalladdCudService;
import iih.ci.mrqc.cimrrecalladd.i.ICimrrecalladdRService;


/**
 * 病历召回新增AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICimrrecalladdCudService.class,ICimrrecalladdRService.class}, binding=Binding.JSONRPC)
public class CimrrecalladdCrudServiceImpl extends BaseDOService<CiMrRecallAddDO> implements ICimrrecalladdCudService,ICimrrecalladdRService {
    public CimrrecalladdCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrRecallAddDODesc.class),IAppFwTempTbl.tmp_iaw_05.name()); 
    }
}
