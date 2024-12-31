package iih.mp.mb.keyboard.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mp.mb.keyboard.d.desc.KeyboardAggDODesc;



/**
 * 移动护理键盘
 */
public class KeyboardAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public KeyBoardDO getParentDO() {
		return ((KeyBoardDO) super.getParentDO());
	}

	public void setParentDO(KeyBoardDO headDO) {
		setParent(headDO);
	}

	public KeyBoardSrvDO[] getKeyBoardSrvDO() {
		IBaseDO[] dos = getChildren(KeyBoardSrvDO.class);
		if(dos==null) return null;
		KeyBoardSrvDO[] result=new KeyBoardSrvDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(KeyBoardSrvDO)dos[i];
		}
		return result;
	}
	
	public void setKeyBoardSrvDO(KeyBoardSrvDO[] dos) {
		setChildren(KeyBoardSrvDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		KeyboardAggDODesc desc = new KeyboardAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new KeyBoardDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mp.mb.keyboard.d.KeyBoardSrvDO")) {
             return new KeyBoardSrvDO();
         }
         return null;
     }
}