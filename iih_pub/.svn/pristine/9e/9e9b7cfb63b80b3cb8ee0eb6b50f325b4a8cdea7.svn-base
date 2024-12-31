package iih.nm.nqm.nqmtaskdetdep.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.nqm.nqmtaskdetdep.d.desc.NqmtaskdetdepAggDODesc;



/**
 * 质控任务明细科室
 */
public class NqmtaskdetdepAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NqmTaskDetDepDO getParentDO() {
		return ((NqmTaskDetDepDO) super.getParentDO());
	}

	public void setParentDO(NqmTaskDetDepDO headDO) {
		setParent(headDO);
	}

	public NqmTaskDetDepTmplDO[] getNqmTaskDetDepTmplDO() {
		IBaseDO[] dos = getChildren(NqmTaskDetDepTmplDO.class);
		if(dos==null) return null;
		NqmTaskDetDepTmplDO[] result=new NqmTaskDetDepTmplDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NqmTaskDetDepTmplDO)dos[i];
		}
		return result;
	}
	
	public void setNqmTaskDetDepTmplDO(NqmTaskDetDepTmplDO[] dos) {
		setChildren(NqmTaskDetDepTmplDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NqmtaskdetdepAggDODesc desc = new NqmtaskdetdepAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NqmTaskDetDepDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.nqm.nqmtaskdetdep.d.NqmTaskDetDepTmplDO")) {
             return new NqmTaskDetDepTmplDO();
         }
         return null;
     }
}