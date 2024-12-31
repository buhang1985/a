package iih.mp.mpbd.prnca.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EnumDisFormat {

    @DmEnumDesc(name="50%",description="50%")
	public static final Integer FIFTY=0; //50%
    @DmEnumDesc(name="75%",description="75%")
	public static final Integer SEVENTYFIVE=1; //75%
    @DmEnumDesc(name="100%",description="100%")
	public static final Integer ONEHUNDRED=2; //100%
    @DmEnumDesc(name="100%_NoDPI",description="100%_NoDPI")
	public static final Integer ONEHUNDRED_NODPI=3; //100%_NoDPI
    @DmEnumDesc(name="125%",description="125%")
	public static final Integer ONEHUNDREDANDTWENTYFIVE=4; //125%
    @DmEnumDesc(name="150%",description="150%")
	public static final Integer ONEHUNDREDANDFIFTY=5; //150%
    @DmEnumDesc(name="175%",description="175%")
	public static final Integer ONEHUNDREDANDSEVENTYFIVE=6; //175%
    @DmEnumDesc(name="200%",description="200%")
	public static final Integer TWOHUNDRED=7; //200%
    @DmEnumDesc(name="250%",description="250%")
	public static final Integer TWOHUNDREDANDFIFTY=8; //250%
    @DmEnumDesc(name="300%",description="300%")
	public static final Integer THREEHUNDRED=9; //300%
    @DmEnumDesc(name="500%",description="500%")
	public static final Integer FIVEHUNDRED=10; //500%
}	
