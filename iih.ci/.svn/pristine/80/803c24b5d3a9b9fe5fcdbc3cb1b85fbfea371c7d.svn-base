package iih.ci.ord.s.ems.ip.ems.apbt;

import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.ci.ord.ciordems.d.EmsBtItemDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.EmsCrtDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.i.meta.EmsSaveDTO;
import iih.ci.ord.s.ems.base.BaseEmsAction;
import iih.ci.ord.s.ems.itf.bp.IEmsCreateBP;
import iih.ci.ord.s.ems.itf.bp.IEmsLoadBP;
import iih.ci.ord.s.ems.itf.bp.IEmsSaveBP;
import xap.mw.core.data.BizException;

public class EmsApBtAction extends BaseEmsAction {
	public EmsApBtAction(IEmsCreateBP c, IEmsLoadBP l, IEmsSaveBP s) {
		super(c, l, s);
	}
	@Override
	public EmsRstDTO[] create(CiEnContextDTO ctx, EmsCrtDTO[] emsarray) throws BizException {
		EmsRstDTO[] rsts = super.create(ctx,emsarray);
		// 获取主服务信息
		MedsrvAggDO aggDO = getMedSrvInfo(emsarray[0].getId_srv());
		if (aggDO == null) {
			throw new BizException("查询主服务信息失败！");
		}
		// 合成主UI模型对象
		EmsBtItemDO emsModel = null;
		
		return rsts;
	}

	@Override
	public EmsRstDTO[] save(CiEnContextDTO ctx, EmsSaveDTO[] ems) throws BizException {
		// TODO Auto-generated method stub
		return super.save(ctx,ems);
	}

	
}
