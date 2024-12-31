package iih.pi.overview.overview.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pi.overview.overview.d.desc.OverviewAggDODesc;



/**
 * 患者临床摘要
 */
public class OverviewAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PiPatDO getParentDO() {
		return ((PiPatDO) super.getParentDO());
	}

	public void setParentDO(PiPatDO headDO) {
		setParent(headDO);
	}

	public PiPatDisaDO[] getPiPatDisaDO() {
		IBaseDO[] dos = getChildren(PiPatDisaDO.class);
		if(dos==null) return null;
		PiPatDisaDO[] result=new PiPatDisaDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PiPatDisaDO)dos[i];
		}
		return result;
	}
	
	public void setPiPatDisaDO(PiPatDisaDO[] dos) {
		setChildren(PiPatDisaDO.class, dos);
	}
	public PiPatDiDO[] getPiPatDiDO() {
		IBaseDO[] dos = getChildren(PiPatDiDO.class);
		if(dos==null) return null;
		PiPatDiDO[] result=new PiPatDiDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PiPatDiDO)dos[i];
		}
		return result;
	}
	
	public void setPiPatDiDO(PiPatDiDO[] dos) {
		setChildren(PiPatDiDO.class, dos);
	}
	public PiPatSrvDO[] getPiPatSrvDO() {
		IBaseDO[] dos = getChildren(PiPatSrvDO.class);
		if(dos==null) return null;
		PiPatSrvDO[] result=new PiPatSrvDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PiPatSrvDO)dos[i];
		}
		return result;
	}
	
	public void setPiPatSrvDO(PiPatSrvDO[] dos) {
		setChildren(PiPatSrvDO.class, dos);
	}
	public PiPatAlDO[] getPiPatAlDO() {
		IBaseDO[] dos = getChildren(PiPatAlDO.class);
		if(dos==null) return null;
		PiPatAlDO[] result=new PiPatAlDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PiPatAlDO)dos[i];
		}
		return result;
	}
	
	public void setPiPatAlDO(PiPatAlDO[] dos) {
		setChildren(PiPatAlDO.class, dos);
	}
	public PiPatFhDO[] getPiPatFhDO() {
		IBaseDO[] dos = getChildren(PiPatFhDO.class);
		if(dos==null) return null;
		PiPatFhDO[] result=new PiPatFhDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PiPatFhDO)dos[i];
		}
		return result;
	}
	
	public void setPiPatFhDO(PiPatFhDO[] dos) {
		setChildren(PiPatFhDO.class, dos);
	}
	public PiPatSugDO[] getPiPatSugDO() {
		IBaseDO[] dos = getChildren(PiPatSugDO.class);
		if(dos==null) return null;
		PiPatSugDO[] result=new PiPatSugDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PiPatSugDO)dos[i];
		}
		return result;
	}
	
	public void setPiPatSugDO(PiPatSugDO[] dos) {
		setChildren(PiPatSugDO.class, dos);
	}
	public PiPatExpDO[] getPiPatExpDO() {
		IBaseDO[] dos = getChildren(PiPatExpDO.class);
		if(dos==null) return null;
		PiPatExpDO[] result=new PiPatExpDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PiPatExpDO)dos[i];
		}
		return result;
	}
	
	public void setPiPatExpDO(PiPatExpDO[] dos) {
		setChildren(PiPatExpDO.class, dos);
	}
	public PiPatBTDO[] getPiPatBTDO() {
		IBaseDO[] dos = getChildren(PiPatBTDO.class);
		if(dos==null) return null;
		PiPatBTDO[] result=new PiPatBTDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PiPatBTDO)dos[i];
		}
		return result;
	}
	
	public void setPiPatBTDO(PiPatBTDO[] dos) {
		setChildren(PiPatBTDO.class, dos);
	}
	public PiPatDrugDO[] getPiPatDrugDO() {
		IBaseDO[] dos = getChildren(PiPatDrugDO.class);
		if(dos==null) return null;
		PiPatDrugDO[] result=new PiPatDrugDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PiPatDrugDO)dos[i];
		}
		return result;
	}
	
	public void setPiPatDrugDO(PiPatDrugDO[] dos) {
		setChildren(PiPatDrugDO.class, dos);
	}
	public PiPatReactDO[] getPiPatReactDO() {
		IBaseDO[] dos = getChildren(PiPatReactDO.class);
		if(dos==null) return null;
		PiPatReactDO[] result=new PiPatReactDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PiPatReactDO)dos[i];
		}
		return result;
	}
	
	public void setPiPatReactDO(PiPatReactDO[] dos) {
		setChildren(PiPatReactDO.class, dos);
	}
	public PiPatImmDO[] getPiPatImmDO() {
		IBaseDO[] dos = getChildren(PiPatImmDO.class);
		if(dos==null) return null;
		PiPatImmDO[] result=new PiPatImmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PiPatImmDO)dos[i];
		}
		return result;
	}
	
	public void setPiPatImmDO(PiPatImmDO[] dos) {
		setChildren(PiPatImmDO.class, dos);
	}
	public PiPatCbhDO[] getPiPatCbhDO() {
		IBaseDO[] dos = getChildren(PiPatCbhDO.class);
		if(dos==null) return null;
		PiPatCbhDO[] result=new PiPatCbhDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PiPatCbhDO)dos[i];
		}
		return result;
	}
	
	public void setPiPatCbhDO(PiPatCbhDO[] dos) {
		setChildren(PiPatCbhDO.class, dos);
	}
	public PiPatMarDO[] getPiPatMarDO() {
		IBaseDO[] dos = getChildren(PiPatMarDO.class);
		if(dos==null) return null;
		PiPatMarDO[] result=new PiPatMarDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PiPatMarDO)dos[i];
		}
		return result;
	}
	
	public void setPiPatMarDO(PiPatMarDO[] dos) {
		setChildren(PiPatMarDO.class, dos);
	}
	public PiPatMhDO[] getPiPatMhDO() {
		IBaseDO[] dos = getChildren(PiPatMhDO.class);
		if(dos==null) return null;
		PiPatMhDO[] result=new PiPatMhDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PiPatMhDO)dos[i];
		}
		return result;
	}
	
	public void setPiPatMhDO(PiPatMhDO[] dos) {
		setChildren(PiPatMhDO.class, dos);
	}
	public PiPatPsnDO[] getPiPatPsnDO() {
		IBaseDO[] dos = getChildren(PiPatPsnDO.class);
		if(dos==null) return null;
		PiPatPsnDO[] result=new PiPatPsnDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PiPatPsnDO)dos[i];
		}
		return result;
	}
	
	public void setPiPatPsnDO(PiPatPsnDO[] dos) {
		setChildren(PiPatPsnDO.class, dos);
	}
	public PiPatVsDO[] getPiPatVsDO() {
		IBaseDO[] dos = getChildren(PiPatVsDO.class);
		if(dos==null) return null;
		PiPatVsDO[] result=new PiPatVsDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PiPatVsDO)dos[i];
		}
		return result;
	}
	
	public void setPiPatVsDO(PiPatVsDO[] dos) {
		setChildren(PiPatVsDO.class, dos);
	}
	public PiPatObsDO[] getPiPatObsDO() {
		IBaseDO[] dos = getChildren(PiPatObsDO.class);
		if(dos==null) return null;
		PiPatObsDO[] result=new PiPatObsDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PiPatObsDO)dos[i];
		}
		return result;
	}
	
	public void setPiPatObsDO(PiPatObsDO[] dos) {
		setChildren(PiPatObsDO.class, dos);
	}
	public PiPatLabDO[] getPiPatLabDO() {
		IBaseDO[] dos = getChildren(PiPatLabDO.class);
		if(dos==null) return null;
		PiPatLabDO[] result=new PiPatLabDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PiPatLabDO)dos[i];
		}
		return result;
	}
	
	public void setPiPatLabDO(PiPatLabDO[] dos) {
		setChildren(PiPatLabDO.class, dos);
	}
	public PiPatCbhindDO[] getPiPatCbhindDO() {
		IBaseDO[] dos = getChildren(PiPatCbhindDO.class);
		if(dos==null) return null;
		PiPatCbhindDO[] result=new PiPatCbhindDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PiPatCbhindDO)dos[i];
		}
		return result;
	}
	
	public void setPiPatCbhindDO(PiPatCbhindDO[] dos) {
		setChildren(PiPatCbhindDO.class, dos);
	}
	public PiPatPhyDO[] getPiPatPhyDO() {
		IBaseDO[] dos = getChildren(PiPatPhyDO.class);
		if(dos==null) return null;
		PiPatPhyDO[] result=new PiPatPhyDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PiPatPhyDO)dos[i];
		}
		return result;
	}
	
	public void setPiPatPhyDO(PiPatPhyDO[] dos) {
		setChildren(PiPatPhyDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		OverviewAggDODesc desc = new OverviewAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PiPatDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pi.overview.overview.d.PiPatDisaDO")) {
             return new PiPatDisaDO();
         }
	    else if (clzName.equals("iih.pi.overview.overview.d.PiPatDiDO")) {
             return new PiPatDiDO();
         }
	    else if (clzName.equals("iih.pi.overview.overview.d.PiPatSrvDO")) {
             return new PiPatSrvDO();
         }
	    else if (clzName.equals("iih.pi.overview.overview.d.PiPatAlDO")) {
             return new PiPatAlDO();
         }
	    else if (clzName.equals("iih.pi.overview.overview.d.PiPatFhDO")) {
             return new PiPatFhDO();
         }
	    else if (clzName.equals("iih.pi.overview.overview.d.PiPatSugDO")) {
             return new PiPatSugDO();
         }
	    else if (clzName.equals("iih.pi.overview.overview.d.PiPatExpDO")) {
             return new PiPatExpDO();
         }
	    else if (clzName.equals("iih.pi.overview.overview.d.PiPatBTDO")) {
             return new PiPatBTDO();
         }
	    else if (clzName.equals("iih.pi.overview.overview.d.PiPatDrugDO")) {
             return new PiPatDrugDO();
         }
	    else if (clzName.equals("iih.pi.overview.overview.d.PiPatReactDO")) {
             return new PiPatReactDO();
         }
	    else if (clzName.equals("iih.pi.overview.overview.d.PiPatImmDO")) {
             return new PiPatImmDO();
         }
	    else if (clzName.equals("iih.pi.overview.overview.d.PiPatCbhDO")) {
             return new PiPatCbhDO();
         }
	    else if (clzName.equals("iih.pi.overview.overview.d.PiPatMarDO")) {
             return new PiPatMarDO();
         }
	    else if (clzName.equals("iih.pi.overview.overview.d.PiPatMhDO")) {
             return new PiPatMhDO();
         }
	    else if (clzName.equals("iih.pi.overview.overview.d.PiPatPsnDO")) {
             return new PiPatPsnDO();
         }
	    else if (clzName.equals("iih.pi.overview.overview.d.PiPatVsDO")) {
             return new PiPatVsDO();
         }
	    else if (clzName.equals("iih.pi.overview.overview.d.PiPatObsDO")) {
             return new PiPatObsDO();
         }
	    else if (clzName.equals("iih.pi.overview.overview.d.PiPatLabDO")) {
             return new PiPatLabDO();
         }
	    else if (clzName.equals("iih.pi.overview.overview.d.PiPatCbhindDO")) {
             return new PiPatCbhindDO();
         }
	    else if (clzName.equals("iih.pi.overview.overview.d.PiPatPhyDO")) {
             return new PiPatPhyDO();
         }
         return null;
     }
}