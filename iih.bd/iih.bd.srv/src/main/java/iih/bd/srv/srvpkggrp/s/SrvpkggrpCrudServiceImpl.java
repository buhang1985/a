package iih.bd.srv.srvpkggrp.s;
import iih.bd.srv.srvpkggrp.d.SrvPkgGrpDO;
import iih.bd.srv.srvpkggrp.d.desc.SrvPkgGrpDODesc;
import iih.bd.srv.srvpkggrp.i.ISrvpkggrpCudService;
import iih.bd.srv.srvpkggrp.i.ISrvpkggrpRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.TreeBaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 服务包项目分组AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ISrvpkggrpCudService.class,ISrvpkggrpRService.class}, binding=Binding.JSONRPC)
public class SrvpkggrpCrudServiceImpl extends TreeBaseDOService<SrvPkgGrpDO> implements ISrvpkggrpCudService,ISrvpkggrpRService {

    public SrvpkggrpCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(SrvPkgGrpDODesc.class),IAppFwTempTbl.tmp_iaw_09.name()); 
    }
}

