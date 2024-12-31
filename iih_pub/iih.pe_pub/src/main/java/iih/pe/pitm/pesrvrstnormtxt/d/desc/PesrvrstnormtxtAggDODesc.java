package iih.pe.pitm.pesrvrstnormtxt.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.pitm.pesrvrstnormtxt.d.PeSrvRstNormTxtDO;
import iih.pe.pitm.pesrvrstnormtxt.d.PeSrvRstNormTxtDtlDO;
import iih.pe.pitm.pesrvrstnormtxt.d.desc.PeSrvRstNormTxtDtlDODesc;

/**
 * 体检结果正常时报告内容
 * @author
 *
 */
public class PesrvrstnormtxtAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PesrvrstnormtxtAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeSrvRstNormTxtDO.class);
        addChildren(PeSrvRstNormTxtDtlDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeSrvRstNormTxtDtlDODesc.class).getFKAttrDesc());        
	  }	  
}