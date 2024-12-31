package iih.ci.mrfp.othert2mrfp.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrfp.othert2mrfp.d.desc.CiMrFpOtherTDODesc;
import iih.ci.mrfp.othert2mrfp.d.CiMrFpOtherTDO;
import iih.ci.mrfp.othert2mrfp.i.IOthert2mrfpCudService;
import iih.ci.mrfp.othert2mrfp.i.IOthert2mrfpRService;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IOthert2mrfpCudService.class,IOthert2mrfpRService.class}, binding=Binding.JSONRPC)
public class Othert2mrfpCrudServiceImpl extends BaseDOService<CiMrFpOtherTDO> implements IOthert2mrfpCudService,IOthert2mrfpRService {
    public Othert2mrfpCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrFpOtherTDODesc.class),IAppFwTempTbl.tmp_iaw_23.name()); 
    }
}
