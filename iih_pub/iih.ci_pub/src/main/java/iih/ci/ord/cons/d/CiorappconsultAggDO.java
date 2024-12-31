package iih.ci.ord.cons.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.ord.cons.d.desc.CiorappconsultAggDODesc;



/**
 * 会诊申请单
 */
public class CiorappconsultAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public OrdApConsDO getParentDO() {
		return ((OrdApConsDO) super.getParentDO());
	}

	public void setParentDO(OrdApConsDO headDO) {
		setParent(headDO);
	}

	public CiConsInviteDO[] getCiConsInviteDO() {
		IBaseDO[] dos = getChildren(CiConsInviteDO.class);
		if(dos==null) return null;
		CiConsInviteDO[] result=new CiConsInviteDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(CiConsInviteDO)dos[i];
		}
		return result;
	}
	
	public void setCiConsInviteDO(CiConsInviteDO[] dos) {
		setChildren(CiConsInviteDO.class, dos);
	}
	public CiConsActInviteDO[] getCiConsActInviteDO() {
		IBaseDO[] dos = getChildren(CiConsActInviteDO.class);
		if(dos==null) return null;
		CiConsActInviteDO[] result=new CiConsActInviteDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(CiConsActInviteDO)dos[i];
		}
		return result;
	}
	
	public void setCiConsActInviteDO(CiConsActInviteDO[] dos) {
		setChildren(CiConsActInviteDO.class, dos);
	}
	public CiConsApproveInviteDO[] getCiConsApproveInviteDO() {
		IBaseDO[] dos = getChildren(CiConsApproveInviteDO.class);
		if(dos==null) return null;
		CiConsApproveInviteDO[] result=new CiConsApproveInviteDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(CiConsApproveInviteDO)dos[i];
		}
		return result;
	}
	
	public void setCiConsApproveInviteDO(CiConsApproveInviteDO[] dos) {
		setChildren(CiConsApproveInviteDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		CiorappconsultAggDODesc desc = new CiorappconsultAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new OrdApConsDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.ord.cons.d.CiConsInviteDO")) {
             return new CiConsInviteDO();
         }
	    else if (clzName.equals("iih.ci.ord.cons.d.CiConsActInviteDO")) {
             return new CiConsActInviteDO();
         }
	    else if (clzName.equals("iih.ci.ord.cons.d.CiConsApproveInviteDO")) {
             return new CiConsApproveInviteDO();
         }
         return null;
     }
}