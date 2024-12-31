package iih.ci.mr.nu.sugeryip.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mr.nu.sugeryip.d.desc.SurgeryipAggDODesc;



/**
 * 外科住院患者护理记录单
 */
public class SurgeryipAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public SurgeryPatInfoDO getParentDO() {
		return ((SurgeryPatInfoDO) super.getParentDO());
	}

	public void setParentDO(SurgeryPatInfoDO headDO) {
		setParent(headDO);
	}

	public SurgeryIpDO[] getSurgeryIpDO() {
		IBaseDO[] dos = getChildren(SurgeryIpDO.class);
		if(dos==null) return null;
		SurgeryIpDO[] result=new SurgeryIpDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(SurgeryIpDO)dos[i];
		}
		return result;
	}
	
	public void setSurgeryIpDO(SurgeryIpDO[] dos) {
		setChildren(SurgeryIpDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		SurgeryipAggDODesc desc = new SurgeryipAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new SurgeryPatInfoDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mr.nu.sugeryip.d.SurgeryIpDO")) {
             return new SurgeryIpDO();
         }
         return null;
     }
}