package iih.bd.pp.bdprewarn.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface TypeEnum {

    @DmEnumDesc(name="全院",description="全院")
    public static final String WHOLEHOS="01"; //全院
    @DmEnumDesc(name="科室",description="科室")
    public static final String DEPARTMENT="02"; //科室
    @DmEnumDesc(name="病区",description="病区")
    public static final String WARD="03"; //病区
    @DmEnumDesc(name="科室和病区",description="科室和病区")
    public static final String WARDANDDEPT="04"; //科室和病区
}	
