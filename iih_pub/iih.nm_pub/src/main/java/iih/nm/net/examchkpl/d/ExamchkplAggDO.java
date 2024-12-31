package iih.nm.net.examchkpl.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.net.examchkpl.d.desc.ExamchkplAggDODesc;



/**
 * 考核计划
 */
public class ExamchkplAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public ExamChkPlDO getParentDO() {
		return ((ExamChkPlDO) super.getParentDO());
	}

	public void setParentDO(ExamChkPlDO headDO) {
		setParent(headDO);
	}

	public ExamChkPlPsnDO[] getExamChkPlPsnDO() {
		IBaseDO[] dos = getChildren(ExamChkPlPsnDO.class);
		if(dos==null) return null;
		ExamChkPlPsnDO[] result=new ExamChkPlPsnDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(ExamChkPlPsnDO)dos[i];
		}
		return result;
	}
	
	public void setExamChkPlPsnDO(ExamChkPlPsnDO[] dos) {
		setChildren(ExamChkPlPsnDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		ExamchkplAggDODesc desc = new ExamchkplAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new ExamChkPlDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.net.examchkpl.d.ExamChkPlPsnDO")) {
             return new ExamChkPlPsnDO();
         }
         return null;
     }
}