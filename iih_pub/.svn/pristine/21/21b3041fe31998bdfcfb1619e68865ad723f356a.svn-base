package iih.nm.net.examqu.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.net.examqu.d.desc.ExamquAggDODesc;



/**
 * 试题
 */
public class ExamquAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public ExamQuDO getParentDO() {
		return ((ExamQuDO) super.getParentDO());
	}

	public void setParentDO(ExamQuDO headDO) {
		setParent(headDO);
	}

	public ExamQuAnsDO[] getExamQuAnsDO() {
		IBaseDO[] dos = getChildren(ExamQuAnsDO.class);
		if(dos==null) return null;
		ExamQuAnsDO[] result=new ExamQuAnsDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(ExamQuAnsDO)dos[i];
		}
		return result;
	}
	
	public void setExamQuAnsDO(ExamQuAnsDO[] dos) {
		setChildren(ExamQuAnsDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		ExamquAggDODesc desc = new ExamquAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new ExamQuDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.net.examqu.d.ExamQuAnsDO")) {
             return new ExamQuAnsDO();
         }
         return null;
     }
}