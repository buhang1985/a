package iih.en.que.board.s;
import iih.en.que.board.d.EnBrdDO;
import iih.en.que.board.d.desc.EnBrdDODesc;
import iih.en.que.board.i.IEnbrddoMDOCudService;
import iih.en.que.board.i.IEnbrddoMDORService;
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
@Service(serviceInterfaces={IEnbrddoMDOCudService.class,IEnbrddoMDORService.class}, binding=Binding.JSONRPC)
public class EnbrddoMDOCrudServiceImpl extends BaseDOService<EnBrdDO> implements IEnbrddoMDOCudService,IEnbrddoMDORService {

    public EnbrddoMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EnBrdDODesc.class),IAppFwTempTbl.tmp_iaw_27.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}
