package iih.ci.mrqc.qaflt.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrqc.qaflt.d.desc.QaFltDODesc;
import iih.ci.mrqc.qaflt.d.QaFltDO;
import iih.ci.mrqc.qaflt.i.IQafltCudService;
import iih.ci.mrqc.qaflt.i.IQafltRService;


/**
 * 质控缺陷AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IQafltCudService.class,IQafltRService.class}, binding=Binding.JSONRPC)
public class QafltCrudServiceImpl extends BaseDOService<QaFltDO> implements IQafltCudService,IQafltRService {
    public QafltCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(QaFltDODesc.class),IAppFwTempTbl.tmp_iaw_18.name()); 
    }
}
