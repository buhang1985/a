package iih.bd.res.bizgrp.s;
import iih.bd.res.bizgrp.d.BizgrpMasterDO;
import iih.bd.res.bizgrp.d.desc.BizgrpMasterDODesc;
import iih.bd.res.bizgrp.i.IBizgrpmasterCudService;
import iih.bd.res.bizgrp.i.IBizgrpmasterRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 业务组主表AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBizgrpmasterCudService.class,IBizgrpmasterRService.class}, binding=Binding.JSONRPC)
public class BizgrpmasterCrudServiceImpl extends BaseDOService<BizgrpMasterDO> implements IBizgrpmasterCudService,IBizgrpmasterRService {

    public BizgrpmasterCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BizgrpMasterDODesc.class),IAppFwTempTbl.tmp_iaw_08.name()); 
    }
}

