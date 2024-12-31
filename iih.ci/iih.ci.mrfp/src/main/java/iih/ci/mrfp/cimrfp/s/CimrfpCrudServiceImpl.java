package iih.ci.mrfp.cimrfp.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrfp.cimrfp.d.desc.CiMrFpDODesc;
import iih.ci.mrfp.cimrfp.d.CiMrFpDO;
import iih.ci.mrfp.cimrfp.i.ICimrfpCudService;
import iih.ci.mrfp.cimrfp.i.ICimrfpRService;


/**
 * 住院病案首页AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICimrfpCudService.class,ICimrfpRService.class}, binding=Binding.JSONRPC)
public class CimrfpCrudServiceImpl extends BaseDOService<CiMrFpDO> implements ICimrfpCudService,ICimrfpRService {
    public CimrfpCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrFpDODesc.class),IAppFwTempTbl.tmp_iaw_08.name()); 
    }
}
