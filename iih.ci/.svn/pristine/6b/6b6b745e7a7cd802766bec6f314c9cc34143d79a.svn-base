package iih.ci.sdk.action;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.i.IMedsrvRService;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.EmsCrtDTO;
import iih.ci.ord.i.meta.EmsLoadDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.i.meta.EmsSaveDTO;
import iih.ci.sdk.ems.itf.IEmsAction;
import iih.ci.sdk.ems.itf.IEmsCreateBP;
import iih.ci.sdk.ems.itf.IEmsLoadBP;
import iih.ci.sdk.ems.itf.IEmsSaveBP;
import iih.ci.sdk.ems.itf.IEmsValidate;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 
 * @author wangqingzhu
 *
 * @date 2019年9月29日下午6:00:06
 *
 * @classpath iih.ci.sdk.action.BaseEmsAction
 *
 * 写明类文件描述
 *
 */
public class BaseEmsAction implements IEmsAction{
	
	private IEmsValidate emsValidate;
	
	private IEmsCreateBP emsCreateBP;
	
	private IEmsLoadBP emsLoadBP ;
	
	private IEmsSaveBP emsSaveBP ;
	
	

	public BaseEmsAction() {
		
	}
	
	public BaseEmsAction(Class<?> createbp,Class<?> loadbp, Class<?> savebp, Class<?> validate) throws BizException {
		try {
			this.setEmsCreateBP((IEmsCreateBP)createbp.newInstance());
			this.setEmsLoadBP((IEmsLoadBP)loadbp.newInstance());
			this.setEmsValidate((IEmsValidate)validate.newInstance());
			Constructor<?> ct = savebp.getDeclaredConstructor(new Class[] {IEmsValidate.class});
			this.setEmsSaveBP((IEmsSaveBP)ct.newInstance((IEmsValidate)validate.newInstance()));
		}
		catch(NoSuchMethodException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new BizException(e);
		}
		
	}

	/**
	 * 创建医疗单
	 */
	@Override
	public EmsRstDTO[] create(CiEnContextDTO ctx, EmsCrtDTO[] szEms)  throws BizException{
		// TODO Auto-generated method stub
		
		return emsCreateBP.create(ctx, szEms);
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
	public EmsRstDTO[] save(CiEnContextDTO ctx, EmsSaveDTO[] szEms) throws BizException {
		// TODO Auto-generated method stub
		return emsSaveBP.save(ctx,szEms);
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

	@Override
	public EmsRstDTO load(CiEnContextDTO ctx, EmsLoadDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return emsLoadBP.load(ctx, arg);
	}

	@Override
	public EmsRstDTO create(CiEnContextDTO ctx, EmsCrtDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return emsCreateBP.create(ctx, arg);
	}

	@Override
	public EmsRstDTO save(CiEnContextDTO ctx, EmsSaveDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return emsSaveBP.save(ctx, arg);
	}
	
}
