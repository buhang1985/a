package iih.bl.st.blpreauditip.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bl.st.blpreauditip.d.desc.BlpreauditipAggDODesc;



/**
 * 医保预审核_住院
 */
public class BlpreauditipAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public BlPreAuditIpDO getParentDO() {
		return ((BlPreAuditIpDO) super.getParentDO());
	}

	public void setParentDO(BlPreAuditIpDO headDO) {
		setParent(headDO);
	}

	public BlPreauditLogIpDO[] getBlPreauditLogIpDO() {
		IBaseDO[] dos = getChildren(BlPreauditLogIpDO.class);
		if(dos==null) return null;
		BlPreauditLogIpDO[] result=new BlPreauditLogIpDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(BlPreauditLogIpDO)dos[i];
		}
		return result;
	}
	
	public void setBlPreauditLogIpDO(BlPreauditLogIpDO[] dos) {
		setChildren(BlPreauditLogIpDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		BlpreauditipAggDODesc desc = new BlpreauditipAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new BlPreAuditIpDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bl.st.blpreauditip.d.BlPreauditLogIpDO")) {
             return new BlPreauditLogIpDO();
         }
         return null;
     }
}