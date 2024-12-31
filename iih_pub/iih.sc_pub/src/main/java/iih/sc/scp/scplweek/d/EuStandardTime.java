package iih.sc.scp.scplweek.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EuStandardTime {

    @DmEnumDesc(name="标准工时",description="标准工时")
    public static final String STANDARD="Y"; //标准工时
    @DmEnumDesc(name="自定义工时",description="自定义工时")
    public static final String CUSTOM="N"; //自定义工时
}	
