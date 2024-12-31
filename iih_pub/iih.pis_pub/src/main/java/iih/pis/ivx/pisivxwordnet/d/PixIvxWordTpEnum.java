package iih.pis.ivx.pisivxwordnet.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PixIvxWordTpEnum {

    @DmEnumDesc(name="科室",description="科室")
	public static final Integer WNDEPT=1; //科室
    @DmEnumDesc(name="号源",description="号源")
	public static final Integer WNAPTNO=2; //号源
    @DmEnumDesc(name="日期时间",description="日期时间")
	public static final Integer WNDAY=3; //日期时间
}	
