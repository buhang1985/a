package iih.mp.mpbd.mpmbhfunca.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mp.mpbd.mpmbhfunca.d.MpMbhAppCaDO;
import iih.mp.mpbd.mpmbhfunca.d.MpMbhAppFunDO;
import iih.mp.mpbd.mpmbhfunca.d.desc.MpMbhAppFunDODesc;

/**
 * 移动医疗功能分类
 * @author
 *
 */
public class MpmbhfuncaAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public MpmbhfuncaAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(MpMbhAppCaDO.class);
        addChildren(MpMbhAppFunDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MpMbhAppFunDODesc.class).getFKAttrDesc());        
	  }	  
}