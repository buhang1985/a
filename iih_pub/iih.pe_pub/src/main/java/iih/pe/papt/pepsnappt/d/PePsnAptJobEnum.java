package iih.pe.papt.pepsnappt.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PePsnAptJobEnum {

    @DmEnumDesc(name="岗前",description="岗前")
	public static final Integer PEPSNAPPTBEFOREJOB=1; //岗前
    @DmEnumDesc(name="岗中",description="岗中")
	public static final Integer PEPSNAPPTINJOB=2; //岗中
    @DmEnumDesc(name="岗后",description="岗后")
	public static final Integer PEPSNAPPTAFTERJOB=3; //岗后
}	
