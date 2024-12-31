package iih.mp.nr.nurhdv.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mp.nr.nurhdv.d.desc.NurhdvAggDODesc;



/**
 * 护士交接班
 */
public class NurhdvAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public HdvEntDO getParentDO() {
		return ((HdvEntDO) super.getParentDO());
	}

	public void setParentDO(HdvEntDO headDO) {
		setParent(headDO);
	}

	public HdvEntAttrDO[] getHdvEntAttrDO() {
		IBaseDO[] dos = getChildren(HdvEntAttrDO.class);
		if(dos==null) return null;
		HdvEntAttrDO[] result=new HdvEntAttrDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(HdvEntAttrDO)dos[i];
		}
		return result;
	}
	
	public void setHdvEntAttrDO(HdvEntAttrDO[] dos) {
		setChildren(HdvEntAttrDO.class, dos);
	}
	public HdvEntTagtDO[] getHdvEntTagtDO() {
		IBaseDO[] dos = getChildren(HdvEntTagtDO.class);
		if(dos==null) return null;
		HdvEntTagtDO[] result=new HdvEntTagtDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(HdvEntTagtDO)dos[i];
		}
		return result;
	}
	
	public void setHdvEntTagtDO(HdvEntTagtDO[] dos) {
		setChildren(HdvEntTagtDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NurhdvAggDODesc desc = new NurhdvAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new HdvEntDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mp.nr.nurhdv.d.HdvEntAttrDO")) {
             return new HdvEntAttrDO();
         }
	    else if (clzName.equals("iih.mp.nr.nurhdv.d.HdvEntTagtDO")) {
             return new HdvEntTagtDO();
         }
         return null;
     }
}