package iih.bd.srv.medsrv.s;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.desc.MedSrvDODesc;
import iih.bd.srv.medsrv.i.IMedsrvRServiceExt;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;

@Service(serviceInterfaces={IMedsrvRServiceExt.class}, binding=Binding.JSONRPC)
public class MedsrvRServiceExtImpl extends BaseDOService<MedSrvDO> implements IMedsrvRServiceExt{

	 public MedsrvRServiceExtImpl() {
	        super(DescManager.getInstance().getDODesc(MedSrvDODesc.class),IAppFwTempTbl.tmp_iaw_08.name()); 
	    }
	 
	 @Override
	 public MedSrvDO[] find(String whereStr,String orderStr,FBoolean isLazy) throws BizException{
		 return super.find(whereStr, orderStr, isLazy);
	 }
	 
	 @Override
	 public MedSrvDO[] update(MedSrvDO[] aggdos) throws BizException{
		 return super.update(aggdos);
	 }
}
