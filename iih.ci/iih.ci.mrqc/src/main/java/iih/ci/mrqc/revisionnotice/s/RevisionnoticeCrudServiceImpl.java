package iih.ci.mrqc.revisionnotice.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrqc.revisionnotice.d.desc.RevisionNoticeDODesc;
import iih.ci.mrqc.revisionnotice.d.RevisionNoticeDO;
import iih.ci.mrqc.revisionnotice.i.IRevisionnoticeCudService;
import iih.ci.mrqc.revisionnotice.i.IRevisionnoticeRService;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IRevisionnoticeCudService.class,IRevisionnoticeRService.class}, binding=Binding.JSONRPC)
public class RevisionnoticeCrudServiceImpl extends BaseDOService<RevisionNoticeDO> implements IRevisionnoticeCudService,IRevisionnoticeRService {
    public RevisionnoticeCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(RevisionNoticeDODesc.class),IAppFwTempTbl.tmp_iaw_27.name()); 
    }
}
