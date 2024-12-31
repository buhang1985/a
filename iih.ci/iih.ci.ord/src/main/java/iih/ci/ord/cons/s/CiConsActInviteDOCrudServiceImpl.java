package iih.ci.ord.cons.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.SqlParamDTO;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.cons.d.desc.CiConsActInviteDODesc;
import iih.ci.ord.cons.d.CiConsActInviteDO;
import iih.ci.ord.cons.i.ICiConsActInviteDOCudService;
import iih.ci.ord.cons.i.ICiConsActInviteDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 会诊申请单主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICiConsActInviteDOCudService.class,ICiConsActInviteDORService.class}, binding=Binding.JSONRPC)
public class CiConsActInviteDOCrudServiceImpl extends BaseDOService<CiConsActInviteDO> implements ICiConsActInviteDOCudService,ICiConsActInviteDORService {

    public CiConsActInviteDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiConsActInviteDODesc.class),IAppFwTempTbl.tmp_iaw_06.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

