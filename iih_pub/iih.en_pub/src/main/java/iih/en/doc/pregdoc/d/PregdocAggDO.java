package iih.en.doc.pregdoc.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.en.doc.pregdoc.d.desc.PregdocAggDODesc;



/**
 * 产科建档
 */
public class PregdocAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PregDocDO getParentDO() {
		return ((PregDocDO) super.getParentDO());
	}

	public void setParentDO(PregDocDO headDO) {
		setParent(headDO);
	}

	public PregDocStatDO[] getPregDocStatDO() {
		IBaseDO[] dos = getChildren(PregDocStatDO.class);
		if(dos==null) return null;
		PregDocStatDO[] result=new PregDocStatDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PregDocStatDO)dos[i];
		}
		return result;
	}
	
	public void setPregDocStatDO(PregDocStatDO[] dos) {
		setChildren(PregDocStatDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PregdocAggDODesc desc = new PregdocAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PregDocDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.en.doc.pregdoc.d.PregDocStatDO")) {
             return new PregDocStatDO();
         }
         return null;
     }
}