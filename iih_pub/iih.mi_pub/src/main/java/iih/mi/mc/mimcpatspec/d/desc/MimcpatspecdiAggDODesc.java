package iih.mi.mc.mimcpatspec.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mi.mc.mimcpatspec.d.MiMcPatSpecDO;
import iih.mi.mc.mimcpatspec.d.MiMcPatSpecDiDO;
import iih.mi.mc.mimcpatspec.d.desc.MiMcPatSpecDiDODesc;

/**
 * 医保特殊病患者维护
 * @author
 *
 */
public class MimcpatspecdiAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public MimcpatspecdiAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(MiMcPatSpecDO.class);
        addChildren(MiMcPatSpecDiDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MiMcPatSpecDiDODesc.class).getFKAttrDesc());        
	  }	  
}