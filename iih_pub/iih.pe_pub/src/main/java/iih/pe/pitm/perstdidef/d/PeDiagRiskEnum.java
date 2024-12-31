package iih.pe.pitm.perstdidef.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PeDiagRiskEnum {

    @DmEnumDesc(name="无",description="无")
	public static final Integer PERISKZERO=0; //无
    @DmEnumDesc(name="低",description="低")
	public static final Integer PERISKLOW=1; //低
    @DmEnumDesc(name="中",description="中")
	public static final Integer PERISKMEDIA=2; //中
    @DmEnumDesc(name="高",description="高")
	public static final Integer PERISKHIGH=3; //高
    @DmEnumDesc(name="极高",description="极高")
	public static final Integer PERISKEXHIGH=4; //极高
}	
