package iih.bd.srv.diagcate.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.srv.diagcate.d.DiagCateDO;
import iih.bd.srv.diagcate.d.DiCateItemDO;
import iih.bd.srv.diagcate.d.desc.DiCateItemDODesc;

/**
 * 疾病诊断分类
 * @author
 *
 */
public class DiagcateAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public DiagcateAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(DiagCateDO.class);
        addChildren(DiCateItemDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(DiCateItemDODesc.class).getFKAttrDesc());        
	  }	  
}