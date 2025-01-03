package iih.ci.mrqc.qared.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrqc.qared.d.desc.QaRecordDODesc;
import iih.ci.mrqc.qared.d.QaRecordDO;
import iih.ci.mrqc.qared.i.IQaCudService;
import iih.ci.mrqc.qared.i.IQaRService;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IQaCudService.class,IQaRService.class}, binding=Binding.JSONRPC)
public class QaCrudServiceImpl extends BaseDOService<QaRecordDO> implements IQaCudService,IQaRService {
    public QaCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(QaRecordDODesc.class),IAppFwTempTbl.tmp_iaw_19.name()); 
    }
}
