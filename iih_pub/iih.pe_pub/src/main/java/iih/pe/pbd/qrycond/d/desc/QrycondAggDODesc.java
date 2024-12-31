package iih.pe.pbd.qrycond.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.pbd.qrycond.d.QryCondDO;
import iih.pe.pbd.qrycond.d.QryCondItmDO;
import iih.pe.pbd.qrycond.d.desc.QryCondItmDODesc;

/**
 * 查询条件
 * @author
 *
 */
public class QrycondAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public QrycondAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(QryCondDO.class);
        addChildren(QryCondItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(QryCondItmDODesc.class).getFKAttrDesc());        
	  }	  
}