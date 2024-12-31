package iih.pe.pitm.perstdocdidef.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.pitm.perstdocdidef.d.PeDocTmplDO;
import iih.pe.pitm.perstdocdidef.d.PeDocDiTmplDO;
import iih.pe.pitm.perstdocdidef.d.desc.PeDocDiTmplDODesc;

/**
 * 体检医生模板
 * @author
 *
 */
public class PerstdocdidefAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PerstdocdidefAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeDocTmplDO.class);
        addChildren(PeDocDiTmplDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeDocDiTmplDODesc.class).getFKAttrDesc());        
	  }	  
}