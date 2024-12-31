package iih.ci.mrm.cimrfpdicatado.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.ci.mrm.cimrfpdicatado.d.CiMrFpDiCataDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.ci.mrm.cimrfpdicatado.d.desc.CiMrFpDiCataDODesc;
import iih.ci.mrm.cimrfpdicatado.d.CimrfpdicatadoAggDO;
import iih.ci.mrm.cimrfpdicatado.i.ICimrfpdicatadoCudService;
import iih.ci.mrm.cimrfpdicatado.i.ICimrfpdicatadoRService;


/**
 * 病案编目诊断AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICimrfpdicatadoCudService.class,ICimrfpdicatadoRService.class}, binding=Binding.JSONRPC)
public class CimrfpdicatadoCrudServiceImpl extends BaseAggService<CimrfpdicatadoAggDO,CiMrFpDiCataDO> implements ICimrfpdicatadoCudService,ICimrfpdicatadoRService {
    public CimrfpdicatadoCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrFpDiCataDODesc.class),IAppFwTempTbl.tmp_iaw_09.name()); 
    }
}
