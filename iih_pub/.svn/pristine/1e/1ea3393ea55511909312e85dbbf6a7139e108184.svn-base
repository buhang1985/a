package iih.bd.mm.custcategoryitem.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.mm.custcategoryitem.d.desc.CustcategoryitemAggDODesc;



/**
 * 医疗物品_自定义分类项目
 */
public class CustcategoryitemAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public CustCategoryItemDO getParentDO() {
		return ((CustCategoryItemDO) super.getParentDO());
	}

	public void setParentDO(CustCategoryItemDO headDO) {
		setParent(headDO);
	}

	public CustCategoryItemRelDO[] getCustCategoryItemRelDO() {
		IBaseDO[] dos = getChildren(CustCategoryItemRelDO.class);
		if(dos==null) return null;
		CustCategoryItemRelDO[] result=new CustCategoryItemRelDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(CustCategoryItemRelDO)dos[i];
		}
		return result;
	}
	
	public void setCustCategoryItemRelDO(CustCategoryItemRelDO[] dos) {
		setChildren(CustCategoryItemRelDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		CustcategoryitemAggDODesc desc = new CustcategoryitemAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new CustCategoryItemDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.mm.custcategoryitem.d.CustCategoryItemRelDO")) {
             return new CustCategoryItemRelDO();
         }
         return null;
     }
}