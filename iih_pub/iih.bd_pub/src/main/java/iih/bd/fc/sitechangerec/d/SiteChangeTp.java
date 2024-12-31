package iih.bd.fc.sitechangerec.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface SiteChangeTp {

    @DmEnumDesc(name="上线",description="上线")
    public static final String ONLINE="00"; //上线
    @DmEnumDesc(name="下线",description="下线")
    public static final String OFFLINE="01"; //下线
    @DmEnumDesc(name="暂停",description="暂停")
    public static final String SUSPEND="02"; //暂停
}	
