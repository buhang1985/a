package iih.nm.net.examchk.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.net.examchk.d.desc.ExamchkAggDODesc;



/**
 * 护理人员考核
 */
public class ExamchkAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public ExamChkDO getParentDO() {
		return ((ExamChkDO) super.getParentDO());
	}

	public void setParentDO(ExamChkDO headDO) {
		setParent(headDO);
	}

	public ExamChkPsnDO[] getExamChkPsnDO() {
		IBaseDO[] dos = getChildren(ExamChkPsnDO.class);
		if(dos==null) return null;
		ExamChkPsnDO[] result=new ExamChkPsnDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(ExamChkPsnDO)dos[i];
		}
		return result;
	}
	
	public void setExamChkPsnDO(ExamChkPsnDO[] dos) {
		setChildren(ExamChkPsnDO.class, dos);
	}
	public ExamChkFlDO[] getExamChkFlDO() {
		IBaseDO[] dos = getChildren(ExamChkFlDO.class);
		if(dos==null) return null;
		ExamChkFlDO[] result=new ExamChkFlDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(ExamChkFlDO)dos[i];
		}
		return result;
	}
	
	public void setExamChkFlDO(ExamChkFlDO[] dos) {
		setChildren(ExamChkFlDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		ExamchkAggDODesc desc = new ExamchkAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new ExamChkDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.net.examchk.d.ExamChkPsnDO")) {
             return new ExamChkPsnDO();
         }
	    else if (clzName.equals("iih.nm.net.examchk.d.ExamChkFlDO")) {
             return new ExamChkFlDO();
         }
         return null;
     }
}