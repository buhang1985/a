package iih.pe.papt.pecorpappt.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.papt.pecorpappt.d.PeCorpApptDO;
import iih.pe.papt.pecorpappt.d.PeCorpApptGrpDO;
import iih.pe.papt.pecorpappt.d.desc.PeCorpApptGrpDODesc;

/**
 * 体检团体预约单
 * @author
 *
 */
public class PecorpapptAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PecorpapptAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeCorpApptDO.class);
        addChildren(PeCorpApptGrpDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeCorpApptGrpDODesc.class).getFKAttrDesc());        
	  }	  
}