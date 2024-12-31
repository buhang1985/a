package iih.mp.mb.mbbcval.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mp.mb.mbbcval.d.MbBcValDO;
import iih.mp.mb.mbbcval.d.MbBcValParamDO;
import iih.mp.mb.mbbcval.d.desc.MbBcValParamDODesc;

/**
 * 条码对照查询
 * @author
 *
 */
public class MbbcvalAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public MbbcvalAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(MbBcValDO.class);
        addChildren(MbBcValParamDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MbBcValParamDODesc.class).getFKAttrDesc());        
	  }	  
}