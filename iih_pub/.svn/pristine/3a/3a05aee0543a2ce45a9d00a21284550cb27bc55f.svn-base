package iih.ci.mr.nu.ipobstetricnur.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mr.nu.ipobstetricnur.d.desc.IpobstetricnurAggDODesc;



/**
 * 产科住院患者护理记录单
 */
public class IpobstetricnurAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public IpobstetricnurinfoDO getParentDO() {
		return ((IpobstetricnurinfoDO) super.getParentDO());
	}

	public void setParentDO(IpobstetricnurinfoDO headDO) {
		setParent(headDO);
	}

	public IpobstetricnurDO[] getIpobstetricnurDO() {
		IBaseDO[] dos = getChildren(IpobstetricnurDO.class);
		if(dos==null) return null;
		IpobstetricnurDO[] result=new IpobstetricnurDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(IpobstetricnurDO)dos[i];
		}
		return result;
	}
	
	public void setIpobstetricnurDO(IpobstetricnurDO[] dos) {
		setChildren(IpobstetricnurDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		IpobstetricnurAggDODesc desc = new IpobstetricnurAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new IpobstetricnurinfoDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mr.nu.ipobstetricnur.d.IpobstetricnurDO")) {
             return new IpobstetricnurDO();
         }
         return null;
     }
}