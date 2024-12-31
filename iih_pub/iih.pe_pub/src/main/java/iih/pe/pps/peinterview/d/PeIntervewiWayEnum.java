package iih.pe.pps.peinterview.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PeIntervewiWayEnum {

    @DmEnumDesc(name="电话",description="电话")
	public static final Integer PEWAYTEL=1; //电话
    @DmEnumDesc(name="短信",description="短信")
	public static final Integer PEWAYSMS=2; //短信
    @DmEnumDesc(name="网络",description="网络")
	public static final Integer PEWAYINTERNET=3; //网络
    @DmEnumDesc(name="面对面",description="面对面")
	public static final Integer PEWAYFACE=4; //面对面
    @DmEnumDesc(name="体检复查",description="体检复查")
	public static final Integer PEWAYRECHECK=5; //体检复查
}	
