package iih.pe.por.pecorpcharge.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.por.pecorpcharge.d.PeCorpChargeDO;
import iih.pe.por.pecorpcharge.d.PeCorpChargeItmDO;
import iih.pe.por.pecorpcharge.d.desc.PeCorpChargeItmDODesc;
import iih.pe.por.pecorpcharge.d.PeCorpChargeSumDO;
import iih.pe.por.pecorpcharge.d.desc.PeCorpChargeSumDODesc;

/**
 * 体检团体账单
 * @author
 *
 */
public class PecorpchargeAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PecorpchargeAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeCorpChargeDO.class);
        addChildren(PeCorpChargeItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeCorpChargeItmDODesc.class).getFKAttrDesc());        
        addChildren(PeCorpChargeSumDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeCorpChargeSumDODesc.class).getFKAttrDesc());        
	  }	  
}