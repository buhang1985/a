package iih.pe.pitm.peexercisetp.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.pitm.peexercisetp.d.PeExerciseTpDO;
import iih.pe.pitm.peexercisetp.d.PeExerciseTpLstDO;
import iih.pe.pitm.peexercisetp.d.desc.PeExerciseTpLstDODesc;

/**
 * 体检运动类别
 * @author
 *
 */
public class PeexercisetpAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PeexercisetpAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeExerciseTpDO.class);
        addChildren(PeExerciseTpLstDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeExerciseTpLstDODesc.class).getFKAttrDesc());        
	  }	  
}