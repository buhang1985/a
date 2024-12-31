package iih.en.que.board.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.en.que.board.d.desc.EnbrddoAggDODesc;



/**
 * 患者就诊_大屏
 */
public class EnbrddoAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public EnBrdDO getParentDO() {
		return ((EnBrdDO) super.getParentDO());
	}

	public void setParentDO(EnBrdDO headDO) {
		setParent(headDO);
	}

	public EnBrdConfigDO[] getEnBrdConfigDO() {
		IBaseDO[] dos = getChildren(EnBrdConfigDO.class);
		if(dos==null) return null;
		EnBrdConfigDO[] result=new EnBrdConfigDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(EnBrdConfigDO)dos[i];
		}
		return result;
	}
	
	public void setEnBrdConfigDO(EnBrdConfigDO[] dos) {
		setChildren(EnBrdConfigDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		EnbrddoAggDODesc desc = new EnbrddoAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new EnBrdDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.en.que.board.d.EnBrdConfigDO")) {
             return new EnBrdConfigDO();
         }
         return null;
     }
}