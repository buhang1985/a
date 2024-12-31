package iih.pe.pps.perstslicemng.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PeRstSliceMngEnum {

    @DmEnumDesc(name="A类",description="A类：需要立即进行临床干预，否则 将危及生命或导致严重不良后果的异常结果。")
	public static final Integer PERSTSLICEMNGENUMA=1; //A类
    @DmEnumDesc(name="B类",description="B类：需要临床进一步检查以明确诊断和(或)需要 医学治疗的重要异常结果。")
	public static final Integer PERSTSLICEMNGENUMB=2; //B类
}	
