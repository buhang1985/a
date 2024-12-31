package iih.ci.ord.s.ems.base;

import iih.bd.base.cache.ContextCache;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.i.IMedsrvRService;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.EmsCrtDTO;
import iih.ci.ord.i.meta.EmsLoadDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.i.meta.EmsSaveDTO;
import iih.ci.ord.s.ems.itf.IEmsAction;
import iih.ci.ord.s.ems.itf.IEmsValidate;
import iih.ci.ord.s.ems.itf.bp.IEmsCreateBP;
import iih.ci.ord.s.ems.itf.bp.IEmsLoadBP;
import iih.ci.ord.s.ems.itf.bp.IEmsSaveBP;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

public class BaseEmsAction extends ContextCache implements IEmsAction{
	
	private IEmsValidate emsValidate;
	
	private IEmsCreateBP emsCreateBP;
	
	private IEmsLoadBP emsLoadBP ;
	
	private IEmsSaveBP emsSaveBP ;
	
	public BaseEmsAction(){
		super();
	}

	public BaseEmsAction(IEmsCreateBP c, IEmsLoadBP l, IEmsSaveBP s) {
		super();
		this.emsCreateBP = c;
		this.emsLoadBP = l;
		this.emsSaveBP = s;
	}

	/**
	 * 创建医疗单
	 */
	@Override
	public EmsRstDTO[] create(CiEnContextDTO ctx, EmsCrtDTO[] emsarray)  throws BizException{
		// TODO Auto-generated method stub
		
		return emsCreateBP.create(ctx,emsarray);
	}
	
	@Override
	public EmsRstDTO[] load(CiEnContextDTO ctx, EmsLoadDTO[] args) throws BizException {
		// TODO Auto-generated method stub
		return  emsLoadBP.load(ctx,args);
	}

	/**
	 * 保存医疗单
	 */
	@Override
	public EmsRstDTO[] save(CiEnContextDTO ctx, EmsSaveDTO[] ems) throws BizException {
		// TODO Auto-generated method stub
		return emsSaveBP.save(ctx,ems);
	}
	
	
	
	
	/**
	 * 获取主服务对象
	 * 
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	protected MedsrvAggDO getMedSrvInfo(String id_srv) throws BizException {
		return ServiceFinder.find(IMedsrvRService.class).findById(id_srv);
	}

	public IEmsCreateBP getEmsCreateBP() {
		return emsCreateBP;
	}

	public void setEmsCreateBP(IEmsCreateBP emsCreateBP) {
		this.emsCreateBP = emsCreateBP;
	}

	public IEmsLoadBP getEmsLoadBP() {
		return emsLoadBP;
	}

	public void setEmsLoadBP(IEmsLoadBP emsLoadBP) {
		this.emsLoadBP = emsLoadBP;
	}

	public IEmsSaveBP getEmsSaveBP() {
		return emsSaveBP;
	}

	public void setEmsSaveBP(IEmsSaveBP emsSaveBP) {
		this.emsSaveBP = emsSaveBP;
	}

	public IEmsValidate getEmsValidate() {
		return emsValidate;
	}

	public void setEmsValidate(IEmsValidate emsValidate) {
		this.emsValidate = emsValidate;
	}
}
