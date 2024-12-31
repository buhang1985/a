package iih.hp.cp.eletp.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.hp.cp.eletp.d.desc.HpcpeletpAggDODesc;



/**
 * 诊疗计划元素类型
 */
public class HpcpeletpAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public HpCpElemTypeDO getParentDO() {
		return ((HpCpElemTypeDO) super.getParentDO());
	}

	public void setParentDO(HpCpElemTypeDO headDO) {
		setParent(headDO);
	}

	public HpCpElemTypeNestableDO[] getHpCpElemTypeNestableDO() {
		IBaseDO[] dos = getChildren(HpCpElemTypeNestableDO.class);
		if(dos==null) return null;
		HpCpElemTypeNestableDO[] result=new HpCpElemTypeNestableDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(HpCpElemTypeNestableDO)dos[i];
		}
		return result;
	}
	
	public void setHpCpElemTypeNestableDO(HpCpElemTypeNestableDO[] dos) {
		setChildren(HpCpElemTypeNestableDO.class, dos);
	}
	public HpCpElemTypePropDO[] getHpCpElemTypePropDO() {
		IBaseDO[] dos = getChildren(HpCpElemTypePropDO.class);
		if(dos==null) return null;
		HpCpElemTypePropDO[] result=new HpCpElemTypePropDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(HpCpElemTypePropDO)dos[i];
		}
		return result;
	}
	
	public void setHpCpElemTypePropDO(HpCpElemTypePropDO[] dos) {
		setChildren(HpCpElemTypePropDO.class, dos);
	}
	public HpCpElemTypePropTrgDO[] getHpCpElemTypePropTrgDO() {
		IBaseDO[] dos = getChildren(HpCpElemTypePropTrgDO.class);
		if(dos==null) return null;
		HpCpElemTypePropTrgDO[] result=new HpCpElemTypePropTrgDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(HpCpElemTypePropTrgDO)dos[i];
		}
		return result;
	}
	
	public void setHpCpElemTypePropTrgDO(HpCpElemTypePropTrgDO[] dos) {
		setChildren(HpCpElemTypePropTrgDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		HpcpeletpAggDODesc desc = new HpcpeletpAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new HpCpElemTypeDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.hp.cp.eletp.d.HpCpElemTypeNestableDO")) {
             return new HpCpElemTypeNestableDO();
         }
	    else if (clzName.equals("iih.hp.cp.eletp.d.HpCpElemTypePropDO")) {
             return new HpCpElemTypePropDO();
         }
	    else if (clzName.equals("iih.hp.cp.eletp.d.HpCpElemTypePropTrgDO")) {
             return new HpCpElemTypePropTrgDO();
         }
         return null;
     }
}