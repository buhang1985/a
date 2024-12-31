package iih.bd.srv.srvortplitem.s;
import iih.bd.srv.srvortplitem.d.SrvOrTplItemDO;
import iih.bd.srv.srvortplitem.d.desc.SrvOrTplItemDODesc;
import iih.bd.srv.srvortplitem.i.ISrvortplitemCudService;
import iih.bd.srv.srvortplitem.i.ISrvortplitemRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医疗服务_医嘱模板项目AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ISrvortplitemCudService.class,ISrvortplitemRService.class}, binding=Binding.JSONRPC)
public class SrvortplitemCrudServiceImpl extends BaseDOService<SrvOrTplItemDO> implements ISrvortplitemCudService,ISrvortplitemRService {

    public SrvortplitemCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(SrvOrTplItemDODesc.class),IAppFwTempTbl.tmp_iaw_19.name()); 
    }

	@Override
	public SrvOrTplItemDO[] findByAttrValString(String attr, String value)
			throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SrvOrTplItemDO[] findByAttrValStrings(String attr, String[] values)
			throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SrvOrTplItemDO[] findByAttrValList(String attr, FArrayList values)
			throws BizException {
		// TODO Auto-generated method stub
		return null;
	}
}

