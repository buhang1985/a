package iih.pe.phm.pepsychology.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PePsychologyEnum {

    @DmEnumDesc(name="从无",description="从无")
	public static final Integer PENONE=1; //从无
    @DmEnumDesc(name="很轻",description="很轻")
	public static final Integer PEMILD=2; //很轻
    @DmEnumDesc(name="中等",description="中等")
	public static final Integer PEMEDIUM=3; //中等
    @DmEnumDesc(name="偏重",description="偏重")
	public static final Integer PEVERY=4; //偏重
    @DmEnumDesc(name="严重",description="严重")
	public static final Integer PEEXTREME=5; //严重
}	
