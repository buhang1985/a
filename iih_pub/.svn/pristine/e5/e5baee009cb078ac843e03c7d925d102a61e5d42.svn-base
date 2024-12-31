package iih.pe.pitm.perstdocdidef.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.pitm.perstdocdidef.d.desc.PerstdocdidefAggDODesc;



/**
 * 体检医生模板
 */
public class PerstdocdidefAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeDocTmplDO getParentDO() {
		return ((PeDocTmplDO) super.getParentDO());
	}

	public void setParentDO(PeDocTmplDO headDO) {
		setParent(headDO);
	}

	public PeDocDiTmplDO[] getPeDocDiTmplDO() {
		IBaseDO[] dos = getChildren(PeDocDiTmplDO.class);
		if(dos==null) return null;
		PeDocDiTmplDO[] result=new PeDocDiTmplDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeDocDiTmplDO)dos[i];
		}
		return result;
	}
	
	public void setPeDocDiTmplDO(PeDocDiTmplDO[] dos) {
		setChildren(PeDocDiTmplDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PerstdocdidefAggDODesc desc = new PerstdocdidefAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeDocTmplDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.pitm.perstdocdidef.d.PeDocDiTmplDO")) {
             return new PeDocDiTmplDO();
         }
         return null;
     }
}