package iih.bd.res.bed.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.res.bed.d.desc.BedAggDODesc;



/**
 * 床位管理
 */
public class BedAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public Bdbed getParentDO() {
		return ((Bdbed) super.getParentDO());
	}

	public void setParentDO(Bdbed headDO) {
		setParent(headDO);
	}

	public Bdbedfa[] getBdbedfa() {
		IBaseDO[] dos = getChildren(Bdbedfa.class);
		if(dos==null) return null;
		Bdbedfa[] result=new Bdbedfa[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(Bdbedfa)dos[i];
		}
		return result;
	}
	
	public void setBdbedfa(Bdbedfa[] dos) {
		setChildren(Bdbedfa.class, dos);
	}
	public BedAttrDO[] getBedAttrDO() {
		IBaseDO[] dos = getChildren(BedAttrDO.class);
		if(dos==null) return null;
		BedAttrDO[] result=new BedAttrDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(BedAttrDO)dos[i];
		}
		return result;
	}
	
	public void setBedAttrDO(BedAttrDO[] dos) {
		setChildren(BedAttrDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		BedAggDODesc desc = new BedAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new Bdbed();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.res.bed.d.Bdbedfa")) {
             return new Bdbedfa();
         }
	    else if (clzName.equals("iih.bd.res.bed.d.BedAttrDO")) {
             return new BedAttrDO();
         }
         return null;
     }
}