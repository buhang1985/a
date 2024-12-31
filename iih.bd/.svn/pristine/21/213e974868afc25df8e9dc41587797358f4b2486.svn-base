package iih.bd.mm.meterial.s;
import iih.bd.mm.meterial.d.MMAliasDO;
import iih.bd.mm.meterial.d.desc.MMAliasDODesc;
import iih.bd.mm.meterial.i.IMMAliasDOCudService;
import iih.bd.mm.meterial.i.IMMAliasDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 医疗物品主实体CRUD服务实现
 */
@Service(serviceInterfaces={IMMAliasDOCudService.class,IMMAliasDORService.class}, binding=Binding.JSONRPC)
public class MMAliasDOCrudServiceImpl extends BaseDOService<MMAliasDO> implements IMMAliasDOCudService,IMMAliasDORService {

    public MMAliasDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MMAliasDODesc.class),IAppFwTempTbl.tmp_iaw_24.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

