package iih.mi.biz.mitransrecord.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.mi.biz.mitransrecord.d.desc.MiTransRecordDODesc;
import iih.mi.biz.mitransrecord.d.MiTransRecordDO;
import iih.mi.biz.mitransrecord.i.IMitransrecordCudService;
import iih.mi.biz.mitransrecord.i.IMitransrecordRService;


/**
 * 医保交易记录AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMitransrecordCudService.class,IMitransrecordRService.class}, binding=Binding.JSONRPC)
public class MitransrecordCrudServiceImpl extends BaseDOService<MiTransRecordDO> implements IMitransrecordCudService,IMitransrecordRService {
    public MitransrecordCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MiTransRecordDODesc.class),IAppFwTempTbl.tmp_iaw_20.name()); 
    }
}
