package iih.nm.net.examnurtra.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.net.examnurtra.d.desc.ExamnurtraAggDODesc;



/**
 * 护理人员培训
 */
public class ExamnurtraAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public ExamNurtraDO getParentDO() {
		return ((ExamNurtraDO) super.getParentDO());
	}

	public void setParentDO(ExamNurtraDO headDO) {
		setParent(headDO);
	}

	public ExamNurtrPsnDO[] getExamNurtrPsnDO() {
		IBaseDO[] dos = getChildren(ExamNurtrPsnDO.class);
		if(dos==null) return null;
		ExamNurtrPsnDO[] result=new ExamNurtrPsnDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(ExamNurtrPsnDO)dos[i];
		}
		return result;
	}
	
	public void setExamNurtrPsnDO(ExamNurtrPsnDO[] dos) {
		setChildren(ExamNurtrPsnDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		ExamnurtraAggDODesc desc = new ExamnurtraAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new ExamNurtraDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.net.examnurtra.d.ExamNurtrPsnDO")) {
             return new ExamNurtrPsnDO();
         }
         return null;
     }
}