package iih.ci.mrqc.randomcheck.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrqc.randomcheck.d.desc.CiMrQcRandomRecordDODesc;
import iih.ci.mrqc.randomcheck.d.CiMrQcRandomRecordDO;
import iih.ci.mrqc.randomcheck.i.IMrqcrandomcheckMDOCudService;
import iih.ci.mrqc.randomcheck.i.IMrqcrandomcheckMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 门诊病历抽查主实体CRUD服务实现
 */
@Service(serviceInterfaces={IMrqcrandomcheckMDOCudService.class,IMrqcrandomcheckMDORService.class}, binding=Binding.JSONRPC)
public class MrqcrandomcheckMDOCrudServiceImpl extends BaseDOService<CiMrQcRandomRecordDO> implements IMrqcrandomcheckMDOCudService,IMrqcrandomcheckMDORService {

    public MrqcrandomcheckMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrQcRandomRecordDODesc.class),IAppFwTempTbl.tmp_iaw_28.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

