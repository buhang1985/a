package iih.pe.pitm.peexercisetp.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.pitm.peexercisetp.d.desc.PeexercisetpAggDODesc;



/**
 * 体检运动类别
 */
public class PeexercisetpAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeExerciseTpDO getParentDO() {
		return ((PeExerciseTpDO) super.getParentDO());
	}

	public void setParentDO(PeExerciseTpDO headDO) {
		setParent(headDO);
	}

	public PeExerciseTpLstDO[] getPeExerciseTpLstDO() {
		IBaseDO[] dos = getChildren(PeExerciseTpLstDO.class);
		if(dos==null) return null;
		PeExerciseTpLstDO[] result=new PeExerciseTpLstDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeExerciseTpLstDO)dos[i];
		}
		return result;
	}
	
	public void setPeExerciseTpLstDO(PeExerciseTpLstDO[] dos) {
		setChildren(PeExerciseTpLstDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PeexercisetpAggDODesc desc = new PeexercisetpAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeExerciseTpDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.pitm.peexercisetp.d.PeExerciseTpLstDO")) {
             return new PeExerciseTpLstDO();
         }
         return null;
     }
}