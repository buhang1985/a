package iih.pe.papt.dto.pecorpexceldto.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PeXmlMarriageEnum {

    @DmEnumDesc(name="未婚",description="未婚")
	public static final Integer PEXLSUNMARRIED=10; //未婚
    @DmEnumDesc(name="已婚",description="已婚")
	public static final Integer PEXLSMARRIED=20; //已婚
    @DmEnumDesc(name="未说明婚姻状况",description="未说明婚姻状况")
	public static final Integer PEXLSMARRIAGEUNKNOW=90; //未说明婚姻状况
}	
