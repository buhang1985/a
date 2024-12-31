package iih.bd.mhi.hpopepermapply.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface hpopepermapply {

    @DmEnumDesc(name="正常",description="正常")
    public static final String SD_NORMAL="1"; //正常
    @DmEnumDesc(name="暂停",description="暂停")
    public static final String SD_SUSPEND="2"; //暂停
    @DmEnumDesc(name="接续",description="接续")
    public static final String SD_FOLLOW="3"; //接续
    @DmEnumDesc(name="终止",description="终止")
    public static final String SD_END="4"; //终止
}	
