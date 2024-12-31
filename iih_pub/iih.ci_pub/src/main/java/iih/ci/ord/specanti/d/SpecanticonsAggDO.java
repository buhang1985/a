package iih.ci.ord.specanti.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.ord.specanti.d.desc.SpecanticonsAggDODesc;



/**
 * 特殊使用级抗菌药物会诊申请
 */
public class SpecanticonsAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public SpecAntiConsDO getParentDO() {
		return ((SpecAntiConsDO) super.getParentDO());
	}

	public void setParentDO(SpecAntiConsDO headDO) {
		setParent(headDO);
	}

	public SpecAntiInvitesDO[] getSpecAntiInvitesDO() {
		IBaseDO[] dos = getChildren(SpecAntiInvitesDO.class);
		if(dos==null) return null;
		SpecAntiInvitesDO[] result=new SpecAntiInvitesDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(SpecAntiInvitesDO)dos[i];
		}
		return result;
	}
	
	public void setSpecAntiInvitesDO(SpecAntiInvitesDO[] dos) {
		setChildren(SpecAntiInvitesDO.class, dos);
	}
	public SpecAntiReviewDO[] getSpecAntiReviewDO() {
		IBaseDO[] dos = getChildren(SpecAntiReviewDO.class);
		if(dos==null) return null;
		SpecAntiReviewDO[] result=new SpecAntiReviewDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(SpecAntiReviewDO)dos[i];
		}
		return result;
	}
	
	public void setSpecAntiReviewDO(SpecAntiReviewDO[] dos) {
		setChildren(SpecAntiReviewDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		SpecanticonsAggDODesc desc = new SpecanticonsAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new SpecAntiConsDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.ord.specanti.d.SpecAntiInvitesDO")) {
             return new SpecAntiInvitesDO();
         }
	    else if (clzName.equals("iih.ci.ord.specanti.d.SpecAntiReviewDO")) {
             return new SpecAntiReviewDO();
         }
         return null;
     }
}