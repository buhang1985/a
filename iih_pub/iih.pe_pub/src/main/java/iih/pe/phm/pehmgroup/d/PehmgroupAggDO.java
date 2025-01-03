package iih.pe.phm.pehmgroup.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.phm.pehmgroup.d.desc.PehmgroupAggDODesc;



/**
 * 体检健康群体管理
 */
public class PehmgroupAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeHmGroupDO getParentDO() {
		return ((PeHmGroupDO) super.getParentDO());
	}

	public void setParentDO(PeHmGroupDO headDO) {
		setParent(headDO);
	}

	public PeHmGroupPsnDO[] getPeHmGroupPsnDO() {
		IBaseDO[] dos = getChildren(PeHmGroupPsnDO.class);
		if(dos==null) return null;
		PeHmGroupPsnDO[] result=new PeHmGroupPsnDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeHmGroupPsnDO)dos[i];
		}
		return result;
	}
	
	public void setPeHmGroupPsnDO(PeHmGroupPsnDO[] dos) {
		setChildren(PeHmGroupPsnDO.class, dos);
	}
	public PeHmGroupRisksDO[] getPeHmGroupRisksDO() {
		IBaseDO[] dos = getChildren(PeHmGroupRisksDO.class);
		if(dos==null) return null;
		PeHmGroupRisksDO[] result=new PeHmGroupRisksDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeHmGroupRisksDO)dos[i];
		}
		return result;
	}
	
	public void setPeHmGroupRisksDO(PeHmGroupRisksDO[] dos) {
		setChildren(PeHmGroupRisksDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PehmgroupAggDODesc desc = new PehmgroupAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeHmGroupDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.phm.pehmgroup.d.PeHmGroupPsnDO")) {
             return new PeHmGroupPsnDO();
         }
	    else if (clzName.equals("iih.pe.phm.pehmgroup.d.PeHmGroupRisksDO")) {
             return new PeHmGroupRisksDO();
         }
         return null;
     }
}