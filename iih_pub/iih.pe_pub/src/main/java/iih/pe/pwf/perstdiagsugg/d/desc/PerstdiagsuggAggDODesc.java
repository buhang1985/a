package iih.pe.pwf.perstdiagsugg.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.pwf.perstdiagsugg.d.PeRstDiagSuggDO;
import iih.pe.pwf.perstdiagsugg.d.PeRstDiDO;
import iih.pe.pwf.perstdiagsugg.d.desc.PeRstDiDODesc;
import iih.pe.pwf.perstdiagsugg.d.PeRstSuggDO;
import iih.pe.pwf.perstdiagsugg.d.desc.PeRstSuggDODesc;

/**
 * 体检结果诊断建议
 * @author
 *
 */
public class PerstdiagsuggAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PerstdiagsuggAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeRstDiagSuggDO.class);
        addChildren(PeRstDiDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeRstDiDODesc.class).getFKAttrDesc());        
        addChildren(PeRstSuggDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeRstSuggDODesc.class).getFKAttrDesc());        
	  }	  
}