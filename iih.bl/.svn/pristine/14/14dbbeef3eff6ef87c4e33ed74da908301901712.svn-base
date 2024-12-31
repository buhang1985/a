package iih.bl.cg.blrecgoepdto.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.cg.blrecgoepdto.d.desc.BlRecgOepDTODesc;
import iih.bl.cg.blrecgoepdto.d.BlRecgOepDTO;
import iih.bl.cg.blrecgoepdto.i.IBlrecgoepdtoCudService;
import iih.bl.cg.blrecgoepdto.i.IBlrecgoepdtoRService;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlrecgoepdtoCudService.class,IBlrecgoepdtoRService.class}, binding=Binding.JSONRPC)
public class BlrecgoepdtoCrudServiceImpl extends BaseDOService<BlRecgOepDTO> implements IBlrecgoepdtoCudService,IBlrecgoepdtoRService {

    public BlrecgoepdtoCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlRecgOepDTODesc.class),IAppFwTempTbl.tmp_iaw_19.name()); 
    }
}

