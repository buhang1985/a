package iih.pe.pqn.peevalchrorisk.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.pqn.peevalchrorisk.d.PeChroRiskDO;
import iih.pe.pqn.peevalchrorisk.d.PeChroDiDO;
import iih.pe.pqn.peevalchrorisk.d.desc.PeChroDiDODesc;
import iih.pe.pqn.peevalchrorisk.d.PeChroQaDO;
import iih.pe.pqn.peevalchrorisk.d.desc.PeChroQaDODesc;
import iih.pe.pqn.peevalchrorisk.d.PeChroRstDO;
import iih.pe.pqn.peevalchrorisk.d.desc.PeChroRstDODesc;

/**
 * 体检慢病风险因素
 * @author
 *
 */
public class PeevalchroriskAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PeevalchroriskAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeChroRiskDO.class);
        addChildren(PeChroDiDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeChroDiDODesc.class).getFKAttrDesc());        
        addChildren(PeChroQaDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeChroQaDODesc.class).getFKAttrDesc());        
        addChildren(PeChroRstDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeChroRstDODesc.class).getFKAttrDesc());        
	  }	  
}