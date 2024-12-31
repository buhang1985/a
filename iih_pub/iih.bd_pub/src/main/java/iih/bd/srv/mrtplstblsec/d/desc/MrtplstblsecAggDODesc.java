package iih.bd.srv.mrtplstblsec.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.srv.mrtplstblsec.d.MrTplSTblSecDO;
import iih.bd.srv.mrtplstblsec.d.MrTplSTblSecItmDO;
import iih.bd.srv.mrtplstblsec.d.desc.MrTplSTblSecItmDODesc;

/**
 * 医疗记录模板智能表格段落
 * @author
 *
 */
public class MrtplstblsecAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public MrtplstblsecAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(MrTplSTblSecDO.class);
        addChildren(MrTplSTblSecItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MrTplSTblSecItmDODesc.class).getFKAttrDesc());        
	  }	  
}