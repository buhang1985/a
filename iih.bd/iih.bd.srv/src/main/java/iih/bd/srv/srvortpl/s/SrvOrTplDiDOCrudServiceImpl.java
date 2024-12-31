package iih.bd.srv.srvortpl.s;
import iih.bd.srv.srvortpl.d.SrvOrTplDiDO;
import iih.bd.srv.srvortpl.d.desc.SrvOrTplDiDODesc;
import iih.bd.srv.srvortpl.i.ISrvOrTplDiDOCudService;
import iih.bd.srv.srvortpl.i.ISrvOrTplDiDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 医疗服务医嘱模板主实体CRUD服务实现
 */
@Service(serviceInterfaces={ISrvOrTplDiDOCudService.class,ISrvOrTplDiDORService.class}, binding=Binding.JSONRPC)
public class SrvOrTplDiDOCrudServiceImpl extends BaseDOService<SrvOrTplDiDO> implements ISrvOrTplDiDOCudService,ISrvOrTplDiDORService {

    public SrvOrTplDiDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(SrvOrTplDiDODesc.class),IAppFwTempTbl.tmp_iaw_07.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}

	@Override
	public SrvOrTplDiDO[] findByAttrValString(String attr, String value)
			throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SrvOrTplDiDO[] findByAttrValStrings(String attr, String[] values)
			throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SrvOrTplDiDO[] findByAttrValList(String attr, FArrayList values)
			throws BizException {
		// TODO Auto-generated method stub
		return null;
	}
}

