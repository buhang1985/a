package iih.bd.srv.srvortplgrp.s;
import iih.bd.srv.srvortplgrp.d.SrvOrTplGrpDO;
import iih.bd.srv.srvortplgrp.d.SrvortplgrpAggDO;
import iih.bd.srv.srvortplgrp.d.desc.SrvOrTplGrpDODesc;
import iih.bd.srv.srvortplgrp.i.ISrvortplgrpCudService;
import iih.bd.srv.srvortplgrp.i.ISrvortplgrpRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医疗服务_医嘱开立模板分组AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ISrvortplgrpCudService.class,ISrvortplgrpRService.class}, binding=Binding.JSONRPC)
public class SrvortplgrpCrudServiceImpl extends BaseAggService<SrvortplgrpAggDO,SrvOrTplGrpDO> implements ISrvortplgrpCudService,ISrvortplgrpRService {

    public SrvortplgrpCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(SrvOrTplGrpDODesc.class),IAppFwTempTbl.tmp_iaw_09.name()); 
    }
}

