package iih.en.doc.pregdoc.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.en.doc.pregdoc.d.PregDocDO;
import iih.en.doc.pregdoc.d.PregDocStatDO;
import iih.en.doc.pregdoc.d.desc.PregDocStatDODesc;

/**
 * 产科建档
 * @author
 *
 */
public class PregdocAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PregdocAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PregDocDO.class);
        addChildren(PregDocStatDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PregDocStatDODesc.class).getFKAttrDesc());        
	  }	  
}