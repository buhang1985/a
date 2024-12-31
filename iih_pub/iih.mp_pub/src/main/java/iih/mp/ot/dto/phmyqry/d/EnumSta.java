package iih.mp.ot.dto.phmyqry.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EnumSta {

    @DmEnumDesc(name="发药窗口",description="发药窗口")
	public static final Integer WINDOW=1; //发药窗口
    @DmEnumDesc(name="病人性质",description="病人性质")
	public static final Integer PHMY=2; //病人性质
    @DmEnumDesc(name="发药人",description="发药人")
	public static final Integer DRUGUSER=3; //发药人
    @DmEnumDesc(name="配药人",description="配药人")
	public static final Integer DISPPSN=4; //配药人
    @DmEnumDesc(name="特殊药品",description="特殊药品")
	public static final Integer SPECILDRUG=5; //特殊药品
}	
