package iih.pi.acc.account.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.pi.acc.account.d.desc.PiPatAccDODesc;
import iih.pi.acc.account.d.PiPatAccDO;
import iih.pi.acc.account.i.IAccountMDOCudService;
import iih.pi.acc.account.i.IAccountMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 患者账户AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IAccountMDOCudService.class,IAccountMDORService.class}, binding=Binding.JSONRPC)
public class AccountMDOCrudServiceImpl extends BaseDOService<PiPatAccDO> implements IAccountMDOCudService,IAccountMDORService {

    public AccountMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PiPatAccDODesc.class),IAppFwTempTbl.tmp_iaw_28.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

