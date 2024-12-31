package iih.sc.apt.dto.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EuStatus {

    @DmEnumDesc(name="申请",description="")
    public static final String APPY="0"; //申请
    @DmEnumDesc(name="安排",description="")
    public static final String ARRANG="1"; //安排
    @DmEnumDesc(name="确认",description="")
    public static final String CONFIRM="2"; //确认
    @DmEnumDesc(name="拒绝",description="")
    public static final String REJECT="3"; //拒绝
    @DmEnumDesc(name="入院",description="")
    public static final String INHOS="4"; //入院
}	
