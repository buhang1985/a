package iih.bl.cg.extritf.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EuSendStatus {

    @DmEnumDesc(name="未发送",description="未发送")
    public static final String UNSENT="0"; //未发送
    @DmEnumDesc(name="发送成功",description="发送成功")
    public static final String SUCCESS="1"; //发送成功
    @DmEnumDesc(name="发送失败",description="发送失败")
    public static final String FAIL="2"; //发送失败
}	
