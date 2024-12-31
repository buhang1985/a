package iih.bd.srv.srvortpl.s;
import iih.bd.srv.srvortpl.d.SrvOrdTplDO;
import iih.bd.srv.srvortpl.d.desc.SrvOrdTplDODesc;
import iih.bd.srv.srvortpl.i.ISrvortplMDOCudService;
import iih.bd.srv.srvortpl.i.ISrvortplMDORService;
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
@Service(serviceInterfaces={ISrvortplMDOCudService.class,ISrvortplMDORService.class}, binding=Binding.JSONRPC)
public class SrvortplMDOCrudServiceImpl extends BaseDOService<SrvOrdTplDO> implements ISrvortplMDOCudService,ISrvortplMDORService {

    public SrvortplMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(SrvOrdTplDODesc.class),IAppFwTempTbl.tmp_iaw_02.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}

	@Override
	public SrvOrdTplDO[] findByAttrValString(String attr, String value)
			throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SrvOrdTplDO[] findByAttrValStrings(String attr, String[] values)
			throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SrvOrdTplDO[] findByAttrValList(String attr, FArrayList values)
			throws BizException {
		// TODO Auto-generated method stub
		return null;
	}
}

