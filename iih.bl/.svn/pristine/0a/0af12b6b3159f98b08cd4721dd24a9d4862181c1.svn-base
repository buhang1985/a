package iih.bl.cg.bliptfin.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.cg.bliptfin.d.desc.BlCgIpTfInDODesc;
import iih.bl.cg.bliptfin.d.BlCgIpTfInDO;
import iih.bl.cg.bliptfin.i.IBliptfinCudService;
import iih.bl.cg.bliptfin.i.IBliptfinRService;


/**
 * 门诊转住院记账明细AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBliptfinCudService.class,IBliptfinRService.class}, binding=Binding.JSONRPC)
public class BliptfinCrudServiceImpl extends BaseDOService<BlCgIpTfInDO> implements IBliptfinCudService,IBliptfinRService {
    public BliptfinCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlCgIpTfInDODesc.class),IAppFwTempTbl.tmp_iaw_22.name()); 
    }
}
