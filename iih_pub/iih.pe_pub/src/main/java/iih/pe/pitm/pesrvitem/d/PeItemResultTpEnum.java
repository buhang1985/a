package iih.pe.pitm.pesrvitem.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PeItemResultTpEnum {

    @DmEnumDesc(name="描述",description="")
	public static final Integer PEITEMDESC=1; //描述
    @DmEnumDesc(name="数值",description="")
	public static final Integer PEITEMNUM=2; //数值
    @DmEnumDesc(name="计算",description="")
	public static final Integer PEITEMCALC=3; //计算
    @DmEnumDesc(name="结论",description="")
	public static final Integer PEITEMDIAG=4; //结论
}	
