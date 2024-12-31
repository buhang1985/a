package iih.nm.net.examappqu.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.net.examappqu.d.desc.ExamappquAggDODesc;



/**
 * 人员考试题目
 */
public class ExamappquAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NmExamAppQuDO getParentDO() {
		return ((NmExamAppQuDO) super.getParentDO());
	}

	public void setParentDO(NmExamAppQuDO headDO) {
		setParent(headDO);
	}

	public NmExamAppQuAnsDO[] getNmExamAppQuAnsDO() {
		IBaseDO[] dos = getChildren(NmExamAppQuAnsDO.class);
		if(dos==null) return null;
		NmExamAppQuAnsDO[] result=new NmExamAppQuAnsDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NmExamAppQuAnsDO)dos[i];
		}
		return result;
	}
	
	public void setNmExamAppQuAnsDO(NmExamAppQuAnsDO[] dos) {
		setChildren(NmExamAppQuAnsDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		ExamappquAggDODesc desc = new ExamappquAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NmExamAppQuDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.net.examappqu.d.NmExamAppQuAnsDO")) {
             return new NmExamAppQuAnsDO();
         }
         return null;
     }
}