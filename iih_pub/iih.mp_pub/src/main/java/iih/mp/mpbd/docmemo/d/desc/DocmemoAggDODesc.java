package iih.mp.mpbd.docmemo.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mp.mpbd.docmemo.d.DocrMemoDO;
import iih.mp.mpbd.docmemo.d.DocMemoFileDO;
import iih.mp.mpbd.docmemo.d.desc.DocMemoFileDODesc;

/**
 * 医生备忘录
 * @author
 *
 */
public class DocmemoAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public DocmemoAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(DocrMemoDO.class);
        addChildren(DocMemoFileDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(DocMemoFileDODesc.class).getFKAttrDesc());        
	  }	  
}