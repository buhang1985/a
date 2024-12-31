package iih.syn.common.syninitapp.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.syn.common.syninitapp.d.desc.SyninitappAggDODesc;



/**
 * 数据初始化申请
 */
public class SyninitappAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public SynInitAppDO getParentDO() {
		return ((SynInitAppDO) super.getParentDO());
	}

	public void setParentDO(SynInitAppDO headDO) {
		setParent(headDO);
	}

	public SynInitAppItemDO[] getSynInitAppItemDO() {
		IBaseDO[] dos = getChildren(SynInitAppItemDO.class);
		if(dos==null) return null;
		SynInitAppItemDO[] result=new SynInitAppItemDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(SynInitAppItemDO)dos[i];
		}
		return result;
	}
	
	public void setSynInitAppItemDO(SynInitAppItemDO[] dos) {
		setChildren(SynInitAppItemDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		SyninitappAggDODesc desc = new SyninitappAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new SynInitAppDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.syn.common.syninitapp.d.SynInitAppItemDO")) {
             return new SynInitAppItemDO();
         }
         return null;
     }
}