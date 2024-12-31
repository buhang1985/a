package iih.en.doc.pregdoc.s;
import iih.en.doc.pregdoc.d.PregDocDO;
import iih.en.doc.pregdoc.d.PregdocAggDO;
import iih.en.doc.pregdoc.d.desc.PregDocDODesc;
import iih.en.doc.pregdoc.i.IPregdocCudService;
import iih.en.doc.pregdoc.i.IPregdocRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 产科建档AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IPregdocCudService.class,IPregdocRService.class}, binding=Binding.JSONRPC)
public class PregdocCrudServiceImpl extends BaseAggService<PregdocAggDO,PregDocDO> implements IPregdocCudService,IPregdocRService {
    public PregdocCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PregDocDODesc.class),IAppFwTempTbl.tmp_iaw_01.name()); 
    }
}
