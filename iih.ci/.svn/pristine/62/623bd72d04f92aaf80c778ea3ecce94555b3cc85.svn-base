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
import iih.ci.ord.cons.d.desc.CiConsInviteDODesc;
import iih.ci.ord.cons.d.CiConsInviteDO;
import iih.ci.ord.cons.i.ICiConsInviteDOCudService;
import iih.ci.ord.cons.i.ICiConsInviteDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 会诊申请单主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICiConsInviteDOCudService.class,ICiConsInviteDORService.class}, binding=Binding.JSONRPC)
public class CiConsInviteDOCrudServiceImpl extends BaseDOService<CiConsInviteDO> implements ICiConsInviteDOCudService,ICiConsInviteDORService {

    public CiConsInviteDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiConsInviteDODesc.class),IAppFwTempTbl.tmp_iaw_11.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

