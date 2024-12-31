package iih.bd.srv.srvpkgca.s;
import iih.bd.srv.srvpkgca.d.SrvPkgCaDO;
import iih.bd.srv.srvpkgca.d.desc.SrvPkgCaDODesc;
import iih.bd.srv.srvpkgca.i.ISrvpkgcaCudService;
import iih.bd.srv.srvpkgca.i.ISrvpkgcaRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.TreeBaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医疗服务包分类AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ISrvpkgcaCudService.class,ISrvpkgcaRService.class}, binding=Binding.JSONRPC)
public class SrvpkgcaCrudServiceImpl extends TreeBaseDOService<SrvPkgCaDO> implements ISrvpkgcaCudService,ISrvpkgcaRService {

    public SrvpkgcaCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(SrvPkgCaDODesc.class),IAppFwTempTbl.tmp_iaw_10.name()); 
    }
}

