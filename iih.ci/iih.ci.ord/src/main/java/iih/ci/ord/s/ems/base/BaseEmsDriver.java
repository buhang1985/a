package iih.ci.ord.s.ems.base;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.EmsCrtDTO;
import iih.ci.ord.i.meta.EmsLoadDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.i.meta.EmsSaveDTO;
import iih.ci.ord.i.op.tmpl.TmplLoadDTO;
import iih.ci.ord.i.op.tmpl.TmplRstDTO;
import iih.ci.ord.i.op.tmpl.TmplSaveDTO;
import iih.ci.ord.s.ems.itf.IEmsAction;
import iih.ci.ord.s.ems.itf.ITmplAction;
import xap.mw.core.data.BizException;

/**
 * 医疗单数据驱动基类
 * 
 * @author wangqingzhu
 *
 */
public class BaseEmsDriver implements IEmsAction, ITmplAction {

	/**
	 * 医疗单代理执行器
	 */
	private IEmsAction emsAction = null;
	/**
	 * 模板代理执行器
	 */
	private ITmplAction tmplAction = null;

	public IEmsAction getEmsAction() {
		return emsAction;
	}

	public void setEmsAction(IEmsAction emsAction) {
		this.emsAction = emsAction;
	}

	@Override
	public EmsRstDTO[] load(CiEnContextDTO ctx, EmsLoadDTO[] args) throws BizException {
		// TODO Auto-generated method stub
		return emsAction.load(ctx,args);
	}

	@Override
	public EmsRstDTO[] create(CiEnContextDTO ctx, EmsCrtDTO[] emsarray) throws BizException {
		// TODO Auto-generated method stub
		return emsAction.create(ctx, emsarray);
	}

	@Override
	public EmsRstDTO[] save(CiEnContextDTO ctx, EmsSaveDTO[] ems) throws BizException {
		// TODO Auto-generated method stub
		return emsAction.save(ctx,ems);
	}

	public ITmplAction getTmplAction() {
		return tmplAction;
	}

	public void setTmplAction(ITmplAction tmplAction) {
		this.tmplAction = tmplAction;
	}

	@Override
	public TmplRstDTO load(CiEnContextDTO ctx, TmplLoadDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return tmplAction.load(ctx,arg);
	}

	@Override
	public TmplRstDTO save(CiEnContextDTO ctx, TmplSaveDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return tmplAction.save(ctx,arg);
	}

}
