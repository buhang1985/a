package iih.pi.dic.phyind.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pi.dic.phyind.d.desc.PhyindAggDODesc;



/**
 * 患者生理指标
 */
public class PhyindAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PiPatPhyIndDO getParentDO() {
		return ((PiPatPhyIndDO) super.getParentDO());
	}

	public void setParentDO(PiPatPhyIndDO headDO) {
		setParent(headDO);
	}

	public PiPatPhyIndOptDO[] getPiPatPhyIndOptDO() {
		IBaseDO[] dos = getChildren(PiPatPhyIndOptDO.class);
		if(dos==null) return null;
		PiPatPhyIndOptDO[] result=new PiPatPhyIndOptDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PiPatPhyIndOptDO)dos[i];
		}
		return result;
	}
	
	public void setPiPatPhyIndOptDO(PiPatPhyIndOptDO[] dos) {
		setChildren(PiPatPhyIndOptDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PhyindAggDODesc desc = new PhyindAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PiPatPhyIndDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pi.dic.phyind.d.PiPatPhyIndOptDO")) {
             return new PiPatPhyIndOptDO();
         }
         return null;
     }
}