package iih.ci.mrm.cimrfpothercatado.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.ci.mrm.cimrfpothercatado.d.CiMrFpOtherCataDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.ci.mrm.cimrfpothercatado.d.desc.CiMrFpOtherCataDODesc;
import iih.ci.mrm.cimrfpothercatado.d.CimrfpothercatadoAggDO;
import iih.ci.mrm.cimrfpothercatado.i.ICimrfpothercatadoCudService;
import iih.ci.mrm.cimrfpothercatado.i.ICimrfpothercatadoRService;


/**
 * 病案编目其他AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICimrfpothercatadoCudService.class,ICimrfpothercatadoRService.class}, binding=Binding.JSONRPC)
public class CimrfpothercatadoCrudServiceImpl extends BaseAggService<CimrfpothercatadoAggDO,CiMrFpOtherCataDO> implements ICimrfpothercatadoCudService,ICimrfpothercatadoRService {
    public CimrfpothercatadoCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrFpOtherCataDODesc.class),IAppFwTempTbl.tmp_iaw_22.name()); 
    }
}
