package iih.ci.ord.s.ems.base;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.i.meta.EmsSaveDTO;
import iih.ci.ord.s.ems.itf.IEmsValidate;
import iih.ci.ord.s.ems.itf.bp.IEmsSaveBP;
import xap.mw.core.data.BizException;

public class BaseEmsSaveBP implements IEmsSaveBP {

	/**
	 * 有效性校验接口
	 */
	private IEmsValidate emsValidate = null;
	/**
	 * 就诊上下文
	 */
	private CiEnContextDTO enContextInfo = null;
	
	
	public BaseEmsSaveBP(){}
	
	public BaseEmsSaveBP(IEmsValidate v){
		this.emsValidate = v;
	}
	
	
	public IEmsValidate getEmsValidate() {
		return emsValidate;
	}


	public void setEmsValidate(IEmsValidate emsValidate) {
		this.emsValidate = emsValidate;
	}


	public CiEnContextDTO getEnContextInfo() {
		return enContextInfo;
	}


	public void setEnContextInfo(CiEnContextDTO enContextInfo) {
		this.enContextInfo = enContextInfo;
	}
	
	

	@Override
	public EmsRstDTO[] save(CiEnContextDTO ctx, EmsSaveDTO[] ems) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

}
