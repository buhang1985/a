package iih.mi.mibd.srvfacdircomp.s;

import iih.mi.mibd.srvfacdircomp.d.SrvFacDirCompDO;
import iih.mi.mibd.srvfacdircomp.d.desc.SrvFacDirCompDODesc;
import iih.mi.mibd.srvfacdircomp.i.ISrvfacdircompCudService;
import iih.mi.mibd.srvfacdircomp.i.ISrvfacdircompRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;

/**
 * 医保平台_服务设施对照AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ISrvfacdircompCudService.class,ISrvfacdircompRService.class}, binding=Binding.JSONRPC)
public class SrvfacdircompCrudServiceImpl extends BaseDOService<SrvFacDirCompDO> implements ISrvfacdircompCudService,ISrvfacdircompRService {
    public SrvfacdircompCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(SrvFacDirCompDODesc.class),IAppFwTempTbl.tmp_iaw_23.name()); 
    }
}
