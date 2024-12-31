package iih.ci.mrfp.sug2mrfp.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrfp.sug2mrfp.d.desc.CiMrFpSugDODesc;
import iih.ci.mrfp.sug2mrfp.d.CiMrFpSugDO;
import iih.ci.mrfp.sug2mrfp.i.ISug2mrfpCudService;
import iih.ci.mrfp.sug2mrfp.i.ISug2mrfpRService;


/**
 * 住院病案首页_手术AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ISug2mrfpCudService.class,ISug2mrfpRService.class}, binding=Binding.JSONRPC)
public class Sug2mrfpCrudServiceImpl extends BaseDOService<CiMrFpSugDO> implements ISug2mrfpCudService,ISug2mrfpRService {
    public Sug2mrfpCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrFpSugDODesc.class),IAppFwTempTbl.tmp_iaw_05.name()); 
    }
}
