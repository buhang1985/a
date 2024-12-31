package iih.bd.fc.queben.s;
import iih.bd.fc.queben.d.QueBenDO;
import iih.bd.fc.queben.d.desc.QueBenDODesc;
import iih.bd.fc.queben.i.IQuebenCudService;
import iih.bd.fc.queben.i.IQuebenRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;


/**
 * 队列工作台AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IQuebenCudService.class,IQuebenRService.class}, binding=Binding.JSONRPC)
public class QuebenCrudServiceImpl extends BaseDOService<QueBenDO> implements IQuebenCudService,IQuebenRService {

    public QuebenCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(QueBenDODesc.class),IAppFwTempTbl.tmp_iaw_05.name()); 
    }
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

