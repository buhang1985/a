package iih.en.que.board.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface BrdtpEnum {

    @DmEnumDesc(name="门诊大屏",description="门诊大屏")
	public static final Integer OPBRD=01; //门诊大屏
    @DmEnumDesc(name="门诊二次分诊屏",description="门诊二次分诊屏")
	public static final Integer SECONDTRG=02; //门诊二次分诊屏
    @DmEnumDesc(name="医技",description="医技")
	public static final Integer MTBRD=03; //医技
    @DmEnumDesc(name="药房窗口大屏",description="药房窗口大屏")
	public static final Integer DRUGBRD=04; //药房窗口大屏
    @DmEnumDesc(name="药房综合大屏",description="药房综合大屏")
	public static final Integer ALLDRUGBRD=05; //药房综合大屏
}	
