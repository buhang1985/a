package iih.en.pv.vt.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.en.pv.vt.d.EnVtDO;
import iih.en.pv.vt.d.EnVtSrvDO;
import iih.en.pv.vt.d.desc.EnVtSrvDODesc;

/**
 * 就诊_体征
 * @author
 *
 */
public class EnvtAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public EnvtAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(EnVtDO.class);
        addChildren(EnVtSrvDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(EnVtSrvDODesc.class).getFKAttrDesc());        
	  }	  
}