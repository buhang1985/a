package iih.ci.mrm.cimrfpothertcatado.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrm.cimrfpothertcatado.d.desc.CiMrFpOthertCataDODesc;
import iih.ci.mrm.cimrfpothertcatado.d.CiMrFpOthertCataDO;
import iih.ci.mrm.cimrfpothertcatado.i.ICimrfpothertcatadoCudService;
import iih.ci.mrm.cimrfpothertcatado.i.ICimrfpothertcatadoRService;


/**
 * 病案编目附页AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICimrfpothertcatadoCudService.class,ICimrfpothertcatadoRService.class}, binding=Binding.JSONRPC)
public class CimrfpothertcatadoCrudServiceImpl extends BaseDOService<CiMrFpOthertCataDO> implements ICimrfpothertcatadoCudService,ICimrfpothertcatadoRService {
    public CimrfpothertcatadoCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrFpOthertCataDODesc.class),IAppFwTempTbl.tmp_iaw_05.name()); 
    }
}
