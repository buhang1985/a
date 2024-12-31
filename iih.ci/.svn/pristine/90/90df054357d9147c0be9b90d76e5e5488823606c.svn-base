package iih.ci.mrm.cimrmmulmedrecord.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrm.cimrmmulmedrecord.d.desc.CiMrmMulMedRecordDesc;
import iih.ci.mrm.cimrmmulmedrecord.d.CiMrmMulMedRecord;
import iih.ci.mrm.cimrmmulmedrecord.i.ICimrmmulmedrecordCudService;
import iih.ci.mrm.cimrmmulmedrecord.i.ICimrmmulmedrecordRService;


/**
 * 多媒体文件记录分类AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICimrmmulmedrecordCudService.class,ICimrmmulmedrecordRService.class}, binding=Binding.JSONRPC)
public class CimrmmulmedrecordCrudServiceImpl extends BaseDOService<CiMrmMulMedRecord> implements ICimrmmulmedrecordCudService,ICimrmmulmedrecordRService {
    public CimrmmulmedrecordCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrmMulMedRecordDesc.class),IAppFwTempTbl.tmp_iaw_04.name()); 
    }
}
