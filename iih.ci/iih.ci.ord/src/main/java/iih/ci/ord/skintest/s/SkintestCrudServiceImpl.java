package iih.ci.ord.skintest.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.skintest.d.desc.CiSkinTestRstDODesc;
import iih.ci.ord.skintest.d.CiSkinTestRstDO;
import iih.ci.ord.skintest.i.ISkintestCudService;
import iih.ci.ord.skintest.i.ISkintestRService;


/**
 * 皮试结果记录AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ISkintestCudService.class,ISkintestRService.class}, binding=Binding.JSONRPC)
public class SkintestCrudServiceImpl extends BaseDOService<CiSkinTestRstDO> implements ISkintestCudService,ISkintestRService {
    public SkintestCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiSkinTestRstDODesc.class),IAppFwTempTbl.tmp_iaw_11.name()); 
    }
}
