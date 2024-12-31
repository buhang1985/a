package iih.bd.fc.mdwfor.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface DeptMacroEnum {

    @DmEnumDesc(name=" ",description="")
    public static final String STRINGEMPTY="0"; // 
    @DmEnumDesc(name="就诊科室",description="")
    public static final String PIENDEPT="1"; //就诊科室
    @DmEnumDesc(name="开单科室",description="")
    public static final String OROPENDEPT="2"; //开单科室
    @DmEnumDesc(name="护理单元",description="")
    public static final String PINSDEPT="3"; //护理单元
}	
