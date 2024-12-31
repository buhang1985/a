package iih.ci.mrm.cimrfppatcatado.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrm.cimrfppatcatado.d.desc.CiMrFpPatCataDODesc;
import iih.ci.mrm.cimrfppatcatado.d.CiMrFpPatCataDO;
import iih.ci.mrm.cimrfppatcatado.i.ICimrfppatcatadoCudService;
import iih.ci.mrm.cimrfppatcatado.i.ICimrfppatcatadoRService;


/**
 * 病案编目患者信息AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICimrfppatcatadoCudService.class,ICimrfppatcatadoRService.class}, binding=Binding.JSONRPC)
public class CimrfppatcatadoCrudServiceImpl extends BaseDOService<CiMrFpPatCataDO> implements ICimrfppatcatadoCudService,ICimrfppatcatadoRService {
    public CimrfppatcatadoCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrFpPatCataDODesc.class),IAppFwTempTbl.tmp_iaw_23.name()); 
    }
}
