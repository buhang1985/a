package iih.mp.dg.adr.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface AdrDgTypeEnum {

    @DmEnumDesc(name="怀疑药品",description="怀疑药品")
	public static final Integer DGTYPE_DOUBT=1; //怀疑药品
    @DmEnumDesc(name="并用药品",description="并用药品")
	public static final Integer DGTYPE_COMB=2; //并用药品
}	
