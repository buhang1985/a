package iih.ci.mr.nu.newborn24hobsrec.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mr.nu.newborn24hobsrec.d.desc.Newborn24hobsrecAggDODesc;



/**
 * 新生儿24小时观察记录单
 */
public class Newborn24hobsrecAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public New24ObsPatDO getParentDO() {
		return ((New24ObsPatDO) super.getParentDO());
	}

	public void setParentDO(New24ObsPatDO headDO) {
		setParent(headDO);
	}

	public New24ObsDO[] getNew24ObsDO() {
		IBaseDO[] dos = getChildren(New24ObsDO.class);
		if(dos==null) return null;
		New24ObsDO[] result=new New24ObsDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(New24ObsDO)dos[i];
		}
		return result;
	}
	
	public void setNew24ObsDO(New24ObsDO[] dos) {
		setChildren(New24ObsDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		Newborn24hobsrecAggDODesc desc = new Newborn24hobsrecAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new New24ObsPatDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mr.nu.newborn24hobsrec.d.New24ObsDO")) {
             return new New24ObsDO();
         }
         return null;
     }
}