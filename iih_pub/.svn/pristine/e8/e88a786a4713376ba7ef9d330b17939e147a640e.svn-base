package iih.bd.srv.qcconreject.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.srv.qcconreject.d.QcconrejectDO;
import iih.bd.srv.qcconreject.d.QcconrejectconDO;
import iih.bd.srv.qcconreject.d.desc.QcconrejectconDODesc;
import iih.bd.srv.qcconreject.d.QcconrejectitemDO;
import iih.bd.srv.qcconreject.d.desc.QcconrejectitemDODesc;

/**
 * 组件
 * @author
 *
 */
public class QcconrejectAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public QcconrejectAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(QcconrejectDO.class);
        addChildren(QcconrejectconDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(QcconrejectconDODesc.class).getFKAttrDesc());        
        addChildren(QcconrejectitemDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(QcconrejectitemDODesc.class).getFKAttrDesc());        
	  }	  
}