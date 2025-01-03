package iih.pe.pitm.perstdidef.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.pitm.perstdidef.d.PeRstDiDefDO;
import iih.pe.pitm.perstdidef.d.PeDiagSuggDO;
import iih.pe.pitm.perstdidef.d.desc.PeDiagSuggDODesc;
import iih.pe.pitm.perstdidef.d.PeDiagSuppDO;
import iih.pe.pitm.perstdidef.d.desc.PeDiagSuppDODesc;
import iih.pe.pitm.perstdidef.d.PeDiagDocDO;
import iih.pe.pitm.perstdidef.d.desc.PeDiagDocDODesc;

/**
 * 体检诊断定义
 * @author
 *
 */
public class PerstdidefAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PerstdidefAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeRstDiDefDO.class);
        addChildren(PeDiagSuggDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeDiagSuggDODesc.class).getFKAttrDesc());        
        addChildren(PeDiagSuppDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeDiagSuppDODesc.class).getFKAttrDesc());        
        addChildren(PeDiagDocDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeDiagDocDODesc.class).getFKAttrDesc());        
	  }	  
}