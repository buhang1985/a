package iih.mp.dg.mpdgshetpprntmpl.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mp.dg.mpdgshetpprntmpl.d.desc.MpdgshetpprntmplAggDODesc;



/**
 * 药单打印模板管理
 */
public class MpdgshetpprntmplAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public MpdgShetpPrntmplDO getParentDO() {
		return ((MpdgShetpPrntmplDO) super.getParentDO());
	}

	public void setParentDO(MpdgShetpPrntmplDO headDO) {
		setParent(headDO);
	}

	public MpdgShetpPrntmplIitmDO[] getMpdgShetpPrntmplIitmDO() {
		IBaseDO[] dos = getChildren(MpdgShetpPrntmplIitmDO.class);
		if(dos==null) return null;
		MpdgShetpPrntmplIitmDO[] result=new MpdgShetpPrntmplIitmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(MpdgShetpPrntmplIitmDO)dos[i];
		}
		return result;
	}
	
	public void setMpdgShetpPrntmplIitmDO(MpdgShetpPrntmplIitmDO[] dos) {
		setChildren(MpdgShetpPrntmplIitmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		MpdgshetpprntmplAggDODesc desc = new MpdgshetpprntmplAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new MpdgShetpPrntmplDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mp.dg.mpdgshetpprntmpl.d.MpdgShetpPrntmplIitmDO")) {
             return new MpdgShetpPrntmplIitmDO();
         }
         return null;
     }
}