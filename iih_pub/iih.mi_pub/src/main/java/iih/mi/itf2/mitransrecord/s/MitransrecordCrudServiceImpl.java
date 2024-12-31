package iih.mi.itf2.mitransrecord.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.mi.itf2.mitransrecord.d.desc.MiTransRecordDesc;
import iih.mi.itf2.mitransrecord.d.MiTransRecord;
import iih.mi.itf2.mitransrecord.i.IMitransrecordCudService;
import iih.mi.itf2.mitransrecord.i.IMitransrecordRService;


/**
 * 医保交易记录AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMitransrecordCudService.class,IMitransrecordRService.class}, binding=Binding.JSONRPC)
public class MitransrecordCrudServiceImpl extends BaseDOService<MiTransRecord> implements IMitransrecordCudService,IMitransrecordRService {
    public MitransrecordCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MiTransRecordDesc.class),IAppFwTempTbl.tmp_iaw_25.name()); 
    }
}
