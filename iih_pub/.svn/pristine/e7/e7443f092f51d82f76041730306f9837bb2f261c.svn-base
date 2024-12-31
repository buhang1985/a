package iih.ci.tsip.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.tsip.d.CiTsOrDO;
import iih.ci.tsip.d.CiTsOrSrvDO;
import iih.ci.tsip.d.desc.CiTsOrSrvDODesc;
import iih.ci.tsip.d.CiTsOrSrvSetDO;
import iih.ci.tsip.d.desc.CiTsOrSrvSetDODesc;

/**
 * 治疗方案医嘱
 * @author
 *
 */
public class CitsorderAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public CitsorderAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(CiTsOrDO.class);
        addChildren(CiTsOrSrvDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(CiTsOrSrvDODesc.class).getFKAttrDesc());        
        addChildren(CiTsOrSrvSetDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(CiTsOrSrvSetDODesc.class).getFKAttrDesc());        
	  }	  
}