package iih.bd.srv.oth.s;
import iih.bd.srv.oth.d.MedSrvWordFreqDO;
import iih.bd.srv.oth.d.desc.MedSrvWordFreqDODesc;
import iih.bd.srv.oth.i.ISrvwordfreqstatisticCudService;
import iih.bd.srv.oth.i.ISrvwordfreqstatisticRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医疗服务词频统计AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ISrvwordfreqstatisticCudService.class,ISrvwordfreqstatisticRService.class}, binding=Binding.JSONRPC)
public class SrvwordfreqstatisticCrudServiceImpl extends BaseDOService<MedSrvWordFreqDO> implements ISrvwordfreqstatisticCudService,ISrvwordfreqstatisticRService {

    public SrvwordfreqstatisticCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MedSrvWordFreqDODesc.class),IAppFwTempTbl.tmp_iaw_17.name()); 
    }
}

