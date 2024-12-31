package iih.mp.mpbd.tcstyle.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mp.mpbd.tcstyle.d.desc.TcstyleAggDODesc;



/**
 * 体温单样式
 */
public class TcstyleAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public TcstyleDO getParentDO() {
		return ((TcstyleDO) super.getParentDO());
	}

	public void setParentDO(TcstyleDO headDO) {
		setParent(headDO);
	}

	public TcstyDepDO[] getTcstyDepDO() {
		IBaseDO[] dos = getChildren(TcstyDepDO.class);
		if(dos==null) return null;
		TcstyDepDO[] result=new TcstyDepDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(TcstyDepDO)dos[i];
		}
		return result;
	}
	
	public void setTcstyDepDO(TcstyDepDO[] dos) {
		setChildren(TcstyDepDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		TcstyleAggDODesc desc = new TcstyleAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new TcstyleDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mp.mpbd.tcstyle.d.TcstyDepDO")) {
             return new TcstyDepDO();
         }
         return null;
     }
}