package iih.bd.srv.bdmrsigntype.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bd.srv.bdmrsigntype.d.desc.BdMrLvlItmTitleDODesc;
import iih.bd.srv.bdmrsigntype.d.BdMrLvlItmTitleDO;
import iih.bd.srv.bdmrsigntype.i.IBdmrlvlitmtitleCudService;
import iih.bd.srv.bdmrsigntype.i.IBdmrlvlitmtitleRService;


/**
 * 病历审签层级明细对应职称AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBdmrlvlitmtitleCudService.class,IBdmrlvlitmtitleRService.class}, binding=Binding.JSONRPC)
public class BdmrlvlitmtitleCrudServiceImpl extends BaseDOService<BdMrLvlItmTitleDO> implements IBdmrlvlitmtitleCudService,IBdmrlvlitmtitleRService {
    public BdmrlvlitmtitleCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdMrLvlItmTitleDODesc.class),IAppFwTempTbl.tmp_iaw_18.name()); 
    }
}
