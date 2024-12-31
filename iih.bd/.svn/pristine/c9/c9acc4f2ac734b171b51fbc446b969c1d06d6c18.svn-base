package iih.bd.srv.macrovaluedo.s;
import iih.bd.srv.macrovaluedo.d.MacroValueDo;
import iih.bd.srv.macrovaluedo.d.desc.MacroValueDoDesc;
import iih.bd.srv.macrovaluedo.i.IMacrovaluedoCudService;
import iih.bd.srv.macrovaluedo.i.IMacrovaluedoRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 宏元素自定义AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMacrovaluedoCudService.class,IMacrovaluedoRService.class}, binding=Binding.JSONRPC)
public class MacrovaluedoCrudServiceImpl extends BaseDOService<MacroValueDo> implements IMacrovaluedoCudService,IMacrovaluedoRService {
    public MacrovaluedoCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MacroValueDoDesc.class),IAppFwTempTbl.tmp_iaw_05.name()); 
    }
}
