package iih.nm.nqm.qctplapp.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.nqm.qctplapp.d.QctplAppDO;
import iih.nm.nqm.qctplapp.d.QctplAppEleDO;
import iih.nm.nqm.qctplapp.d.desc.QctplAppEleDODesc;

/**
 * 质量控制应用
 * @author
 *
 */
public class QctplappAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public QctplappAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(QctplAppDO.class);
        addChildren(QctplAppEleDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(QctplAppEleDODesc.class).getFKAttrDesc());        
	  }	  
}