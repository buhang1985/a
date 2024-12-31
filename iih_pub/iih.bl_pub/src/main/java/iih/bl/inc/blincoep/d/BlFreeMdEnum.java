package iih.bl.inc.blincoep.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface BlFreeMdEnum {

    @DmEnumDesc(name="金额减免（默认）",description="金额减免（默认）")
	public static final Integer AMT_FREE_MD=1; //金额减免（默认）
    @DmEnumDesc(name="项目减免",description="项目减免")
	public static final Integer ITM_FREE_MD=2; //项目减免
    @DmEnumDesc(name="医保自付减免",description="医保自付减免")
	public static final Integer HP_SELF_FREE=3; //医保自付减免
    @DmEnumDesc(name="项目减免合并医保自付减免",description="项目减免合并医保自付减免")
	public static final Integer ITM_AND_HP_SELF=4; //项目减免合并医保自付减免
}	
