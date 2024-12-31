package iih.bd.srv.diagcate.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.srv.diagcate.d.desc.DiagcateAggDODesc;



/**
 * 疾病诊断分类
 */
public class DiagcateAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public DiagCateDO getParentDO() {
		return ((DiagCateDO) super.getParentDO());
	}

	public void setParentDO(DiagCateDO headDO) {
		setParent(headDO);
	}

	public DiCateItemDO[] getDiCateItemDO() {
		IBaseDO[] dos = getChildren(DiCateItemDO.class);
		if(dos==null) return null;
		DiCateItemDO[] result=new DiCateItemDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(DiCateItemDO)dos[i];
		}
		return result;
	}
	
	public void setDiCateItemDO(DiCateItemDO[] dos) {
		setChildren(DiCateItemDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		DiagcateAggDODesc desc = new DiagcateAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new DiagCateDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.srv.diagcate.d.DiCateItemDO")) {
             return new DiCateItemDO();
         }
         return null;
     }
}