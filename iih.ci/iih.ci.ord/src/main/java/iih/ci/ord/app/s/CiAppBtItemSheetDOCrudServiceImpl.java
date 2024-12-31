package iih.ci.ord.app.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.app.d.desc.CiAppBtItemSheetDODesc;
import iih.ci.ord.app.d.CiAppBtItemSheetDO;
import iih.ci.ord.app.i.ICiAppBtItemSheetDOCudService;
import iih.ci.ord.app.i.ICiAppBtItemSheetDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 备血打印申请单主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICiAppBtItemSheetDOCudService.class,ICiAppBtItemSheetDORService.class}, binding=Binding.JSONRPC)
public class CiAppBtItemSheetDOCrudServiceImpl extends BaseDOService<CiAppBtItemSheetDO> implements ICiAppBtItemSheetDOCudService,ICiAppBtItemSheetDORService {

    public CiAppBtItemSheetDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiAppBtItemSheetDODesc.class),IAppFwTempTbl.tmp_iaw_10.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

