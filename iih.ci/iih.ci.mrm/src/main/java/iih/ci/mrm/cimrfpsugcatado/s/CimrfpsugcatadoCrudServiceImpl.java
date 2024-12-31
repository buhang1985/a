package iih.ci.mrm.cimrfpsugcatado.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import iih.ci.mrm.cimrfpsugcatado.d.desc.CiMrFpSugCataDODesc;
import iih.ci.mrm.cimrfpsugcatado.d.CiMrFpSugCataDO;
import iih.ci.mrm.cimrfpsugcatado.i.ICimrfpsugcatadoCudService;
import iih.ci.mrm.cimrfpsugcatado.i.ICimrfpsugcatadoRService;


/**
 * 病案编目手术AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICimrfpsugcatadoCudService.class,ICimrfpsugcatadoRService.class}, binding=Binding.JSONRPC)
public class CimrfpsugcatadoCrudServiceImpl extends BaseDOService<CiMrFpSugCataDO> implements ICimrfpsugcatadoCudService,ICimrfpsugcatadoRService {
    public CimrfpsugcatadoCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrFpSugCataDODesc.class),IAppFwTempTbl.tmp_iaw_23.name()); 
    }
}
