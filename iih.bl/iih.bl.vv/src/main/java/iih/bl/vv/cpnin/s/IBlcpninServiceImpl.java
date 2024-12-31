package iih.bl.vv.cpnin.s;

import iih.bl.vv.cpn.d.BlCpnDO;
import iih.bl.vv.cpn.i.ICpnCudService;
import iih.bl.vv.cpnin.d.BlCpnInDO;
import iih.bl.vv.cpnin.i.IBlcpninService;
import iih.bl.vv.cpnin.i.ICpninCudService;
import iih.bl.vv.s.bp.BlcpninAddBp;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

public class IBlcpninServiceImpl implements IBlcpninService {

	/***
	 * 优惠券入库新增保存
	 * 
	 * @author houll
	 * @return
	 */
	@Override
	public FBoolean blcpninAdd(BlCpnInDO bi, int BlCpnAddCodeLen) throws BizException {
		if (bi == null) {
			return null;
		}
		
		bi.setId_org(Context.get().getOrgId());
		bi.setId_grp(Context.get().getGroupId());
		bi.setId_emp_entry(Context.get().getStuffId());
		bi.setDt_entry(new FDateTime());
		
		BlcpninAddBp saveBP = new BlcpninAddBp();

		BlCpnDO[] blCpnDOs = saveBP.exec(bi, BlCpnAddCodeLen);

		if (blCpnDOs == null) {
			return FBoolean.FALSE;
		}
		
		// BL_CPN_IN增加一条记录
		bi.setStatus(DOStatus.NEW);
		ICpninCudService cudService = ServiceFinder.find(ICpninCudService.class);
		cudService.save(new BlCpnInDO[] { bi });

		for (BlCpnDO blCpnDo : blCpnDOs) {
			blCpnDo.setCode_cpnin(bi.getCode_cpnin());
			blCpnDo.setId_cpnin(bi.getId_cpnin());
			blCpnDo.setStatus(DOStatus.NEW);
		}
		
		// bl_cpn增加一条记录
		ICpnCudService iCpnCudService = ServiceFinder.find(ICpnCudService.class);
		iCpnCudService.save(blCpnDOs);

		return FBoolean.TRUE;
	}

}
