package iih.nm.nom.nomwkitmapp.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.nom.nomwkitmapp.d.NomWkitmAppDO;
import iih.nm.nom.nomwkitmapp.d.NomWkitmAppItmDO;
import iih.nm.nom.nomwkitmapp.d.desc.NomWkitmAppItmDODesc;

/**
 * 护理工作项目数据录入
 * @author
 *
 */
public class NomwkitmappAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NomwkitmappAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NomWkitmAppDO.class);
        addChildren(NomWkitmAppItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NomWkitmAppItmDODesc.class).getFKAttrDesc());        
	  }	  
}