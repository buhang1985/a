package iih.pe.phm.pecmaresult.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.phm.pecmaresult.d.desc.PecmaresultAggDODesc;



/**
 * 健康评估自测问卷结果
 */
public class PecmaresultAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeCmaDO getParentDO() {
		return ((PeCmaDO) super.getParentDO());
	}

	public void setParentDO(PeCmaDO headDO) {
		setParent(headDO);
	}

	public PeCmaKeyDO[] getPeCmaKeyDO() {
		IBaseDO[] dos = getChildren(PeCmaKeyDO.class);
		if(dos==null) return null;
		PeCmaKeyDO[] result=new PeCmaKeyDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeCmaKeyDO)dos[i];
		}
		return result;
	}
	
	public void setPeCmaKeyDO(PeCmaKeyDO[] dos) {
		setChildren(PeCmaKeyDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PecmaresultAggDODesc desc = new PecmaresultAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeCmaDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.phm.pecmaresult.d.PeCmaKeyDO")) {
             return new PeCmaKeyDO();
         }
         return null;
     }
}