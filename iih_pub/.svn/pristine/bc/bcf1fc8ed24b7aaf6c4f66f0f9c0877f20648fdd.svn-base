package iih.bd.srv.qcmraddrule.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.srv.qcmraddrule.d.QcmraddruleDO;
import iih.bd.srv.qcmraddrule.d.QcmraddpreruleDO;
import iih.bd.srv.qcmraddrule.d.desc.QcmraddpreruleDODesc;

/**
 * 组件
 * @author
 *
 */
public class QcmraddruleAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public QcmraddruleAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(QcmraddruleDO.class);
        addChildren(QcmraddpreruleDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(QcmraddpreruleDODesc.class).getFKAttrDesc());        
	  }	  
}