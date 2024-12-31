package iih.ci.mr.nu.earlywarnmark.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mr.nu.earlywarnmark.d.desc.EarlywarnmarkAggDODesc;



/**
 * 重症患者早期预警评分表
 */
public class EarlywarnmarkAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public EarlywarnminfoDO getParentDO() {
		return ((EarlywarnminfoDO) super.getParentDO());
	}

	public void setParentDO(EarlywarnminfoDO headDO) {
		setParent(headDO);
	}

	public EarlywarnmDO[] getEarlywarnmDO() {
		IBaseDO[] dos = getChildren(EarlywarnmDO.class);
		if(dos==null) return null;
		EarlywarnmDO[] result=new EarlywarnmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(EarlywarnmDO)dos[i];
		}
		return result;
	}
	
	public void setEarlywarnmDO(EarlywarnmDO[] dos) {
		setChildren(EarlywarnmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		EarlywarnmarkAggDODesc desc = new EarlywarnmarkAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new EarlywarnminfoDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mr.nu.earlywarnmark.d.EarlywarnmDO")) {
             return new EarlywarnmDO();
         }
         return null;
     }
}