package iih.bd.srv.mrctmca.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.srv.mrctmca.d.MrCtmCaDO;
import iih.bd.srv.mrctmca.d.MrCaCtmItmDO;
import iih.bd.srv.mrctmca.d.desc.MrCaCtmItmDODesc;

/**
 * 医疗记录类型自定义分类
 * @author
 *
 */
public class MrctmcaAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public MrctmcaAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(MrCtmCaDO.class);
        addChildren(MrCaCtmItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MrCaCtmItmDODesc.class).getFKAttrDesc());        
	  }	  
}