package iih.nm.net.exampp.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.net.exampp.d.desc.ExamppAggDODesc;



/**
 * 试卷
 */
public class ExamppAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public ExamppDO getParentDO() {
		return ((ExamppDO) super.getParentDO());
	}

	public void setParentDO(ExamppDO headDO) {
		setParent(headDO);
	}

	public ExamppSecDO[] getExamppSecDO() {
		IBaseDO[] dos = getChildren(ExamppSecDO.class);
		if(dos==null) return null;
		ExamppSecDO[] result=new ExamppSecDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(ExamppSecDO)dos[i];
		}
		return result;
	}
	
	public void setExamppSecDO(ExamppSecDO[] dos) {
		setChildren(ExamppSecDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		ExamppAggDODesc desc = new ExamppAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new ExamppDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.net.exampp.d.ExamppSecDO")) {
             return new ExamppSecDO();
         }
         return null;
     }
}