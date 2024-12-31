package iih.ci.sdk.driver;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.EmsCrtDTO;
import iih.ci.ord.i.meta.EmsLoadDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.i.meta.EmsSaveDTO;
import iih.ci.sdk.ems.itf.IEmsAction;
import xap.mw.core.data.BizException;


public class BaseEmsDriver implements IEmsAction{

	private IEmsAction emsAction = null;

	public IEmsAction getEmsAction() {
		return emsAction;
	}

	public void setEmsAction(IEmsAction emsAction) {
		this.emsAction = emsAction;
	}

	@Override
	public EmsRstDTO[] load(CiEnContextDTO ctx, EmsLoadDTO[] args) throws BizException {
		// TODO Auto-generated method stub
		return emsAction.load(ctx, args);
	}

	@Override
	public EmsRstDTO[] create(CiEnContextDTO ctx, EmsCrtDTO[] emsarray) throws BizException {
		// TODO Auto-generated method stub
		return emsAction.create(ctx, emsarray);
	}

	@Override
	public EmsRstDTO[] save(CiEnContextDTO ctx, EmsSaveDTO[] ems) throws BizException {
		// TODO Auto-generated method stub
		return emsAction.save(ctx, ems);
	}

	@Override
	public EmsRstDTO load(CiEnContextDTO ctx, EmsLoadDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return emsAction.load(ctx, arg);
	}

	@Override
	public EmsRstDTO create(CiEnContextDTO ctx, EmsCrtDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return emsAction.create(ctx, arg);
	}

	@Override
	public EmsRstDTO save(CiEnContextDTO ctx, EmsSaveDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return emsAction.save(ctx, arg);
	}
}
