package iih.pe.pitm.pechrodisedef.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.pitm.pechrodisedef.d.PeChroDiseDefDO;
import iih.pe.pitm.pechrodisedef.d.PeChroDiseDiDefDO;
import iih.pe.pitm.pechrodisedef.d.desc.PeChroDiseDiDefDODesc;
import iih.pe.pitm.pechrodisedef.d.PeChroDiseRuleDefDO;
import iih.pe.pitm.pechrodisedef.d.desc.PeChroDiseRuleDefDODesc;

/**
 * 体检慢性病定义
 * @author
 *
 */
public class PechrodisedefAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PechrodisedefAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeChroDiseDefDO.class);
        addChildren(PeChroDiseDiDefDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeChroDiseDiDefDODesc.class).getFKAttrDesc());        
        addChildren(PeChroDiseRuleDefDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeChroDiseRuleDefDODesc.class).getFKAttrDesc());        
	  }	  
}