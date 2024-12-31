package iih.bd.srv.mrarchivesrc.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bd.srv.mrarchivesrc.d.desc.MrArchiveSrcDODesc;
import iih.bd.srv.mrarchivesrc.d.MrArchiveSrcDO;
import iih.bd.srv.mrarchivesrc.i.IMrarchivesrcCudService;
import iih.bd.srv.mrarchivesrc.i.IMrarchivesrcRService;


/**
 * 病案归档来源AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMrarchivesrcCudService.class,IMrarchivesrcRService.class}, binding=Binding.JSONRPC)
public class MrarchivesrcCrudServiceImpl extends BaseDOService<MrArchiveSrcDO> implements IMrarchivesrcCudService,IMrarchivesrcRService {
    public MrarchivesrcCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MrArchiveSrcDODesc.class),IAppFwTempTbl.tmp_iaw_12.name()); 
    }
}
