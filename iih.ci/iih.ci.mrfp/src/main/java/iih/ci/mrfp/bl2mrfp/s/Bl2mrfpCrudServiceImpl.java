package iih.ci.mrfp.bl2mrfp.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrfp.bl2mrfp.d.desc.CiMrFpBlDODesc;
import iih.ci.mrfp.bl2mrfp.d.CiMrFpBlDO;
import iih.ci.mrfp.bl2mrfp.i.IBl2mrfpCudService;
import iih.ci.mrfp.bl2mrfp.i.IBl2mrfpRService;


/**
 * 住院病案首页_费用AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBl2mrfpCudService.class,IBl2mrfpRService.class}, binding=Binding.JSONRPC)
public class Bl2mrfpCrudServiceImpl extends BaseDOService<CiMrFpBlDO> implements IBl2mrfpCudService,IBl2mrfpRService {
    public Bl2mrfpCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrFpBlDODesc.class),IAppFwTempTbl.tmp_iaw_01.name()); 
    }
}
