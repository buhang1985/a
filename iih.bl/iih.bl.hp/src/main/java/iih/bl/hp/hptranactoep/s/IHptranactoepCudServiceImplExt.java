package iih.bl.hp.hptranactoep.s;

import iih.bl.hp.hptranactoep.d.HpTransactOepDO;
import iih.bl.hp.hptranactoep.d.desc.HpTransactOepDODesc;
import iih.bl.hp.hptranactoep.i.IHptranactoepCudService;
import iih.bl.hp.hptranactoep.i.IHptranactoepCudServiceExt;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;

public class IHptranactoepCudServiceImplExt extends BaseDOService<HpTransactOepDO> implements IHptranactoepCudServiceExt{

	 public IHptranactoepCudServiceImplExt() {
	        super(DescManager.getInstance().getDODesc(HpTransactOepDODesc.class),IAppFwTempTbl.tmp_iaw_10.name()); 
	    }

	@Override
	public HpTransactOepDO backFeeSaveHpTradeInfo(HpTransactOepDO[] dos) throws BizException {
		
		IHptranactoepCudService rs=ServiceFinder.find(IHptranactoepCudService.class);
		
		HpTransactOepDO[] ret=rs.save(dos);
		
		if(ret.length>0)
			return ret[0];
		
		return null;
	}
	
}
