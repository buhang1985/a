package iih.nm.nqm.nmnqmqcmt.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.nqm.nmnqmqcmt.d.desc.NmnqmqcmtAggDODesc;



/**
 * 护理管理_质控会议议题
 */
public class NmnqmqcmtAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NmNqmQcmtDO getParentDO() {
		return ((NmNqmQcmtDO) super.getParentDO());
	}

	public void setParentDO(NmNqmQcmtDO headDO) {
		setParent(headDO);
	}

	public NmNqmQcmtIsuDO[] getNmNqmQcmtIsuDO() {
		IBaseDO[] dos = getChildren(NmNqmQcmtIsuDO.class);
		if(dos==null) return null;
		NmNqmQcmtIsuDO[] result=new NmNqmQcmtIsuDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NmNqmQcmtIsuDO)dos[i];
		}
		return result;
	}
	
	public void setNmNqmQcmtIsuDO(NmNqmQcmtIsuDO[] dos) {
		setChildren(NmNqmQcmtIsuDO.class, dos);
	}
	public NmNqmqcmtPsnDO[] getNmNqmqcmtPsnDO() {
		IBaseDO[] dos = getChildren(NmNqmqcmtPsnDO.class);
		if(dos==null) return null;
		NmNqmqcmtPsnDO[] result=new NmNqmqcmtPsnDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NmNqmqcmtPsnDO)dos[i];
		}
		return result;
	}
	
	public void setNmNqmqcmtPsnDO(NmNqmqcmtPsnDO[] dos) {
		setChildren(NmNqmqcmtPsnDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NmnqmqcmtAggDODesc desc = new NmnqmqcmtAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NmNqmQcmtDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.nqm.nmnqmqcmt.d.NmNqmQcmtIsuDO")) {
             return new NmNqmQcmtIsuDO();
         }
	    else if (clzName.equals("iih.nm.nqm.nmnqmqcmt.d.NmNqmqcmtPsnDO")) {
             return new NmNqmqcmtPsnDO();
         }
         return null;
     }
}