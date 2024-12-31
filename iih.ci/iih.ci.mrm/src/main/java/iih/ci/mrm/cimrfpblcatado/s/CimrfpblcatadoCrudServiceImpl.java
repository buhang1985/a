package iih.ci.mrm.cimrfpblcatado.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrm.cimrfpblcatado.d.desc.CiMrFpBlCataDODesc;
import iih.ci.mrm.cimrfpblcatado.d.CiMrFpBlCataDO;
import iih.ci.mrm.cimrfpblcatado.i.ICimrfpblcatadoCudService;
import iih.ci.mrm.cimrfpblcatado.i.ICimrfpblcatadoRService;


/**
 * 病案编目费用AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICimrfpblcatadoCudService.class,ICimrfpblcatadoRService.class}, binding=Binding.JSONRPC)
public class CimrfpblcatadoCrudServiceImpl extends BaseDOService<CiMrFpBlCataDO> implements ICimrfpblcatadoCudService,ICimrfpblcatadoRService {
    public CimrfpblcatadoCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrFpBlCataDODesc.class),IAppFwTempTbl.tmp_iaw_07.name()); 
    }
}
