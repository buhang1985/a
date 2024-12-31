package iih.mp.mpbd.mprs.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mp.mpbd.mprs.d.desc.MprsAggDODesc;



/**
 * 护士站滚屏
 */
public class MprsAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public MpRsDO getParentDO() {
		return ((MpRsDO) super.getParentDO());
	}

	public void setParentDO(MpRsDO headDO) {
		setParent(headDO);
	}

	public MpRsDepDO[] getMpRsDepDO() {
		IBaseDO[] dos = getChildren(MpRsDepDO.class);
		if(dos==null) return null;
		MpRsDepDO[] result=new MpRsDepDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(MpRsDepDO)dos[i];
		}
		return result;
	}
	
	public void setMpRsDepDO(MpRsDepDO[] dos) {
		setChildren(MpRsDepDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		MprsAggDODesc desc = new MprsAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new MpRsDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mp.mpbd.mprs.d.MpRsDepDO")) {
             return new MpRsDepDO();
         }
         return null;
     }
}