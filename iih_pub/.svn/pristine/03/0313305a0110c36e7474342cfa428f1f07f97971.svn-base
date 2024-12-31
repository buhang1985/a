package iih.bd.res.opt.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.res.opt.d.desc.OptAggDODesc;



/**
 * 手术台
 */
public class OptAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public OptDO getParentDO() {
		return ((OptDO) super.getParentDO());
	}

	public void setParentDO(OptDO headDO) {
		setParent(headDO);
	}

	public OptFaDO[] getOptFaDO() {
		IBaseDO[] dos = getChildren(OptFaDO.class);
		if(dos==null) return null;
		OptFaDO[] result=new OptFaDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(OptFaDO)dos[i];
		}
		return result;
	}
	
	public void setOptFaDO(OptFaDO[] dos) {
		setChildren(OptFaDO.class, dos);
	}
	public OptDepDO[] getOptDepDO() {
		IBaseDO[] dos = getChildren(OptDepDO.class);
		if(dos==null) return null;
		OptDepDO[] result=new OptDepDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(OptDepDO)dos[i];
		}
		return result;
	}
	
	public void setOptDepDO(OptDepDO[] dos) {
		setChildren(OptDepDO.class, dos);
	}
	public OptEntpDO[] getOptEntpDO() {
		IBaseDO[] dos = getChildren(OptEntpDO.class);
		if(dos==null) return null;
		OptEntpDO[] result=new OptEntpDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(OptEntpDO)dos[i];
		}
		return result;
	}
	
	public void setOptEntpDO(OptEntpDO[] dos) {
		setChildren(OptEntpDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		OptAggDODesc desc = new OptAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new OptDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.res.opt.d.OptFaDO")) {
             return new OptFaDO();
         }
	    else if (clzName.equals("iih.bd.res.opt.d.OptDepDO")) {
             return new OptDepDO();
         }
	    else if (clzName.equals("iih.bd.res.opt.d.OptEntpDO")) {
             return new OptEntpDO();
         }
         return null;
     }
}