package iih.ci.sdk.ems.bp;

import iih.ci.ems.b.BaseEmsViewDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.EmsLoadDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.sdk.ems.itf.IEmsLoadBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;

public class BaseEmsLoadBP implements IEmsLoadBP {

	@Override
	public EmsRstDTO[] load(CiEnContextDTO ctx, EmsLoadDTO[] args) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}
	
	protected FArrayList handleReturnDocument(CiEnContextDTO ctx, BaseEmsViewDTO ems) throws BizException {
		FArrayList objList = new FArrayList();
		objList.add(ems);

		return objList;
	}

	@Override
	public EmsRstDTO load(CiEnContextDTO ctx, EmsLoadDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}
}
