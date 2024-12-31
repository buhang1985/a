package iih.bd.mm.custcategoryitem.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.mm.custcategoryitem.d.CustCategoryItemDO;
import iih.bd.mm.custcategoryitem.d.CustCategoryItemRelDO;
import iih.bd.mm.custcategoryitem.d.desc.CustCategoryItemRelDODesc;

/**
 * 医疗物品_自定义分类项目
 * @author
 *
 */
public class CustcategoryitemAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public CustcategoryitemAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(CustCategoryItemDO.class);
        addChildren(CustCategoryItemRelDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(CustCategoryItemRelDODesc.class).getFKAttrDesc());        
	  }	  
}