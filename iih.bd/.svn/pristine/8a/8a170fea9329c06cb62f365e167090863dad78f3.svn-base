package iih.bd.srv.srvortpl.s;
import iih.bd.srv.srvortpl.d.SrvOrdTplDO;
import iih.bd.srv.srvortpl.d.SrvortplAggDO;
import iih.bd.srv.srvortpl.d.desc.SrvOrdTplDODesc;
import iih.bd.srv.srvortpl.i.ISrvortplCudService;
import iih.bd.srv.srvortpl.i.ISrvortplRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医疗服务医嘱模板AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ISrvortplCudService.class,ISrvortplRService.class}, binding=Binding.JSONRPC)
public class SrvortplCrudServiceImpl extends BaseAggService<SrvortplAggDO,SrvOrdTplDO> implements ISrvortplCudService,ISrvortplRService {

    public SrvortplCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(SrvOrdTplDODesc.class),IAppFwTempTbl.tmp_iaw_23.name()); 
    }

	@Override
	public SrvortplAggDO[] findByAttrValString(String attr, String value)
			throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SrvortplAggDO[] findByAttrValStrings(String attr, String[] values)
			throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SrvortplAggDO[] findByAttrValList(String attr, FArrayList values)
			throws BizException {
		// TODO Auto-generated method stub
		return null;
	}
}

