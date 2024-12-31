package iih.bd.srv.diagcatectm.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.srv.diagcatectm.d.desc.DiagcatectmitmAggDODesc;



/**
 * 疾病诊断自定义分类项目
 */
public class DiagcatectmitmAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public DiCaCtmItmDO getParentDO() {
		return ((DiCaCtmItmDO) super.getParentDO());
	}

	public void setParentDO(DiCaCtmItmDO headDO) {
		setParent(headDO);
	}

	public DiCaCtmItmRelDO[] getDiCaCtmItmRelDO() {
		IBaseDO[] dos = getChildren(DiCaCtmItmRelDO.class);
		if(dos==null) return null;
		DiCaCtmItmRelDO[] result=new DiCaCtmItmRelDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(DiCaCtmItmRelDO)dos[i];
		}
		return result;
	}
	
	public void setDiCaCtmItmRelDO(DiCaCtmItmRelDO[] dos) {
		setChildren(DiCaCtmItmRelDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		DiagcatectmitmAggDODesc desc = new DiagcatectmitmAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new DiCaCtmItmDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.srv.diagcatectm.d.DiCaCtmItmRelDO")) {
             return new DiCaCtmItmRelDO();
         }
         return null;
     }
}