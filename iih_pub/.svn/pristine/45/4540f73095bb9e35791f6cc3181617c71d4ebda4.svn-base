package iih.pe.por.pecorpbinfo.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.por.pecorpbinfo.d.PeCorpbInfoDO;
import iih.pe.por.pecorpbinfo.d.PeCorpDeptDO;
import iih.pe.por.pecorpbinfo.d.desc.PeCorpDeptDODesc;
import iih.pe.por.pecorpbinfo.d.PeCorpPrivacyDO;
import iih.pe.por.pecorpbinfo.d.desc.PeCorpPrivacyDODesc;

/**
 * 体检团体信息
 * @author
 *
 */
public class PecorpbinfoAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PecorpbinfoAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeCorpbInfoDO.class);
        addChildren(PeCorpDeptDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeCorpDeptDODesc.class).getFKAttrDesc());        
        addChildren(PeCorpPrivacyDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeCorpPrivacyDODesc.class).getFKAttrDesc());        
	  }	  
}