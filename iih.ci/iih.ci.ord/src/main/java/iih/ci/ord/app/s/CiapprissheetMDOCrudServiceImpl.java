package iih.ci.ord.app.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.app.d.desc.CiAppRisSheetDODesc;
import iih.ci.ord.app.d.CiAppRisSheetDO;
import iih.ci.ord.app.i.ICiapprissheetMDOCudService;
import iih.ci.ord.app.i.ICiapprissheetMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 检查打印申请单主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICiapprissheetMDOCudService.class,ICiapprissheetMDORService.class}, binding=Binding.JSONRPC)
public class CiapprissheetMDOCrudServiceImpl extends BaseDOService<CiAppRisSheetDO> implements ICiapprissheetMDOCudService,ICiapprissheetMDORService {

    public CiapprissheetMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiAppRisSheetDODesc.class),IAppFwTempTbl.tmp_iaw_22.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

