package iih.ci.ord.app.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.app.d.desc.CiAppRisSheetOrDODesc;
import iih.ci.ord.app.d.CiAppRisSheetOrDO;
import iih.ci.ord.app.i.ICiAppRisSheetOrDOCudService;
import iih.ci.ord.app.i.ICiAppRisSheetOrDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 检查打印申请单主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICiAppRisSheetOrDOCudService.class,ICiAppRisSheetOrDORService.class}, binding=Binding.JSONRPC)
public class CiAppRisSheetOrDOCrudServiceImpl extends BaseDOService<CiAppRisSheetOrDO> implements ICiAppRisSheetOrDOCudService,ICiAppRisSheetOrDORService {

    public CiAppRisSheetOrDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiAppRisSheetOrDODesc.class),IAppFwTempTbl.tmp_iaw_15.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

