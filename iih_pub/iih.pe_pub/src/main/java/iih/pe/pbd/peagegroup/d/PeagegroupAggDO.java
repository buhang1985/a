package iih.pe.pbd.peagegroup.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.pbd.peagegroup.d.desc.PeagegroupAggDODesc;



/**
 * 体检年龄分组
 */
public class PeagegroupAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeAgeDO getParentDO() {
		return ((PeAgeDO) super.getParentDO());
	}

	public void setParentDO(PeAgeDO headDO) {
		setParent(headDO);
	}

	public PeAgeListDO[] getPeAgeListDO() {
		IBaseDO[] dos = getChildren(PeAgeListDO.class);
		if(dos==null) return null;
		PeAgeListDO[] result=new PeAgeListDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeAgeListDO)dos[i];
		}
		return result;
	}
	
	public void setPeAgeListDO(PeAgeListDO[] dos) {
		setChildren(PeAgeListDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PeagegroupAggDODesc desc = new PeagegroupAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeAgeDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.pbd.peagegroup.d.PeAgeListDO")) {
             return new PeAgeListDO();
         }
         return null;
     }
}