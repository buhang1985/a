package iih.pe.por.pepsncard.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.por.pepsncard.d.desc.PepsncardAggDODesc;



/**
 * 体检客户会员卡
 */
public class PepsncardAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PePsnCardDDO getParentDO() {
		return ((PePsnCardDDO) super.getParentDO());
	}

	public void setParentDO(PePsnCardDDO headDO) {
		setParent(headDO);
	}

	public PePsnCardRecDO[] getPePsnCardRecDO() {
		IBaseDO[] dos = getChildren(PePsnCardRecDO.class);
		if(dos==null) return null;
		PePsnCardRecDO[] result=new PePsnCardRecDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PePsnCardRecDO)dos[i];
		}
		return result;
	}
	
	public void setPePsnCardRecDO(PePsnCardRecDO[] dos) {
		setChildren(PePsnCardRecDO.class, dos);
	}
	public PePsnCardMemDO[] getPePsnCardMemDO() {
		IBaseDO[] dos = getChildren(PePsnCardMemDO.class);
		if(dos==null) return null;
		PePsnCardMemDO[] result=new PePsnCardMemDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PePsnCardMemDO)dos[i];
		}
		return result;
	}
	
	public void setPePsnCardMemDO(PePsnCardMemDO[] dos) {
		setChildren(PePsnCardMemDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PepsncardAggDODesc desc = new PepsncardAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PePsnCardDDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.por.pepsncard.d.PePsnCardRecDO")) {
             return new PePsnCardRecDO();
         }
	    else if (clzName.equals("iih.pe.por.pepsncard.d.PePsnCardMemDO")) {
             return new PePsnCardMemDO();
         }
         return null;
     }
}