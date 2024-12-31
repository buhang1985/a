package iih.sc.scbd.bdsrv.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.sc.scbd.bdsrv.d.desc.ScbdsrvAggDODesc;



/**
 * 排班计划-医疗服务
 */
public class ScbdsrvAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public ScBdsrvDO getParentDO() {
		return ((ScBdsrvDO) super.getParentDO());
	}

	public void setParentDO(ScBdsrvDO headDO) {
		setParent(headDO);
	}

	public ScBdsrvKindItm[] getScBdsrvKindItm() {
		IBaseDO[] dos = getChildren(ScBdsrvKindItm.class);
		if(dos==null) return null;
		ScBdsrvKindItm[] result=new ScBdsrvKindItm[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(ScBdsrvKindItm)dos[i];
		}
		return result;
	}
	
	public void setScBdsrvKindItm(ScBdsrvKindItm[] dos) {
		setChildren(ScBdsrvKindItm.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		ScbdsrvAggDODesc desc = new ScbdsrvAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new ScBdsrvDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.sc.scbd.bdsrv.d.ScBdsrvKindItm")) {
             return new ScBdsrvKindItm();
         }
         return null;
     }
}