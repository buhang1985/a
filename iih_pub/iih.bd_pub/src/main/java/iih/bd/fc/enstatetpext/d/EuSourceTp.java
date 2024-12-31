package iih.bd.fc.enstatetpext.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EuSourceTp {

    @DmEnumDesc(name="医嘱服务",description="医嘱服务")
	public static final Integer ORSRV=01; //医嘱服务
    @DmEnumDesc(name="就诊事件",description="就诊事件")
	public static final Integer ENEVENT=02; //就诊事件
    @DmEnumDesc(name="护理文书",description="护理文书")
	public static final Integer NURDOC=03; //护理文书
    @DmEnumDesc(name="其他",description="其他")
	public static final Integer OTHER=99; //其他
}	
