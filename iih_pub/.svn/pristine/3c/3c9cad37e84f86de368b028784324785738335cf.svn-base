package iih.ci.mrm.cimrfpothercatado.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mrm.cimrfpothercatado.d.CiMrFpOtherCataDO;
import iih.ci.mrm.cimrfpothercatado.d.CiMrFpIntencareCataDO;
import iih.ci.mrm.cimrfpothercatado.d.desc.CiMrFpIntencareCataDODesc;

/**
 * 病案编目其他
 * @author
 *
 */
public class CimrfpothercatadoAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public CimrfpothercatadoAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(CiMrFpOtherCataDO.class);
        addChildren(CiMrFpIntencareCataDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(CiMrFpIntencareCataDODesc.class).getFKAttrDesc());        
	  }	  
}