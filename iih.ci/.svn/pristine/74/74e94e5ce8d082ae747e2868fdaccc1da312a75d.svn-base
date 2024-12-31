package iih.ci.mr.mrsign.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mr.mrsign.d.desc.CiMrSignDODesc;
import iih.ci.mr.mrsign.d.CiMrSignDO;
import iih.ci.mr.mrsign.i.IMrsignMDOCudService;
import iih.ci.mr.mrsign.i.IMrsignMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 临床医疗记录签名主实体CRUD服务实现
 */
@Service(serviceInterfaces={IMrsignMDOCudService.class,IMrsignMDORService.class}, binding=Binding.JSONRPC)
public class MrsignMDOCrudServiceImpl extends BaseDOService<CiMrSignDO> implements IMrsignMDOCudService,IMrsignMDORService {

    public MrsignMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrSignDODesc.class),IAppFwTempTbl.tmp_iaw_29.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

