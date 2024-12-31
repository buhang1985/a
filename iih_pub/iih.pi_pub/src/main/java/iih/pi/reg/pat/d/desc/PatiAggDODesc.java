package iih.pi.reg.pat.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.desc.PatiAddrDODesc;
import iih.pi.reg.pat.d.PiPatContDO;
import iih.pi.reg.pat.d.desc.PiPatContDODesc;
import iih.pi.reg.pat.d.PiPatCardDO;
import iih.pi.reg.pat.d.desc.PiPatCardDODesc;
import iih.pi.reg.pat.d.PiPatHpDO;
import iih.pi.reg.pat.d.desc.PiPatHpDODesc;
import iih.pi.reg.pat.d.PiPatBiolDO;
import iih.pi.reg.pat.d.desc.PiPatBiolDODesc;

/**
 * 患者基本信息
 * @author
 *
 */
public class PatiAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PatiAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PatDO.class);
        addChildren(PatiAddrDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PatiAddrDODesc.class).getFKAttrDesc());        
        addChildren(PiPatContDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PiPatContDODesc.class).getFKAttrDesc());        
        addChildren(PiPatCardDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PiPatCardDODesc.class).getFKAttrDesc());        
        addChildren(PiPatHpDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PiPatHpDODesc.class).getFKAttrDesc());        
        addChildren(PiPatBiolDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PiPatBiolDODesc.class).getFKAttrDesc());        
	  }	  
}