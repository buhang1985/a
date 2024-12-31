package iih.ci.mrqc.cimrrecallrecord.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrqc.cimrrecallrecord.d.desc.CiMrRecallRecordDODesc;
import iih.ci.mrqc.cimrrecallrecord.d.CiMrRecallRecordDO;
import iih.ci.mrqc.cimrrecallrecord.i.ICimrrecallrecordCudService;
import iih.ci.mrqc.cimrrecallrecord.i.ICimrrecallrecordRService;


/**
 * 病历召回记录AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICimrrecallrecordCudService.class,ICimrrecallrecordRService.class}, binding=Binding.JSONRPC)
public class CimrrecallrecordCrudServiceImpl extends BaseDOService<CiMrRecallRecordDO> implements ICimrrecallrecordCudService,ICimrrecallrecordRService {
    public CimrrecallrecordCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrRecallRecordDODesc.class),IAppFwTempTbl.tmp_iaw_26.name()); 
    }
}
