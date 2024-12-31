package iih.nm.net.examtrapl.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.net.examtrapl.d.desc.ExamtraplAggDODesc;



/**
 * 培训计划
 */
public class ExamtraplAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public ExamtraplDO getParentDO() {
		return ((ExamtraplDO) super.getParentDO());
	}

	public void setParentDO(ExamtraplDO headDO) {
		setParent(headDO);
	}

	public ExamtraplfileDo[] getExamtraplfileDo() {
		IBaseDO[] dos = getChildren(ExamtraplfileDo.class);
		if(dos==null) return null;
		ExamtraplfileDo[] result=new ExamtraplfileDo[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(ExamtraplfileDo)dos[i];
		}
		return result;
	}
	
	public void setExamtraplfileDo(ExamtraplfileDo[] dos) {
		setChildren(ExamtraplfileDo.class, dos);
	}
	public ExamtraplpsnDO[] getExamtraplpsnDO() {
		IBaseDO[] dos = getChildren(ExamtraplpsnDO.class);
		if(dos==null) return null;
		ExamtraplpsnDO[] result=new ExamtraplpsnDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(ExamtraplpsnDO)dos[i];
		}
		return result;
	}
	
	public void setExamtraplpsnDO(ExamtraplpsnDO[] dos) {
		setChildren(ExamtraplpsnDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		ExamtraplAggDODesc desc = new ExamtraplAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new ExamtraplDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.net.examtrapl.d.ExamtraplfileDo")) {
             return new ExamtraplfileDo();
         }
	    else if (clzName.equals("iih.nm.net.examtrapl.d.ExamtraplpsnDO")) {
             return new ExamtraplpsnDO();
         }
         return null;
     }
}