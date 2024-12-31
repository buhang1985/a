package iih.ci.mr.nu.newbabyskinriskass.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mr.nu.newbabyskinriskass.d.desc.NewbabyskinriskassAggDODesc;



/**
 * 新生儿皮肤风险评估
 */
public class NewbabyskinriskassAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NewBabySkinAssDO getParentDO() {
		return ((NewBabySkinAssDO) super.getParentDO());
	}

	public void setParentDO(NewBabySkinAssDO headDO) {
		setParent(headDO);
	}

	public ScoreProjectDO[] getScoreProjectDO() {
		IBaseDO[] dos = getChildren(ScoreProjectDO.class);
		if(dos==null) return null;
		ScoreProjectDO[] result=new ScoreProjectDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(ScoreProjectDO)dos[i];
		}
		return result;
	}
	
	public void setScoreProjectDO(ScoreProjectDO[] dos) {
		setChildren(ScoreProjectDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NewbabyskinriskassAggDODesc desc = new NewbabyskinriskassAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NewBabySkinAssDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mr.nu.newbabyskinriskass.d.ScoreProjectDO")) {
             return new ScoreProjectDO();
         }
         return null;
     }
}