package iih.bd.pp.anhuiinsur.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface HospitalLevel {

    @DmEnumDesc(name="一级医院",description="一级医院")
    public static final String FIRSTLEVEL="01"; //一级医院
    @DmEnumDesc(name="二级医院",description="二级医院")
    public static final String SECONDLEVEL="02"; //二级医院
    @DmEnumDesc(name="三级医院",description="三级医院")
    public static final String THIRDLEVEL="03"; //三级医院
}	
