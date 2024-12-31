package iih.syn.common.init.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.syn.common.init.d.desc.InitAggDODesc;



/**
 * 基础数据初始化
 */
public class InitAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public SynInitDO getParentDO() {
		return ((SynInitDO) super.getParentDO());
	}

	public void setParentDO(SynInitDO headDO) {
		setParent(headDO);
	}

	public SynInitTableDO[] getSynInitTableDO() {
		IBaseDO[] dos = getChildren(SynInitTableDO.class);
		if(dos==null) return null;
		SynInitTableDO[] result=new SynInitTableDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(SynInitTableDO)dos[i];
		}
		return result;
	}
	
	public void setSynInitTableDO(SynInitTableDO[] dos) {
		setChildren(SynInitTableDO.class, dos);
	}
	public SynInitRcdDO[] getSynInitRcdDO() {
		IBaseDO[] dos = getChildren(SynInitRcdDO.class);
		if(dos==null) return null;
		SynInitRcdDO[] result=new SynInitRcdDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(SynInitRcdDO)dos[i];
		}
		return result;
	}
	
	public void setSynInitRcdDO(SynInitRcdDO[] dos) {
		setChildren(SynInitRcdDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		InitAggDODesc desc = new InitAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new SynInitDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.syn.common.init.d.SynInitTableDO")) {
             return new SynInitTableDO();
         }
	    else if (clzName.equals("iih.syn.common.init.d.SynInitRcdDO")) {
             return new SynInitRcdDO();
         }
         return null;
     }
}