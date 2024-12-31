package iih.en.que.board.s;
import iih.en.que.board.d.EnBrdConfigDO;
import iih.en.que.board.d.desc.EnBrdConfigDODesc;
import iih.en.que.board.i.IEnBrdConfigDOCudService;
import iih.en.que.board.i.IEnBrdConfigDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 患者就诊_大屏主实体CRUD服务实现
 */
@Service(serviceInterfaces={IEnBrdConfigDOCudService.class,IEnBrdConfigDORService.class}, binding=Binding.JSONRPC)
public class EnBrdConfigDOCrudServiceImpl extends BaseDOService<EnBrdConfigDO> implements IEnBrdConfigDOCudService,IEnBrdConfigDORService {

    public EnBrdConfigDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EnBrdConfigDODesc.class),IAppFwTempTbl.tmp_iaw_03.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

