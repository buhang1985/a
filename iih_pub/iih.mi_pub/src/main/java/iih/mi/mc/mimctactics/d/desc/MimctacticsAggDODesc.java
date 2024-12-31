package iih.mi.mc.mimctactics.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mi.mc.mimctactics.d.MiMcTacticsDO;
import iih.mi.mc.mimctactics.d.MiMcTacticsPara;
import iih.mi.mc.mimctactics.d.desc.MiMcTacticsParaDesc;

/**
 * 医保策略库
 * @author
 *
 */
public class MimctacticsAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public MimctacticsAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(MiMcTacticsDO.class);
        addChildren(MiMcTacticsPara.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MiMcTacticsParaDesc.class).getFKAttrDesc());        
	  }	  
}