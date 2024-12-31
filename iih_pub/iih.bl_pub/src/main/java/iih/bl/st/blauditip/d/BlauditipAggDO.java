package iih.bl.st.blauditip.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bl.st.blauditip.d.desc.BlauditipAggDODesc;



/**
 * 住院费用审核
 */
public class BlauditipAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public BlAuditIp getParentDO() {
		return ((BlAuditIp) super.getParentDO());
	}

	public void setParentDO(BlAuditIp headDO) {
		setParent(headDO);
	}

	public BlAuditLogIp[] getBlAuditLogIp() {
		IBaseDO[] dos = getChildren(BlAuditLogIp.class);
		if(dos==null) return null;
		BlAuditLogIp[] result=new BlAuditLogIp[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(BlAuditLogIp)dos[i];
		}
		return result;
	}
	
	public void setBlAuditLogIp(BlAuditLogIp[] dos) {
		setChildren(BlAuditLogIp.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		BlauditipAggDODesc desc = new BlauditipAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new BlAuditIp();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bl.st.blauditip.d.BlAuditLogIp")) {
             return new BlAuditLogIp();
         }
         return null;
     }
}