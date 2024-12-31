package iih.pi.dic.cardtype.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface CardSrcEnum {

	@DmEnumDesc(name="院内",description="")
	public static final Integer INSIDE=1; //院内
    @DmEnumDesc(name="院外",description="")
	public static final Integer OUTSIDE=0; //院外
}	
