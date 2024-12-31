package iih.nm.nom.nommeet.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.nom.nommeet.d.desc.NommeetAggDODesc;



/**
 * 会议记录
 */
public class NommeetAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NomMeetDO getParentDO() {
		return ((NomMeetDO) super.getParentDO());
	}

	public void setParentDO(NomMeetDO headDO) {
		setParent(headDO);
	}

	public NomMeetPsnDO[] getNomMeetPsnDO() {
		IBaseDO[] dos = getChildren(NomMeetPsnDO.class);
		if(dos==null) return null;
		NomMeetPsnDO[] result=new NomMeetPsnDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NomMeetPsnDO)dos[i];
		}
		return result;
	}
	
	public void setNomMeetPsnDO(NomMeetPsnDO[] dos) {
		setChildren(NomMeetPsnDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NommeetAggDODesc desc = new NommeetAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NomMeetDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.nom.nommeet.d.NomMeetPsnDO")) {
             return new NomMeetPsnDO();
         }
         return null;
     }
}