package iih.pe.pps.pecohort.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.pps.pecohort.d.desc.PecohortAggDODesc;



/**
 * 体检人群队列管理
 */
public class PecohortAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeCohortDO getParentDO() {
		return ((PeCohortDO) super.getParentDO());
	}

	public void setParentDO(PeCohortDO headDO) {
		setParent(headDO);
	}

	public PeCohortPsnDO[] getPeCohortPsnDO() {
		IBaseDO[] dos = getChildren(PeCohortPsnDO.class);
		if(dos==null) return null;
		PeCohortPsnDO[] result=new PeCohortPsnDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeCohortPsnDO)dos[i];
		}
		return result;
	}
	
	public void setPeCohortPsnDO(PeCohortPsnDO[] dos) {
		setChildren(PeCohortPsnDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PecohortAggDODesc desc = new PecohortAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeCohortDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.pps.pecohort.d.PeCohortPsnDO")) {
             return new PeCohortPsnDO();
         }
         return null;
     }
}