package iih.pe.papt.dto.pecorpexceldto.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PeXlsGenderEnum {

    @DmEnumDesc(name="未知",description="未知")
	public static final Integer PEXLSGENDERUNKNOW=0; //未知
    @DmEnumDesc(name="男",description="男")
	public static final Integer PEXLSGENDERMAN=1; //男
    @DmEnumDesc(name="女",description="女")
	public static final Integer PEXLSGENDERWOMAN=2; //女
    @DmEnumDesc(name="未说明",description="未说明")
	public static final Integer PEXMLGENDERNOTSTATED=9; //未说明
}	
