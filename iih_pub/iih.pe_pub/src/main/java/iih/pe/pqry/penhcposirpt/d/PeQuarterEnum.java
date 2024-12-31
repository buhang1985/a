package iih.pe.pqry.penhcposirpt.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PeQuarterEnum {

    @DmEnumDesc(name="第一季度",description="第一季度")
	public static final Integer PEQ1=1; //第一季度
    @DmEnumDesc(name="第二季度",description="第二季度")
	public static final Integer PEQ2=2; //第二季度
    @DmEnumDesc(name="第三季度",description="第三季度")
	public static final Integer PEQ3=3; //第三季度
    @DmEnumDesc(name="第四季度",description="第四季度")
	public static final Integer PEQ4=4; //第四季度
}	
