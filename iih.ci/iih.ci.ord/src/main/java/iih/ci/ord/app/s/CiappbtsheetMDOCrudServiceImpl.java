package iih.ci.ord.app.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.app.d.desc.CiAppBtSheetDODesc;
import iih.ci.ord.app.d.CiAppBtSheetDO;
import iih.ci.ord.app.i.ICiappbtsheetMDOCudService;
import iih.ci.ord.app.i.ICiappbtsheetMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 备血打印申请单主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICiappbtsheetMDOCudService.class,ICiappbtsheetMDORService.class}, binding=Binding.JSONRPC)
public class CiappbtsheetMDOCrudServiceImpl extends BaseDOService<CiAppBtSheetDO> implements ICiappbtsheetMDOCudService,ICiappbtsheetMDORService {

    public CiappbtsheetMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiAppBtSheetDODesc.class),IAppFwTempTbl.tmp_iaw_07.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

