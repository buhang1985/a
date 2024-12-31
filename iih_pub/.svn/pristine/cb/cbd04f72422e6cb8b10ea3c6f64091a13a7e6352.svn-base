package iih.hp.cp.hpcp.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.hp.cp.hpcp.d.desc.HpcpAggDODesc;



/**
 * 诊疗计划
 */
public class HpcpAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public HpCpDO getParentDO() {
		return ((HpCpDO) super.getParentDO());
	}

	public void setParentDO(HpCpDO headDO) {
		setParent(headDO);
	}

	public HpCpEnblOrgDO[] getHpCpEnblOrgDO() {
		IBaseDO[] dos = getChildren(HpCpEnblOrgDO.class);
		if(dos==null) return null;
		HpCpEnblOrgDO[] result=new HpCpEnblOrgDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(HpCpEnblOrgDO)dos[i];
		}
		return result;
	}
	
	public void setHpCpEnblOrgDO(HpCpEnblOrgDO[] dos) {
		setChildren(HpCpEnblOrgDO.class, dos);
	}
	public HpCpFileDO[] getHpCpFileDO() {
		IBaseDO[] dos = getChildren(HpCpFileDO.class);
		if(dos==null) return null;
		HpCpFileDO[] result=new HpCpFileDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(HpCpFileDO)dos[i];
		}
		return result;
	}
	
	public void setHpCpFileDO(HpCpFileDO[] dos) {
		setChildren(HpCpFileDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		HpcpAggDODesc desc = new HpcpAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new HpCpDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.hp.cp.hpcp.d.HpCpEnblOrgDO")) {
             return new HpCpEnblOrgDO();
         }
	    else if (clzName.equals("iih.hp.cp.hpcp.d.HpCpFileDO")) {
             return new HpCpFileDO();
         }
         return null;
     }
}