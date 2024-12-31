package iih.bl.cg.blrecgoep.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.cg.blrecgoep.d.desc.BlRecgOepDODesc;
import iih.bl.cg.blrecgoep.d.BlRecgOepDO;
import iih.bl.cg.blrecgoep.i.IBlrecgoepCudService;
import iih.bl.cg.blrecgoep.i.IBlrecgoepRService;


/**
 * 门急诊重划价AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlrecgoepCudService.class,IBlrecgoepRService.class}, binding=Binding.JSONRPC)
public class BlrecgoepCrudServiceImpl extends BaseDOService<BlRecgOepDO> implements IBlrecgoepCudService,IBlrecgoepRService {

    public BlrecgoepCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlRecgOepDODesc.class),IAppFwTempTbl.tmp_iaw_02.name()); 
    }
}

