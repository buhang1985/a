package iih.bd.pp.prisrvsetfix.s;
import iih.bd.pp.prisrvsetfix.d.PriSrvSetFixDO;
import iih.bd.pp.prisrvsetfix.d.desc.PriSrvSetFixDODesc;
import iih.bd.pp.prisrvsetfix.i.IPrisrvsetfixCudService;
import iih.bd.pp.prisrvsetfix.i.IPrisrvsetfixRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 服务套成员数量定价AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IPrisrvsetfixCudService.class,IPrisrvsetfixRService.class}, binding=Binding.JSONRPC)
public class PrisrvsetfixCrudServiceImpl extends BaseDOService<PriSrvSetFixDO> implements IPrisrvsetfixCudService,IPrisrvsetfixRService {

    public PrisrvsetfixCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PriSrvSetFixDODesc.class),IAppFwTempTbl.tmp_iaw_06.name()); 
    }
}

