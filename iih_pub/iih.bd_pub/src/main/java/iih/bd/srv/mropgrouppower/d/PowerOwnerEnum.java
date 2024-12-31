package iih.bd.srv.mropgrouppower.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PowerOwnerEnum {

    @DmEnumDesc(name="机构",description="")
    public static final String ORGANIZATION  ="00"; //机构
    @DmEnumDesc(name="科室",description="")
    public static final String DEPT ="10"; //科室
    @DmEnumDesc(name="个人",description="")
    public static final String PERSON ="20"; //个人
}	
